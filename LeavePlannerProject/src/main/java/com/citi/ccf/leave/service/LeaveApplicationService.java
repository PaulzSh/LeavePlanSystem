package com.citi.ccf.leave.service;


import com.citi.ccf.leave.dto.LeaveApplicationDTO;
import com.citi.ccf.leave.exception.ConflictException;
import com.citi.ccf.leave.model.LeaveApplication;
import com.citi.ccf.leave.repository.LeaveApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaveApplicationService {
    private final LeaveApplicationRepository repository;
    private final LeaveTypeService leaveTypeService;
    private final ModelMapper modelMapper;

    public LeaveApplicationDTO createApplication(LeaveApplicationDTO dto) {
        // Check for date conflicts
        if (repository.existsByStaffNameAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                dto.getStaffName(), dto.getEndDate(), dto.getStartDate())) {
            throw new ConflictException("Leave application conflicts with existing records");
        }

        LeaveApplication application = modelMapper.map(dto, LeaveApplication.class);
        application.setLeaveType(leaveTypeService.getLeaveTypeEntity(dto.getLeaveTypeId()));
        application.setCreatedBy("SYSTEM"); // Should be replaced with actual user from security context

        LeaveApplication saved = repository.save(application);
        return modelMapper.map(saved, LeaveApplicationDTO.class);
    }

    public Page<LeaveApplicationDTO> getAllApplications(Pageable pageable) {
        return repository.findAll(pageable)
                .map(app -> modelMapper.map(app, LeaveApplicationDTO.class));
    }

    public List<LeaveApplicationDTO> getApplicationsByStaff(String staffName) {
        return repository.findByStaffName(staffName).stream()
                .map(app -> modelMapper.map(app, LeaveApplicationDTO.class))
                .collect(Collectors.toList());
    }
}