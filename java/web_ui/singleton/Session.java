package web_ui.singleton;

import org.openqa.selenium.WebDriver;
import web_ui.factoryBrowser.FactoryBrowser;

public class Session {
    private static Session session=null;
    private WebDriver driver;

    private Session(){
        driver= FactoryBrowser.make("chrome").createBrowser();
    }

    public static Session getInstance(){
        if (session == null)
            session= new Session();
        return session;
    }

    public void closeSession(){
        driver.quit();
        session=null;
    }

    public WebDriver getDriver() {
        return driver;
    }
}