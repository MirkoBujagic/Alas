package APITests;

import api.DeleteUser;
import base.BaseSetup;
import org.testng.annotations.Test;

public class DeleteUserTest extends BaseSetup {

    @Test
    public void verifyDeleteUser(){
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }
}
