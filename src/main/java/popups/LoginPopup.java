package popups;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.AbsCommon;

public class LoginPopup extends AbsCommon {

  Locator entrance = page.getByText("Вход");
  Locator emailField = page.locator("//*[@id=\"__PORTAL__\"]//div[1]/div/input");
  Locator passwordField = page.getByText("password");
  Locator loginButton = page.locator("//*[@id=\"__PORTAL__\"]//div[1]/div/button/div");

  public LoginPopup(Page page) {
    super(page);
  }


}
