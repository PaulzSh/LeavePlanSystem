package com.citi.ccf.leave.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LeaveApplicationDTO {
    private Long applicationId;
    private String staffName;
    private Long leaveTypeId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private Double hoursTaken;
    private Boolean managerApproved;
    private String applicationManagerName;
    private String locationDuringLeave;
    private String remarks;
}