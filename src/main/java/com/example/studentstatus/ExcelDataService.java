package com.example.studentstatus;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExcelDataService {
    private final Map<String, String> studentData = new HashMap<>();
    public ExcelDataService() throws IOException {
        // Replace "path/to/your/file.xlsx" with the actual path
        FileInputStream file = new FileInputStream("studentsList.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;


            }
        String nationalId = row.getCell(1).getStringCellValue(); // Assuming National ID is in column B

        String acceptanceStatus = row.getCell(7).getStringCellValue(); // Assuming Acceptance Status is in column C
        studentData.put(nationalId, acceptanceStatus);
    }
        workbook.close();
        file.close();
}

public String getAcceptanceStatus(String nationalId) {
    return studentData.getOrDefault(nationalId, "Not Found");
}
}
