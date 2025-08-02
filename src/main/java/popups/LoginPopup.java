package popups;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.AbsCommon;

public class LoginPopup extends AbsCommon {

  Locator xbutton = page.locator("//*[@id=\"__PORTAL__\"]/div/div/div[2]/div");

  public LoginPopup(Page page) {
    super(page);
  }

  public boolean isXButtonVisible() {
    return isVisible(xbutton);
  }

}
