package com.apress.prospring2.ch04.mi;

/**
 * @author janm
 */
public abstract class AbstractLookupDemoBean implements DemoBean {

    public abstract MyHelper getMyHelper();

    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}