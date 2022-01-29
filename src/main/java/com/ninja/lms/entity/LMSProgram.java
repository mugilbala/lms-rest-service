package com.ninja.lms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "TBL_LMS_PROGRAM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"batches"})
@EqualsAndHashCode(exclude = {"batches"})
public class LMSProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer programId;
    String programName;
    String programDescription;
    String programStatus;
    Timestamp creationTime;
    Timestamp lastModTime;

    @JsonManagedReference
    @OneToMany(mappedBy = "program", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<LMSBatch> batches;
}
