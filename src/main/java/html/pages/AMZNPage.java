package html.pages;

import html.blocks.TabHistoricalData;
import html.elements.Link;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import static utils.GlobalValues.BASE_URL;
import static utils.GlobalValues.DRIVER;

public class AMZNPage extends BasePage {

    private final String URL = BASE_URL + "/quote/AMZN";

    private TabHistoricalData tabHistoricalData;

    @Name("Link 'Historical Data'")
    @FindBy(xpath = ".//span[text()='Historical Data']/ancestor::a")
    private Link historicalData;

    @Name("Link 'Download Data'")
    @FindBy(xpath = ".//span[text()='Download Data']/ancestor::a")
    private Link downloadData;

    public AMZNPage open(){
        DRIVER.get(URL);
        return this;
    }

    public TabHistoricalData openTabHistoricalData(){
        historicalData.shouldBeDisplayed()
                .click();
        return tabHistoricalData;
    }

    public TabHistoricalData getTabHistoricalData() {
        return tabHistoricalData;
    }

    public TabHistoricalData clickdownloadDataLink(){
        downloadData.shouldBeDisplayed()
                .click();
        return tabHistoricalData;
    }
}
