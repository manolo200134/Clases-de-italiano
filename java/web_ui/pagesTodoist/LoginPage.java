package web_ui.pagesTodoist;


import org.openqa.selenium.By;
import web_ui.control.Button;
import web_ui.control.TextBox;

public class LoginPage {
    public TextBox emailTxtBox = new TextBox(By.id("email"));
    public TextBox passwordTxtBox = new TextBox(By.id("password"));
    public Button loginButton = new Button(By.xpath("//button[text()=\"Log in\"]"));
}
