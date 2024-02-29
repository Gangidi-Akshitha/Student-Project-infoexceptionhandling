package com.example.StudentprojectInfo.controller;

import com.example.StudentprojectInfo.dto.Projectrequest;
import com.example.StudentprojectInfo.exception.UserNotFoundException;
import com.example.StudentprojectInfo.model.Project;
import com.example.StudentprojectInfo.service.Projectservice;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class Projectcontroller {
    @Autowired
    private Projectservice projectservice;

    @PostMapping("/addproject")
    public ResponseEntity<Project> saveproject(@RequestBody @Valid Projectrequest projectrequest) {
        return new ResponseEntity<>(projectservice.saveproject(projectrequest), HttpStatus.CREATED);
    }
    @PostMapping("/addprojects")
    public List<Project> saveprojects(@RequestBody List<Project> projects) {
        return projectservice.saveprojects(projects);
    }

   @GetMapping("/getproject")
    public List<Project> getproject() {
        return projectservice.getproject();
    }
   /* @GetMapping("/{id}")
    public Project getProjects(@PathVariable int id){
        return projectservice.getProjects(id);
    }*/
    @GetMapping("/{rollno}")
    public ResponseEntity<Project> getProjectByRollNo(@PathVariable String rollno) throws UserNotFoundException {
        return ResponseEntity.ok(projectservice.getProjectByRollno(rollno));
    }



    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable int id){
        projectservice.deleteProject(id);
        return "Deleted";
    }
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable int id,@RequestBody Project project){
        return projectservice.updateProject(id, project);
    }

}