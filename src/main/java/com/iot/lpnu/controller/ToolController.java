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
import org.springframework.http.ResponseEntity;
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
public class ToolController {
    @Autowired
    private ToolService toolService;
    
    @GET
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
//    @GetMapping("/tool/")
    public ResponseEntity<Object> getAllTool() {
        if(toolService.findAll().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        else {
            return ResponseEntity.ok(toolService.findAll());
        }
    }
    
    @GET
    @Path("/getbyname/{nameString}")
    @Consumes("application/json")
    @Produces("application/json")
//  @GetMapping("/tool/getbyname/{nameString}")
    public ResponseEntity<Object> searchByName(@PathParam("nameString") String nameString) {
        try {
            if(toolService.findByName(nameString).isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            
            else {
                return ResponseEntity.ok(toolService.findByName(nameString));
            }
            
         } catch (NullPointerException e) {
             return ResponseEntity.noContent().build();
         }
     }
    
    @GET
    @Path("/getbyid/{id}")
    @Consumes("application/json")
    @Produces("application/json")
//  @GetMapping("/tool/getbyid/{id}")
    public ResponseEntity<Object> searchById(@PathParam("id") int id) {
       try {
           if(toolService.findById(id).isEmpty()) {
               return ResponseEntity.noContent().build();
           }
           
           else {
               return ResponseEntity.ok(toolService.findById(id));
           }
           
        } catch (NullPointerException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @GET
    @Path("/getbycost/{costInUaPerOne}")
    @Consumes("application/json")
    @Produces("application/json")
//    @GetMapping("/tool/getbycost/{costInUaPerOne}")
    public ResponseEntity<Object> searchByCost(@PathParam("costInUaPerOne") Float costInUaPerOne) {
        try {
            if(toolService.findByCostInUaPerOne(costInUaPerOne).isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            
            else {
                return ResponseEntity.ok(toolService.findByCostInUaPerOne(costInUaPerOne));
            }
            
         } catch (NullPointerException e) {
             return ResponseEntity.noContent().build();
         }
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
    public ResponseEntity<Object> updateTool(@PathParam("id") Integer id, @RequestBody TreeTools treeTools) {
        try {
            if(toolService.findById(id).isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            
            else {
                return ResponseEntity.ok(toolService.update(id, treeTools));
            }
            
         } catch (NullPointerException e) {
             return ResponseEntity.noContent().build();
         }
     }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    @Produces("application/json")
//    @DeleteMapping("tool/delete/{id}")
    public ResponseEntity<Object> delete(@PathParam("id") int id) {
//        HttpStatus httpStatus;
        try {
            if(toolService.findById(id).isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            
            else {
//                toolService.delete(id);
//                httpStatus = HttpStatus.OK;
//                return ResponseEntity.status(httpStatus).build();
                return (ResponseEntity<Object>) ResponseEntity.ok();
            }
            
         } catch (NullPointerException e) {
             return ResponseEntity.noContent().build();
         }
     }
}
