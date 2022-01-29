package com.ninja.lms.jpa;

import com.ninja.lms.entity.LMSBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LMSBatchRepository extends JpaRepository<LMSBatch, Long> {
    List<LMSBatch> findByBatchName(String batchName);
    List<LMSBatch> findByBatchNameAndBatchDescription(String batchName, String batchDescription);

    /**
     * When you need to refer to a field of an underlying object in entity, need to give that field name as
     * underlyingObject_FieldName for better reference
     */
    List<LMSBatch> findByBatchNameAndProgram_ProgramId(String batchName, Integer batchProgramId);
}
