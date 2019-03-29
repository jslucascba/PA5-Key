package com.company;
import java.util.Scanner;

public class Dog {
    private int id;
    private String name;
    private String breed;
    private String sex;
    private int age;
    private int weight;
    private boolean avlb;
    private boolean deleted;
    private static int count;
    private static int maxId;


    public Dog() {
    }

    public Dog(int id) {
        this.id = id;
    }

    public Dog(int id, String name, String breed, String sex, int age, int weight, boolean avlb, boolean deleted) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.avlb = avlb;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isAvlb() {
        return avlb;
    }

    public void setAvlb(boolean avlb) {
        this.avlb = avlb;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Dog.count = count;
    }

    public static int getMaxId() {
        return maxId;
    }

    public static void setMaxId(int maxId) {
        Dog.maxId = maxId;
    }

    public String toString(){
        return id + " " + name + " " + breed + " " + age;
    }

    public boolean equals(Dog yourDog){
        return (this.id == yourDog.getId());
    }

    public boolean equals(int yourDog){
        return (this.id == yourDog);
    }

    public int compareTo(Dog yourDog){
        return (this.id - yourDog.getId());
    }

    public int compareTo(int yourID){
        return (this.id - yourID);
    }

    public static void sortDogs(Dog[] myDogs){
        for(int i=0; i<count-1; i++){
            int min = i;
            for(int j=i+1; j<count; j++){
                if(myDogs[j].compareTo(myDogs[min])<0){
                    min = j;
                }
            }
            if(min!=i){
                swap(myDogs,i,min);
            }
        }
    }

    private static void swap(Dog[] myDogs, int i, int min){
        Dog temp = myDogs[i];
        myDogs[i] = myDogs[min];
        myDogs[min] = temp;
    }

    public static void printAllDogs(Dog[] myDogs){
        for(int i = 0; i<count; i++){
            System.out.println(myDogs[i]);
        }
    }

    public static int find(Dog[] myDogs, int searchVal){
        int first = 0;
        int last = count-1;
        int returnVal = -1;
        int middle;
        boolean found = false;

        while(!found && first <= last){
            middle = (first + last) / 2;

            if(myDogs[middle].equals(searchVal)){
                found = true;
                returnVal = middle;
            }
            else if(myDogs[middle].compareTo(searchVal)>0){
                last = middle - 1;
            }
            else{
                first = middle + 1;
            }
        }

        return returnVal;
    }

    public static void addDog(Dog[] myDogs){
        Scanner keyboard = new Scanner(System.in);
        maxId++;
        myDogs[count] = new Dog(maxId);
        System.out.println("Enter a name");
        myDogs[count].setName(keyboard.nextLine());
        System.out.println("Enter the breed");
        myDogs[count].setBreed((keyboard.nextLine()));
        System.out.println("Enter the sex");
        myDogs[count].setSex(keyboard.nextLine());
        System.out.println("Enter the age");
        myDogs[count].setAge(Integer.parseInt(keyboard.nextLine()));
        System.out.println("Enter the weight");
        myDogs[count].setWeight(Integer.parseInt(keyboard.nextLine()));
        count++;

    }

    public String toFile(){

        return id+"#"+name+"#"+breed+"#"+sex+"#"+age+"#"+weight+"#"+avlb+"#"+deleted;
    }
}
