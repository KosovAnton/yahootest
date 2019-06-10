package html.elements;

import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.Objects;

import static org.junit.Assert.assertTrue;
import static utils.GlobalValues.DEFAULT_WAITING_TIMEOUT;
import static utils.GlobalValues.DRIVER;

public class BaseWebElement<T> extends HtmlElement {

    private WebDriverWait wait = new WebDriverWait(DRIVER, DEFAULT_WAITING_TIMEOUT);

    private boolean isVisible() {
        try {
            wait.until(Function -> this.isDisplayed());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public T shouldBeDisplayed() {
        assertTrue("Element " + this.getName() + " was not visible during " + DEFAULT_WAITING_TIMEOUT + " seconds", isVisible());
        return (T) this;
    }

    public void shouldNotBeDisplayed() {
        assertTrue("Element " + this.getName() + " was visible during " + DEFAULT_WAITING_TIMEOUT + " seconds",
                wait.until(Function -> Objects.equals(isVisible(), false)));
    }
}
