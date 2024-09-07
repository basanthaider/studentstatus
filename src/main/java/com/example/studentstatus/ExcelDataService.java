package com.example.studentstatus;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;


@Service
public class ExcelDataService {
    public String getStudentDetails(String nationalId) throws IOException {
        // Replace "path/to/your/file.xlsx" with the actual path
        FileInputStream file = new FileInputStream("studentsList.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
                // Skip header row
            }

            Cell idCell = row.getCell(1); // Assuming National ID is in column A
            Cell nameCell = row.getCell(0); // Assuming name is in column B
            Cell statusCell = row.getCell(2); // Assuming Acceptance Status is in column C

            if (idCell != null && idCell.getCellType() == CellType.STRING) {
                String currentNationalId = idCell.getStringCellValue();
                if (currentNationalId.equals(nationalId)) {
                    String name = (nameCell != null) ? nameCell.getStringCellValue() : "";
                    String status = (statusCell != null) ? statusCell.getStringCellValue() : "Not Found";
                    workbook.close();
                    file.close();
                    return String.format("%s - %s - %s", name, currentNationalId, status);
                }
            }
        }

        workbook.close();
        file.close();
        return "Student Not Found";
    }
}

