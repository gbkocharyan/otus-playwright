package pages;

import annotations.Path;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

@Path("/custom_courses")
public class CustomCoursesPage extends AbsBasePage<CustomCoursesPage> {

  public CustomCoursesPage(Page page) {
    super(page);
  }

  public boolean isCustomCoursesPageOpened(Page page) {
    page.waitForLoadState();
    return page.url().contains("custom_courses");
  }

  public void clickOnTestingCategory(Page page) {
    Locator testingCategory = page.locator("a.tn-atom[href='https://otus.ru/categories/testing']");
    click(testingCategory);
  }

}
