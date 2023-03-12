import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;
    WebDriverWait wait;
    By submitBtn = By.cssSelector("[type='submit']");
    By nextBtn = By.cssSelector("[data-testid ='play-next-btn']");
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    @Parameters("BaseUrl")
    public void setUpBrowser(String BaseUrl) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BaseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   protected void openBrowser() {String url = "https://bbb.testpro.io/";
        driver.get(url);
   }

    public void closeBrowser() {
        driver.quit();
    }

    public void enterEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("rfkayoub12@gmail.com");
    }

    public void enterPassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }

    public void submit() throws InterruptedException {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitButton.click();

    }

    public void searchForSong() throws InterruptedException {
       // WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        searchField.click();
        searchField.sendKeys("Lament");

    }

    public void clickViewAll() throws InterruptedException {
        //WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='view-all-songs-btn']")));
        viewAll.click();

    }

    public void clickFirstSong() throws InterruptedException {

        //WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title")));
        firstSong.click();



    }

    public void clickAddTo() throws InterruptedException {
       //WebElement addToBtn = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn-add-to']")));
        addToBtn.click();

    }

    public void choosePlaylist() throws InterruptedException {
       // WebElement chosenPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)"));
        WebElement chosenPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)")));
        chosenPlaylist.click();

    }

    public String getNotification() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }

    public void clickNext() throws InterruptedException {
        WebElement nextBtn = driver.findElement(By.cssSelector("[data-testid ='play-next-btn']"));
       // WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.valueOf(nextBtn))));
        nextBtn.click();

    }

    public void clickPlay()  {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
       // WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-btn']")));
        playBtn.click();

    }

    public Boolean isSongPlaying() {
        WebElement songIsPLaying = driver.findElement(By.cssSelector("[class='plyr__progress--seek']"));
        return songIsPLaying.isDisplayed();
    }

    public void clickPlaylist() throws InterruptedException {
        WebElement chosenPlaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        chosenPlaylist.click();
    }
    public void clickDelete() throws InterruptedException {
        WebElement xPlaylist = driver.findElement(By.cssSelector("[title = 'Delete this playlist']"));
        xPlaylist.click();
    }
}