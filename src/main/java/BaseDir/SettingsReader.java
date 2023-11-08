package BaseDir;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SettingsReader {
    static Properties props;
    public static String browser;
    public static String url;
    public static int waitTime;
    public static String timerValue;

    static {
        props = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/configuration/config.properties")) {
            props.load(input);
            browser = props.getProperty("browser");
            url = props.getProperty("url");
            waitTime = Integer.parseInt(props.getProperty("waitTime"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (InputStream input2 = new FileInputStream("src/main/resources/test_data.properties")) {
            props.load(input2);
            timerValue = props.getProperty("timer.value");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
