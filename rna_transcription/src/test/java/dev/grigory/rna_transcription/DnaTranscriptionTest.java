package dev.grigory.rna_transcription;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DnaTranscriptionTest {
private DnaTranscription dnaTranscription;

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
}
