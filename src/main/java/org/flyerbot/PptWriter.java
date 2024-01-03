package org.flyerbot;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PptWriter {
    public static void createPresentation() {
        FileCopyWithDate.copyPPT();
        String filePath = "C:\\Users\\bhaye\\OneDrive\\Documents\\Flyer\\Daily Flyers\\" + FileCopyWithDate.getFileNameWithDate("Template.pptx");
        int slideNumber = 1;
//
//        try (FileInputStream fileIn = new FileInputStream(filePath);
//             XMLSlideShow ppt = new XMLSlideShow(fileIn);
//             FileOutputStream fileOut = new FileOutputStream("updatedPresentation.pptx")) {
//
//            // Get the existing slide
//            XSLFSlide existingSlide = ppt.getSlides().get(slideNumber - 1);
//
//            // Create a text box and set its content
//            XSLFTextBox contentTextBox = existingSlide.createTextBox();
//            contentTextBox.setAnchor(new java.awt.Rectangle(150, 150, 500, 200));
//            contentTextBox.setText("This is the updated content of the existing slide.");
//
//            // Save the updated presentation to a new file
//            ppt.write(fileOut);
//            System.out.println("Presentation updated successfully: updatedPresentation.pptx");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}