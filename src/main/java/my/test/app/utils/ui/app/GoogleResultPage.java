package my.test.app.utils.ui.app;

import my.test.app.utils.ui.app.customWidget.SearchResultItem;
import my.test.app.utils.ui.base.Locator;
import my.test.app.utils.ui.base.PageObject;

import java.util.ArrayList;
import java.util.List;


public class GoogleResultPage extends PageObject {

    @Override
    protected Locator readyLocator() {
        return Locator.create("//div[@id='res' and @class = 'med']");
    }

    final public List<SearchResultItem> getResultItems() {
        List<SearchResultItem> result = new ArrayList<>();
        Locator searchResultLocator = Locator.create("//div[@id='search']//div[@class='srg']/div[@class='g']");
        int count = this.wd().findElements(searchResultLocator.webDriverLocator()).size();
        for (int i = 0; i < count; i++){
            result.add(new SearchResultItem(searchResultLocator.createChild("../div[@class='g'][" + i + "]")));
        }

        return result;
    }

}
