package com.example.StudentprojectInfo.service;

import com.example.StudentprojectInfo.dto.Projectrequest;
import com.example.StudentprojectInfo.exception.UserNotFoundException;
import com.example.StudentprojectInfo.model.Project;
import com.example.StudentprojectInfo.repository.Projectrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Projectservice {
    @Autowired
    private Projectrepository repo;



    public Project saveproject(Projectrequest projectRequest) {
Project project=new Project();
        project.setRollno(projectRequest.getRollno());
        project.setName(projectRequest.getName());
        project.setBatch(projectRequest.getBatch());
        project.setEmail(projectRequest.getEmail());
        project.setPhone(projectRequest.getPhone());
        project.setDepartment(projectRequest.getDepartment());
        project.setSemester(projectRequest.getSemester());
        project.setProjectname(projectRequest.getProjectname());
        project.setDescription(projectRequest.getDescription());
        project.setStatus(projectRequest.getStatus());
        project.setSupervisor(projectRequest.getSupervisor());
        project.setHodname(projectRequest.getHodname());
        project.setDate(projectRequest.getDate());
        project.setTopic(projectRequest.getTopic());
        project.setGithublink(projectRequest.getGithublink());
        project.setProjectlink(projectRequest.getProjectlink());
        return repo.save(project);
    }
    public List<Project> getproject() {
        return repo.findAll();
    }
    /*public Project getProjects(int id) {
        return repo.findById(id).get();
    }*/

    public void deleteProject(int id) {
        repo.deleteById(id);
    }


    public Project updateProject(int id, Project project) {
        Project existingProject = repo.findById(id).get();
        existingProject.setRollno(project.getRollno());
        existingProject.setName(project.getName());
        existingProject.setBatch(project.getBatch());
        existingProject.setEmail(project.getEmail());
        existingProject.setPhone(project.getPhone());
        existingProject.setDepartment(project.getDepartment());
        existingProject.setSemester(project.getSemester());
        existingProject.setProjectname(project.getProjectname());
        existingProject.setDescription(project.getDescription());
        existingProject.setStatus(project.getStatus());
        existingProject.setSupervisor(project.getSupervisor());
        existingProject.setHodname(project.getHodname());
        existingProject.setDate(project.getDate());
        existingProject.setTopic(project.getTopic());
        existingProject.setGithublink(project.getGithublink());
        existingProject.setProjectlink(project.getProjectlink());
        return repo.save(existingProject);
    }

    public List<Project> saveprojects(List<Project> projects) {
        return repo.saveAll(projects);
    }
    public Project getProjectByRollno(String rollno) throws UserNotFoundException {
        Project p = repo.findByRollno(rollno);
        if(p != null){
            return p;
        } else {
            throw new UserNotFoundException("User not found with roll number: " + rollno);
        }
    }

}
