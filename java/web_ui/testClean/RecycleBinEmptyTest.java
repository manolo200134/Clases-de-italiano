package web_ui.testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import web_ui.control.Button;
import web_ui.pages.*;

public class RecycleBinEmptyTest extends BaseTodoly {
    MainPage mainPage = new MainPage();
    PrincipalPage principalPage = new PrincipalPage();
    LoginModal loginModal = new LoginModal();
    LeftMenu leftMenu = new LeftMenu();
    PopUpMessageSection popUpMessageSection = new PopUpMessageSection();
    String email="upb_api_prueba@upb.com";
    String pwd="upb123";

    @Test
    public void verifyRecyclerBinEmpty() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailLogInTxtBox.setText(email);
        loginModal.pwdLoginTextBox.setText(pwd);
        Thread.sleep(2000);
        loginModal.loginButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(principalPage.logoutButton.isControlDisplayed());

        //Recycler Bin
        leftMenu.recyclerBinOptions.click();
        Thread.sleep(2000);
        leftMenu.emptyRecycleBinButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(popUpMessageSection.emptyRecyclerBinMessage.isControlDisplayed());
    }

}
