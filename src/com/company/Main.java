package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Dog[] myDogs = DogFile.getAllDogs();
        Dog.sortDogs(myDogs);
        Dog.printAllDogs(myDogs);

        //How to do an edit
        int searchID = 1; // would get this from user input
        int index = Dog.find(myDogs,searchID);
        if(index!=-1){
            myDogs[index].setAge(myDogs[index].getAge() + 1);
        } else System.out.println("Dog not on file");

        Dog.sortDogs(myDogs);
        DogFile.saveAllDogs(myDogs);
        System.out.println("after the edit");
        Dog.printAllDogs(myDogs);

        //How to add a dog
        Dog.addDog(myDogs);
        Dog.sortDogs(myDogs);
        DogFile.saveAllDogs(myDogs);
        System.out.println("after the add");
        Dog.printAllDogs(myDogs);
    }
}
