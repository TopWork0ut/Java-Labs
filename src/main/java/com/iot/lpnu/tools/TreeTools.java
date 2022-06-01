package com.iot.lpnu.tools;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Caption")
public class TreeTools extends GardenTools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
   
    @Column(name = "isProfilacticTool", nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isProfilacticTool;
    
	public TreeTools() {
	    this("Default",true,4.1f,1f,DangerLevel.LOW,true);
	    
	}
	public TreeTools(String nameString, boolean isElectric, Float costInUaPerOne, Float weightInKg,
			DangerLevel dangerLevel, Boolean isProfilacticTool) {
		super(nameString, isElectric, costInUaPerOne, weightInKg, dangerLevel);
		this.isProfilacticTool = isProfilacticTool;
		super.toolSpecialization = ToolSpecialization.IS_FOR_TREES;
	}
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
	public String getHeaders() {
		return super.getHeaders() + ",isProfilacticTool";
	}

	@Override
	public String toCSV() {
		return super.toCSV() + "," + this.isProfilacticTool;
	}

	public Boolean isProfilacticTool() {
		return isProfilacticTool;
	}

	public void setProfilacticTool(Boolean isProfilacticTool) {
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