package payrollsystem;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
public class SpreadsheetPDF {

    public static void generate(List<Employee> employees) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.LETTER);
        document.addPage(page);

        try (PDPageContentStream content = new PDPageContentStream(document, page)) {
            content.setFont(PDType1Font.COURIER, 12);
            content.beginText();
            content.newLineAtOffset(40, 750);

            // Header
            String header = String.format("%-20s %-8s %-12s %-12s %-12s %-12s",
                    "Name", "ID", "Hours", "Overtime", "Wage", "Total Pay");
            content.showText(header);
            content.newLineAtOffset(0, -20);

            // Body
            content.setFont(PDType1Font.COURIER, 12);
            for (Employee emp : employees) {
                String name = emp.getFirstName() + " " + emp.getLastName();
                String row = String.format("%-20s %-8d %-12.2f %-12.2f $%-11.2f $%-11.2f",
                        name, emp.getId(), emp.getHoursWorked(), emp.getOvertimeWorked(),
                        emp.getHourlyWage(), emp.getCheck());
                content.showText(row);
                content.newLineAtOffset(0, -15);
            }

            content.endText();
            content.close();

            String userHome = System.getProperty("user.home");
            String downloadsPath = userHome + "\\Downloads";
            String fileName = downloadsPath + "\\payroll_summary.pdf";
            document.save(fileName);
            System.out.println("Payroll summary PDF created: " + fileName);

        } catch (IOException e) {
            System.err.println("Error generating spreadsheet PDF: " + e.getMessage());
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                System.err.println("Failed to close PDF document.");
            }
        }
    }
}
