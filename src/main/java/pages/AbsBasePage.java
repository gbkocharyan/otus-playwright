package pages;

import annotations.Path;
import com.microsoft.playwright.Page;
import common.AbsCommon;

public abstract class AbsBasePage<T> extends AbsCommon {

  private final String baseUrl = System.getProperty("baseUrl", "https://otus.ru");

  public AbsBasePage (Page page) {
    super(page);
  }

  private String getPath() {
    Class<T> clazz = (Class<T>)getClass();
    if(clazz.isAnnotationPresent(Path.class)) {
      Path path = clazz.getDeclaredAnnotation(Path.class);
      return path.value();
    }
    return "";
  }

  public T open() {
    page.navigate(this.baseUrl + getPath());
    acceptCookie();
    page.reload();
    page.waitForLoadState();
    return (T) this;
  }

  public void acceptCookie() {
    page.evaluate("() => localStorage.getItem('cookieAccess')");
  }

}
