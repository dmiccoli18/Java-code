package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.File;
import java.lang.String;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Vector;


public class Bot extends TelegramLongPollingBot {

    Birthday birth = new Birthday();
    @Override
    public String getBotToken() {
        String token = " ";
        try {
            File tokenFile = new File("<bot token>");
            Scanner sc = new Scanner(tokenFile);
            token = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public String getBotUsername() {
        return "TestBot";
    }


    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();

        var newMsg = msg.getText();

        if (newMsg.toLowerCase().contains("ball")){
            String ball = "BALL?";
            sendText(id, ball);
        }
        else {
            if (msg.isCommand()){
                if(msg.getText().contains("/addword")) {
                    addWords(newMsg, id);
                }
                if(msg.getText().contains("/addbirth")) {
                    String bday = birth.addBirth(newMsg);
                    sendText(id,bday);
                }
                if(msg.getText().contains("/removebirth")) {
                    String bday = birth.removeBirth(newMsg);

                    sendText(id,bday);
                }
                if(msg.getText().contains("/listbirth")) {
                    String bday = birth.listBirth();
                    sendText(id,bday);
                }
                if(msg.getText().contains("/sendstick")) {
                    String stickerid = stickerParser(msg.getText());
                    StickerBot.getRequest(id,getBotToken(),stickerid);
                }
                if(msg.getText().contains("/stick")) {
                    int stickerint = stickerIndex(msg.getText());
                    String stickerid = StickerBot.sendSticker(stickerint);
                    if (stickerid != null){
                        StickerBot.getRequest(id,getBotToken(),stickerid);
                    }
                    else {
                        sendText(id, "awwrrrf, no sticker available");
                    }
                }
                if(msg.getText().contains("/fact")) {
                    String fact = Wolf.wolfFact();
                    sendText(id, fact);
                }
                if(msg.getText().contains("/weather")) {
                    String city = weatherParser(msg.getText());
                    String weather = Weather.weatherRequest(city);
                    sendText(id, weather);
                }
                if(msg.getText().contains("/wuffweather")) {
                    getWeather(id);
                    StickerBot.getRequest(id,getBotToken(),
                            "CAACAgEAAxkBAAEyBWpnulWXqtDeyXwcF-KXt3vMWJlsOwACbwQAAr-1iESCskqCAAGsrHo2BA");
                }
                if(msg.getText().contains("/commands")) {
                    String comms = Commands.comPrompt();
                    sendText(id, comms);
                }
            }
            replaceString(msg,id);
        }

        //sendText(id, newMsg);
        System.out.println(user.getFirstName() + " wrote: " + msg.getText());
    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }


    Vector<String> words = new Vector<>(1,1);
    Vector<String> newWords = new Vector<>(1,1);

    public void addWords(String subMsg,Long id){
        String subSubMsg = subMsg.replace("/addword ","");
        String[] subwords = subSubMsg.split("\\s+");
        String word = subwords[0];
        String newWord = subwords[1];
        words.add(word);
        newWords.add(newWord);
        String superMsg = "Awruff! New word swapped: " + word;
        sendText(id, superMsg);
    }

    //weather
    public void getWeather(Long id){
        //placeholder code until the weather API gets set up
        String report = "the forecast is looking ruff today!";
        sendText(id, report);
    }
    public void replaceString(Message msg,Long id){
        String sentence = msg.getText().toLowerCase();
        String mess = sentence;

        //
        words.add("fuck");
        words.add("shit");
        words.add("asshole");
        words.add("ass");
        words.add("bitch");

        newWords.add("bark");
        newWords.add("sniff");
        newWords.add("snoofer");
        newWords.add("woof");
        newWords.add("puppy");

        for (int i = 0; i < words.size(); i++){
            String initWord = words.get(i);
            String repWord = newWords.get(i);
            mess = mess.replace(initWord,repWord);
        }

        if(!mess.contains("/")){
            sendText(id, mess);
        }
    }

    public String weatherParser(String city){
        String loc = city.replace("/weather ","").replace(" ","%20");
        return loc;
    }
    public String stickerParser(String fileid){
        String id = fileid.replace("/sendstick ","");
        return id;
    }
    public int stickerIndex(String fileid){
        String id = fileid.replace("/stick ","");
        int index = Integer.parseInt(id);
        return index;
    }
}