package com.company;

import java.util.Vector;

public class Birthday {


    Vector<String> names = new Vector<>(1,1);
    Vector<String> birthdays = new Vector<>(1,1);

    public String addBirth(String subMsg){
        String subSubMsg = subMsg.replace("/addbirth ","");
        String[] bday = subSubMsg.split("\\s+");
        String name = bday[0];
        String birthday = bday[1];
        names.add(name);
        birthdays.add(birthday);
        String superMsg = "Arf Arf! New birthday added: " + name + " " + birthday;
        return superMsg;
    }

    public String removeBirth(String subMsg){
        String subSubMsg = subMsg.replace("/removebirth ","");
        String name = "";
        String superMsg = "";
        for(int i = 0; i < names.size(); i++) {
            if (subSubMsg.toLowerCase().contains(names.get(i).toLowerCase())) {
                name = names.get(i);
                names.remove(i);
                birthdays.remove(i);
                superMsg = "Awrf! Birthday removed: " + name;
                break;
            }
        }
        if (name.equals("")){
            superMsg = "Woof Woof! There is no name that matches: " + subSubMsg;
        }
        return superMsg;
    }

    public String listBirth(){
        String birthList = "Awruff! Here's the current list of birthdays: " + "\n";

        for (int i = 0; i < names.size(); i++){
            birthList = birthList + names.get(i) + " " + birthdays.get(i) + "\n";
        }
        return birthList;
    }
}
