package com.aashi.StudentManagementSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectDto {

    private int subjectId;
    private String subject;
    private String description;
    @JsonProperty("studentId")
    private int student_id;
 private boolean Active=true;

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
