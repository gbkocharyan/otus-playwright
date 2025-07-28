import com.google.inject.Inject;
import com.microsoft.playwright.Page;
import extensions.UIExtension;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CompanyServicesPage;
import pages.CoursesPage;
import pages.CustomCoursesPage;

@ExtendWith(UIExtension.class)
public class CompanyServicesTest {

  @Inject
  private CompanyServicesPage companyServicesPage;

  @Inject
  private CustomCoursesPage customCoursesPage;

  @Inject
  private CoursesPage coursesPage;

  @Test
  public void companyServicesTest() {
    SoftAssertions softAssertions = new SoftAssertions();
    Page page = companyServicesPage.open()
        .clickMoreInfo();
    softAssertions.assertThat(customCoursesPage.isCustomCoursesPageOpened(page))
        .as("Custom courses page does not opened")
        .isTrue();
    customCoursesPage.clickOnTestingCategory(page);
    softAssertions.assertThat(coursesPage.isTestingCourseSelected(page))
        .as("Testing course does not selected")
        .isTrue();
    softAssertions.assertAll();
  }
}
