// Пусть дан произвольный список целых чисел, удалить из него чётные числа
// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

package HW_3;

import java.util.ArrayList;
import java.util.Iterator;

public class HW_3 {
    public static void main(String[] args) {

        deleteUneven();
        System.out.println();
        findMinMaxAverage();


    }

    private static void findMinMaxAverage() {
        System.out.println("Поиск минимального, максимального и среднего значения в списке:");
        ArrayList<Integer> numbers = new ArrayList<>();

        int numbersQuantity = 10;
        int min;
        int max;
        float average;
        int summOfNumbers = 0;

        for (int i = 0; i < numbersQuantity; i++) {
            numbers.add((int) (Math.random() * 10));
        }


        System.out.println("Сгенерированы числа: " + numbers);


        min = numbers.get(0);
        max = numbers.get(0);


        for (int i = 0; i < numbersQuantity; i++) {
            summOfNumbers = summOfNumbers + numbers.get(i);
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }


        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число: " + max);
        System.out.println("Сумма чисел: " + summOfNumbers);
        average = (float) summOfNumbers / (float) numbersQuantity;
        System.out.println("Среднее число: " + average);


    }

    private static void deleteUneven() {
        System.out.println("Удаление четных чисел:");
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add((int) (Math.random() * 10));
        }


        System.out.println("Сгенерированы числа: " + numbers);


        Iterator<Integer> iter = numbers.iterator();
        while (iter.hasNext()) {
            if (iter.next() % 2 == 0) {
                iter.remove();
            }
        }


        System.out.println("Нечетные числа: " + numbers);

    }
}
