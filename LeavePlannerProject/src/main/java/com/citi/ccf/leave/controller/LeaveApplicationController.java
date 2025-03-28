package com.citi.ccf.leave.controller;


import com.citi.ccf.leave.dto.LeaveApplicationDTO;
import com.citi.ccf.leave.service.LeaveApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class LeaveApplicationController {
    private final LeaveApplicationService service;

    @PostMapping
    public ResponseEntity<LeaveApplicationDTO> createApplication(
            @RequestBody LeaveApplicationDTO dto) {
        LeaveApplicationDTO created = service.createApplication(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<Page<LeaveApplicationDTO>> getAllApplications(Pageable pageable) {
        return ResponseEntity.ok(service.getAllApplications(pageable));
    }

    @GetMapping("/staff/{staffName}")
    public ResponseEntity<List<LeaveApplicationDTO>> getApplicationsByStaff(
            @PathVariable String staffName) {
        return ResponseEntity.ok(service.getApplicationsByStaff(staffName));
    }
}
