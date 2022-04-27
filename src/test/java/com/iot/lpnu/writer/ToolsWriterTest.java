package com.iot.lpnu.writer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
//	private BushTools bushtool4;
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
//		bushtool4 = new BushTools("bush3", true, 9f, 1f, DangerLevel.MEDIUM, false);
		flowerTools1 = new FlowerTools("flower1", false, 1.7f, 2f, DangerLevel.HIGH, true);
		flowerTools2 = new FlowerTools("flower2", true, 0.2f, 2f, DangerLevel.LOW, true);
		flowerTools3 = new FlowerTools("flower3", false, 5f, 2.5f, DangerLevel.LOW, false);
		treeTools1 = new TreeTools("tree1", true, 8f, 1.4f, DangerLevel.MEDIUM, true);
		treeTools2 = new TreeTools("tree2", true, 9.5f, 1f, DangerLevel.MEDIUM, false);
		treeTools3 = new TreeTools("tree3", false, 15.2f, 6f, DangerLevel.LOW, true);

		treeTools4 = new TreeTools("tree4", true, 2.1f, 9f, DangerLevel.MEDIUM, true);

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
	}

	@Test
	public void TestContentOfWriter() throws FileNotFoundException, IOException {
		ToolsWriter toolsWriter = new ToolsWriter();
		toolsWriter.writeToFile(instrumentShop);

		File expectedFile1 = new File("expectedFiles/expected.csv");
		File expectedFile2 = new File("expectedFiles/expected2.csv");
		File resultFile = new File("result.csv");

		assertTrue(FileUtils.contentEquals(expectedFile1, resultFile));

		toolsWriter.addOneToolToFile(treeTools4);
		assertFalse(FileUtils.contentEquals(expectedFile1, resultFile));

		assertTrue(FileUtils.contentEquals(expectedFile2, resultFile));
	}

//	@Test
//	public void addingToolInfoToTheFile() throws IOException {
//		ToolsWriter toolsWriter = new ToolsWriter();
//		toolsWriter.writeToFile(instrumentShop);
//		
//		toolsWriter.addOneToolToFile(bushtool4);
//		toolsWriter.addOneToolToFile(treeTools4);
//	}
}

//		try(
//	    	FileReader actualFileReader = new FileReader("result.csv");
//			Scanner scannerOfActualFile = new Scanner(actualFileReader);
//				
//			FileReader expectedFileReader = new FileReader("expected.csv");
//			Scanner scannerOfExpectedFile = new Scanner(expectedFileReader);){
//			
//			String actualContentOfFileReaderString = "";
//			String expectedContentOfFileReaderString = "";
//			while (scannerOfActualFile.hasNextLine() && scannerOfExpectedFile.hasNextLine()) {
//
//				actualContentOfFileReaderString += scannerOfActualFile.nextLine();
//				expectedContentOfFileReaderString += scannerOfExpectedFile.nextLine();
//			
//			}
//			System.out.println(actualContentOfFileReaderString);
//			System.out.println(expectedContentOfFileReaderString);
//			assertEquals(actualContentOfFileReaderString, expectedContentOfFileReaderString);

//			try (FileWriter writer = new FileWriter("result.csv",true)) {		
//				writer.write(treeTool4.toCSV());
//				actualContentOfFileReaderString += scannerOfActualFile.nextLine();
//				writer.close();
//			}
//			
//			
//			System.out.println(actualContentOfFileReaderString);
//			System.out.println(expectedContentOfFileReaderString);
////			assertEquals(actualContentOfFileReaderString, expectedContentOfFileReaderString);
//			assertTrue("The files differ!", FileUtils.contentEquals("expected.csv", "result.csv"));

//			scannerOfActualFile.close();
//			actualFileReader.close();
//			
//			scannerOfExpectedFile.close();
//			expectedFileReader.close();

//		}
//		
//	}
//	@Test
//	public void testOfWritingToTheFile() throws IOException {
//		ToolsWriter toolsWriter = new ToolsWriter();
//		toolsWriter.writeToFile(null);
//	}
//}
