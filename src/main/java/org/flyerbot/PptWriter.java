package org.flyerbot;

import org.apache.poi.xslf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PptWriter {
    public static void createPresentation(String userMsg) throws IOException {
        try {
            FileCopyWithDate.copyPPT();
            String baseDirectory = System.getProperty("user.dir");
            String filePath = baseDirectory+"\\Flyer\\Daily Flyers\\"+ FileCopyWithDate.getFileNameWithDate();

            // Load the PowerPoint file
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Flyer\\Template\\Template.pptx");
            XMLSlideShow ppt = new XMLSlideShow(fis);
            fis.close();
            // Get the first slide
            XSLFSlide slide = ppt.getSlides().getFirst();
            XSLFTextRun application = slide.getPlaceholder(0).addNewTextParagraph().addNewTextRun();
            application.setText(MessageBroker.application(userMsg)[0]);
            XSLFTextRun date = slide.getPlaceholder(1).addNewTextParagraph().addNewTextRun();
            date.setText(MessageBroker.application(userMsg)[1]);
            XSLFTextRun time = slide.getPlaceholder(2).addNewTextParagraph().addNewTextRun();
            time.setText(MessageBroker.application(userMsg)[2]);
            FileOutputStream fos = new FileOutputStream(baseDirectory+"\\Flyer\\Daily Flyers\\"+FileCopyWithDate.getFileNameWithDate());
            ppt.write(fos);
            fos.close();
            ppt.close();

            System.out.println("PowerPoint file edited successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}