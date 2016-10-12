package com.apress.prospring2.ch13.service;

import com.apress.prospring2.ch13.domain.EmailMessage;
import com.apress.prospring2.ch13.domain.MailFormat;
import junit.framework.TestCase;
import org.springframework.beans.FatalBeanException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Locale;

/**
 * @author anirvanc
 */
public class FreemarkerEmailMessageProducerTest extends TestCase {
    private FreemarkerEmailMessageProducer producer;
	private Locale cs_CZ = new Locale("cs", "CZ");
	private Locale en_GB = new Locale("en", "GB");

	@Override
	protected void setUp() throws Exception {
		String cd = getClass().getResource(".").toExternalForm();
		FreeMarkerConfigurer fmc = new FreeMarkerConfigurer();
		fmc.setTemplateLoaderPath(cd);
		fmc.afterPropertiesSet();

		this.producer = new FreemarkerEmailMessageProducer();
		this.producer.setFreeMarkerConfig(fmc);
		this.producer.afterPropertiesSet();
	}

	public void testAfterPropertiesSet() throws Exception {
		this.producer.afterPropertiesSet();

		this.producer.setFreeMarkerConfig(null);
		try {
			this.producer.afterPropertiesSet();
			fail("FreeMarkerConfig property not set and no Exception thrown");
		} catch (FatalBeanException ex) {
			// OK
		}
	}

	private void assertBody(final Locale locale, final MailFormat format, final String expected) {
		EmailMessage mailMessage;

		mailMessage = this.producer.produce("test", locale, format, null);
		assertEquals("Incorrect body", expected, mailMessage.getBody());
	}

	public void testCreateBodyValidLocale() {
		assertBody(cs_CZ, MailFormat.html, "<html>cesky</html>");
		assertBody(cs_CZ, MailFormat.plain, "cesky");
		assertBody(en_GB, MailFormat.plain, "British English");
	}

    public void testCreateBodyInvalidLocale() {
        try {
            assertBody(new Locale("fo", "BA"), MailFormat.plain, "British English");
            fail("Loaded template for invalid locale");
        } catch (RuntimeException e) {
            // expected
        }
    }
}
