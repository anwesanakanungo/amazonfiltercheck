package browser;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;

        }
        return driverManager;

    }
}
