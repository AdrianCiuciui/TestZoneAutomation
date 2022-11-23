import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BigTestClassMe {

    /**
     * Known issues:
     *
     * can't use a class for the search results page (issues with the base test and page object classes)
     *      that's why I cannot uncomment the last assert, if I want to show something moving in the app
     * after clicking the submit button an error page is returned. Cannot figure out why
     * little knowledge with Date, so did not have time to implement the selections
     *      the plan was to convert the local date to the one from the website, even found out the patter -> Month D, yyyy
     * little knowledge with the locators that have changeable content -
     *  you create them initially as Strings and you convert them afterwards to xpath
     *      I would have used it with the dates and with most of the locators
     *
     */


    private static final String URL = "https://www.hotwire.com/";
    private static final String FLY_FROM_LOCATION = "SFO";
    private static final String FLY_TO_LOCATION = "LAX";

    private static final By NON_FUNCTIONAL = By.xpath("//*[@class=\"bundle-options-subhead \"]");
    private static final By BTN_BUNDLES = By.xpath("//*[@data-bdd=\"farefinder-option-bundles\"]");
    private static final By BTN_CAR_INACTIVE = By.xpath("//*[@data-bdd=\"farefinder-package-bundleoption-car\"]");
    private static final By BTN_FLIGHT_ACTIVE = By.xpath("//*[@data-bdd=\"farefinder-package-bundleoption-flight\"]//*[@data-id=\"SVG_HW_FUNCTIONAL_CIRCLE_CHECK_FILLED\"]\n");
    private static final By BTN_HOTEL_ACTIVE = By.xpath("//*[@data-bdd=\"farefinder-package-bundleoption-hotel\"]//*[@data-id=\"SVG_HW_FUNCTIONAL_CIRCLE_CHECK_FILLED\"]\n");
    private static final By BTN_CAR_ACTIVE = By.xpath("//*[@data-bdd=\"farefinder-package-bundleoption-car\"]//*[@data-id=\"SVG_HW_FUNCTIONAL_CIRCLE_CHECK_FILLED\"]\n");
    private static final By INPUT_FIELD_FLY_FROM = By.xpath("//*[@data-bdd=\"farefinder-package-origin-location-input\"]");
    private static final By INPUT_FIELD_FLY_TO = By.xpath("//*[@data-bdd=\"farefinder-package-destination-location-input\"]");

    private static final By DEPARTING_CALENDAR_START = By.xpath("//*[contains(@aria-label,\"November 24, 2022\")]");
    private static final By DEPARTING_CALENDAR_END = By.xpath("//*[contains(@aria-label=\"December 13, 2022\")]");
    private static final By DEPARTING_PICKUP_START = By.xpath("//*[@name=\"carPickupTime\"]");
    private static final By DEPARTING_PICKUP_END = By.xpath("//*[@name=\"carDropoffTime\"]");
    private static final By DD_EVENING = By.xpath("//*[@value=\"Evening\"]");
    private static final By DD_MORNING = By.xpath("//*[@value=\"Morning\"]");
    private static final By BTN_SUBMIT = By.xpath("//*[@class=\"submit-button\"]");

//    private SearchResultsPage searchResultsPage;

    @Test ()
    void theTest() throws InterruptedException {

        //setup
        WebDriver driver = new FirefoxDriver();
//        SearchResultsPage searchResultsPage = new SearchResultsPage();
        driver.get(URL);
        Thread.sleep(2500);


        driver.findElement(BTN_BUNDLES).click();
        driver.findElement(BTN_CAR_INACTIVE).click();
        boolean areAllButtonsActive = driver.findElement(BTN_FLIGHT_ACTIVE).isDisplayed() &&
                driver.findElement(BTN_HOTEL_ACTIVE).isDisplayed() &&
                driver.findElement(BTN_CAR_ACTIVE).isDisplayed();
        assertThat(areAllButtonsActive, is(true));

        driver.findElement(INPUT_FIELD_FLY_FROM).sendKeys(FLY_FROM_LOCATION);
        driver.findElement(INPUT_FIELD_FLY_TO).sendKeys(FLY_TO_LOCATION);
        driver.findElement(NON_FUNCTIONAL).click();
        Thread.sleep(1000);

        //calendar stuff. I tried the following, but Java wouldn't build.
//
//        LocalDate currentDay = LocalDate.now();
//        System.out.println("===>  Time: " + currentDay);
//        String dateAsString = currentDay.toString();
//        LocalDate test = LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern("Month D, yyyy"));
//        System.out.println("\n =>>>>> new date: " + test);
//        SimpleDateFormat dddaaa = new SimpleDateFormat("Month D, yyyy");


        driver.findElement(DEPARTING_PICKUP_START).click();
        driver.findElement(DD_EVENING).click();
        driver.findElement(DEPARTING_PICKUP_END).click();
        driver.findElement(DD_MORNING);
        driver.findElement(NON_FUNCTIONAL).click();

        driver.findElement(BTN_SUBMIT).click();
        Thread.sleep(15000);

//        assertThat(searchResultsPage.isSearchResultsDisplayed(), is(true));

        driver.close();
    }
}
