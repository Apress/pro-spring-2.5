package com.apress.prospring2.ch15.remoting.http;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author aleksav
 */
public class HttpClientFactoryBean implements FactoryBean, InitializingBean {

    private HttpClient httpClient = null;

    private String username = null;

    private String password = null;

    private String authenticationHost = null;

    private String authenticationRealm = null;

    public Object getObject() throws Exception {
        return httpClient;
    }

    public Class getObjectType() {
        return HttpClient.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthenticationHost(String authenticationHost) {
        this.authenticationHost = authenticationHost;
    }

    public void setAuthenticationRealm(String authenticationRealm) {
        this.authenticationRealm = authenticationRealm;
    }

    public void afterPropertiesSet() throws Exception {
        if ((username == null) || (password == null)) {
            throw new IllegalArgumentException(
                    "You must set the username, password and "
                            + "authenticationHost properties");
        }

        httpClient = new HttpClient();
        httpClient.getState().setAuthenticationPreemptive(true);

        Credentials credentials = new UsernamePasswordCredentials(username,
                password);
        httpClient.getState().setCredentials(authenticationRealm,
                authenticationHost, credentials);
    }
}
