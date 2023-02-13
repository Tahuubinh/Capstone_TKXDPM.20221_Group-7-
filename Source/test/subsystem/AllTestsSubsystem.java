package subsystem;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ BarcodeConverterTest.class, InterbankTest.class })
public class AllTestsSubsystem {

}
