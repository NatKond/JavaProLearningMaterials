package org.tel.ran.homework01;

/**
 * Написать класс FibonacciSequence, в котором есть поле length - длинна последовательности Фибоначчи.
 * Написать 3 метода в этом классе, возвращающих последовательность фибоначчи размера length в виде массива. Пример [0, 1, 1, 2, 3, 5] для length = 6.
 * Каждый метод использует свой вариант цикла: 1 метод через цикл for, 2 через while, 3 через do-while.
 * Написать конструктор с параметром и без параметров для этого класса. Не допускать возможность установки отрицательного значения length.
 * Написать программу (отдельный класс с методом main) в котором создать объект класса FibonacciSequence и протестировать работу всех получившихся методов
 */


public class FibonacciSequence {

    private int length;

    public FibonacciSequence() {
    }

    public FibonacciSequence(int length) {
        if (length >= 0) {
            this.length = length;
        } else {
            System.err.println("Error. The sequence cannot have a negative length.");
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getSequenceFor(){
        int[] sequence = initSequence();

        for (int i = 2; i < sequence.length; i++) {
            sequence[i] = sequence[i - 2] + sequence[i - 1];
        }
        return sequence;
    }

    public int[] getSequenceWhile(){
        int[] sequence = initSequence();

        int i = 2;
        while (i < sequence.length){
            sequence[i] = sequence[i - 2] + sequence[i - 1];
            i++;
        }
        return sequence;
    }
    public int[] getSequenceDoWhile(){
        int[] sequence = initSequence();

        if (length < 3) return sequence;

        int i = 2;
        do {
            sequence[i] = sequence[i - 2] + sequence[i - 1];
            i++;
        } while (i < sequence.length);
        return sequence;
    }

    private int[] initSequence(){
        int[] sequence = new int[length];

        if (length == 0) return sequence;
        sequence[0] = 0;
        if (length == 1) return sequence;
        sequence[1] = 1;
        return sequence;
    }



}
