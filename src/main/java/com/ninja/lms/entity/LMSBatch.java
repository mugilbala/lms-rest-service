package com.ninja.lms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TBL_LMS_BATCH")
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
    String batchName;
    String batchDescription;
    String batchStatus;
    Integer batchNoOfClasses;
    Timestamp creationTime;
    Timestamp lastModTime;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_program_id")
    private LMSProgram program;
}
