package com.citi.ccf.leave.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "leave_attachment")
public class LeaveAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private LeaveApplication application;

    @Column(nullable = false)
    private String fileName;

    private Long fileSize;
    private String fileType;

    @Column(nullable = false)
    private String storagePath;

    @CreationTimestamp
    private LocalDateTime uploadTime;

    private String uploadBy;
}