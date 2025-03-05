package com.company;

public class Commands {
    public static String comPrompt(){
        String comms = "Awoo! list of commands, anything in [these] brackets is required after command: \n"
                + "/addword [word] [newWord]: adds a word to be censored by newWord \n \n"
                + "/addbirth [name] [date]: adds the birthday of someone, specified by name \n \n"
                + "/removebirth [name]: removes the birthday of name, an error will be sent if no name is found \n \n"
                + "/listbirth: lists all the birthdays in the calendar \n \n"
                // change sendstick when file_id vector is implemented
                + "/sendstick [file_id]: sends a sticker with the associated file_id \n \n"
                + "/stick [index]: sends a sticker from a premade list at input index \n \n"
                + "/fact: sends a random wolf fact \n \n"
                + "/weather [city]: returns the 3-day future weather forecast for the desired city, incluting highs, lows" +
                "and precipitation \n \n"
                + "/wuffweather: it's a secret";
        return comms;
    }
}
