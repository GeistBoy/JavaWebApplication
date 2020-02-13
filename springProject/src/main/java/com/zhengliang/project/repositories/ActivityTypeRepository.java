package com.zhengliang.project.repositories;

import com.zhengliang.project.domain.ActivityType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTypeRepository extends CrudRepository<ActivityType, Long> {

    ActivityType findById(long id);

    @Override
    Iterable<ActivityType> findAll();
}
