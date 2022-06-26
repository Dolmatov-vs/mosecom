package ru.lanit.at.utils.selenide.extensions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.Commands;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.OutputType;
import ru.lanit.at.utils.allure.AllureHelper;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;

/**
 * Класс для переопределения и добавление методов Selenide элемента
 */
@ParametersAreNonnullByDefault
public class CustomCommands
        extends Commands {
    @Nullable
    @Override
    public <T> T execute(Object proxy, WebElementSource webElementSource, String methodName, @Nullable Object[] args) throws IOException {
        if (methodName.equals("click")) {
            addAllureScreenshoot("Клик по элементу: " + proxy);
        } else if (methodName.equals("setValue")) {
            addAllureScreenshoot("Установить значение элемента: " + proxy);
        }
        return super.execute(proxy, webElementSource, methodName, args);
    }

    private void addAllureScreenshoot(String name) {
        AllureHelper.attachScreenShot(name, Selenide.screenshot(OutputType.BYTES));
    }
}
