package com.ninja.lms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "LMSProgram")
@Table(name = "TBL_LMS_PROGRAM",
        uniqueConstraints = {
            @UniqueConstraint(name = "tbl_lms_program_program_name_key", columnNames = {"programName"})
        })
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
    @NotNull(message = "Program Name is a required field.")
    String programName;
    String programDescription;
    @NotNull(message = "Program Status is a required field.")
    String programStatus;
    @CreationTimestamp
    @Column(nullable = false, updatable = false, insertable = true)
    Timestamp creationTime;
    @UpdateTimestamp
    @Column(nullable = false, updatable = true, insertable = true)
    Timestamp lastModTime;

    @JsonManagedReference
    @OneToMany(mappedBy = "program",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<LMSBatch> batches;
}
