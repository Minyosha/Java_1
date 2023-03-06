package HW_1;
//
import java.util.Scanner;

public class HW_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculations(scanner);
        simpleNumbers(1000);
        simpleCalculator(scanner);
//        equation(scanner);


        scanner.close();
    }


    // ��������� n-�� ������������ �����(����� ����� �� 1 �� n), n! (������������ ����� �� 1 �� n)
    private static void calculations(Scanner scanner) {
        System.out.println("������� n ��� ���������� ������������ ����� � n!");
        int n = scanner.nextInt();
        int triangleNumber = ((n * (n + 1)) / 2);
        int triangleSumm = 0;
        System.out.println("��� n = " + n + ": �n = " + triangleNumber);
        for (int i = 1; i < n + 1; i++) {
            triangleSumm = triangleSumm + ((i * (i + 1)) / 2);
        }
        System.out.println("����� ������ " + n + " ����������� ����� ����� " + triangleSumm);
        int factorial = 1;
        for (int i = 1; i < n + 1; i++) {
            factorial = factorial * i;
        }
        System.out.println("��� n = " + n + ": n! = " + factorial);
    }


    // �������� ������� �� �����
    public static boolean isSimple(Integer number) {
        if (number < 2) return false;
        for (int i = 2; i < ((number / 2) + 1); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    // ������� ��� ������� ����� �� 1 �� 1000
    public static void simpleNumbers(int n) {
        System.out.println("������ ������� ����� �� 1 �� " + n + ":");
        for (int i = 1; i < n + 1; i++) {
            if (isSimple(i) == true) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }


    // ������� �����������
    public static void simpleCalculator(Scanner scanner) {
        System.out.println("������� ����� a:");
        float a = scanner.nextInt();
        System.out.println("������� ����� b:");
        float b = scanner.nextInt();
        System.out.println("������� ����� ��� ������ ��������� ��� ������� ��������� a?b:");
        System.out.println("1: +");
        System.out.println("2: -");
        System.out.println("3: *");
        System.out.println("4: /");

        byte symbol = scanner.nextByte();
        switch (symbol) {
            case 1:
                System.out.println("a + b = " + (a + b));
                break;
            case 2:
                System.out.println("a - b = " + (a - b));
                break;
            case 3:
                System.out.println("a * b = " + (a * b));
                break;
            case 4:
                if (b == 0) {
                    System.out.println("�� ���� ������ ������");
                } else {
                    System.out.println("a / b = " + (a / b));
                }
                break;

        }
    }


    //������ ��������� ���� q + w = e, q, w, e >= 0. ��������� ����� ����� ���� �������� ������ �������,
    // �������� 2? + ?5 = 69. ��������� ������������ ��������� �� ������� ���������.
    // ���������� ���� �� ���� ������� ��� ��������, ��� ��� ���.
//    public static void equation(Scanner scanner) {
//        System.out.println("������ ��������� ���� q + w = e, ��� q, w, e >= 0");
//        System.out.println("������� ���������� q, w, e, ������� ��������� ����� ������� ?");
//        System.out.println("��������� ��������� ��������� �������, ��� ������� ��������� ����� ������ ��� �������, ��� ������� ���");
//        System.out.println("������� q");
//        int countQuestions = 0;
//        int qRank = 0;
//        int wRank = 0;
//        int eRank = 0;
//        String q = scanner.nextLine();
//        for (char element : q.toCharArray()){
//            if (element == '?') countQuestions++;
//            qRank++;
//        }
//        System.out.println("������� w");
//        String w = scanner.nextLine();
//        for (char element : w.toCharArray()){
//            if (element == '?') countQuestions++;
//            wRank++;
//        }
//        System.out.println("������� e");
//        String e = scanner.nextLine();
//        for (char element : e.toCharArray()){
//            if (element == '?') countQuestions++;
//            eRank++;
//        }
//        System.out.println(countQuestions);
//

//        System.out.println(w.charAt(0));
//        System.out.println(qRank);
//        System.out.println(wRank);
//        System.out.println(eRank);
//
//    }

}
