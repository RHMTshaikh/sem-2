package KhalidSir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CSVFileToSetOperations {
    public static void main(String[] args) {
        String csvFileRead = "C:\\Users\\rahmat shaikh\\CSVFiles\\Set1.csv"; // Replace with the actual path to your CSV file
        String csvFileWrite = "C:\\Users\\rahmat shaikh\\CSVFiles\\Set2.csv"; // Replace with the actual path to your CSV file

        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        Set<String> setC = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFileRead));
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileWrite, false))) 
            {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    setA.add(values[0].trim());
                    setB.add(values[1].trim());
                    setC.add(values[2].trim());
                }
            }

            System.out.println("Set A: " + setA);
            System.out.println("Set B: " + setB);
            System.out.println("Set C: " + setC);

            // AUBUC
            Set<String> unionResult = new HashSet<>(setA);
            unionResult.addAll(setB);
            unionResult.addAll(setC);

            // A∩B∩C
            Set<String> intersectionResult = new HashSet<>(setA);
            intersectionResult.retainAll(setB);
            intersectionResult.retainAll(setC);

            // (A ∩ B) U (A ∩ C) U (B ∩C)
            // Calculate A ∩ B
            Set<String> AB = new HashSet<>(setA);
            AB.retainAll(setB);
            // Calculate A ∩ C
            Set<String> AC = new HashSet<>(setA);
            AC.retainAll(setC);
            // Calculate B ∩ C
            Set<String> BC = new HashSet<>(setB);
            BC.retainAll(setC);
            // Calculate (A ∩ B) U (A ∩ C) U (B ∩ C)
            Set<String> result = new HashSet<>();
            result.addAll(AB);
            result.addAll(AC);
            result.addAll(BC);

            System.out.println("AUBUC: " + unionResult);
            System.out.println("A∩B∩C: " + intersectionResult);
            System.out.println("(A ∩ B) U (A ∩ C) U (B ∩ C): " + result);

            writer.write("unionResult");
            for (String element : unionResult) {
                writer.write(element + "\n");
            }
            writer.write("\nintersectionResult\n");
            for (String element : intersectionResult) {
                writer.write(element + "\n");
            }
            writer.write("\nresult\n");
            for (String element : result) {
                writer.write(element + "\n");
            }
            // writer.newLine();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
