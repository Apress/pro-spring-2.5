package com.apress.prospring2.ch05.annotation;

/**
 * Created by aleksav
 */
@SimpleAnnotation
public class SampleBean {

    @SimpleAnnotation
    public String getName() {
        return "Aleksa V";
    }

    public void setName(String name) {

    }

    public int getHeight() {
        return 201;
    }
}
