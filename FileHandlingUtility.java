import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility{

    // Method to write content to a file
    public static void writeFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName,true)) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to append content to an existing file
    public static void modifyFile(String fileName, String newContent) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("\n" + newContent);
            System.out.println("File modified (appended) successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying the file: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = "sample.txt";

        // Writing to the file
        System.out.println("Enter text to write to the file:");
        String content = scanner.nextLine();
        writeFile(fileName, content);

        // Reading the file
        readFile(fileName);

        // Modifying the file
        System.out.println("\nEnter text to append to the file:");
        String newContent = scanner.nextLine();
        modifyFile(fileName, newContent);

        // Reading the updated file
        readFile(fileName);

        scanner.close();
    }



}

