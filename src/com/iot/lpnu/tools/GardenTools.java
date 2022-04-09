package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;

public abstract class GardenTools {
	private String nameString;
	private boolean isElectric;
	private Float costInUaPerOne;
	private Float weightInKg;
	protected DangerLevel dangerLevel;
	protected ToolSpecialization toolSpecialization;

	public GardenTools(String nameString, boolean isElectric, Float costInUaPerOne, Float weightInKg,
			DangerLevel dangerLevel) {
		super();
		this.nameString = nameString;
		this.isElectric = isElectric;
		this.costInUaPerOne = costInUaPerOne;
		this.weightInKg = weightInKg;
		this.dangerLevel = dangerLevel;

	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public boolean isElectric() {
		return isElectric;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}

	public Float getCostInUaPerOne() {
		return costInUaPerOne;
	}

	public void setCostInUaPerOne(Float costInUaPerOne) {
		this.costInUaPerOne = costInUaPerOne;
	}

	public Float getWeightInKg() {
		return weightInKg;
	}

	public void setWeightInKg(Float weightInKg) {
		this.weightInKg = weightInKg;
	}

	public DangerLevel getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(DangerLevel dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	public ToolSpecialization getToolSpecialization() {
		return toolSpecialization;
	}

	public void setToolSpecialization(ToolSpecialization toolSpecialization) {
		this.toolSpecialization = toolSpecialization;
	}

	@Override
	public String toString() {
		return "GardenTools [nameString=" + nameString + ", isElectric=" + isElectric + ", costInUaPerOne="
				+ costInUaPerOne + ", weightInKg=" + weightInKg + ", dangerLevel=" + dangerLevel
				+ ", toolSpecialization=" + toolSpecialization + "]";
	}
}
