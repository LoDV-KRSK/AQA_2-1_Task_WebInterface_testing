import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebInterfaceTest {

    @Test
    void shouldSubmitRequest(){
        open("http://0.0.0.0:9999/");
        SelenideElement form = $("[action=\"/\"]");
        form.$("[data-test-id='name'] input").setValue("Лощенов Денис");
        form.$("[data-test-id='phone'] input").setValue("+79002001001");
        form.$("[data-test-id='agreement'] ").click();
        form.$("[type='button'] ").click();
        $("[data-test-id=\"order-success\"]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! " +
               "Наш менеджер свяжется с вами в ближайшее время."));
    }
}
