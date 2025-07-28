import com.google.inject.Inject;
import extensions.UIExtension;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.SubscriptionPage;
import popups.LoginPopup;

@ExtendWith(UIExtension.class)
public class SubscriptionTest {

  @Inject
  private SubscriptionPage subscriptionPage;

  @Inject
  private LoginPopup loginPopup;

  @Test
  public void subscriptionTest() {
    SoftAssertions softAssertions = new SoftAssertions();
    String infoText = subscriptionPage.open()
        .clickMoreInfo()
        .getMoreInfoButtonText();
    softAssertions.assertThat(infoText).as("More info button text is wrong").isEqualTo("Свернуть");
    softAssertions.assertThat(subscriptionPage.clickMoreInfo()
            .getMoreInfoButtonText()
            .equalsIgnoreCase("Подробнее"))
        .as("the Подробнее text is wrong")
        .isTrue();
    subscriptionPage.clickBuySubscription();
    softAssertions.assertAll();
  }
}
