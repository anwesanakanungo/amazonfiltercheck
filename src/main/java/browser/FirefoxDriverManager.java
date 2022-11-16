package browser;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;


import java.io.File;

public class FirefoxDriverManager extends DriverManager  {

    private GeckoDriverService firefoxService;

    @Override
    public void startService() {
        if (null == firefoxService) {
            try {
                firefoxService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("src/main/resources/Browser/Chrome/firefox/geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
                firefoxService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != firefoxService && firefoxService.isRunning())
            firefoxService.stop();
    }

    @Override
    public void createDriver() {

        driver = new FirefoxDriver();
    }

}
