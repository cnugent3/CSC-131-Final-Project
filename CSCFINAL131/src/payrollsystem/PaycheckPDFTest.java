package payrollsystem;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import payrollsystem.PaycheckPDF;

public class PaycheckPDFTest {

    @Test
    public void testPDFGeneration() {
        // Create a test employee
    	
        Employee testEmployee = new Employee("New", "Employee", 12345, 40f, 5f, 25f, "test123!", 0f, false);

        // Generate the PDF
        PaycheckPDF.generate(testEmployee);

        // Construct the expected file path
        String userHome = System.getProperty("user.home");
        String downloadsPath = userHome + "\\Downloads";
        String expectedFileName = downloadsPath + "\\paycheck_New_Employee.pdf";

        File generatedFile = new File(expectedFileName);

        // Verify that the PDF was created
        assertTrue(generatedFile.exists(), "The PDF file should be created at: " + expectedFileName);

        // Optional cleanup: delete the test PDF after checking
        // generatedFile.delete();
    }
}