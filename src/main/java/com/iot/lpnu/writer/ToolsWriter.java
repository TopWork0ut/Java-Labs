package com.iot.lpnu.writer;

import java.io.FileWriter;
import java.io.IOException;

import com.iot.lpnu.manager.InstrumentShop;
import com.iot.lpnu.tools.GardenTools;

public class ToolsWriter {
	private String previousClassName = "";

	public void writeToFile(InstrumentShop instrumentShop) throws IOException {
		try (FileWriter writer = new FileWriter("result.csv")) {
			for (GardenTools tool : instrumentShop.getListOfTools()) {
				if (!previousClassName.equals(tool.getClass().getSimpleName())) {
					writer.write(tool.getHeaders());
					writer.write("\r\n");
				}
				previousClassName = tool.getClass().getSimpleName();
				writer.write(tool.toCSV());
				writer.write("\r\n");
			}
			writer.close();
		}

	}

	protected void addOneToolToFile(GardenTools tool) throws IOException {
		try (FileWriter writer = new FileWriter("result.csv", true)) {
			if (previousClassName != tool.getClass().getSimpleName()) {
				writer.write(tool.getHeaders());
				writer.write("\r\n");
				writer.write(tool.toCSV());

			} else {
				writer.write(tool.toCSV());
				writer.write("\r\n");
			}
			writer.close();
		}
	}
}
