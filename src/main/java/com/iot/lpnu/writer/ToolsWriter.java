package com.iot.lpnu.writer;

import java.io.FileWriter;
import java.io.IOException;

import com.iot.lpnu.manager.InstrumentShop;
import com.iot.lpnu.tools.GardenTools;

public class ToolsWriter {
    private String previousClassName = "";

    public void writeToFile(InstrumentShop instrumentShop, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath /* "src/test/resourses/result.csv" */)) {
            for (GardenTools tool : instrumentShop.getListOfTools()) {
                if (!previousClassName.equals(tool.getClass().getSimpleName())) {
                    writer.write(tool.getHeaders());
                    writer.write("\r\n");
                }
                previousClassName = tool.getClass().getSimpleName();
                writer.write(tool.toCSV());
                writer.write("\r\n");
            }
        }
    }

    protected void addOneToolToFile(GardenTools tool, String fileSource) throws IOException {
        try (FileWriter writer = new FileWriter(fileSource/*"src/test/resourses/result.csv"*/, true)) {
            if (!previousClassName.equals(tool.getClass().getSimpleName())) {
                writer.write(tool.getHeaders());
                writer.write("\r\n");
                writer.write(tool.toCSV());

            } else {
                writer.write(tool.toCSV());
                writer.write("\r\n");
            }
        }
    }
}
