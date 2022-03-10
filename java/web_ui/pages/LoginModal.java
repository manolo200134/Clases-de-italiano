package web_ui.pages;

import org.openqa.selenium.By;
import org.w3c.dom.Text;
import web_ui.control.Button;
import web_ui.control.Image;
import web_ui.control.TextBox;

public class LoginModal {
    public TextBox emailLogInTxtBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"));
    public TextBox pwdLoginTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"));
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"));
}
