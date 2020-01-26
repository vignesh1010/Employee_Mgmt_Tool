package com.rbsagile.tcsrbs.services;

import com.rbsagile.tcsrbs.Exception.ProjectIdException;
import com.rbsagile.tcsrbs.Repository.ProjectRepository;
import com.rbsagile.tcsrbs.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project SaveOrUpdate(Project project)
    {
        try
        {
            project.setDeskNo(project.getDeskNo().toUpperCase());
            return projectRepository.save(project);
        }
        catch (Exception e)
        {
            throw new ProjectIdException("Employee Id '"+project.getDeskNo().toUpperCase()+"'already exists");
        }
    }

    public Project findProjectByDeskNo(String DeskNo)
    {
        Project project = projectRepository.findBydeskNo(DeskNo.toUpperCase());
        if (project==null){
            throw new ProjectIdException("Desk No "+DeskNo+"Does not Exists");
        }
        return project;
    }
    public Project findprojectByEmpID(String EmpId)
    {
        Project project = projectRepository.findByempId(EmpId.toUpperCase());
        if(project==null){
            throw new ProjectIdException("EmpId"+EmpId+"Does not Exists");
        }
        return project;
    }

    public Iterable<Project> findAllEmployees(){
        return projectRepository.findAll();
    }

    public void deleteEmployeeById(String deskno){
        Project project = projectRepository.findBydeskNo(deskno);
        if (project==null){
            throw new ProjectIdException(deskno+"Desk Number does not Exists");
        }
        projectRepository.delete(project);
    }

}
