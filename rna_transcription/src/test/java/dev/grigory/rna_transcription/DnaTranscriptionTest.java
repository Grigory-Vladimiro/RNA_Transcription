package dev.grigory.rna_transcription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        void testMainRuns() {
        System.setIn(new ByteArrayInputStream("ACGT\n".getBytes())); 
        System.setOut(new PrintStream(outputStream, true)); 

    DnaTranscription.main(new String[]{});

    System.out.flush(); 
    String output = outputStream.toString().trim(); 

    assertFalse(output.isEmpty(), "Main() produced no output!");
}
}
