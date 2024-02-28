package com.example.hrms.controllers.admin;

import com.example.hrms.dto.RegisterDTO;
import com.example.hrms.models.User;
import com.example.hrms.models.employment_info.*;
import com.example.hrms.models.employment.Job;
import com.example.hrms.service.employment.EmploymentCategoryService;
import com.example.hrms.service.employment.EmploymentTypeService;
import com.example.hrms.service.employment_info.*;
import com.example.hrms.service.user.UserService;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
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
    private final ContactService contactService;
    private final FamilyService familyService;
    private final EmergencyService emergencyService;
    private final PhotographService photographService;
    private final AttachmentService attachmentService;
    private final NomineeService nomineeService;
    private final HealthService healthService;
    private final EmploymentTypeService employmentTypeService;
    private final EmploymentCategoryService employmentCategoryService;
    private final UserService userService;

    @Autowired
    public AdminController(EmployeeService employeeService, DesignationService designationService, DepartmentService departmentService, GroupService groupService, BankService bankService, BankBranchService bankBranchService, PersonalService personalService, ContactService contactService, FamilyService familyService, EmergencyService emergencyService, PhotographService photographService, AttachmentService attachmentService, NomineeService nomineeService, HealthService healthService, EmploymentTypeService employmentTypeService, EmploymentCategoryService employmentCategoryService, UserService userService) {
        this.employeeService = employeeService;
        this.designationService = designationService;
        this.departmentService = departmentService;
        this.groupService = groupService;
        this.bankService = bankService;
        this.bankBranchService = bankBranchService;
        this.personalService = personalService;
        this.contactService = contactService;
        this.familyService = familyService;
        this.emergencyService = emergencyService;
        this.photographService = photographService;
        this.attachmentService = attachmentService;
        this.nomineeService = nomineeService;
        this.healthService = healthService;
        this.employmentTypeService = employmentTypeService;
        this.employmentCategoryService = employmentCategoryService;
        this.userService = userService;
    }

    @GetMapping("")
    public String admin(Model model){
        model.addAttribute("date", new Date());
        return "admin/basehtml";
    }

    @GetMapping("/sample")
    public String sample(Model model) {
        return "admin/sample";
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
            return new ResponseEntity<>("something went wrong", HttpStatus.CONFLICT);
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
        Long empId = Long.valueOf(employeeId);
        Optional<Employee> employee = employeeService.findEmployeeById(empId);
        if (employee.isEmpty()) {
            model.addAttribute("errorMessage", "Employee not present");
            return "admin/errorPage"; // Return the view name for the error page
        }
        setDate(model);
        model.addAttribute("gender", Personal.Gender.values());
        model.addAttribute("marriageStatus", Personal.MarriageStatus.values());
        model.addAttribute("communityCategory", Personal.CommunityCategory.values());
        model.addAttribute("vehicleType", Personal.VehicleType.values());
        model.addAttribute("banks", bankService.findAllBanks());
        model.addAttribute("bankBranches", bankBranchService.findAllBankBranches());
        model.addAttribute("familiesByNominee", familyService.findAllFamiliesByNominee(empId));
        model.addAttribute("personal", personalService.findPersonalByEmpId(empId));
        model.addAttribute("contact", contactService.findContactByEmpId(empId));
        model.addAttribute("families", familyService.findFamiliesById(empId));
        model.addAttribute("emergency", emergencyService.findAllById(empId));
        model.addAttribute("nominees", nomineeService.findNomineesByEmpId(empId));
        model.addAttribute("health", healthService.findHealthByEmpId(empId));
        model.addAttribute("photograph", photographService.findPhotographByEmpId(empId));
        model.addAttribute("attachment", attachmentService.findAttachmentByEmpId(empId));

        model.addAttribute("employmentStatus", Job.EmploymentStatus.values());
        model.addAttribute("employmentTypes", employmentTypeService.findAllEmploymentTypes());
        model.addAttribute("employmentCategories", employmentCategoryService.findAllEmploymentCategories());

        return "admin/editEmployee";
    }

    @PostMapping("/submitPersonal/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitPersonalDetails(@RequestBody Personal personal, @PathVariable String employeeId) {
        try {
            Long bankBranchId = personal.getBankDetail().getBankBranchId();
            BankBranch bankbranch = bankBranchService.findBankBranchById(bankBranchId).get();

            Optional<Employee> employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
            employee.ifPresent(personal::setEmployee);
            personal.setBankDetail(bankbranch);

            personalService.savePersonal(personal);
            return ResponseEntity.ok("Personal details saved!");
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving personal details!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/submitContact/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitContactDetails(@RequestBody Contact contact, @PathVariable String employeeId) {
        try {
            Contact contactNew = contactService.findContactByEmpId(Long.valueOf(employeeId));
            if (contactNew != null) {
                return new ResponseEntity<>("Contact already exists!", HttpStatus.BAD_REQUEST);
            }
            else {
                Optional<Employee> employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
                employee.ifPresent(contact::setEmployee);
                contactService.saveContact(contact);
                return ResponseEntity.ok("Contact saved successfully");
            }

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

            return ResponseEntity.ok("Family contacts saved successfully");
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
            emergencyService.saveEmergencyContacts(emergencyList);

            return ResponseEntity.ok("Emergency contacts saved successfully");
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving emergency!", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/submitNominee/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitNomineeDetails(@RequestBody List<Nominee> nominees, @PathVariable String employeeId) {
        try {
            Optional<Employee> employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
            nominees.forEach(emergency -> emergency.setEmployee(employee.get()));
            nomineeService.saveNominees(nominees);

            return ResponseEntity.ok("Nominees saved successfully");
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving nominee!", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/submitHealth/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitHealthDetails(@RequestBody Health health, @PathVariable String employeeId) {
        try {
            Optional<Employee> employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
            health.setEmployee(employee.get());
            healthService.saveHealth(health);

            return ResponseEntity.ok("Emergency contacts saved successfully");
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving emergency!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/submitPhoto/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitPhotos(@ModelAttribute Photograph photo, @PathVariable String employeeId) {
        try {
            Optional<Employee> employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
            Photograph photograph = photographService.findPhotographByEmpId(Long.valueOf(employeeId));
            if (photograph != null) {
                if (photo.getEmployeePhoto() != null)
                    photograph.setEmployeePhotoBytes(photo.getEmployeePhoto());
                if (photo.getEmployeeSign() != null)
                    photograph.setEmployeeSignBytes(photo.getEmployeeSign());

                photographService.savePhotograph(photograph);
            }
            else {
                photo.setEmployee(employee.get());
                photographService.savePhotograph(photo);
            }
            return ResponseEntity.ok("Photos saved successfully");
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Error occurred while saving photo!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/submitAttachment/{employeeId}")
    @ResponseBody
    public ResponseEntity<String> submitAttachments(@ModelAttribute Attachment attachment ,@PathVariable String employeeId) {
        try {
            Optional<Employee> employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
            attachment.setEmployee(employee.get());
            attachmentService.saveAttachment(attachment);
            return ResponseEntity.ok("Attachment details saved successfully");
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving attachment!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/registerUser")
    @ResponseBody
    public ResponseEntity<String> registerNewUser(@RequestBody RegisterDTO registerDTO) {
        try {
            if (registerDTO.getUsername() != null && registerDTO.getPassword() != null) {
                User user = new User();
                user.setUsername(registerDTO.getUsername());
                user.setPassword(registerDTO.getPassword());
                Optional<Employee> employee = employeeService.findEmployeeById(registerDTO.getEmployeeId());
                if (employee.isPresent()) {
                    user.setEmployee(employee.get());
                    userService.saveUser(user);
                    return ResponseEntity.ok("User registered successfully.");
                }
                else {
                    return new ResponseEntity<>("Employee null.", HttpStatus.BAD_REQUEST);
                }
            }
            else {
                return new ResponseEntity<>("Username or password null.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong while creating a user!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searchEmployees")
    @ResponseBody
    public List<Employee> searchEmployees(@RequestParam String searchTerm) {
        return employeeService.searchEmployeesByFirstName(searchTerm);
    }


    public void setDate(Model model){
        LocalDate date = LocalDate.now();
        model.addAttribute("day", date.getDayOfWeek());
        model.addAttribute("date", date.getDayOfMonth());
        model.addAttribute("month", date.getMonth());
        model.addAttribute("year", date.getYear());
    }

    @GetMapping("/deshboard")
    public String deshboard(Model model){
        List<Employee> employees = employeeService.findAllEmployees();
        setDate(model);
        model.addAttribute("employees",employees);
        return "admin/deshboard";
    }
}
