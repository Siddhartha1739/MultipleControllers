package com.example.EmployeeDatabase.Service;

import com.example.EmployeeDatabase.Entity.Project;
import com.example.EmployeeDatabase.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class ProjectServiceImp {
    @Autowired
    private ProjectRepository projectRepository;
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public void delProject(int prjctId){
        projectRepository.deleteById(prjctId);
    }

    public void updateProject(int prjctId,String pName){
        Project project=projectRepository.getReferenceById(prjctId);
        String Name=project.getName();
        Name=pName;
        projectRepository.save(new Project(prjctId,Name));
    }
    public HashMap<Integer, Project> viewProjects() {
        HashMap<Integer,Project> map=new HashMap<>();
        List<Project> projectList=projectRepository.findAll();
        for(Project prjct: projectList){
            map.put(prjct.getId(),prjct);
        }
        return map;
    }

    public Project getProjectById(int prjctId) {
        return projectRepository.getReferenceById(prjctId);
    }

    public boolean existPrjct(int prjctId){
        return projectRepository.existsById(prjctId);
    }
}
