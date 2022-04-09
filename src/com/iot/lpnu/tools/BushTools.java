package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;

public class BushTools extends GardenTools{
    private boolean isForBushesWithThornes;
    
    
    public BushTools(String nameString, boolean isElectric, Float costInUaPerOne, Float weightInKg,
	    DangerLevel dangerLevel, boolean isForBushesWithThornes) {
    	super(nameString, isElectric, costInUaPerOne, weightInKg, dangerLevel);
    	this.isForBushesWithThornes = isForBushesWithThornes;
    	super.toolSpecialization = ToolSpecialization.IS_FOR_BUSHES;
	
    }

    public boolean isForBushesWithThornes() {
        return isForBushesWithThornes;
    }

    public void setForBushesWithThornes(boolean isForBushesWithThornes) {
        this.isForBushesWithThornes = isForBushesWithThornes;
    }

    @Override
    public String toString() {
	return "BushTools [isForBushesWithThornes=" + isForBushesWithThornes + ", dangerLevel=" + dangerLevel
		+ ", toolSpecialization=" + toolSpecialization + ", isForBushesWithThornes()="
		+ isForBushesWithThornes() + ", getNameString()=" + getNameString() + ", isElectric()=" + isElectric()
		+ ", getCostInUaPerOne()=" + getCostInUaPerOne() + ", getWeightInKg()=" + getWeightInKg()
		+ ", getDangerLevel()=" + getDangerLevel() + ", getToolSpecialization()=" + getToolSpecialization()
		+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
		+ "]";
    }  
}