import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest {
    @Test
    public void renameOldPlaylist() {
        enterEmail();
        enterPassword();
        submit();
        clickPlaylist();
        renamePlaylist();
        enterPlaylistName();
    }
}