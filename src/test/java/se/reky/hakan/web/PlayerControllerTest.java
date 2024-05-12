package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;


// Implementerar Lifecycle.PER_CLASS för att dela state mellan olika klasser
@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayerControllerTest {
    private WebDriver driver;

    // Vi sätter upp webbdriver som körs genom alla test
    @BeforeAll
    void setUpWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    // Vi skapar en ny instansering av webbdriver innan varje test för att säkerställa att varje test sker självständigt
    @BeforeEach
    void setUpWebDriver() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDownWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void verifyListOfTotalPlayers() {

        // Hämta sidan
        driver.get("http://localhost:8080/players");

        // Hitta elementet som innehåller listan med players
        List<WebElement> playerElements = driver.findElements(By.cssSelector("ul > li"));

        int actualPlayerCount = playerElements.size();
        int expectedPlayerCount = 3;

        Assertions.assertEquals(expectedPlayerCount, actualPlayerCount, "Numbers of players is incorrect");

    }

    @Test
    void verifyFirstNameOfPlayerIsDisplayed() {
        driver.get("http://localhost:8080/players");
        WebElement firstPlayerElementInListOfPlayers = driver.findElement(By.cssSelector("ul > li:first-child > .player-name"));
        Assertions.assertTrue(firstPlayerElementInListOfPlayers.isDisplayed(), "First player is not displayed");
    }

    @Test
    void verifyPageTitleIsDisplayedAndCorrect() {
        driver.get("http://localhost:8080/players");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Players List";

        Assertions.assertEquals(expectedTitle, actualTitle, "Title is incorrect");
    }

    @Test
    void verifyLoginButtonHasCorrectText() {
        driver.get("http://localhost:8080/players");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        String actualLoginButtonText = loginButton.getText();
        String expectedLoginButtonText = "Logga in";
        Assertions.assertEquals(expectedLoginButtonText, actualLoginButtonText, "Login button is incorrect");

    }

}
