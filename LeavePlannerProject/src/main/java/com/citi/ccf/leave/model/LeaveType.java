package com.citi.ccf.leave.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "leave_type")
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveTypeId;

    @Column(nullable = false, unique = true)
    private String typeName;

    private String description;
}
