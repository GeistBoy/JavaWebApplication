package com.zhengliang.project.repositories;

import com.zhengliang.project.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findById(long id);

    @Override
    Iterable<Project> findAll();
}
