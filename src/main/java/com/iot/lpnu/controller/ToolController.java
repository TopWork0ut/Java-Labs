package com.iot.lpnu.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iot.lpnu.services.ToolService;
import com.iot.lpnu.tools.TreeTools;

@RestController
public class ToolController {
    @Autowired
    private ToolService toolService;
    
    @GetMapping("/tool/")
    public List<TreeTools> getAllTool() {
        return toolService.findAll();
    }
    
    @GetMapping("/tool/getbyname/{nameString}")
    public List<TreeTools> searchByName(@PathVariable String nameString){
        return toolService.findByName(nameString);
    }
    
    @GetMapping("/tool/getbyid/{id}")
    public TreeTools searchById(@PathVariable int id){
        return toolService.findById(id);
    }
    
    @GetMapping("/tool/getbycost/{costInUaPerOne}")
    public List<TreeTools> searchByCost(@PathVariable Float costInUaPerOne){
        return toolService.findByCostInUaPerOne(costInUaPerOne);
    }

    @PostMapping("/tool/add")
    public TreeTools addTool(@RequestBody TreeTools treeTools){
        return toolService.addTool(treeTools);
    }
    
    @PostMapping("/tool/addlist")
    public List<TreeTools> addListOfTools(@RequestBody LinkedList<TreeTools> list){
        return toolService.addListOfTool(list);
    }
    
    @PutMapping("/tool/update/{id}")
    public TreeTools addListOfTools(@PathVariable Integer id, @RequestBody TreeTools treeTools){
        return toolService.update(id, treeTools);
    }
    
    @DeleteMapping("tool/delete/{id}")
    public void delete(@PathVariable int id) {
        toolService.delete(id);
    }
}
