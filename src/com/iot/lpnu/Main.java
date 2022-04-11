package com.iot.lpnu;

import com.iot.lpnu.tools.BushTools;
import com.iot.lpnu.tools.FlowerTools;
import com.iot.lpnu.tools.TreeTools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.OrderOfSOrting;
import com.iot.lpnu.enums.ToolSpecialization;
import com.iot.lpnu.manager.*;

public class Main {

    public static void main(String[] args) {
    	BushTools bushtool1 = new BushTools("bush1", true, 7.2f, 1f, DangerLevel.LOW, true);
    	BushTools bushtool2 = new BushTools("bush2", false, 1.2f, 2f, DangerLevel.HIGH, false);
    	BushTools bushtool3 = new BushTools("bush3", true, 9f, 1f, DangerLevel.MEDIUM, false);
    	FlowerTools flowerTools1 = new FlowerTools("flower1", false, 1.7f, 2f, DangerLevel.HIGH, true);
    	FlowerTools flowerTools2 = new FlowerTools("flower2", true, 0.2f, 2f, DangerLevel.LOW, true);
    	FlowerTools flowerTools3 = new FlowerTools("flower3", false, 5f, 2.5f, DangerLevel.LOW, false);
    	TreeTools treeTools1 = new TreeTools("tree1", true, 8f, 1.4f, DangerLevel.MEDIUM, true);
    	TreeTools treeTools2 = new TreeTools("tree2", true, 9.5f, 1f, DangerLevel.MEDIUM, false);
    	TreeTools treeTools3 = new TreeTools("tree3", false, 15.2f, 6f, DangerLevel.LOW, true);
    	
    	
    	InstrumentShop instrumentShop = new InstrumentShop();
    	instrumentShop.addToolToTheShop(flowerTools1);
    	instrumentShop.addToolToTheShop(flowerTools2);
    	instrumentShop.addToolToTheShop(flowerTools3);
    	instrumentShop.addToolToTheShop(bushtool1);
    	instrumentShop.addToolToTheShop(bushtool2);
    	instrumentShop.addToolToTheShop(bushtool3);
    	instrumentShop.addToolToTheShop(treeTools1);
    	instrumentShop.addToolToTheShop(treeTools2);
    	instrumentShop.addToolToTheShop(treeTools3);
    	
    	
    	System.out.println(instrumentShop.sellInstruments(ToolSpecialization.IS_FOR_BUSHES, 9));
    	System.out.println(instrumentShop.calculatePriceForTool(treeTools3, 7));
    	System.out.println(instrumentShop.getListOfToolsForProfilacticWorksWithTrees(OrderOfSOrting.ASCENDING));
    //	System.out.println(instrumentShop.removeToolFromShop(ToolSpecialization.IS_FOR_TREES, 3));
    		
    }
}
