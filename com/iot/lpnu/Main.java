package com.iot.lpnu;

import com.iot.lpnu.tools.BushTools;
import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;
import com.iot.lpnu.manager.*;

public class Main {

    public static void main(String[] args) {
	BushTools bushtool1 = new BushTools("bushtool1", true , 2.3f, 5.0f, 4.1f, 6.7f,DangerLevel.LOW,
		ToolSpecialization.IS_FOR_GRABBING_PLANTS );
	
	SortingManager sortingManager = new SortingManager();
	InstrumentShop instrumentShop = new InstrumentShop();
	
	
	System.out.println(bushtool1);
    }
}
