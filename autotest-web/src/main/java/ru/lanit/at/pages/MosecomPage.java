package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Name(value = "МОСЭКОМОНИТОРИНГ")
public class MosecomPage extends WebPage {

    @Name("заголовок страницы")
    private SelenideElement mainHeader = $("section h1").shouldHave(visible, text("ЭКОЛОГИЧЕСКАЯ СИТУАЦИЯ"));
}
