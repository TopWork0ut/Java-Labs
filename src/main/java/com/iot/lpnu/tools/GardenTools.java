package com.iot.lpnu.tools;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class GardenTools {
	private String nameString;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isElectric;
	private Float costInUaPerOne;
	private Float weightInKg;

    @Enumerated(EnumType.STRING)
	protected DangerLevel dangerLevel;
    
//    @Column(columnDefinition = "toolSpecialization('IS_FOR_BUSHES', 'IS_FOR_FLOWERS', ' IS_FOR_TREES')")
//    @Enumerated(EnumType.ORDINAL)
    @Transient
	protected ToolSpecialization toolSpecialization;


	public GardenTools(String nameString, Boolean isElectric, Float costInUaPerOne, Float weightInKg,
			DangerLevel dangerLevel) {
		super();
		this.nameString = nameString;
		this.isElectric = isElectric;
		this.costInUaPerOne = costInUaPerOne;
		this.weightInKg = weightInKg;
		this.dangerLevel = dangerLevel;

	}

	@JsonIgnore
	public String getHeaders() {
		return "nameString,isElectric,costInUaPerOne,weightInKg,dangerLevel";
	}

	public String toCSV() {
		return String.format("%s,%b,%f,%f,%s", this.nameString, this.isElectric, this.costInUaPerOne, this.weightInKg,
				this.dangerLevel);
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public Boolean isElectric() {
		return isElectric;
	}

	public void setElectric(Boolean isElectric) {
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
	
	@JsonIgnore
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
