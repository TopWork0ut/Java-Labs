package com.iot.lpnu.manager;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.iot.lpnu.enums.OrderOfSOrting;
import com.iot.lpnu.tools.GardenTools;


public class SortingManager {
    protected List<GardenTools> getToolsSortedByPrice(List<GardenTools> listOfTools, OrderOfSOrting order ) {
    	List<GardenTools> sortedListOfGardenTools;
    	if(order == OrderOfSOrting.DESCENDING) {
    	    sortedListOfGardenTools = listOfTools.stream()
    		    .sorted(Comparator.comparing(GardenTools::getCostInUaPerOne))
    		    .collect(Collectors.toList());
    	}
    	
    	else {
    	    sortedListOfGardenTools = listOfTools.stream()
    		    .sorted(Comparator.comparing(GardenTools::getCostInUaPerOne).reversed())
    		    .collect(Collectors.toList());
    	}
    	
    	return sortedListOfGardenTools;
	
    }
    
    protected List<GardenTools> getToolsSortedByWeight(List<GardenTools> listOfTools, OrderOfSOrting order) {
    	List<GardenTools> sortedListOfGardenTools;
    	if(order == OrderOfSOrting.DESCENDING) {
    	   sortedListOfGardenTools = listOfTools.stream()
    		   .sorted(Comparator.comparing(GardenTools::getWeightInKg))
    		   .collect(Collectors.toList());
    	}
    	
    	else {
    	    sortedListOfGardenTools = listOfTools.stream()
    		    .sorted(Comparator.comparing(GardenTools::getWeightInKg).reversed())
    		    .collect(Collectors.toList());
    	}
    	
    	return sortedListOfGardenTools;
    } 
       
}

//enum OrderOfSOrting{
//    ASCENDING,
//    DESCENDING;
//}
