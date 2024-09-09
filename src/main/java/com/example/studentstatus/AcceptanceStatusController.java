package com.example.studentstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AcceptanceStatusController {

    @Autowired
    private ExcelDataService excelDataService;

    @GetMapping("/acceptance-status/{nationalId}")
    public ResponseEntity<Object> getStudentDetails(@PathVariable String nationalId) {
        try {
            StudentModel student = excelDataService.getStudentDetails(nationalId);
            if (student == null) {
                return ResponseEntity.ok(new HashMap<String, String>() {{
                    put("message", "Student Not Found");
                }});
            }
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred while retrieving student details.");
        }
    }
}