package com.zhengliang.project.repositories;

import com.zhengliang.project.domain.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

    Activity findById(long id);

    @Override
    Iterable<Activity> findAll();
}
