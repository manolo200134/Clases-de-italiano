package web_ui.pages;

import org.openqa.selenium.By;
import web_ui.control.Label;

public class PopUpMessageSection {
    public Label emptyRecyclerBinMessage=new Label(By.xpath("//td[@class=\"HeaderTd\"]//div[@style=\"display: block;\"]"));
}
