package web_ui.pages;

import org.openqa.selenium.By;
import web_ui.control.Button;
import web_ui.control.TextBox;

public class SingUpModal {
    public TextBox fullnameTxtBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox emailTxtBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public TextBox pwdTxtBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public Button  singUpButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));
    public Button agreementButton = new Button(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
}
