package com.iot.lpnu.repository;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot.lpnu.tools.TreeTools;

@Repository
public interface ToolRepository extends JpaRepository<TreeTools, Integer>{
    List<TreeTools> findByNameString(String nameString);
    default Map<String, TreeTools> findByNameStringMap(String nameString){
        return findByNameString(nameString).stream().collect(Collectors.toMap(TreeTools::getNameString, tool -> tool));
    }
    
    List<TreeTools> findByCostInUaPerOne(Float costInUaPerOne);
    default Map<Float,TreeTools> findByCostInUaPerOneMap(Float costInUaPerOne){
        return findByCostInUaPerOne(costInUaPerOne).stream().collect(Collectors.toMap(TreeTools::getCostInUaPerOne, tool -> tool));
    }
    
    List<TreeTools> findById(int id); 
    default Map<Integer, TreeTools> findByIdMap(int id){
        return findById(id).stream().collect(Collectors.toMap(TreeTools::getId, tool -> tool));

    }
}
