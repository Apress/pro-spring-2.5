package com.apress.prospring2.ch04.factoy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

/**
 * @author janm
 */
public class MessageDigestFactoryBean implements FactoryBean, InitializingBean {
    private static final String DEFAULT_ALGORITHM = "MD5";
    
    private String algorithm = DEFAULT_ALGORITHM;
    private MessageDigest messageDigest;
    
    public Object getObject() throws Exception {
        return this.messageDigest.clone();
    }

    public Class getObjectType() {
        return MessageDigest.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void afterPropertiesSet() throws Exception {
        this.messageDigest = MessageDigest.getInstance(this.algorithm);
    }
}
