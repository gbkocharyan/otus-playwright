package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.microsoft.playwright.Page;
import pages.*;

public class GuicePageModule extends AbstractModule {

  private final Page page;

  public GuicePageModule(Page page) {
    this.page = page;
  }

  @Provides
  @Singleton
  public CoursesPage getCoursesPage() {
    return new CoursesPage(page);
  }

  @Provides
  @Singleton
  public ClickHousePage getClickHousePage() {
    return new ClickHousePage(page);
  }

  @Provides
  @Singleton
  public CompanyServicesPage getCompanyServicesPage() {
    return new CompanyServicesPage(page);
  }

  @Provides
  @Singleton
  public CustomCoursesPage getCustomCoursesPage() {
    return new CustomCoursesPage(page);
  }

  @Provides
  @Singleton
  public SubscriptionPage getSubscriptionPage() {
    return new SubscriptionPage(page);
  }

}
