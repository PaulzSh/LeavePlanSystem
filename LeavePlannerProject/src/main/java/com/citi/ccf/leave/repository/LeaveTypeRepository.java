package com.citi.ccf.leave.repository;


import com.citi.ccf.leave.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
}