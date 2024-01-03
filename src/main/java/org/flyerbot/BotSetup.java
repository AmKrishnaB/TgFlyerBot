package org.flyerbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;


public class BotSetup extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        if(update.getMessage().getText().equalsIgnoreCase("/start")){
            sendMessage(update, "Welcome to Downtime Flyer Bot");
            sendMessage(update, "Please use /Downtime with downtime in <FromTime - ToTime>_<OnDate> format");
        }
        if(update.getMessage().getText().toUpperCase().contains("/DOWNTIME")){
            sendMessage(update, "Please wait untill we build your Flyer");
            PptWriter.createPresentation();
            File fileIn = new File("C:\\Users\\bhaye\\OneDrive\\Documents\\Flyer\\Daily Flyers\\"+ FileCopyWithDate.getFileNameWithDate("Template.pptx"));
            SendDocument doc= new SendDocument();
            doc.setChatId(update.getMessage().getChatId().toString());
            doc.setDocument(new InputFile(fileIn));
            try {
                execute(doc);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }


    public void sendMessage(Update update, String text){
        SendMessage msg = new SendMessage(update.getMessage().getChatId().toString(), text);
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "Downtime_Flyer_Bot";
    }

    @Override
    public String getBotToken() {
        return "6716502696:AAEky_p4LCkK0D08oqZ7x8ZeaDvGKrRSAqI";
    }
}
