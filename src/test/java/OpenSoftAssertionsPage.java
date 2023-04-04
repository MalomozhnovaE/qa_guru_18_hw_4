import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OpenSoftAssertionsPage {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testSoftAssertions() {
        // открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // перейти в Wiki
        $("#wiki-tab").click();
        // проверить, что в списке Pages есть SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        // открыть страницу SoftAssertions
        $(byText("SoftAssertions")).click();
        //проверить что есть пример для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
