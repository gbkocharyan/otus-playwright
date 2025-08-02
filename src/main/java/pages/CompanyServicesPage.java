package pages;

import annotations.Path;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

@Path("/uslugi-kompaniyam")
public class CompanyServicesPage extends AbsBasePage<CompanyServicesPage> {

  Locator moreInfo = page.getByText("Подробнее");

  public CompanyServicesPage(Page page) {
    super(page);
  }

  public Page clickMoreInfo() {
    Page customCoursesTab = page.waitForPopup(() -> click(moreInfo));
    customCoursesTab.waitForLoadState();
    this.page = customCoursesTab;
    return customCoursesTab;
  }

}
