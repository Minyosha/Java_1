package HW_2;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

public class HW_2 {
    public static void main(String[] args) throws IOException {
        String example = "\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"";
        System.out.println(transformToSql(example));
        bubbleSort();

    }


    //    Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
//    Данные для фильтрации приведены ниже в виде json строки.
//    Если значение null, то параметр не должен попадать в запрос.
//    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    private static String transformToSql(String stringToConvert) {
        // Разделение на отдельные строки
        String[] dataFromString = stringToConvert.split(",");
        ArrayList<String> afterTransform = new ArrayList<String>();
        afterTransform.add("SELECT * FROM students WHERE ");

        for (int i = 0; i < dataFromString.length; i++) {
            dataFromString[i] = dataFromString[i].replace(" ", "");
            dataFromString[i] = dataFromString[i].replace("\"", "");
            // Строки, содержащие null, не будут добавлены в ArrayList
            if (dataFromString[i].contains("null")) {
            } else {
                dataFromString[i] = dataFromString[i].replace(":", " = '");
                afterTransform.add(dataFromString[i]);
                afterTransform.add("'");
                afterTransform.add(" AND ");
            }

        }
        // Заменяем лишний AND на ;
        afterTransform.set((afterTransform.size() - 1), ";");

        // Удаляем лишний AND
//        afterTransform.remove(afterTransform.size() - 1);

        // Склейка строки из элементов ArrayList
        StringBuilder finalSqlQueue = new StringBuilder();
        for (Object o : afterTransform) {
            finalSqlQueue.append(o);
        }

        return finalSqlQueue.toString();
    }


    // Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
    private static void bubbleSort() throws IOException {
        // Получаем текущую дату и время
        Date date = new Date();
        // Преобразуем в String и заменяем : на -
        String dateName = String.valueOf(date);
        dateName = dateName.replace(":", "-");
        StringBuffer sb = new StringBuffer(dateName);
        sb.append(".txt");
        System.out.println("Создан файл с именем:");
        System.out.println(sb);
        // Создаем новый файл с расширением txt
        StandardCharsets.UTF_8.name();
        FileWriter fileWriter = new FileWriter(String.valueOf(sb), StandardCharsets.UTF_8, true);


        // Создаем и генерируем массив
        int nums[] = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 10);
        }

        System.out.println("Сгенерирован массив:");
        fileWriter.append("Сгенерирован массив: ");

        // Печать массива и запись его в буфер
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
            fileWriter.append(String.valueOf(nums[i]));
            fileWriter.append(" ");
        }
        System.out.println();
        fileWriter.append("\n");

        // Создание счетчика перестановок для логгера
        int replacementCounter = 1;

        // Цикл, выполняющий перестановки элементов массива
        boolean needSort = true;
        while (needSort == true) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    //Логгирование вида [№][Date][№... = ... <=> №... = ...]
                    fileWriter.append("[");
                    fileWriter.append(String.valueOf(replacementCounter));
                    fileWriter.append("] [");
                    fileWriter.append(String.valueOf(date));
                    fileWriter.append("] [№");
                    fileWriter.append(String.valueOf(i));
                    fileWriter.append(" = ");
                    fileWriter.append(String.valueOf(nums[i]));
                    fileWriter.append(" <=> №");
                    fileWriter.append(String.valueOf(i + 1));
                    fileWriter.append(" = ");
                    fileWriter.append(String.valueOf(nums[i + 1]));
                    fileWriter.append("]");
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                    replacementCounter = replacementCounter + 1;
                    fileWriter.append("\n");
                }
            }
            // Проверка необходимости дальнейшей сортировки массива
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] <= nums[i + 1]) {
                    count = count + 1;
                    if (count == nums.length - 1) {
                        needSort = false;
                    }
                } else {
                    break;
                }
            }

        }

        // Печать отсортированного массива и запись его в буфер
        System.out.println("Отсортированный массив:");
        fileWriter.append("Отсортированный массив: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
            fileWriter.append(String.valueOf(nums[i]));
            fileWriter.append(" ");
        }

        // Запись данных из буфера в файл
        fileWriter.flush();

    }

}
