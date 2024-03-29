package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
    @Query("SELECT F FROM Family AS F WHERE F.isNominee = true AND F.employee.employeeId = :employeeId")
    List<Family> findAllFamiliesWithNomineeAndEmployeeId(@Param("employeeId") Long employeeId);

    List<Family> findAllByEmployeeEmployeeId(Long employee_employeeId);
}
