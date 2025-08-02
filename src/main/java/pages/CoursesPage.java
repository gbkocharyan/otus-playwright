package pages;

import annotations.Path;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import java.util.ArrayList;
import java.util.List;

@Path("/catalog/courses")
public class CoursesPage extends AbsBasePage<CoursesPage> {

  Locator allDirectionsCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Все направления"));
  Locator anyLevelCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Любой уровень"));
  Locator resetFilter = page.getByText("Очистить фильтры");
  Locator slider = page.getByRole(AriaRole.SLIDER);
  Locator coursesDates = page.locator("//*[@id=\"__next\"]/div[1]/main/div/section[2]/div[2]/div/a/div[2]/div/div");
  Locator architecture = page.getByText("Архитектура");

  public CoursesPage(Page page) {
    super(page);
  }

  public boolean isAllDirectionsCheckboxSelected() {
    return isChecked(allDirectionsCheckbox);
  }

  public boolean isAnyLevelCheckboxSelected() {
    return isChecked(anyLevelCheckbox);
  }

  public boolean isTestingCourseSelected(Page page) {
    page.waitForLoadState();
    Locator testingCourse = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Тестирование"));
    return isChecked(testingCourse);
  }

  public CoursesPage moveLeftSlider(int value) {
    moveSlider(slider.nth(0), value);
    return this;
  }

  public void moveRightSlider(int value) {
    moveSlider(slider.nth(1), value);
  }

  public List<Integer> getCoursesDates() {
    implicitWait();
    ArrayList<String> strings = new ArrayList<>();
    for (int i = 0; i < coursesDates.all().size(); i++) {
      strings.add(getText(coursesDates.nth(i)));
    }
    return strings.stream()
        .map(String::trim)
        .map(courseDate -> {
          String[] parts = courseDate.split("·");
          String durationPart = parts[1].trim();
          String[] duration = durationPart.split(" ");
          try {
            return Integer.parseInt(duration[0]);
          } catch (NumberFormatException e) {
            e.printStackTrace();
          }
          return null;
        }).toList();
  }

  public CoursesPage clickOnArchitecture() {
    click(architecture.nth(1));
    return this;
  }

  public String getCourseInfo(int index) {
    implicitWait();
    return getText(coursesDates.nth(index));
  }

  public CoursesPage resetFilter() {
    click(resetFilter);
    return this;
  }
}
