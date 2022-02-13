package com.ninja.lms.service;

import com.ninja.lms.dto.LMSBatchDTO;
import com.ninja.lms.entity.LMSBatch;
import com.ninja.lms.entity.LMSProgram;
import com.ninja.lms.exception.LMSException;
import com.ninja.lms.jpa.LMSBatchRepository;
import com.ninja.lms.jpa.LMSProgramRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
public class LMSBatchService {

    @Autowired
    private LMSBatchRepository batchRepository;

    @Autowired
    private LMSProgramRepository programRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LMSBatch> getAllBatches() {
        return batchRepository.findAll();
    }

    public LMSBatch getBatchById(Integer batchId) {
        return batchRepository
                .findById(batchId)
                .orElseThrow(() -> new LMSException("LMS_4000", "Batch Id " + batchId + " is not found."));
    }

    public LMSBatch getBatchByBatchNameAndProgramId(String batchName, Integer programId) {
        return batchRepository
                .findByBatchNameAndProgram_ProgramId(batchName, programId);
    }

    public LMSBatch createBatch(Integer batchProgramId, @Valid LMSBatch newBatch) {
        LMSProgram program = programRepository.findById(batchProgramId)
                .orElseThrow(() -> new LMSException("LMS_4000", "Program details not found for program Id " + batchProgramId));

        LMSBatch duplicateBatchProgram = this.getBatchByBatchNameAndProgramId(newBatch.getBatchName(), batchProgramId);
        if (Objects.nonNull(duplicateBatchProgram)) {
            throw new LMSException("LMS_2000", "Batch Name " + newBatch.getBatchName() + " and Batch Program Id " + batchProgramId + " combination already exists.");
        }

        newBatch.setProgram(program);
        return batchRepository.save(newBatch);
    }

    public LMSBatch createBatchFromDTO(LMSBatchDTO batchDTO){
        return this.createBatch(batchDTO.getBatchProgramId(), convertToEntity(batchDTO));
    }

    public LMSBatch convertToEntity(LMSBatchDTO batchDTO) {
        return modelMapper.map(batchDTO, LMSBatch.class);
    }
}
