//* Напишите программу, в которой запускается 10 потоков
//        и каждый из них выводит
//        числа от 0 до 100.

package N1_Thread10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Создаем n-количество потоков
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько потоков создать? - ");
        int count = scanner.nextInt();
        System.out.println("Нужна последовательность выполнения потоков? 0(НЕТ)   1(ДА)?");
        int bool = scanner.nextInt();

        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(() -> showNumbers());
        }

        for (int j = 0; j < count; j++) {
            threads[j].start();
            if (bool == 1) {
                threads[j].join();
            }
        }
    }

    public static void showNumbers() {
        for (int h = 0; h < 100; h++) {
            System.out.println(Thread.currentThread().getName() + " мое число: " + h);
        }
    }
}
