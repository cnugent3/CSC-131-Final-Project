package payrollsystem;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite
@SelectClasses({
    EmployeeTest.class,
    ManagerTest.class,
    DataListTest.class,
    PaycheckPDFTest.class
})
public class AllTests {
    // No code needed here
}

