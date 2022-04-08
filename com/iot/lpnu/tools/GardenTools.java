package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;

public abstract class GardenTools {
    private String nameString;
    private boolean isElectric;
    private Float costInUaPerOne;
    private Float lengthInCm;
    private Float wigthInCm;
    private Float heightInCm;
    DangerLevel dangerLevel;
    ToolSpecialization toolSpecialization;
    
    public GardenTools(String nameString, boolean isElectric, Float costInUaPerOne, Float lengthInCm, Float wigthInCm,
	    Float heightInCm, DangerLevel dangerLevel, ToolSpecialization toolSpecialization) {
	super();
	this.nameString = nameString;
	this.isElectric = isElectric;
	this.costInUaPerOne = costInUaPerOne;
	this.lengthInCm = lengthInCm;
	this.wigthInCm = wigthInCm;
	this.heightInCm = heightInCm;
	this.dangerLevel = dangerLevel;
	this.toolSpecialization = toolSpecialization;
    }  
    
    public abstract void calculateSizeOfTheTool();

    @Override
    public String toString() {
	return "GardenTools [nameString=" + nameString + ", isElectric=" + isElectric + ", costInUaPerOne="
		+ costInUaPerOne + ", lengthInCm=" + lengthInCm + ", wigthInCm=" + wigthInCm + ", heightInCm="
		+ heightInCm + ", dangerLevel=" + dangerLevel + ", toolSpecialization=" + toolSpecialization
		+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
		+ "]";
    }
    
    
}

