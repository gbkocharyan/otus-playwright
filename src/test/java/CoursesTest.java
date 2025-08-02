import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.google.inject.Inject;
import extensions.UIExtension;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CoursesPage;

@ExtendWith(UIExtension.class)
public class CoursesTest {

  @Inject
  private CoursesPage coursesPage;

  @Test
  public void testCoursesPage() {
    SoftAssertions softAssertions = new SoftAssertions();
    coursesPage.open();
    softAssertions.assertThat(coursesPage.isAllDirectionsCheckboxSelected())
        .as("The 'All Directions' checkbox should be selected")
        .isTrue();
    softAssertions.assertThat(coursesPage.isAnyLevelCheckboxSelected())
        .as("The 'Any level' checkbox should be selected")
        .isTrue();
    coursesPage.moveLeftSlider(50)
        .moveRightSlider(-70);
    softAssertions.assertThat(coursesPage.getCoursesDates())
        .as("The courses dates are incorrect")
        .allSatisfy(duration -> {
          assertThat(duration).isBetween(3, 10);
        });
    String coursesInfo = coursesPage.getCourseInfo(0);
    String coursesInfoAfter = coursesPage.clickOnArchitecture().getCourseInfo(0);
    softAssertions.assertThat(coursesInfoAfter).as("The Architecture is not selected").isNotEqualTo(coursesInfo);
    String coursesInfoAfterReset = coursesPage.resetFilter().getCourseInfo(0);
    softAssertions.assertThat(coursesInfoAfter).as("Reset is not working").isNotEqualTo(coursesInfoAfterReset);
    softAssertions.assertAll();
  }
}
