package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;

public class FlowerTools extends GardenTools{
    
    
public FlowerTools(String nameString, boolean isElectric, Float costInUaPerOne, Float lengthInCm, Float wigthInCm,
	    Float heightInCm, DangerLevel dangerLevel, ToolSpecialization toolSpecialization) {
	super(nameString, isElectric, costInUaPerOne, lengthInCm, wigthInCm, heightInCm, dangerLevel, toolSpecialization);
	// TODO Auto-generated constructor stub
    }

    @Override
    public void calculateSizeOfTheTool() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String toString() {
	return  super.toString();
    }
}