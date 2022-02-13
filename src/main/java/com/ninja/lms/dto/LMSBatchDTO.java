package com.ninja.lms.dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class LMSBatchDTO {
    private Integer batchId;
    @NotNull(message = "Batch Name is required field.")
    private String batchName;
    private String batchDescription;
    @NotNull(message = "Batch Status is required field")
    private String batchStatus;
    @NotNull(message = "No of classes is required field.")
    private Integer batchNoOfClasses;
    private Timestamp creationTime;
    private Timestamp lastModTime;
    @NotNull(message = "Batch Program Id is a required field.")
    private Integer batchProgramId;

    public LMSBatchDTO() {
    }

    public LMSBatchDTO(Integer batchId, String batchName, String batchDescription, String batchStatus, Integer batchNoOfClasses, Timestamp creationTime, Timestamp lastModTime, Integer batchProgramId) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.batchDescription = batchDescription;
        this.batchStatus = batchStatus;
        this.batchNoOfClasses = batchNoOfClasses;
        this.creationTime = creationTime;
        this.lastModTime = lastModTime;
        this.batchProgramId = batchProgramId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Integer getBatchNoOfClasses() {
        return batchNoOfClasses;
    }

    public void setBatchNoOfClasses(Integer batchNoOfClasses) {
        this.batchNoOfClasses = batchNoOfClasses;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(Timestamp lastModTime) {
        this.lastModTime = lastModTime;
    }

    public Integer getBatchProgramId() {
        return batchProgramId;
    }

    public void setBatchProgramId(Integer batchProgramId) {
        this.batchProgramId = batchProgramId;
    }
}
