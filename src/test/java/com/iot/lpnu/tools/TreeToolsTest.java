package com.iot.lpnu.tools;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.ToolSpecialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeToolsTest {
    private TreeTools treeTool;


    @BeforeEach
    public void setUp(){
        treeTool = new TreeTools("Tool",true,5f,4f, DangerLevel.LOW,true);
    }
    @Test
    public void testConstrucor(){
        assertEquals("Tool",treeTool.getNameString());
        assertTrue(treeTool.isElectric());
        assertEquals(5f,treeTool.getCostInUaPerOne());
        assertEquals(4f,treeTool.getWeightInKg());
        assertEquals(DangerLevel.LOW,treeTool.getDangerLevel());
        assertEquals(ToolSpecialization.IS_FOR_TREES,treeTool.getToolSpecialization());
        treeTool.setProfilacticTool(false);
        assertFalse(treeTool.isProfilacticTool());

    }

    @Test
    void testToString() {
        String toString = treeTool.toString();
        assertTrue(toString.contains(", getNameString()=" + treeTool.getNameString()));
    }
}