package APITests;

import api.UserEditor;
import base.BaseSetup;
import org.testng.annotations.Test;

public class EditUserTest extends BaseSetup {

    @Test
    public void verifyEditingUser(){
        UserEditor userEditor = new UserEditor();
        userEditor.editUser();
    }
}
