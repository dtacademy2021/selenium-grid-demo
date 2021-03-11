package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before()
    public void setupScenario() {

        Driver.getDriver().manage().timeouts().
                implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().manage().window().maximize();



    }






    @After()
    public void tearDownScenario(Scenario scenario) {

        if(scenario.isFailed()) {
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

            scenario.attach(screenshot, "image/png", "Screenshot"+date);
        }



        Driver.quit();
    }
}
