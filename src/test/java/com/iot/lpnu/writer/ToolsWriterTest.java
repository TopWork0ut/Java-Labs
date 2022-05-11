package com.iot.lpnu.writer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iot.lpnu.enums.DangerLevel;
import com.iot.lpnu.manager.InstrumentShop;
import com.iot.lpnu.tools.BushTools;
import com.iot.lpnu.tools.FlowerTools;
import com.iot.lpnu.tools.TreeTools;


class ToolsWriterTest extends ToolsWriter/* extends SortingManagerTest */ {
    private BushTools bushtool1;
    private BushTools bushtool2;
    private BushTools bushtool3;
    private FlowerTools flowerTools1;
    private FlowerTools flowerTools2;
    private FlowerTools flowerTools3;
    private TreeTools treeTools1;
    private TreeTools treeTools2;
    private TreeTools treeTools3;
    private TreeTools treeTools4;

    InstrumentShop instrumentShop;

    @BeforeEach
    public void setUp() {
        bushtool1 = new BushTools("bush1", true, 7.2f, 1f, DangerLevel.LOW, true);
        bushtool2 = new BushTools("bush2", false, 1.2f, 2f, DangerLevel.HIGH, false);
        bushtool3 = new BushTools("bush3", true, 9f, 1f, DangerLevel.MEDIUM, false);
        flowerTools1 = new FlowerTools("flower1", false, 1.7f, 2f, DangerLevel.HIGH, true);
        flowerTools2 = new FlowerTools("flower2", true, 0.2f, 2f, DangerLevel.LOW, true);
        flowerTools3 = new FlowerTools("flower3", false, 5f, 2.5f, DangerLevel.LOW, false);
        treeTools1 = new TreeTools("tree1", true, 8f, 1.4f, DangerLevel.MEDIUM, true);
        treeTools2 = new TreeTools("tree2", true, 9.5f, 1f, DangerLevel.MEDIUM, false);
        treeTools3 = new TreeTools("tree3", false, 15.2f, 6f, DangerLevel.LOW, true);
        treeTools4 = new TreeTools("tree4", true, 2.1f, 9f, DangerLevel.MEDIUM, true);

        instrumentShop = new InstrumentShop();
    }

    @Test
    public void testContentOfWriter() throws FileNotFoundException, IOException {
        instrumentShop = new InstrumentShop();
        instrumentShop.addToolToTheShop(flowerTools1);
        instrumentShop.addToolToTheShop(flowerTools2);
        instrumentShop.addToolToTheShop(flowerTools3);
        instrumentShop.addToolToTheShop(bushtool1);
        instrumentShop.addToolToTheShop(bushtool2);
        instrumentShop.addToolToTheShop(bushtool3);
        instrumentShop.addToolToTheShop(treeTools1);
        instrumentShop.addToolToTheShop(treeTools2);
        instrumentShop.addToolToTheShop(treeTools3);

        ToolsWriter toolsWriter = new ToolsWriter();
        toolsWriter.writeToFile(instrumentShop, "src/test/resourses/result1.csv");

        File expectedFile1 = new File("src/test/resourses/expected1.csv");
        File resultFile1 = new File("src/test/resourses/result1.csv");

        assertTrue(FileUtils.contentEquals(expectedFile1, resultFile1));
    }

    @Test
    public void testContentOfAddningOneLineByWriter() throws IOException {
        ToolsWriter toolsWriter = new ToolsWriter();
        File expectedFile2 = new File("src/test/resourses/expected2.csv");
        File resultFile2 = new File("src/test/resourses/result2.csv");

//		cleaning result2, cause in the next coverage attempt there will be 
//		added tool4 again and assertrue will give an exception
        try (FileWriter fileWriter = new FileWriter(resultFile2)) {
            fileWriter.flush();
        }

//		it should be only one tool info(tool4)
        toolsWriter.addOneToolToFile(treeTools4, "src/test/resourses/result2.csv");

        assertTrue(FileUtils.contentEquals(expectedFile2, resultFile2));
		
        File resultFile1 = new File("src/test/resourses/result1.csv");
//		check if it is also not equal extepcted file1 where is a lot of lines
        assertFalse(FileUtils.contentEquals(expectedFile2, resultFile1));
    }

    @Test
    public void testNullFileContent() throws IOException {
        /* instrumentShop - Is empty now because hadn't added any files there*/
        /*result3.csv should be empty*/
        ToolsWriter toolsWriter = new ToolsWriter();
        toolsWriter.writeToFile(instrumentShop, "src/test/resourses/result3.csv");

        List<String> resultContentOfTheFile = Files.readAllLines(Paths.get("src/test/resourses/result3.csv"));
        List<String> expectedContentOfTheFile = Files.readAllLines(Paths.get("src/test/resourses/expected3.csv"));

        assertEquals(resultContentOfTheFile, expectedContentOfTheFile);

//		and by the second method
        File expectedFile3 = new File("src/test/resourses/expected3.csv");
        File resultFile3 = new File("src/test/resourses/result3.csv");
        assertTrue(FileUtils.contentEquals(expectedFile3, resultFile3));
    }

}

