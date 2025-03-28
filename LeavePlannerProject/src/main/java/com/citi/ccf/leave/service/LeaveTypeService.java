package com.citi.ccf.leave.service;


import com.citi.ccf.leave.dto.LeaveTypeDTO;
import com.citi.ccf.leave.exception.ResourceNotFoundException;
import com.citi.ccf.leave.model.LeaveType;
import com.citi.ccf.leave.repository.LeaveTypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaveTypeService {
    private final LeaveTypeRepository repository;
    private final ModelMapper modelMapper;

    public List<LeaveTypeDTO> getAllLeaveTypes() {
        return repository.findAll().stream()
                .map(type -> modelMapper.map(type, LeaveTypeDTO.class))
                .collect(Collectors.toList());
    }

    public LeaveType getLeaveTypeEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave type not found"));
    }
}
