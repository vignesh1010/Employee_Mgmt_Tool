package com.rbsagile.tcsrbs.web;


import com.rbsagile.tcsrbs.domain.Project;
import com.rbsagile.tcsrbs.services.MapValidationErrorServices;
import com.rbsagile.tcsrbs.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorServices mapValidationErrorServices;

    @PostMapping("")
    public ResponseEntity<?> CreateNewEmployee(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorServices.MapValidationService(result);
        if (errorMap!=null){
            return errorMap;
        }
        Project project1 = projectService.SaveOrUpdate(project);
        return new ResponseEntity<Project>(project1,HttpStatus.CREATED);
    }

    @GetMapping("/{DeskNo}")
    public ResponseEntity<?> getProjectByDeskNo(@PathVariable String DeskNo)
    {
        Project project = projectService.findProjectByDeskNo(DeskNo);
        return new ResponseEntity<Project>(project,HttpStatus.OK);

    }
    @GetMapping("/EmpId/{EmpId}")
    public ResponseEntity<?> getProjectByEmpId(@PathVariable String EmpId){
        Project project1=projectService.findprojectByEmpID(EmpId);
        return new ResponseEntity<Project>(project1,HttpStatus.OK);

    }

    @GetMapping("/all")
    public Iterable<Project> getAllEmployees(){
        return projectService.findAllEmployees();
    }

    @DeleteMapping("/{DeskNo}")
    public ResponseEntity<?> deleteProject(@PathVariable String DeskNo){
        projectService.deleteEmployeeById(DeskNo.toUpperCase());
        return new ResponseEntity<String>("Employee With Desk No"+DeskNo+"Was Deleted",HttpStatus.OK);
    }



}
