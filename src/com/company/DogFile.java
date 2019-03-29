package com.company;

import java.io.*;
import java.util.Scanner;

public class DogFile {

    public static Dog[] getAllDogs() throws IOException{
        Dog[] myDogs = new Dog[200];
        File input = new File("dogs.txt");
        if (input.exists()){
            Scanner inFile = new Scanner(input);
            while(inFile.hasNext()){
                String line = inFile.nextLine();
                String[] temp = line.split("#");
                int id = Integer.parseInt(temp[0]);
                int age = Integer.parseInt(temp[4]);
                int weight = Integer.parseInt(temp[5]);
                boolean avlb=false;
                if (temp[6].equalsIgnoreCase("true")) {
                    avlb = true;
                }
                boolean deleted = false;
                if(temp[7].equalsIgnoreCase("true")){
                    deleted=true;
                }
                myDogs[Dog.getCount()] = new Dog(id,temp[1],temp[2],temp[3],age,weight,avlb,deleted);
                Dog.setCount((Dog.getCount()+1));
                if(id > Dog.getMaxId()){
                    Dog.setMaxId(id);
                }
            }
            inFile.close();
        }
        return myDogs;
    }

    public static void saveAllDogs(Dog[] myDogs)throws IOException{
        PrintWriter outFile = new PrintWriter("dogs.txt");

        for(int i = 0; i<Dog.getCount(); i++){
            outFile.println(myDogs[i].toFile());
        }

        outFile.close();
    }
}
