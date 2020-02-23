package config;

public class Configuration {

    public static String WRONG_EMAIL = "pawel@pawelo.com";
    public static String WRONG_PASSWORD = "DummyPassword123";
    public static String CHROME_LOCATION = chromedriverLocation();


    private static String chromedriverLocation(){

        String chromeLocation;
        String userDirectory = System.getProperty("user.dir");
        String os_version=System.getProperty("os.name");

        if(os_version.contains("Mac")){
           chromeLocation=userDirectory+"/src/main/resources/chromedriver-mac";
        }
        else if(os_version.contains("Windows")){
            chromeLocation=userDirectory+"/src/main/resources/chromedriver-windows.exe";
        }
        else {
            chromeLocation=userDirectory+"/src/main/resources/chromedriver-linux";
        }

        return chromeLocation;
    }

}



