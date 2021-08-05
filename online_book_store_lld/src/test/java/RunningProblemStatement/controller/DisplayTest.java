package RunningProblemStatement.controller;

import RunningProblemStatement.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class DisplayTest {

    Display display;

    @BeforeEach
    public void setUp() throws Exception {
        display = new Display();
    }

    @Test
    public void testShouldBeAbleToDisplayUser() {
        User user = new User(1, "", "vru");
        display.displayUser(user);
    }
}