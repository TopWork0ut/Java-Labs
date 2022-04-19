package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BushToolsTest {
    private BushTools bushTool;


    @BeforeEach
    public void setUp() {
        bushTool = new BushTools("Tool", true, 5f, 4f, DangerLevel.LOW, true);

    }

    @Test
    public void testConstrucor() {
        assertEquals("Tool", bushTool.getNameString());
        assertTrue(bushTool.isElectric());
        assertEquals(5f, bushTool.getCostInUaPerOne());
        assertEquals(4f, bushTool.getWeightInKg());
        assertEquals(DangerLevel.LOW, bushTool.getDangerLevel());
        assertEquals(ToolSpecialization.IS_FOR_BUSHES, bushTool.getToolSpecialization());
        bushTool.setForBushesWithThornes(false);
        assertFalse(bushTool.isForBushesWithThornes());

    }

    @Test
    void testToString() {
        String toString = bushTool.toString();
        assertTrue(toString.contains(", getNameString()=" + bushTool.getNameString()));
    }


}