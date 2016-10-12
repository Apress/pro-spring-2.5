package com.apress.prospring2.ch04.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * @author janm
 */
public class BetterErrorReportingDemo {

    private static void run(ApplicationContext context, Locale locale,
        ErrorReporter reporter, double[] values) {
        try {
            reporter.evaluate(values);
            System.out.println("Success");
        } catch (SourceDataInvalidException ex) {
            System.out.println(context.getMessage(ex.getMessage(),
                new Object[] { ex.getLength() }, locale ));
        } catch (ArgumentDomainException ex) {
            System.out.println(context.getMessage(ex.getMessage(),
                new Object[] { ex.getArgument() }, locale ));
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "/META-INF/spring/acdemo5-context.xml");
        ErrorReporter reporter = (ErrorReporter) ctx.getBean("errorReporter");
        Locale en_GB = new Locale("en", "GB");
        Locale cs_CZ = new Locale("cs", "CZ");
        run(ctx, en_GB, reporter, new double[] { 1 } );
        run(ctx, en_GB, reporter, new double[] { 1, -2 } );
        run(ctx, en_GB, reporter, new double[] { 1, 3 } );
        run(ctx, cs_CZ, reporter, new double[] { 1 } );
        run(ctx, cs_CZ, reporter, new double[] { 1, -2 } );
        run(ctx, cs_CZ, reporter, new double[] { 1, 3 } );
    }

}