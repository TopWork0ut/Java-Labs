package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;

public class BushTools extends GardenTools{
    

public BushTools(String nameString, boolean isElectric, Float costInUaPerOne, Float lengthInCm, Float wigthInCm,
	    Float heightInCm, DangerLevel dangerLevel, ToolSpecialization toolSpecialization) {
	super(nameString, isElectric, costInUaPerOne, lengthInCm, wigthInCm, heightInCm, dangerLevel, toolSpecialization);
	
    }    
    

    @Override
    public void calculateSizeOfTheTool() {
	// TODO Auto-generated method stub
	
    }


    @Override
    public String toString() {
	return super.toString();
    }
}