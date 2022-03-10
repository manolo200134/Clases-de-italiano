package web_ui.testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web_ui.pages.LoginModal;
import web_ui.pages.MainPage;
import web_ui.pages.PrincipalPage;

public class LogoutTest extends BaseTodoly {
    MainPage mainPage = new MainPage();
    PrincipalPage principalPage = new PrincipalPage();
    LoginModal loginModal = new LoginModal();
    String email="upb_api_prueba@upb.com";
    String pwd="upb123";

    @Test
    public void verifyLogOut() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailLogInTxtBox.setText(email);
        loginModal.pwdLoginTextBox.setText(pwd);
        Thread.sleep(2000);
        loginModal.loginButton.click();
        Thread.sleep(2000);
        principalPage.logoutButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(mainPage.loginImage.isControlDisplayed());
        Assertions.assertTrue(mainPage.singUpFree.isControlDisplayed());

    }
}
