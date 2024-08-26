package Steps;

import Pages.LoginPage;
import Pages.SecurePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;

public class TC1_ValidateLogin extends BaseTest {


    @Test
    void VerifyWeCanLoginWithValidData(){
    LoginPage loginPage = new LoginPage(this.driver);
    SecurePage securePage = loginPage.loginWithData();
    securePage.assertLoginSuccess();
    securePage.pressLogout();
    loginPage.assertLogoutSuccess();
    }
}
