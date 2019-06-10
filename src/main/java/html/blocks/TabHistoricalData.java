package html.blocks;

import html.elements.BaseWebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Name("Tab 'Historical Data'")
@FindBy(xpath = ".//div[@id='Col1-1-HistoricalDataTable-Proxy']")
public class TabHistoricalData extends BaseWebElement<TabHistoricalData> {

    @Name("Table 'Currency in USD'")
    @FindBy(xpath = ".//table[@data-test='historical-prices']")
    private Table table;

    public List<Date> getColumnDates() throws ParseException {
        List<Date> columnDate = new ArrayList<>();
        int historyListSize = table.getRowsAsString().size()-1;
        List<List<String>> temp = table.getRowsAsString();
        for (int i = 0; i < historyListSize; i++) {
            columnDate.add(new SimpleDateFormat("MMM d, yyyy").parse(temp.get(i).get(0)));
        }
        return columnDate;
    }

}
