package com.ninja.lms.jpa;

import com.ninja.lms.entity.LMSBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LMSBatchRepository extends JpaRepository<LMSBatch, Long> {
}
