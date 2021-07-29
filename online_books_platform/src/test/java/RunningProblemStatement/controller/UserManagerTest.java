package RunningProblemStatement.controller;


import RunningProblemStatement.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
class UserManagerTest {

    UserManager userManager;

    @BeforeEach
    public void setUp() throws Exception {
        userManager = new UserManager();
    }

    @Test
    public void shouldAddNewUser() {
        User user = new User(1, "", "Vru");
        Assertions.assertTrue(userManager.addUser(user));
    }

    @Test
    public void shouldNotAddDuplicateAddNewUser() {
        User user = new User(1, "", "Vru");
        User user2 = new User(1, "", "Abhi");
        Assertions.assertTrue(userManager.addUser(user));
        Assertions.assertFalse(userManager.addUser(user2));
    }

    @Test
    public void testShouldShouldRemoveUserFromUserManager() {
        User user = new User(1, "", "Vru");
        User user2 = new User(2, "", "Abhi");

        userManager.addUser(user);
        userManager.addUser(user2);

        Assertions.assertEquals(2, userManager.getUsers());

        boolean b = userManager.remove(user);
        Assertions.assertTrue(b);
        Assertions.assertEquals(1, userManager.getUsers());
    }

    @Test
    public void shouldCheckUserEquality() {
        User user = new User(1, "", "Vru");
        User user2 = new User(1, "", "Vru");
        Assertions.assertEquals(user, user2);
    }
}