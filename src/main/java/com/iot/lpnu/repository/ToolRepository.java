package com.iot.lpnu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot.lpnu.tools.TreeTools;

@Repository
public interface ToolRepository extends JpaRepository<TreeTools, Integer >{
    List<TreeTools> findByNameString(String nameString);
    List<TreeTools> findByCostInUaPerOne(Float costInUaPerOne);
    TreeTools findById(int id);
      
}
