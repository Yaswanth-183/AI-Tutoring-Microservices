package com.interview.interview_outbox.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;

    private String interviewerName;

    private String status;

    public Interview() {
    }

    public Interview(String candidateName,
                     String interviewerName,
                     String status) {

        this.candidateName = candidateName;
        this.interviewerName = interviewerName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}