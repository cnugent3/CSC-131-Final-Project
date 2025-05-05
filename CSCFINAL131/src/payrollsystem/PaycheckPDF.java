package payrollsystem;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
public class PaycheckPDF {

    
	public static void generate(Employee employee) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.LETTER);
        document.addPage(page);

        try {
            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont(PDType1Font.TIMES_ROMAN, 16);
            content.newLineAtOffset(100, 700);
            content.showText("Paycheck Summary");
            content.endText();

            content.setFont(PDType1Font.HELVETICA, 12);
            content.beginText();
            content.newLineAtOffset(100, 670);
            content.showText("Name: " + employee.getFirstName() + " " + employee.getLastName());
            content.newLineAtOffset(0, -20);
            content.showText("Employee ID: " + employee.getId());
            content.newLineAtOffset(0, -20);
            content.showText("Hours Worked: " + employee.getHoursWorked());
            content.newLineAtOffset(0, -20);
            content.showText("Overtime Hours: " + employee.getOvertimeWorked());
            content.newLineAtOffset(0, -20);
            content.showText("Hourly Wage: $" + employee.getHourlyWage());
            content.newLineAtOffset(0, -20);
            content.showText("Total Pay (after tax): $" + String.format("%.2f", employee.getCheck()));
            content.endText();

            content.close();
            String userHome = System.getProperty("user.home");
            String downloadsPath = userHome + "\\Downloads";
            String fileName = downloadsPath + "\\paycheck_" + employee.getFirstName() + "_" + employee.getLastName() + ".pdf";
            document.save(fileName);
            System.out.println("Paycheck PDF created: " + fileName);

        } catch (IOException e) {
            System.err.println("Error generating paycheck: " + e.getMessage());
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                System.err.println("Failed to close PDF document.");
            }
        }
    }
}