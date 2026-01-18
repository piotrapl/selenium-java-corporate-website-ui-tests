//BaseTest to abstrakcyjna klasa bazowa dla wszystkich testów
// Rola klasy BaseTest - dostarczenie wspólnych funkcjonalności
// 1. zarządzanie cyklem życia WebDrivera.
// 2. unikanie duplikacji kodu w klasach testowych (zasada DRY)
// 3. spójny lifecycle testów (setup / teardown)
//    ( ułatwienie utrzymania i rozszerzania testów w przyszłości ) 

package pl.ageno.tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

// główny interfejs Selenium do sterowania przeglądarką
// scope: protected - chroniony dostęp,
// aby driver nie był dostępny spoza hierarchii dziedziczenia
// (zapewnienie enkapsulacji i bezpieczeństwa danych)

protected WebDriver driver;

// adnotacje JUnit 5, sterujące cyklem życia testów
    @BeforeEach
    void setUp() {
        driver = DriverFactory.createChromeDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

// klasa BaseTest jest abstract (abstrakcyjna), bo nie ma sensu tworzyć jej instancji.
// nie jest testem - jest tylko fundamentem dla testów
// BaseTest istnieje tylko po to, by inne klasy po niej dziedziczyły
//        (zapewnienie wspólnych funkcjonalności i lifecycle testów)