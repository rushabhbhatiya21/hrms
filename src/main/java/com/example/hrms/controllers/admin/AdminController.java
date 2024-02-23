package com.example.hrms.controllers.admin;

import com.example.hrms.models.emploment_info.Employee;
import com.example.hrms.service.DepartmentService;
import com.example.hrms.service.DesignationService;
import com.example.hrms.service.EmployeeService;
import com.example.hrms.service.GroupService;
import com.example.hrms.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final EmployeeService employeeService;
    private final DesignationService designationService;
    private final DepartmentService departmentService;
    private final GroupService groupService;

    @Autowired
    public AdminController(EmployeeService employeeService, DesignationService designationService, DepartmentService departmentService, GroupService groupService) {
        this.employeeService = employeeService;
        this.designationService = designationService;
        this.departmentService = departmentService;
        this.groupService = groupService;
    }

    @GetMapping("")
    public String admin(){
        return "admin/basehtml";
    }

    @PostMapping("/submitEmployeeData")
    @ResponseBody
    public ResponseEntity<String> submitEmpData(
//            @RequestBody Map<String, String> employeeJson
            @RequestBody Employee employee
    ) {
//        Employee newEmployee = new Employee();
//        newEmployee.setEmployeeCode(Long.valueOf(employeeJson.get("employeeCode")));
//        newEmployee.setPanNumber(Long.valueOf(employeeJson.get("panNumber")));
//        newEmployee.setOldEmployeeCode(Long.valueOf(employeeJson.get("oldEmployeeCode")));
//        newEmployee.setDateOfAppointment(ConvertUtils.convertStringToDate(employeeJson.get("dateOfAppointment")));
//        newEmployee.setBioMetricId((employeeJson.get("bioMetricId")));
//        newEmployee.setFirstName((employeeJson.get("firstName")));
//        newEmployee.setMiddleName((employeeJson.get("middleName")));
//        newEmployee.setLastName((employeeJson.get("lastName")));
//        newEmployee.setUnit((employeeJson.get("unit")));
//        newEmployee.setEmployeeEligibleFor((employeeJson.get("employeeEligibleFor")));
//        newEmployee.setUnderGratuityAct(Boolean.parseBoolean((employeeJson.get("isUnderGratuityAct"))));
        System.out.println(employee.getFirstName());
        System.out.println(employee.getDepartment());

        return ResponseEntity.ok("Employee details saved.");
    }

    @GetMapping("/addEmployee")
    public String addEmp(Model model){
        model.addAttribute("employeeCode", employeeService.getNextEmployeeCode());
        model.addAttribute("date", new Date());
        model.addAttribute("designations", designationService.findAllDesignations());
        model.addAttribute("departments", departmentService.findALlDepartments());
        model.addAttribute("groups", groupService.findAllGroups());
        return "admin/addEmployee";
    }
}
