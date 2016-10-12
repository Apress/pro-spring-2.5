package com.apress.prospring2.ch04.mi;

/**
 * @author janm
 */
public class StandardLookupDemoBean implements DemoBean {
    private MyHelper helper;

    public void setMyHelper(MyHelper helper) {
        this.helper = helper;
    }

    public MyHelper getMyHelper() {
        return this.helper;
    }

    public void someOperation() {
        helper.doSomethingHelpful();
    }
}
