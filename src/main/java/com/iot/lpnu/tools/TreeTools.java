package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;

public class TreeTools extends GardenTools{
    public boolean isProfilacticTool;
    
  
    public TreeTools(String nameString, boolean isElectric, Float costInUaPerOne, Float weightInKg,
	    DangerLevel dangerLevel, boolean isProfilacticTool) {
    	super(nameString, isElectric, costInUaPerOne, weightInKg, dangerLevel);
    	this.isProfilacticTool = isProfilacticTool;
    	super.toolSpecialization = ToolSpecialization.IS_FOR_TREES;
    }
    

    public boolean isProfilacticTool() {
        return isProfilacticTool;
    }

    public void setProfilacticTool(boolean isProfilacticTool) {
        this.isProfilacticTool = isProfilacticTool;
    }


    @Override
    public String toString() {
	return "TreeTools [isProfilacticTool=" + isProfilacticTool + ", dangerLevel=" + dangerLevel
		+ ", toolSpecialization=" + toolSpecialization + ", isProfilacticTool()=" + isProfilacticTool()
		+ ", getNameString()=" + getNameString() + ", isElectric()=" + isElectric() + ", getCostInUaPerOne()="
		+ getCostInUaPerOne() + ", getWeightInKg()=" + getWeightInKg() + ", getDangerLevel()="
		+ getDangerLevel() + ", getToolSpecialization()=" + getToolSpecialization() + ", toString()="
		+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
    }
}