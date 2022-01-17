package com.surfer.repositories;

import com.surfer.Entities.Beach;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeachSqlRepository extends JpaRepository<Beach, Long> {
    List<Beach> findByBeachName(String beachName);

    List<Beach> findByLocation(String location);

}
