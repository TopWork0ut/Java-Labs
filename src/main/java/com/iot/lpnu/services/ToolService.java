package com.iot.lpnu.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.lpnu.repository.ToolRepository;
import com.iot.lpnu.tools.TreeTools;


@Service
public class ToolService {
    @Autowired
    ToolRepository repository;
       
    public TreeTools addTool(TreeTools treeTools) {
        repository.save(treeTools);
        return treeTools;
    }
    
    public List<TreeTools> addListOfTool(List<TreeTools> list) {
        repository.saveAll(list);
        return list;
    }
    
    public Map<Integer, TreeTools> findAll() {       
        return repository.findAll().stream().collect(Collectors.toMap(TreeTools::getId, tool -> tool));
    }

    public Map<String,TreeTools> findByName(String string) {
        return repository.findByNameStringMap(string);
    }
    
    public Map<Integer,TreeTools> findById(int id) {
        return repository.findByIdMap(id);
    }
    
    public Map<Float,TreeTools> findByCostInUaPerOne(Float costInUaPerOne) {
        return repository.findByCostInUaPerOneMap(costInUaPerOne);
    }
    
    public TreeTools update(Integer id, TreeTools treeTools) {
        TreeTools treeTools2 = repository.findById(id).get();
        treeTools2.setCostInUaPerOne(treeTools.getCostInUaPerOne());
        treeTools2.setDangerLevel(treeTools.getDangerLevel());
        treeTools2.setId(id);
        treeTools2.setElectric(treeTools.isElectric());
        treeTools2.setNameString(treeTools.getNameString());
        treeTools2.setProfilacticTool(treeTools.isProfilacticTool());
        treeTools2.setToolSpecialization(treeTools.getToolSpecialization());
        treeTools2.setWeightInKg(treeTools.getWeightInKg());
              
        repository.save(treeTools2);
        return treeTools2;
    }
    
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
    
    
    
}
