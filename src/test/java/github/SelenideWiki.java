package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWiki {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browser = "chrome";
    }
    @Test
    void WikiTest(){
        //открыть страницу selenide в github
        open("/selenide/selenide");
        //перейти в раздел wiki
        $("#wiki-tab").click();
        //показать все страницы в списке
        $("#wiki-pages-box li.wiki-more-pages-link button").click();
        // проверить что есть страница SoftAssertions
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        //открыть страницу SoftAssertions
        $("#wiki-body").find(byText("Soft assertions")).click();
        //проверить что внутри есть пример кода для JUnit5
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));

    }
}
