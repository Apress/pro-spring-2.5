package com.apress.prospring2.ch13.service;

import com.apress.prospring2.ch13.domain.EmailMessage;
import com.apress.prospring2.ch13.domain.MailFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;

/**
 * @author anirvanc
 */
public class FreemarkerEmailMessageProducer implements EmailMessageProducer, InitializingBean {

    private TemplateLoader templateLoader;
    private FreeMarkerConfig freeMarkerConfig;

    public void afterPropertiesSet() throws Exception {
        if (this.freeMarkerConfig == null)
            throw new FatalBeanException("Property [freeMarkerConfig] of [" + getClass().getName() + "] is required.");
        this.templateLoader = new DefaultTemplateLoader("", ".ftl", freeMarkerConfig);
    }

    static interface TemplateLoader {
        Template load(final String name, final Locale locale, final MailFormat format) throws IOException;
    }

    static class DefaultTemplateLoader implements TemplateLoader {
        private FreeMarkerConfig config;
        private String prefix;
        private String suffix;

        public DefaultTemplateLoader(final String prefix, final String suffix, final FreeMarkerConfig config) {
            this.config = config;
            this.prefix = prefix;
            this.suffix = suffix;
        }

        private String resolveTemplateName(final String name, final Locale locale, final MailFormat format) {
            StringBuilder result = new StringBuilder(50);
            result.append(prefix);
            result.append(locale.getLanguage());
            result.append("_");
            result.append(locale.getCountry());
            result.append("/");
            result.append(name);
            result.append("_");
            result.append(format.toString());
            result.append(suffix);
            return result.toString();
        }

        public Template load(final String name, final Locale locale, final MailFormat format) throws IOException {
            Configuration configuration = config.getConfiguration();
            return configuration.getTemplate(resolveTemplateName(name, locale, format));
        }
    }

    private Template attemptLoad(final String templateName, final Locale locale, final MailFormat format) {
        try {
            return this.templateLoader.load(templateName, locale, format);
        } catch (IOException e) {
            // log error here
            return null;
        }
    }

    public EmailMessage produce(String emailTemplateCode, Locale locale, MailFormat format, Map<String, Object> arguments) {
        EmailMessage message = new EmailMessage();
        Template template = attemptLoad(emailTemplateCode, locale, format);
        if (template == null) throw new RuntimeException("Cannot load email template.");
        try {
            StringWriter body = new StringWriter();
            template.process(arguments, body);
            message.setBody(body.toString());
        } catch (TemplateException e) {
            //handle it
            return null;
        } catch (IOException e) {
            //impossible!
        }

        return message;
    }

    public void setFreeMarkerConfig(FreeMarkerConfig freeMarkerConfig) {
        this.freeMarkerConfig = freeMarkerConfig;
    }
}
