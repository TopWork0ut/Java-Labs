package com.iot.lpnu.manager;

import static org.junit.jupiter.api.Assertions.*;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.enums.OrderOfSOrting;
import com.iot.lpnu.tools.BushTools;
import com.iot.lpnu.tools.GardenTools;
import com.iot.lpnu.tools.TreeTools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SortingManagerTest {
    protected List<GardenTools> listOfTools;
    protected BushTools bushtool1;
    protected BushTools bushtool2;
    protected TreeTools treetool1;
    protected TreeTools treetool2;
    protected TreeTools treetool3;

    protected SortingManager sortingManager;
    @BeforeEach
    public void setUp(){
        bushtool1 = new BushTools("bush1", true, 7.2f, 1f, DangerLevel.LOW, true);
        bushtool2 = new BushTools("bush2", true, 7.4f, 2f, DangerLevel.MEDIUM, false);
        treetool1 = new TreeTools("tree1", false, 2.1f, 2.2f, DangerLevel.LOW, true);
        treetool2 = new TreeTools("tree2", true, 8f, 4f, DangerLevel.LOW, false);
        treetool3 = new TreeTools("tree3", true, 5f, 9f, DangerLevel.MEDIUM, true);
        listOfTools = new ArrayList<>();
        listOfTools.add(treetool1);
        listOfTools.add(treetool2);
        listOfTools.add(treetool3);

        sortingManager = new SortingManager();
    }

    @Test
    public void testToolsToBeSortedByPrice(){
        assertEquals(treetool2, sortingManager.getToolsSortedByPrice(listOfTools, OrderOfSOrting.DESCENDING).get(0));
        assertEquals(treetool3, sortingManager.getToolsSortedByPrice(listOfTools, OrderOfSOrting.DESCENDING).get(1));
        assertEquals(treetool1, sortingManager.getToolsSortedByPrice(listOfTools, OrderOfSOrting.DESCENDING).get(2));

        assertEquals(treetool1, sortingManager.getToolsSortedByPrice(listOfTools, OrderOfSOrting.ASCENDING).get(0));
        assertEquals(treetool3, sortingManager.getToolsSortedByPrice(listOfTools, OrderOfSOrting.ASCENDING).get(1));
        assertEquals(treetool2, sortingManager.getToolsSortedByPrice(listOfTools, OrderOfSOrting.ASCENDING).get(2));
    }

    @Test
    public void testToolsToBeSortedByWeight(){
        assertEquals(treetool3, sortingManager.getToolsSortedByWeight(listOfTools, OrderOfSOrting.DESCENDING).get(0));
        assertEquals(treetool2, sortingManager.getToolsSortedByWeight(listOfTools, OrderOfSOrting.DESCENDING).get(1));
        assertEquals(treetool1, sortingManager.getToolsSortedByWeight(listOfTools, OrderOfSOrting.DESCENDING).get(2));

        assertEquals(treetool1, sortingManager.getToolsSortedByWeight(listOfTools, OrderOfSOrting.ASCENDING).get(0));
        assertEquals(treetool2, sortingManager.getToolsSortedByWeight(listOfTools, OrderOfSOrting.ASCENDING).get(1));
        assertEquals(treetool3, sortingManager.getToolsSortedByWeight(listOfTools, OrderOfSOrting.ASCENDING).get(2));
    }

}
