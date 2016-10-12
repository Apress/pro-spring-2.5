package com.apress.prospring2.ch21.services;

import com.apress.prospring2.ch21.domain.User;
import org.springframework.test.annotation.AbstractAnnotationAwareTransactionalTests;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;

/**
 * @author Aleksa Vukotic
 */
public class DefaultUserServiceIntegrationTests5 extends AbstractAnnotationAwareTransactionalTests {
    protected UserService userService;

    protected String[] getConfigLocations() {
        String[] paths = new String[]{
                "classpath*:/com/apress/prospring2/ch22/dataaccess/applicationContext-dataaccess.xml",
                "classpath*:/com/apress/prospring2/ch22/services/applicationContext-services.xml"
        };
        return paths;
    }

    @Repeat(10)
    @Timed(millis = 5000)
    @ExpectedException(IllegalArgumentException.class)
    public void testRegister() throws Exception {
        System.out.println("done");
        User user = new User();
        user.setUsername("jonhs");
        user.setPassword("hTy86dj");

        userService.register(user);

        assertNotNull("User not saved!", user.getId());

        User user2 = new User();
        user2.setUsername("jonhs");
        user2.setPassword("fGC467");

        userService.register(user2);


    }

    @ExpectedException(IllegalArgumentException.class)
    public void testRegisterIncorrectPassword() throws Exception {

        User user3 = new User();
        user3.setUsername("jandD");
        user3.setPassword("fgh85");
        userService.register(user3);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
