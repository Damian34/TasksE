package me.pack;

import java.util.Arrays;

public class Main {

    public static int counter = 0;
    /*
    * methods returning a table with not repeated values from 0 to maxValue-1
    * but if size > maxValue it will return null, cuz it not possible get such table
    * */
    public int[] generateTable(int size, int maxValue){
        if(size > maxValue){
            return null;
        }
        int[] table = new int[size];
        for(int i=0;i<size;i++){
            while(true) {
                int newValue = (int) (Math.random() * maxValue);
                boolean checkIfExist = false;
                for (int j = 0; j < i; j++) {
                    if (table[j] == newValue) {
                        checkIfExist = true;
                        break;
                    }
                }
                if (!checkIfExist){
                    table[i] = newValue;
                    break;
                }
            }
        }
        return table;
    }

    /*
    * It is java Quicksort algorithm with complexity O(n log(n))
    * and cuz in order to make descending sort I would need table of wrapped class Integer instant of int
    * so cuz i wouldn't like change int[] to Integer[] then i added simple reversing table
     * */
    public void sort(int[] table){
        Arrays.sort(table);
        for(int i=0;i<table.length/2;i++){
            int pom = table[i];
            table[i] = table[table.length-1-i];
            table[table.length-1-i] = pom;
        }
    }

    private boolean searchPart(int[] numbers, int x, int minIndex, int maxIndex){
        counter++;
        if(numbers[minIndex] == x){
            return true;
        }else if(numbers[maxIndex] == x){
            return true;
        }else if(minIndex == maxIndex || minIndex+1 == maxIndex){
            return false;
        }else{
            int center = (minIndex+maxIndex)/2;
            if(numbers[center] < x){
                return searchPart(numbers,x,minIndex,center);
            }else{
                return searchPart(numbers,x,center,maxIndex);
            }
        }
    }

    /*
     *  the computing complexity of this search algorithm will be O(log(n))
     *  the memory complexity will be O(1)
     * */
    private boolean search(int[] numbers, int x){
        return searchPart(numbers,x,0,numbers.length-1);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Hello here is task 2!");
        int[] table = main.generateTable(1000,4000);
        int numberToFind = 25;

        if(table!=null){
            main.sort(table);
            System.out.println("And these is generated and sorted table of numbers");
            for(int i=0;i<table.length;i++){
                System.out.print(i < table.length-1 ? table[i] + ", " : table[i]);
            }
            System.out.println();
            if(main.search(table,numberToFind)){
                System.out.println(String.format("number %d was found in %d iterations", numberToFind, counter));
            }else {
                System.out.println(String.format("number %d wasn't found in %d iterations", numberToFind, counter));
            }
        }
        else{
            System.out.println("table size and maxValue are kinda not correct");
        }
    }
}