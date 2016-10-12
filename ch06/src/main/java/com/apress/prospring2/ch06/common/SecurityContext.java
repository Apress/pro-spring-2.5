package com.apress.prospring2.ch06.common;

import org.springframework.util.Assert;

/**
 * @author janm
 */
public class SecurityContext {

    private static class SecurityContextHolder {
        private ThreadLocal<String> currentUser = new ThreadLocal<String>();

        void setCurrentUser(String user) {
            this.currentUser.set(user);
        }

        String getCurrentUser() {
            return this.currentUser.get();
        }
    }

    private static SecurityContextHolder holder = new SecurityContextHolder();

    public static void setCurrentUser(String user) {
        Assert.notNull(user, "The argument 'user' must not be null.");
        holder.setCurrentUser(user);
    }

    public static String getCurrentUser() {
        return holder.getCurrentUser();
    }

}
