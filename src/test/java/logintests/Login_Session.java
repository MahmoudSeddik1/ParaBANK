package logintests;

import basetests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Login_Session extends BaseTest {
    @Test
    public void test_LoginSession(){
        var mainpage = homepage.login_predefined();
        closeSession();
        setup();
        goHome();
        assertEquals(mainpage.getWelcomeMessage(),"Welcome John Smith");
    }
    @Test
    public void test_LoginSessionBack(){
        var mainpage = homepage.login_predefined();
        getWindowManager().goBack();
        getWindowManager().goForward();
        assertEquals(mainpage.getWelcomeMessage(),"Welcome John Smith");
    }
}
