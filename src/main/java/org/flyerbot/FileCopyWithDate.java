package org.flyerbot;

import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileCopyWithDate {

    public static void copyPPT() {
        String baseDirectory = System.getProperty("user.dir");
        String sourceFolderPath = baseDirectory+"\\Flyer\\Template";
        String destinationFolderPath = baseDirectory+"\\Flyer\\Daily Flyers";
        String fileName = "Template.pptx"; // Replace with the actual file name

        copyFileWithDate(sourceFolderPath, destinationFolderPath, fileName);
    }

    public static void copyFileWithDate(String sourceFolderPath, String destinationFolderPath, String fileName) {
        Path sourcePath = Paths.get(sourceFolderPath, fileName);
        Path destinationPath = Paths.get(destinationFolderPath, getFileNameWithDate());

        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully to: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileNameWithDate() {
        // Append current date to the file name
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmm");
        String currentDate = dateFormat.format(new Date());
        return "Flyer_" + currentDate + ".pptx";
    }
}

