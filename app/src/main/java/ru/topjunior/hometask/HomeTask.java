package ru.topjunior.hometask;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeTask {

    private static int[] nominal = {200, 100, 50, 20, 10};
    private static int[] m = new int[5];
    private static int[] mVvod = new int[5];
    private static int sum;
    private static int password = 1111;
    private static int menuT;

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {

        while(true) {
            System.out.println("Введите PIN-код:");
            try {
                password = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (password == 1111) {
                System.out.println("Добро Пожаловать");
                break;
            } else
                System.out.println("Ошибка, попробуйте еще раз");
        }

        while (true) {
            System.out.println("Пожалуйста, выберите услугу: ");
            System.out.println("1.Пополнение счёта");
            System.out.println("2.Выдача наличных");
            System.out.println("3.Остаток на счёте");
            System.out.println("4.Выход");

            try {
                menuT = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (menuT == 1) add();
            else if (menuT == 2) money();
            else if (menuT ==3) {
                System.out.println("Остаток на счетё:");
                for (int i = 0; i < 5; i++) {
                    System.out.println(nominal[i] + " " + "x" + " " + (mVvod[i] - m[i]) + " " + "=" + " " + nominal[i] * (mVvod[i] - m[i]));
                }
            }
            else if (menuT == 4) {
                System.out.println("До свиданья");
                break;
            } else System.out.println("Ошибка, Вы ввели неверный номер");
        }
    }


    private static void add() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите кол-во блокнот номинала " + ":" + nominal[i]);
            try {
                mVvod[i] = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static int count(int nominal, int sum, int put) {

        if ((sum / nominal) >= put) {
            return put;
        } else {
            return (sum / nominal);
        }
    }

    private static void money() {

        System.out.println("Введите сумму для снятия кратную 10: ");
        try {
            sum = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            m[i] = count(nominal[i], sum, mVvod[i]);
            sum = sum - nominal[i] * m[i];
        }

        if (sum == 0) {
            for (int i = 0; i < 5; i++) {
                System.out.println(nominal[i] + " " + "x" + " " + m[i] + " " + "=" + " " + nominal[i] * m[i]);
            }
        }
    }
}





