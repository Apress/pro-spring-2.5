package com.apress.prospring2.ch21.services;

import com.apress.prospring2.ch21.domain.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.AbstractTransactionalSpringContextTests;

import javax.naming.NamingException;

/**
 * @author Aleksa Vukotic
 */
public class DefaultUserServiceIntegrationTests4 extends AbstractTransactionalSpringContextTests {
    protected UserService userService;

    public static void buildJndi() {
        try {
            SimpleNamingContextBuilder builder;
            builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();

            String connectionString = "jdbc:oracle:thin:@oracle.devcake.co.uk:1521:INTL";
            builder.bind("java:comp/env/jdbc/prospring2/ch11", new DriverManagerDataSource(
                    "oracle.jdbc.driver.OracleDriver", connectionString, "PROSPRING", "x******6"));
        } catch (NamingException e) {
            // noop
        }
    }

    public DefaultUserServiceIntegrationTests4() {
        buildJndi();
    }

    protected String[] getConfigLocations() {
        String[] paths = new String[]{
                "classpath*:/com/apress/prospring2/ch22/dataaccess/applicationContext-dataaccess.xml",
                "classpath*:/com/apress/prospring2/ch22/services/applicationContext-services.xml"
        };
        return paths;
    }

    public void testRegister() throws Exception {

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

    }


    public void testRegisterIncorrectPassword() throws Exception {

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

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
