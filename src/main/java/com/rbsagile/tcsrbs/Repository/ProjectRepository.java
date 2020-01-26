package com.rbsagile.tcsrbs.Repository;

import com.rbsagile.tcsrbs.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
    Project findBydeskNo(String DeskNo);
    Project findByempId(String EmpId);



    @Override
    Iterable<Project> findAll();
}
