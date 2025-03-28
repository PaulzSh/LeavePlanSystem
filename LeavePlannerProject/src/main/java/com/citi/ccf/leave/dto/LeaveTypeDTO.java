package com.citi.ccf.leave.dto;


import lombok.Data;

@Data
public class LeaveTypeDTO {
    private Long leaveTypeId;
    private String typeName;
    private String description;
}