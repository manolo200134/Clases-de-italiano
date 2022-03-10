package web_ui.pages;

import org.openqa.selenium.By;
import web_ui.control.Image;

public class MainPage {
    public Image singUpFree = new Image(By.xpath("//img[@src=\"/Images/design/pagesignup.png\"]"));
    public Image loginImage= new Image(By.xpath("//img[@src='/Images/design/pagelogin.png']"));

}
