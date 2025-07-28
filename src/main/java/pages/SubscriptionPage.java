package pages;

import annotations.Path;
import com.google.inject.Inject;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import popups.LoginPopup;

@Path("/subscription")
public class SubscriptionPage extends AbsBasePage<SubscriptionPage> {

  Locator buy = page.locator("xpath=/html/body/div[1]/div[1]/main/section[2]/div/div/div[1]/div/div[2]/button");
  Locator moreInfo = page.locator("xpath=/html/body/div[1]/div[1]/main/section[2]/div/div[2]/div[2]/div/div[2]/button");

  public SubscriptionPage(Page page) {
    super(page);
  }

  @Inject
  private LoginPopup loginPopup;

  public LoginPopup clickBuySubscription() {
    Locator nth = buy.nth(1);
    click(nth);
    return loginPopup;
  }

  public SubscriptionPage clickMoreInfo() {
    click(moreInfo);
    return this;
  }

  public String getMoreInfoButtonText() {
    return getText(moreInfo);
  }

}
