package com.example.studentstatus;

import lombok.Data;

@Data
public class StudentModel {
    private String nationalId;
    private String name;
    private String acceptanceStatus;

    public StudentModel(String nationalId, String name, String acceptanceStatus) {
        this.nationalId = nationalId;
        this.name = name;
        this.acceptanceStatus = acceptanceStatus;
    }
}
