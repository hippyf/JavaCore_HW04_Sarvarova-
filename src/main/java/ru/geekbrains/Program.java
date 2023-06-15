package ru.geekbrains;

public class Program {
    private static char [] [] myArray;

    public static void main(String[] args) {
        try {
            MyArray myArray = new MyArray();
            String array [][] = myArray.createArray();
            myArray.printMyArray(array);
            myArray.transformAndSum(array);

        } catch (MyArraySizeException ex) {
            System.out.println(ex.getMessage());
        } catch (MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
