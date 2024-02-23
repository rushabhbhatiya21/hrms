package com.example.hrms.controllers.admin;

import com.example.hrms.models.emploment_info.*;
import com.example.hrms.service.DepartmentService;
import com.example.hrms.service.DesignationService;
import com.example.hrms.service.EmployeeService;
import com.example.hrms.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

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
    public String admin(Model model){
        model.addAttribute("date", new Date());
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
//        System.out.println(employee.getFirstName());
        try {
            Department department = departmentService.findDepartmentById(employee.getDepartment().getDepartmentId()).get();
            employee.setDepartment(department);

            Designation designation = designationService.findDesignationById(employee.getDesignation().getDesignationId()).get();
            employee.setDesignation(designation);

            GroupMain group = groupService.findGroupById(employee.getGroupMain().getGroupMainId()).get();
            employee.setGroupMain(group);

            employeeService.saveEmployee(employee);

            return ResponseEntity.ok("Employee details saved.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/addEmployee")
    public String addEmp(Model model){
//        System.out.println(employeeService.getNextEmployeeCode());
        model.addAttribute("employeeCode", employeeService.getNextEmployeeCode());
        setdate(model);
        model.addAttribute("designations", designationService.findAllDesignations());
        model.addAttribute("departments", departmentService.findALlDepartments());
        model.addAttribute("groups", groupService.findAllGroups());
        return "admin/addEmployee";
    }

    @GetMapping("/editEmployee/{employeeId}")
    public String editEmployeePage(@PathVariable String employeeId, Model model) {
        setdate(model);
        return "admin/editEmployee";
    }

    @PostMapping("submitPersonal")
    @ResponseBody
    public ResponseEntity<String> submitPersonalDetails(@RequestBody Personal personal) {
        return null;
    }

    public void setdate(Model model){
        LocalDate date = LocalDate.now();
        model.addAttribute("day", date.getDayOfWeek());
        model.addAttribute("date", date.getDayOfMonth());
        model.addAttribute("month", date.getMonth());
        model.addAttribute("year", date.getYear());
    }
}
