package pages;

import annotations.Path;
import com.google.inject.Inject;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import popups.LoginPopup;

@Path("/subscription")
public class SubscriptionPage extends AbsBasePage<SubscriptionPage> {

  Locator buy = page.getByText("Купить");
  Locator moreInfo = page.locator("//section[2]/div/div[2]/div[2]/div/div[2]/button");

  public SubscriptionPage(Page page) {
    super(page);
  }

  @Inject
  private LoginPopup loginPopup;

  public void clickBuySubscription() {
    Locator nth = buy.nth(1);
    click(nth);
  }

  public SubscriptionPage clickMoreInfo() {
    click(moreInfo);
    return this;
  }

  public String getMoreInfoButtonText() {
    return getText(moreInfo);
  }

}
