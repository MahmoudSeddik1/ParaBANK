package logintests;

import basetests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Login_Credentials extends BaseTest {
    @Test (priority = 0)
    public void login_Successful(){

       var mainpage=  homepage.login_predefined();
       assertEquals(mainpage.getWelcomeMessage(),"Welcome John Smith");
       mainpage.logout();
    }
    @Test (priority = 1)
    public void login_Failure_Credentials(){
        homepage.login_custom("john", "test");
        assertEquals(homepage.getErrorHeader(),"Error!","Error message did not appear!");
    }
    @Test
    public void login_TAB(){
        var mainpage = homepage.login_TAB("john", "demo");
    }
    @Test
    public void login_Failure_MissingCredentialUser(){
        homepage.login_custom("John","");
        assertEquals(homepage.getErrorMessage(),"Please enter a username and password.",
                "Error message did not appear!");
    }
    @Test
    public void login_Failure_MissingCredentialPassword(){
        homepage.login_custom("","demo");
        assertEquals(homepage.getErrorMessage(),"Please enter a username and password.",
                "Error message did not appear!");
        
    }


}
