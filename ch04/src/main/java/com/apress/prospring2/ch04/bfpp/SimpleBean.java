package com.apress.prospring2.ch04.bfpp;

/**
 * @author janm
 */
@Magic
public class SimpleBean {
    private String connectionString;
    private String username;
    private String password;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SimpleBean");
        sb.append("{password='").append(password).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", connectionString='").append(connectionString).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
