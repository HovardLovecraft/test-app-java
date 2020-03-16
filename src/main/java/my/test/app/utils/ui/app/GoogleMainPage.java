package my.test.app.utils.ui.app;

import my.test.app.utils.ui.app.customWidget.SearchResultItem;
import my.test.app.utils.ui.base.Locator;
import my.test.app.utils.ui.base.PageObject;
import my.test.app.utils.ui.widget.TextBox;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class GoogleMainPage extends PageObject {

    final private TextBox _searchField = new TextBox(Locator.create("//input[@name='q']"));

    //div[@class = 'search']//
    @Override
    protected Locator readyLocator() {
        return Locator.create("//div[@id='logo']");
    }

    final public GoogleResultPage search(String text) {
        this._searchField.setValue(text);
        this._searchField.pressEnter();
        return new GoogleResultPage();
    }



}
