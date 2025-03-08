package dev.grigory.rna_transcription;

public class DnaTranscription {
    public String transcribe(String dna) {
        StringBuilder rna = new StringBuilder();

        for (char nucleotide : dna.toCharArray()) {
            rna.append(switch (nucleotide) {
                case 'G' -> 'C';
                case 'C' -> 'G';
                case 'T' -> 'A';
                case 'A' -> 'U';
                default -> throw new IllegalArgumentException("Invalid DNA nucleotide: " + nucleotide);
            });
        }

        return rna.toString();
    }
}
