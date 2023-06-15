package ru.geekbrains;

import java.util.Scanner;

public class MyArray {
    protected static int sizeX;
    protected static int sizeY;

    public static int getSizeX() {
        return sizeX;
    }

    public static int getSizeY() {
        return sizeY;
    }

    /**
     * Создание массива
     *
     * @return
     */
    String[][] createArray() throws MyArraySizeException {
        // Запрос размера массива 4х4
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива по горизонтали (значение 4): ");
        sizeX = in.nextInt();
        System.out.print("Введите размер массива по вертикали (значение 4): ");
        sizeY = in.nextInt();
        if (sizeX != 4 || sizeY != 4) {
            in.close();
            throw new MyArraySizeException("Ошибка: введите значение размера массива 4х4");
        } else {
            String[][] myArray = new String[sizeX][sizeY];
            String str;
            for (int x = 0; x < sizeX; x++) {
                System.out.printf("Введите числовое значение ячеек в строке %d: ", x + 1);
                str = in.next();
                for (int y = 0; y < sizeY; y++) {
                    myArray[x][y] = str;
                }
            }
            in.close();
            return myArray;
        }
    }

    void printMyArray(String[][] myArray) {
        System.out.println("Ваш массив: ");
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean isNumber(String str) {
        try {
            int i;
            i = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    void transformAndSum1 (String[][] myArray) throws MyArrayDataException {
        int[][] myArrayInt = new int[sizeX][sizeY];
        int sum = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (!isNumber(myArray[i][j])) {
                    throw new MyArrayDataException("Ошибка в ячейках строки [" + (i+1) +"]: введённые значения не являются числами");
                } else {
                    myArrayInt[i][j] = Integer.parseInt(myArray[i][j]);
                    sum += myArrayInt[i][j];
                }
            }
        }
        System.out.printf("Сумма всех ячеек массива равна: %d", sum);
    }
}
