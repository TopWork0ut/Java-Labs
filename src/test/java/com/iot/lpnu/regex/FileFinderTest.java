package com.iot.lpnu.regex;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

class FileFinderTest {
    private FileFinder fileFinder;

    @Test
    public void testFindingAppropriateFilesFromText() {
        fileFinder = new FileFinder();

        printInputOfDataInScanner(2345,
                "kjk2345.docfjdk f jsk ia m ajfd.docx so jdks. jdks.sjal2345.txt ajsd:8%23оа1Ро2345олва2345.txt");
        assertEquals("[kjk2345.doc, jdks.sjal2345.txt, ajsd:8%23оа1Ро2345олва2345.txt]", String.valueOf(fileFinder.findAndPrintIdentifiedFilesInText()));

        printInputOfDataInScanner(12, "fkjd12.txtjfd fjkds fd");
        assertEquals("[fkjd12.txt]", String.valueOf(fileFinder.findAndPrintIdentifiedFilesInText()));

        printInputOfDataInScanner(-1, "sometext fjdksj.txt @fjdks f^fh*fd.docx");
        assertEquals("[]", String.valueOf(fileFinder.findAndPrintIdentifiedFilesInText()));
    }

    private void printInputOfDataInScanner(Integer lastNumbers, String imaginedInputedTextByConsole) {
        ByteArrayInputStream in = new ByteArrayInputStream((lastNumbers + System.lineSeparator() + imaginedInputedTextByConsole).getBytes());
        System.setIn(in);
    }

}
