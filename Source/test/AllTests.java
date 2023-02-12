

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import cardcontroller.*;
import subsystem.*;

@Suite
@SelectClasses({ ValidateCardCodeTest.class, ValidateCvvCodeTest.class, ValidateExpiredDateTest.class,
		ValidateOwnerTest.class, BarcodeConverterTest.class, InterbankTest.class })
public class AllTests {

}
