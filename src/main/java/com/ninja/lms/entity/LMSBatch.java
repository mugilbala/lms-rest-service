package com.ninja.lms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "LMSBatch")
@Table(name = "TBL_LMS_BATCH",
        uniqueConstraints = {
                @UniqueConstraint(name = "tbl_lms_batch_batch_name_batch_program_id_key",
                        columnNames = {"batchName","batch_program_id"})
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"program"})
@EqualsAndHashCode(exclude = {"program"})
public class LMSBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch-seq")
    @SequenceGenerator(name = "batch-seq", sequenceName = "tbl_lms_batch_batch_id_seq", allocationSize = 1)
    Integer batchId;
    @NotNull(message = "Batch Name is required field.")
    String batchName;
    String batchDescription;
    @NotNull(message = "Batch Status is required field")
    String batchStatus;
    @NotNull(message = "No of classes is required field.")
    Integer batchNoOfClasses;
    @CreationTimestamp
    @Column(insertable = true, updatable = false, nullable = false)
    Timestamp creationTime;
    @UpdateTimestamp
    @Column(insertable = true, updatable = true, nullable = false)
    Timestamp lastModTime;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_program_id")
    private LMSProgram program;

    @Transient
    private Integer programId;

    public Integer getProgramId() {
        return getProgram().getProgramId();
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }
}
