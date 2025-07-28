import com.google.inject.Inject;
import extensions.UIExtension;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ClickHousePage;
import popups.TeacherPopup;
import java.util.List;

@ExtendWith(UIExtension.class)
public class TeachersTest {

  @Inject
  private ClickHousePage clickHousePage;

  @Inject
  private TeacherPopup teacherPopup;

  @Test
  public void checkTeachersVisibility() {
    SoftAssertions softAssertions = new SoftAssertions();
    List<String> teachers = clickHousePage.open().checkTeacherVisibility().scrollTeachers();
    clickHousePage.clickTeacher();
    String teacherName = teacherPopup.getTeacherName(1);
    softAssertions.assertThat(teachers.get(1))
        .as("Wrong teacher's popup was opened")
        .contains(teacherName);
    String teacherName1 = teacherPopup.clickLeftIcon().getTeacherName(0);
    softAssertions.assertThat(teacherName1)
        .as("The left icon was not clicked")
        .isNotEqualTo(teacherName);
    String teacherName2 = teacherPopup.clickRightIcon().getTeacherName(0);
    softAssertions.assertThat(teacherName2)
        .as("The right icon was not clicked")
        .isNotEqualTo(teacherName);
    softAssertions.assertAll();
  }
}
