package com.apress.prospring2.ch21.services.testacontext;

import com.apress.prospring2.ch21.domain.User;
import com.apress.prospring2.ch21.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.sql.DataSource;

/**
 * @author Aleksa Vukotic
 */

@ContextConfiguration(locations = {"/com/apress/prospring2/ch22/dataaccess/applicationContext-dataaccess.xml", "/com/apress/prospring2/ch22/services/applicationContext-services.xml"})
@TransactionConfiguration(transactionManager = "myTransactionManager")
public class DefaultUserServiceIntegrationTests extends AbstractTransactionalJUnit38SpringContextTests {

    protected UserService userService;

    public DefaultUserServiceIntegrationTests() {

    }

    @AfterTransaction
    public void checkDatabaseState() {
        assertEquals("No users should be saved in this test", 0, this.userService.findAllUsers().size());
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

    @Autowired(required = false)
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired(required = false)
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
