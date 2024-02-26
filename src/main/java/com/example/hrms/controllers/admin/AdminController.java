package com.example.hrms.controllers.admin;

import com.example.hrms.models.emploment_info.*;
import com.example.hrms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final EmployeeService employeeService;
    private final DesignationService designationService;
    private final DepartmentService departmentService;
    private final GroupService groupService;
    private final BankService bankService;
    private final BankBranchService bankBranchService;
    private final PersonalService personalService;
    private final AddressService addressService;
    private final ContactService contactService;
    private final FamilyService familyService;

    @Autowired
    public AdminController(EmployeeService employeeService, DesignationService designationService, DepartmentService departmentService, GroupService groupService, BankService bankService, BankBranchService bankBranchService, PersonalService personalService, AddressService addressService, ContactService contactService, FamilyService familyService) {
        this.employeeService = employeeService;
        this.designationService = designationService;
        this.departmentService = departmentService;
        this.groupService = groupService;
        this.bankService = bankService;
        this.bankBranchService = bankBranchService;
        this.personalService = personalService;
        this.addressService = addressService;
        this.contactService = contactService;
        this.familyService = familyService;
    }

    @GetMapping("")
    public String admin(Model model){
        model.addAttribute("date", new Date());
        return "admin/baseHtml";
    }

    @PostMapping("/submitEmployeeData")
    @ResponseBody
    public ResponseEntity<String> submitEmpData(@RequestBody Employee employee) {
        try {
            Department department = departmentService.findDepartmentById(employee.getDepartment().getDepartmentId()).get();
            employee.setDepartment(department);

            Designation designation = designationService.findDesignationById(employee.getDesignation().getDesignationId()).get();
            employee.setDesignation(designation);

            GroupMain group = groupService.findGroupById(employee.getGroupMain().getGroupMainId()).get();
            employee.setGroupMain(group);

            employee = employeeService.saveEmployee(employee);

            return ResponseEntity.ok(employee.getEmployeeId().toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/addEmployee")
    public String addEmp(Model model){
//        System.out.println(employeeService.getNextEmployeeCode());
        model.addAttribute("employeeCode", employeeService.getNextEmployeeCode());
        setDate(model);
        model.addAttribute("designations", designationService.findAllDesignations());
        model.addAttribute("departments", departmentService.findALlDepartments());
        model.addAttribute("groups", groupService.findAllGroups());
        return "admin/addEmployee";
    }

    @GetMapping("/editEmployee/{employeeId}")
    public String editEmployeePage(Model model, @PathVariable String employeeId) {
        setDate(model);
        model.addAttribute("gender", Personal.Gender.values());
        model.addAttribute("marriageStatus", Personal.MarriageStatus.values());
        model.addAttribute("communityCategory", Personal.CommunityCategory.values());
        model.addAttribute("vehicleType", Personal.VehicleType.values());
        model.addAttribute("banks", bankService.findAllBanks());
        model.addAttribute("bankBranches", bankBranchService.findAllBankBranches());

        return "admin/editEmployee";
    }

    @PostMapping("/submitPersonal/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitPersonalDetails(@RequestBody Personal personal, @PathVariable String employeeId) {
        Long bankBranchId = personal.getBankDetail().getBankBranchId();
        BankBranch bankbranch = bankBranchService.findBankBranchById(bankBranchId).get();


        System.out.println(bankbranch.getBankBranchName());

        personalService.savePersonal(personal);
        return ResponseEntity.ok("Personal details saved!");
    }

    @PostMapping("/submitContact/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitContactDetails(@RequestBody Contact contact, @PathVariable String employeeId) {
        try {
            Optional<Employee> employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
            employee.ifPresent(contact::setEmployee);
            contactService.saveContact(contact);

            return ResponseEntity.ok("Contact saved successfully");
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving contact!", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/submitFamily/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitFamilyDetails(@RequestBody List<Family> families, @PathVariable String employeeId) {
        try {
            Optional<Employee> employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
            families.forEach(family -> family.setEmployee(employee.get()));
            familyService.saveFamilies(families);

            return ResponseEntity.ok("Family saved successfully");
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving family!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/submitEmergency/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitEmergencyDetails(@RequestBody List<Emergency> emergencyList, @PathVariable String employeeId) {
        try {
            Optional<Employee> employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
            emergencyList.forEach(emergency -> emergency.setEmployee(employee.get()));

            return ResponseEntity.ok("Emergency contacts saved successfully");
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving emergency!", HttpStatus.BAD_REQUEST);
        }
    }


    public void setDate(Model model){
        LocalDate date = LocalDate.now();
        model.addAttribute("day", date.getDayOfWeek());
        model.addAttribute("date", date.getDayOfMonth());
        model.addAttribute("month", date.getMonth());
        model.addAttribute("year", date.getYear());
    }
}
