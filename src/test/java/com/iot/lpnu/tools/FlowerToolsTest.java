package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerToolsTest {
    private FlowerTools flowerTool;

    @BeforeEach
    public void setUp(){
    	flowerTool = new FlowerTools("Tool", true, 5f, 4f, DangerLevel.LOW, true);
    }
    @Test
    public void testConstrucor(){
        assertEquals("Tool", flowerTool.getNameString());
        assertTrue(flowerTool.isElectric());
        assertEquals(5f, flowerTool.getCostInUaPerOne());
        assertEquals(4f, flowerTool.getWeightInKg());
        assertEquals(DangerLevel.LOW, flowerTool.getDangerLevel());
        assertEquals(ToolSpecialization.IS_FOR_FLOWERS, flowerTool.getToolSpecialization());
        flowerTool.setForPoisonousFlowers(false);
        assertFalse(flowerTool.isForPoisonousFlowers());
    }

    @Test
    void testToString() {
        String toString = flowerTool.toString();
        assertTrue(toString.contains(", getNameString()=" + flowerTool.getNameString()));
    }
}