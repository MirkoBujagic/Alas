package APITests;

import api.UserCreator;
import base.BaseSetup;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseSetup {

    @Test
    public void verifyCreatingUser() {
        UserCreator userCreator = new UserCreator();
        userCreator.creatingUser();
    }
}
