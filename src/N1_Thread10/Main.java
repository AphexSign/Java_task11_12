//* Напишите программу, в которой запускается 10 потоков
//        и каждый из них выводит
//        числа от 0 до 100.

package N1_Thread10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//
        //Создаем n-количество потоков
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько потоков создать? - ");
        int count = scanner.nextInt();
        System.out.println("Нужна последовательность выполнения потоков? 0(НЕТ)   1(ДА)?");
        int bool = scanner.nextInt();

        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(Main::showNumbers);
            System.out.println("Поток N" + i + " (создан) статус:" + threads[i].getState());
        }
        //
        Arrays.stream(threads).
                forEach(thread -> {
            thread.start();
            System.out.println(thread.getName() + " (после старта) статус:" + thread.getState());
            if (bool == 1) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        if (bool == 1) {
            Arrays.stream(threads).forEach(thread -> System.out.println(thread.getName() + " (конец) статус:" + thread.getState()));
        }

        if (bool == 0) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Arrays.stream(threads).forEach(thread -> System.out.println(thread.getName() + " (после завершение Main-потока) статус:" + thread.getState()));
        }

    }

    public static void showNumbers() {
        for (int h = 0; h < 101; h++) {
            System.out.println(Thread.currentThread().getName() + " мое число: " + h + " статус (во время выполнения): " + Thread.currentThread().getState());
        }
    }

}

