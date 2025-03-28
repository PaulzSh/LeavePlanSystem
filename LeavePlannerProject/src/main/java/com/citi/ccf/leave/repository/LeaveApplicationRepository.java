package com.citi.ccf.leave.repository;

import com.citi.ccf.leave.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Long> {
    List<LeaveApplication> findByStaffName(String staffName);
    List<LeaveApplication> findByStartDateBetween(LocalDate start, LocalDate end);
    boolean existsByStaffNameAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            String staffName, LocalDate endDate, LocalDate startDate);
}
