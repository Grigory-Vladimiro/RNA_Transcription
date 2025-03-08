package dev.grigory.rna_transcription;

import java.util.Scanner;

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
    public static void main(String[] args) {
        System.out.println("Enter a DNA sequence:");

        try (Scanner scanner = new Scanner(System.in)) { 
            String dna = scanner.nextLine();
            DnaTranscription transcription = new DnaTranscription();

            try {
                String rna = transcription.transcribe(dna);
                System.out.println("Transcribed RNA: " + rna);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
