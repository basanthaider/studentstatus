package com.example.studentstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcceptanceStatusController {

    @Autowired
    private ExcelDataService excelDataService;

    @GetMapping("/acceptance-status/{nationalId}")
    public ResponseEntity<String> getStudentDetails(@PathVariable String nationalId) {
        try {
            String studentDetails = excelDataService.getStudentDetails(nationalId);
            return ResponseEntity.ok(studentDetails);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred while retrieving student details.");
        }
    }
}