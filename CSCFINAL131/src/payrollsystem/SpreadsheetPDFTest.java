package payrollsystem;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpreadsheetPDFTest {

    @Test
    public void testSpreadsheetPDFGeneration() {
        // Create some test employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("New", "Employee", 12345, 40f, 5f, 25f, "test123!", 0f, false));
        employees.add(new Employee("John", "Doe", 67890, 35f, 10f, 30f, "password123", 0f, true));

        // Call the method to generate the PDF
        SpreadsheetPDF.generate(employees);

        // Construct the expected file path for the generated PDF
        String userHome = System.getProperty("user.home");
        String downloadsPath = userHome + "\\Downloads";
        String expectedFileName = downloadsPath + "\\payroll_summary.pdf";

        // Create a file object for the generated PDF
        File generatedFile = new File(expectedFileName);

        // Assert that the file exists
        assertTrue(generatedFile.exists(), "The payroll summary PDF should be created at: " + expectedFileName);

        // Optionally, you can perform further validation on the content of the PDF,
        // but reading and verifying PDF content would require a PDF library, which is outside the scope of basic JUnit tests.

        // Optionally clean up the generated PDF after the test (uncomment the next line if you want to delete the file)
        // generatedFile.delete();
    }
}
