import categories.MainTests;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.CartTests;
import tests.ChangeAddressTest;
import tests.LoginTests;

@RunWith(Categories.class)
@Categories.IncludeCategory(MainTests.class)
@Suite.SuiteClasses({ChangeAddressTest.class, LoginTests.class, CartTests.class})

public class MainTestSuite {
}
