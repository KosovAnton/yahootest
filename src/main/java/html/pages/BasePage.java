package html.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static utils.GlobalValues.DEFAULT_WAITING_TIMEOUT;
import static utils.GlobalValues.DRIVER;

public class BasePage extends HtmlElement {

    public WebDriverWait wait = new WebDriverWait(DRIVER, DEFAULT_WAITING_TIMEOUT);

    public BasePage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DRIVER)), this);
    }
}
