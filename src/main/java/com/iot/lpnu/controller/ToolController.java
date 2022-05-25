package com.iot.lpnu.controller;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iot.lpnu.services.ToolService;
import com.iot.lpnu.tools.TreeTools;


@RestController
@Path("/tool")
@Consumes("application/json")
@Produces("application/json")
public class ToolController {
    @Autowired
    private ToolService toolService;
    
    @GET
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
//    @GetMapping("/tool/")
    public List<TreeTools> getAllTool() {
        return toolService.findAll();
    }
    
    @GET
    @Path("/getbyname/{nameString}")
    @Consumes("application/json")
    @Produces("application/json")
//  @GetMapping("/tool/getbyname/{nameString}")
    public List<TreeTools> searchByName(@PathParam("nameString") String nameString){
        return toolService.findByName(nameString);
    }
    
    @GET
    @Path("/getbyid/{id}")
    @Consumes("application/json")
    @Produces("application/json")
//  @GetMapping("/tool/getbyid/{id}")
    public TreeTools searchById(@PathParam("id") int id){
        return toolService.findById(id);
    }
    
    @GET
    @Path("/getbycost/{costInUaPerOne}")
    @Consumes("application/json")
    @Produces("application/json")
//    @GetMapping("/tool/getbycost/{costInUaPerOne}")
    public List<TreeTools> searchByCost(@PathParam("costInUaPerOne") Float costInUaPerOne/* @PathVariable Float costInUaPerOne */){
        return toolService.findByCostInUaPerOne(costInUaPerOne);
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    @Produces("application/json")
//    @PostMapping("/tool/add")
    public TreeTools addTool(@RequestBody TreeTools treeTools){
        return toolService.addTool(treeTools);
    }
    
    @POST
    @Path("/addlist")
    @Consumes("application/json")
    @Produces("application/json")
//    @PostMapping("/tool/addlist")
    public List<TreeTools> addListOfTools(@RequestBody LinkedList<TreeTools> list){
        return toolService.addListOfTool(list);
    }
    
    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    @Produces("application/json")
//    @PutMapping("/tool/update/{id}")
    public TreeTools addListOfTools(@PathParam("id") Integer id, @RequestBody TreeTools treeTools){
        return toolService.update(id, treeTools);
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    @Produces("application/json")
//    @DeleteMapping("tool/delete/{id}")
    public void delete(@PathParam("id") int id) {
        toolService.delete(id);
    }
}
