package HW_2;
//

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class HW_2 {
    public static void main(String[] args) throws IOException {
        String example = "\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"";
        System.out.println(transformToSql(example));
        bubbleSort();

    }

    //    ���� ������ sql-������� "select * from students where ". ����������� ����� WHERE ����� �������, ��������� StringBuilder.
//    ������ ��� ���������� ��������� ���� � ���� json ������.
//    ���� �������� null, �� �������� �� ������ �������� � ������.
//    ��������� ��� ����������: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    private static String transformToSql(String stringToConvert) {
        // ���������� �� ��������� ������
        String[] dataFromString = stringToConvert.split(",");
        ArrayList<String> afterTransform = new ArrayList<String>();
        afterTransform.add("SELECT * FROM students WHERE ");

        for (int i = 0; i < dataFromString.length; i++) {
            dataFromString[i] = dataFromString[i].replace(" ", "");
            dataFromString[i] = dataFromString[i].replace("\"", "");
            // ������, ���������� null, �� ����� ��������� � ArrayList
            if (dataFromString[i].contains("null")) {
            } else {
                dataFromString[i] = dataFromString[i].replace(":", " = '");
                afterTransform.add(dataFromString[i]);
                afterTransform.add("'");
                afterTransform.add(" AND ");
            }

        }
        // �������� ������ AND �� ;
        afterTransform.set((afterTransform.size() - 1), ";");

        // ������� ������ AND
//        afterTransform.remove(afterTransform.size() - 1);

        // ������� ������ �� ��������� ArrayList
        StringBuilder finalSqlQueue = new StringBuilder();
        for (Object o : afterTransform) {
            finalSqlQueue.append(o);
        }

        return finalSqlQueue.toString();
    }


    //    ���������� �������� ���������� ��������� ��������� �������, ��������� ����� ������ �������� �������� � ���-����.
    private static void bubbleSort() throws IOException {
        // �������� ���� � �����
        Date date = new Date();
        // ��������� � String � �������� : �� -
        String dateName = String.valueOf(date);
        dateName = dateName.replace(":", "-");
        StringBuffer sb = new StringBuffer(dateName);
        sb.append(".txt");
        System.out.println("������ ���� � ������:");
        System.out.println(sb);
        // ������� ����� ���� � ����������� txt
        FileWriter fileWriter = new FileWriter(String.valueOf(sb), true);


        // �������� � ��������� �������
        int nums[] = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 10);
        }

        System.out.println("������������ ������:");
        fileWriter.append("������������ ������: ");

        // ������ ������� � ������ ��� � �����
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
            fileWriter.append(String.valueOf(nums[i]));
            fileWriter.append(" ");
        }
        System.out.println();
        fileWriter.append("\n");

        // ������� ������������ ��� �������
        int replacementCounter = 1;

        // ���� ����������� ���������� � ������������� �������� � �����
        boolean needSort = true;
        while (needSort == true) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    //������������ ���� [�][Date][�... = ... <=> �... = ...]
                    fileWriter.append("[");
                    fileWriter.append(String.valueOf(replacementCounter));
                    fileWriter.append("] [");
                    fileWriter.append(String.valueOf(date));
                    fileWriter.append("] [�");
                    fileWriter.append(String.valueOf(i));
                    fileWriter.append(" = ");
                    fileWriter.append(String.valueOf(nums[i]));
                    fileWriter.append(" <=> �");
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
            // �������� ���������� ���������� ����������
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

        // ����� �� ����� ���������������� ������� � ������ ��� � �����
        System.out.println("Отсортированный массив:");
        fileWriter.append("Отсортированный массив:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
            fileWriter.append(String.valueOf(nums[i]));
            fileWriter.append(" ");
        }

        // ���������� ��� �� ������ � ����
        fileWriter.flush();

    }

}
