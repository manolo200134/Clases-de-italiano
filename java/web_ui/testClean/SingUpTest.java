package web_ui.testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web_ui.pages.MainPage;
import web_ui.pages.PrincipalPage;
import web_ui.pages.SingUpModal;

import java.util.Date;

public class SingUpTest extends BaseTodoly{
    MainPage mainPage = new MainPage();
    PrincipalPage principalPage = new PrincipalPage();
    SingUpModal singUpModal = new SingUpModal();
    String fullname="Manuel"+ new Date().getMinutes()+new Date().getSeconds();
    String email="pruebamanuel"+new Date().getSeconds()+new Date().getMinutes()+"@upb.com";
    String pwd="prueba123";

    @Test
    public void verifySingUp() throws InterruptedException {
        mainPage.singUpFree.click();
        singUpModal.fullnameTxtBox.setText(fullname);
        singUpModal.emailTxtBox.setText(email);
        singUpModal.pwdTxtBox.setText(pwd);
        singUpModal.agreementButton.click();
        Thread.sleep(3000);
        singUpModal.singUpButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(principalPage.logoutButton.isControlDisplayed());
    }

}
