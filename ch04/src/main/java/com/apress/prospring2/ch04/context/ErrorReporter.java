package com.apress.prospring2.ch04.context;

/**
 * @author janm
 */
public class ErrorReporter {

    public void evaluate(double[] values) {
        if (values.length % 2 != 0)
            throw new SourceDataInvalidException(
                "@Lcom.apress.prospring2.ch04.context.sourcedatainvalid",
                    values.length);
        for (int i = 0; i < values.length; i++) {
            double value = values[i];
            if (value < 0)
                throw new ArgumentDomainException(
                    "@Lcom.apress.prospring2.ch04.context.argumentdomain",
                        value);
            Math.log(value);
        }
    }
    
}
