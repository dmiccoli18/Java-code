package com.company;

import java.io.*;
import java.util.Vector;

import org.telegram.telegrambots.meta.api.objects.InputFile;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;

public class StickerBot {

    public static String sendSticker(int index){
        Vector<String> stickers = new Vector<>();
        stickers.add("CAACAgEAAxkBAAEx9bxnt-dt8oJ6lWIeiouJ47ydgQUuyAAC6wIAAgb5gUST8o0WyPd81jYE");
        stickers.add("CAACAgEAAxkBAAEyBKVnujRbgsDr2lujnNHldAPE1JpSmwACIwUAAqlv2UVE1SsroGRYxjYE");
        stickers.add("CAACAgEAAxkBAAEyWvpnx7wPR5YRVjLWeL2LdF_hhCaH8AAC_HwAAq8ZYgcTjzKoEJxlljYE");
        stickers.add("CAACAgEAAxkBAAEyWvxnx7yM_S2nIWQsIBfYH-bTz4eD7AAC7wQAAmvoWEeU2V0ZStiRjzYE");
        stickers.add("CAACAgIAAxkBAAEyWv5nx7ylASHfY2FewWG581v_R3cBzAACSgEAAvKkAwIgRizJMm7r2DYE");

        if (index > stickers.size()){
            return null;
        }
        else {
            return stickers.get(index - 1);
        }
    }

    public static void getRequest(Long who, String botToken, String stickerid) {

        // implement vector or some data structure to add/check sticker id's
        //String stickerid = "CAACAgEAAxkBAAEx9bxnt-dt8oJ6lWIeiouJ47ydgQUuyAAC6wIAAgb5gUST8o0WyPd81jYE";
        //String stickerid = "CAACAgEAAxkBAAEyBKVnujRbgsDr2lujnNHldAPE1JpSmwACIwUAAqlv2UVE1SsroGRYxjYE";


        //post request file for sticker
        String filePath = "https://api.telegram.org/bot" + botToken + "/sendSticker?chat_id=" + who.toString()
               + "&sticker=" + stickerid;

    CloseableHttpClient httpclient = HttpClients.createDefault();

    //file entity
    HttpPost post = new HttpPost(filePath);

    CloseableHttpResponse response = null;
    HttpEntity entity = null;
    try{
        response = httpclient.execute(post);
        entity = response.getEntity();
    }
    catch(IOException ie){
        ie.printStackTrace();
    }

    InputStream instream = null;
    InputFile IF = null;

    if (entity != null) {
        try{
            instream = entity.getContent();
        }
        catch (IOException ie){
            ie.printStackTrace();
        }
        IF = new InputFile().setMedia(instream,"Sticker");
        }
    }
}
