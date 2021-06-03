package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TestText {

    @Test
    void verifyOutput() throws Exception {
        assertThat(expectedLines()).containsExactlyElementsOf(actualLines());
    }

    private List<String> expectedLines() throws IOException {
        return Files.readAllLines(Path.of(TextTestFixture.FILENAME));
    }

    private List<String> actualLines() throws IOException {
        var tempFile = File.createTempFile("gildedrose-", ".txt");
        tempFile.deleteOnExit();
        try (var writer = new PrintWriter(new FileWriter(tempFile))) {
            TextTestFixture.printFixture(writer);
        }
        return Files.readAllLines(tempFile.toPath());
    }

}
