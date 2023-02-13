package cardcontroller;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ValidateCardCodeTest.class, ValidateCvvCodeTest.class, ValidateExpiredDateTest.class,
		ValidateOwnerTest.class })
public class AllTestsCardController {

}
