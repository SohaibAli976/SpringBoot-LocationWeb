package com.example.location.locationweb.Repository;

import com.example.location.locationweb.entities.Location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("select l.type,count(l.type) from Location l group by l.type")
    public List<Object[]> findTypeAndTypeCount();

}
