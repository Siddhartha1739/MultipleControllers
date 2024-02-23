package com.example.EmployeeDatabase.Controller;

import com.example.EmployeeDatabase.Entity.Project;
import com.example.EmployeeDatabase.Service.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/Project")
public class ProjectController {
    @Autowired
    private ProjectServiceImp projectService;

    @RequestMapping("/addPrjct")
    public String  addPrjct(){
        System.out.println("Project Details:");
        return "addPrjct";
    }

    @RequestMapping("/addedProject")
    public String addedProject(Project project, ModelMap map, int prjctId){
        if( projectService.viewProjects().containsKey(prjctId)){return "DataExist";}
        System.out.println("added Project");
        projectService.addProject(project);
        map.addAttribute("project",project);
        String name=project.getName();
        map.put("name",name);
        return "prjct";
    }

    @RequestMapping("/viewPrjct")
    public String viewEmploys(ModelMap model){
        Map<Integer, Project> projectMap=projectService.viewProjects();
       // System.out.println("view Employees");
        model.addAttribute("ProjectMap",projectMap);
        return "viewPrjct";
    }


    @RequestMapping("/deleteP")
    public String  delete(){
        System.out.println("Project Details deleting:");
        return "delPrjct";
    }
    @RequestMapping("/deleteProject")

    public String deleteProject(int projectId,ModelMap model){
        Project project = projectService.getProjectById(projectId);
        if(!projectService.existPrjct(projectId)){ return "DataNotFound";}
        projectService.delProject(projectId);
        System.out.println("Project details deleted...");
        Map<Integer,Project> projectMap=projectService.viewProjects();
        System.out.println("view after delete Project");
        model.addAttribute("ProjectMap",projectMap);
        return "viewPrjct";
    }
    @RequestMapping("/updateP")
    public String  update(){
        System.out.println("Employee Details updating:");
        return "updateP";
    }
    @RequestMapping("/updateProject")
    public String updateEmployee(int projectId,ModelMap model){
       Project project = projectService.getProjectById(projectId);
        if(!projectService.existPrjct(projectId)){ return "DataNotFound";}
        System.out.println("Project Details updated!!!!!"+projectId);
        String Name=project.getName();
        int prjctId=project.getId();
        model.addAttribute("Name",Name);
        model.addAttribute("Id",prjctId);
        return "updatingP";
    }
    @RequestMapping("/updatedP")
    public String updated(int prjctId,String Name,ModelMap model){
        projectService.updateProject(prjctId,Name);
        Map<Integer, Project> projectMap=projectService.viewProjects();
        System.out.println("view Project");
        model.addAttribute("projectMap",projectMap);
        return "viewPrjct";
    }

    @RequestMapping("/DataNotFound")
    public String DataNotFound(){
        return "DataNotFound";
    }
}
