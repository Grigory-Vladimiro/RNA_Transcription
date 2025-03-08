package dev.grigory.rna_transcription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DnaTranscriptionTest {
private DnaTranscription dnaTranscription;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        dnaTranscription = new DnaTranscription();
    }
    @Test
    void testTranscription() {
        assertEquals("C", dnaTranscription.transcribe("G"));
        assertEquals("G", dnaTranscription.transcribe("C"));
        assertEquals("A", dnaTranscription.transcribe("T"));
        assertEquals("U", dnaTranscription.transcribe("A"));
    }
    @Test
    void testMultipleNucleotides() {
        assertEquals("UGCACCAGAAUU", dnaTranscription.transcribe("ACGTGGTCTTAA"));
    }
    @Test
    void testEmptyString() {
        assertEquals("", dnaTranscription.transcribe(""));
    }
    @Test
    void testInvalidCharacter() {
        assertThrows(IllegalArgumentException.class, () -> dnaTranscription.transcribe("B"));
    }
    @Test
    void testMainValidInput() {
        provideInput("ACGT\n");

        DnaTranscription.main(new String[]{});

        String output = getOutput();
        assertTrue(output.contains("Transcribed RNA: UGCA"), "Expected output not found!");
    }

    @Test
    void testMainInvalidInput() {
        provideInput("X\n");

        DnaTranscription.main(new String[]{});

        String output = getOutput();
        assertTrue(output.contains("Error: Invalid DNA nucleotide: X"), "Expected error message not found!");
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private String getOutput() {
        System.out.flush();
        return outputStream.toString().trim(); 
    }
}
