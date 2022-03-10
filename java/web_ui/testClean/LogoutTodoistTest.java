package web_ui.testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web_ui.pagesTodoist.MainPage;
import web_ui.pagesTodoist.LoginPage;
import web_ui.pagesTodoist.TopBarTools;

public class LogoutTodoistTest extends BaseTodoist{

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    TopBarTools topBarTools = new TopBarTools();
    String email = "manli2001@hotmail.es";
    String password="PruebaWeb123";

    @Test
    public void verifyLogOut() throws InterruptedException {
        Thread.sleep(2000);
        mainPage.loginButton.click();
        Thread.sleep(2000);
        loginPage.emailTxtBox.setText(email);
        loginPage.passwordTxtBox.setText(password);
        loginPage.loginButton.click();
        topBarTools.avatarMenuButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(topBarTools.logoutButton.isControlDisplayed(),"ERROR, no se hizo el login");

        //Log out
        topBarTools.logoutButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(mainPage.loginButton.isControlDisplayed());
    }
}
