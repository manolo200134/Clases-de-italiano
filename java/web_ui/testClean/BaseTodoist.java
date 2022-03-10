package web_ui.testClean;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import web_ui.singleton.Session;

public class BaseTodoist {

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getDriver().get("https://todoist.com/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
