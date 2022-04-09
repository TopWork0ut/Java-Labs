package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;

public class FlowerTools extends GardenTools{
    private boolean isForPoisonousFlowers;

    public FlowerTools(String nameString, boolean isElectric, Float costInUaPerOne, Float weightInKg,
	    DangerLevel dangerLevel, boolean isForPoisonousFlowers) {
    	super(nameString, isElectric, costInUaPerOne, weightInKg, dangerLevel);
    	this.isForPoisonousFlowers = isForPoisonousFlowers;
    	super.toolSpecialization = ToolSpecialization.IS_FOR_FLOWERS;
    }


    public boolean isForPoisonousFlowers() {
        return isForPoisonousFlowers;
    }

    public void setForPoisonousFlowers(boolean isForPoisonousFlowers) {
        this.isForPoisonousFlowers = isForPoisonousFlowers;
    }


    @Override
    public String toString() {
	return "FlowerTools [isForPoisonousFlowers=" + isForPoisonousFlowers + ", dangerLevel=" + dangerLevel
		+ ", toolSpecialization=" + toolSpecialization + ", getNameString()=" + getNameString()
		+ ", isElectric()=" + isElectric() + ", getCostInUaPerOne()=" + getCostInUaPerOne()
		+ ", getWeightInKg()=" + getWeightInKg() + ", getDangerLevel()=" + getDangerLevel()
		+ ", getToolSpecialization()=" + getToolSpecialization() + ", toString()=" + super.toString()
		+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
    }
}