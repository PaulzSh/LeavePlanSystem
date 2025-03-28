package com.citi.ccf.leave.controller;


import com.citi.ccf.leave.dto.LeaveTypeDTO;
import com.citi.ccf.leave.service.LeaveTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/leave-types")
@RequiredArgsConstructor
public class LeaveTypeController {
    private final LeaveTypeService service;

    @GetMapping
    public ResponseEntity<List<LeaveTypeDTO>> getAllLeaveTypes() {
        return ResponseEntity.ok(service.getAllLeaveTypes());
    }
}