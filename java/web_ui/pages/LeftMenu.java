package web_ui.pages;

import org.openqa.selenium.By;
import web_ui.control.Button;

public class LeftMenu {
    public Button recyclerBinButton = new Button(By.xpath("//tbody//td[text()='Recycle Bin']"));
    public Button recyclerBinOptions = new Button(By.xpath("//div[@itemid=\"-3\"]//img"));
    public Button emptyRecycleBinButton = new Button(By.xpath("//a[@href='#emptyRecycle']"));

}