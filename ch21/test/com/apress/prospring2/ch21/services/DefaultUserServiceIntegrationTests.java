package com.apress.prospring2.ch21.services;

import com.apress.prospring2.ch21.domain.User;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksa Vukotic
 */
public class DefaultUserServiceIntegrationTests extends TestCase {


    private ApplicationContext getApplicationContext() {
        String[] paths = new String[]{
                "classpath*:/com/apress/prospring2/ch22/dataaccess/applicationContext-dataaccess.xml",
                "classpath*:/com/apress/prospring2/ch22/services/applicationContext-services.xml"
        };
        return new ClassPathXmlApplicationContext(paths);
    }

    public void testRegister() {
        ApplicationContext context = getApplicationContext();
        UserService userService = (UserService) context.getBean("userService");

        User user = new User();
        user.setUsername("jonhs");
        user.setPassword("hTy86dj");

        userService.register(user);

        assertNotNull("User not saved!", user.getId());

        User user2 = new User();
        user2.setUsername("jonhs");
        user2.setPassword("fGC467");
        try {
            userService.register(user2);
            fail("Cannot save user with existing username!");
        } catch (IllegalArgumentException ex) {
            //OK
        }
        userService.delete(user);
    }

    public void testRegisterSameUsername() {

    }

    public void testRegisterIncorrectPassword() {
        ApplicationContext context = getApplicationContext();
        UserService userService = (UserService) context.getBean("userService");

        User user3 = new User();
        user3.setUsername("jandD");
        user3.setPassword("fgh85");
        try {
            userService.register(user3);
            fail("Password must be at least 6 characters long!");
        } catch (IllegalArgumentException ex) {
            //OK
        }
    }
}
