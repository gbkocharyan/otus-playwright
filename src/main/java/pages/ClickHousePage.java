package pages;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import annotations.Path;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;

@Path("/lessons/clickhouse")
public class ClickHousePage extends AbsBasePage<ClickHousePage> {

  Locator teacher1 = page.locator("//*[@id=\"__next\"]//section/div/div[2]//div[1]/p[1]");
  Locator teacher3 = page.locator("//*[@id=\"__next\"]//section/div/div[2]//div[3]/p[1]");

  public ClickHousePage(Page page) {
    super(page);
  }

  public ClickHousePage checkTeacherVisibility() {
    isVisible(teacher1);
    return this;
  }

  public List<String> scrollTeachers() {
    String sourceTeacher = getText(teacher1);
    String toTeacher = getText(teacher3);
    teacher1.dragTo(teacher3);
    assertNotEquals(sourceTeacher, getText(teacher1), "the drag and drop were not worked");
    return List.of(sourceTeacher, toTeacher);
  }

  public void clickTeacher() {
    click(teacher1);
  }

}
