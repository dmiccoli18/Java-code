package com.company;
import java.util.Random;

public class Wolf {
    public static String wolfFact(){
        String fact = "";
        Random rand  = new Random();
        int foo = rand.nextInt(25) + 1;

        switch (foo){
            case 1:
                fact = "Wolves are neat";
                break;
            case 2:
                fact = "Wolves are silly goobers";
                break;
            case 3:
                fact = "Wolves use smell from urine or feces to communicate location or which wolf " +
                        "they are within their pack";
                break;
            case 4:
                fact = "Wolves like to sleep in the breakfast nook";
                break;
            case 5:
                fact = "You can just take the wolves in the forest, they're free!";
                break;
            case 6:
                fact = "Wolves don't pay taxes";
                break;
            case 7:
                fact = "Wolves mate with one partner for life";
                break;
            case 8:
                fact = "Wolves have an average bite force of 400psi, over 3x stronger than humans";
                break;
            case 9:
                fact = "It's perfectly safe to pet wolves, don't let the propaganda " +
                        "tell you otherwise";
                break;
            case 10:
                fact = "The earliest drawings of wolves are in caves in southern Europe " +
                        "and date from 20,000 BCE";
                break;
            case 11:
                fact = "Wolves have 5-7 pups per litter";
                break;
            case 12:
                fact = "There are over 38 subspecies of grey wolves";
                break;
            case 13:
                fact = "Wolves have over 200 million sensory receptors in their nose " +
                        "and their smell is 10,000x more " +
                        "sensitive than humans";
                break;
            case 14:
                fact = "Wolves have a reflecting layer on their eyes that cause " +
                        "them to glow in the dark";
                break;
            case 15:
                fact = "Wolves run on their toes, protecting their pawpads from " +
                        "wearing down as well as running and maneuvering faster";
                break;
            case 16:
                fact = "Wolves actually have webbed feet, called interdigital webbing, that help them swim";
                break;
            case 17:
                fact = "Maned wolf urine smells like marijuana, leading to the nickname 'weed dogs'";
                break;
            case 18:
                fact = "Wolves don't stimulate the economy with jobs";
                break;
            case 19:
                fact = "No other word rhymes with wolf";
                break;
            case 20:
                fact = "A wolf howl can be heard up to 10 km/6.2 mi away";
                break;
            case 21:
                fact = "Standing next to a howling wolf for +15 minutes would cause permanent hearing damage";
                break;
            case 22:
                fact = "2/3rds of all wolves in the US live in Alaska";
                break;
            case 23:
                fact = "A wolf footprint will measure 4 in/10.2 cm wide by 5 in/12.7 cm long";
                break;
            case 24:
                fact = "In Japanese folklore, the Raiju was a wolf-like creature associated with the shinto god of " +
                        "lightning, said to leap about in trees, fields, and buildings during thunderstorms";
                break;
            case 25:
                fact = "The name for the country of Georgia comes from the old Persian word for 'the land of wolves'";
                break;
            case 26:
                fact = "The Apennine wolf is the national animal of Italy and can be seen on buildings " +
                        "and statues all throughout Rome, due to it's role in the legend of the founding of Rome";
        }

        return fact;
    }
}
