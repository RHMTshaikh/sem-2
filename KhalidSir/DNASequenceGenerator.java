package KhalidSir;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class DNASequenceGenerator {
    public static void main(String[] args) throws Exception {
        int k = 4; 
        String userDNA_file = "C:\\Users\\rahmat shaikh\\CSVFiles\\userDNA.txt";
        String outputKmer_file = "C:\\Users\\rahmat shaikh\\CSVFiles\\DNA.csv";
        Scanner userFileScanner = new Scanner(new File(userDNA_file));

        String userDNA = (userFileScanner.next());
        List<String> userKmersList = userKmers(userDNA, k);

        LinkedHashMap<String,Integer> permutationsMap = generateAllPermutations(k,'a');

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputKmer_file))) {
            writer.write("");
            System.out.println("Cleared the previous data of CSV file.");
        } catch (IOException e) {
            System.out.println("Error clearing contents of the CSV file: " + e.getMessage());
        }
        for (String kmer : userKmersList) {
            if(permutationsMap.containsKey(kmer)){
                permutationsMap.put(kmer, permutationsMap.get(kmer)+1);
            }
        }
        writeLinkedHashMapToCSV(permutationsMap, outputKmer_file);
        
        System.out.println("done adding");
        userFileScanner.close();
    }

    public static LinkedHashMap<String,Integer> generateAllPermutations(int k,char a) {
        LinkedHashMap<String,Integer> permutationsMap = new LinkedHashMap<>();
        generatePermutations("",k, permutationsMap,a);
        return permutationsMap;
    }

    private static void generatePermutations(String current, int k,LinkedHashMap<String,Integer> permutationsMap, char a) {
        if (k == 0) {
            permutationsMap.put(current, 0);
            return;
        }
        for (char base : "ATGC".toCharArray()) {
            generatePermutations(current + base, k - 1, permutationsMap,a);
        }
    }

    public static List<String> userKmers(String dnaSequence, int k) {
        List<String> kmers = new ArrayList<>();
        if (k <= 0 || k > dnaSequence.length()) {
            System.out.println("Invalid value of k");
            return kmers;
        }
        for (int i = 0; i <= dnaSequence.length() - k; i++) {
            String kmer = dnaSequence.substring(i, i + k);
            kmers.add(kmer);
        }
        return kmers;
    }
    
    private static void writeLinkedHashMapToCSV(Map<String, Integer> linkedHashMap, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("");
            for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

