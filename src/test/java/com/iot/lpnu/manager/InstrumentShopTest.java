package com.iot.lpnu.manager;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.OrderOfSOrting;
import com.iot.lpnu.enums.ToolSpecialization;
import com.iot.lpnu.tools.BushTools;
import com.iot.lpnu.tools.TreeTools;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstrumentShopTest extends SortingManagerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {

        bushtool1 = new BushTools("bush1", true, 7.2f, 1f, DangerLevel.LOW, true);
        bushtool2 = new BushTools("bush2", true, 7.4f, 2f, DangerLevel.MEDIUM, false);
        treetool1 = new TreeTools("tree1", false, 2.1f, 2.2f, DangerLevel.LOW, true);
        treetool2 = new TreeTools("tree2", true, 8f, 4f, DangerLevel.LOW, false);
        treetool3 = new TreeTools("tree3", true, 5f, 9f, DangerLevel.MEDIUM, true);

        instrumentShop = new InstrumentShop();
        sortingManager = new SortingManager();
        listOfTools = new ArrayList<>();
        instrumentShop.addToolToTheShop(bushtool1);

        listOfTools.add(treetool1);
        listOfTools.add(treetool2);
        listOfTools.add(treetool3);
        System.setOut(new PrintStream(outputStreamCaptor));

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testCalculatePriceForTool() {
        assertEquals(14.4f, instrumentShop.calculatePriceForTool(bushtool1, 2));
        assertEquals(21.6f, instrumentShop.calculatePriceForTool(bushtool1, 3), 0.1);
        assertEquals(0, instrumentShop.calculatePriceForTool(bushtool1, -1));
        assertEquals(0, instrumentShop.calculatePriceForTool(bushtool1, 0));
    }

    @Test
    public void testAddingOfInstrumentsToTheShop() {

        assertEquals(2, instrumentShop.addToolToTheShop(bushtool2).size());
    }

    @Test
    public void testSellingTheInstruments() {

        assertEquals(0, instrumentShop.sellInstruments(ToolSpecialization.IS_FOR_BUSHES, 1).size());
        assertEquals(0, instrumentShop.sellInstruments(ToolSpecialization.IS_FOR_BUSHES, -1).size());
        instrumentShop.addToolToTheShop(bushtool1);
        instrumentShop.addToolToTheShop(bushtool2);
        assertEquals(0, instrumentShop.sellInstruments(ToolSpecialization.IS_FOR_BUSHES, 3).size());

    }

    @Test
    public void testRemovingTheInstruments() {


        instrumentShop.removeToolFromShop(ToolSpecialization.IS_FOR_BUSHES, 0);
        assertEquals("We haven't deleted any of the tools", outputStreamCaptor.toString().trim());

        assertEquals(1, instrumentShop.removeToolFromShop(ToolSpecialization.IS_FOR_BUSHES, 0).size());
        assertEquals(0, instrumentShop.removeToolFromShop(ToolSpecialization.IS_FOR_BUSHES, 1).size());

        instrumentShop.addToolToTheShop(bushtool1);
        assertEquals(1, instrumentShop.removeToolFromShop(ToolSpecialization.IS_FOR_BUSHES, 2).size());

        instrumentShop.addToolToTheShop(bushtool2);

        assertEquals(1, instrumentShop.removeToolFromShop(ToolSpecialization.IS_FOR_BUSHES, 1).size());
        assertEquals(1, instrumentShop.removeToolFromShop(ToolSpecialization.IS_FOR_BUSHES, -10).size());

    }

    @Test
    public void testGettingProfilacticToolsForTrees() {
        instrumentShop.addToolToTheShop(treetool1);
        instrumentShop.addToolToTheShop(treetool2);

        assertEquals(1, instrumentShop.getListOfToolsForProfilacticWorksWithTrees(OrderOfSOrting.DESCENDING).size());
        instrumentShop.addToolToTheShop(treetool3);
        assertEquals(2, instrumentShop.getListOfToolsForProfilacticWorksWithTrees(OrderOfSOrting.DESCENDING).size());

    }
}
