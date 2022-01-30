package com.ninja.lms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program-seq")
    @SequenceGenerator(name = "program-seq", sequenceName = "tbl_lms_program_program_id_seq", allocationSize = 1)
    Integer programId;
    @NotNull(message = "Program Name is a required field")
    @Column(unique = true)
    String programName;
    String programDescription;
    @NotNull(message = "Program Status is a required field")
    String programStatus;
    @NotNull(message = "Creation time is a required field")
    Timestamp creationTime;
    @NotNull(message = "Last Modification time is a required field")
    Timestamp lastModTime;

    @JsonManagedReference
    @OneToMany(mappedBy = "program", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<LMSBatch> batches;
}
