package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GardenToolsTest {
    private GardenTools gardenTool;
    private  FlowerTools flowerTool;

    @BeforeEach
    public void setUp(){
        flowerTool = new FlowerTools("Tool", true, 5f, 4f, DangerLevel.LOW, true);
        gardenTool = (GardenTools) flowerTool;
    }
    
    @Test
    public void testConstrucor(){
        gardenTool.setNameString("Tool");
        assertEquals("Tool", gardenTool.getNameString());
        gardenTool.setElectric(true);
        assertTrue(gardenTool.isElectric());
        gardenTool.setCostInUaPerOne(4f);
        assertEquals(4f, gardenTool.getCostInUaPerOne());
        gardenTool.setWeightInKg(3f);
        assertEquals(3f, gardenTool.getWeightInKg());
        gardenTool.setDangerLevel(DangerLevel.LOW);
        assertEquals(DangerLevel.LOW, gardenTool.getDangerLevel());
        gardenTool.setToolSpecialization(ToolSpecialization.IS_FOR_TREES);
        assertEquals(ToolSpecialization.IS_FOR_TREES, gardenTool.getToolSpecialization());

    }
    @Test
    void testToString() {
        String toString = gardenTool.toString();
        assertTrue(toString.contains(", getNameString()=" + gardenTool.getNameString()));
    }
}