package web_ui.testClean;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import web_ui.singleton.Session;

public class BaseTodoly {

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getDriver().get("http://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
