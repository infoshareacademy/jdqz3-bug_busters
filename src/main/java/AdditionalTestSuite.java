import categories.AdditionalTests;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.AccountTests;
import tests.CartTests;
import tests.ChangeAddressTest;
import tests.LoginTests;

@RunWith(Categories.class)
@Categories.IncludeCategory(AdditionalTests.class)
@Suite.SuiteClasses({ChangeAddressTest.class, LoginTests.class, CartTests.class, AccountTests.class})

public class AdditionalTestSuite {
}
