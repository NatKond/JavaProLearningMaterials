package org.tel.ran.homework02;

public class FibonacciSequence {

    private int length;

    public FibonacciSequence() {
    }

    public FibonacciSequence(int length) {
        setLength(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length >= 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Error. The sequence cannot have a negative length.");
        }
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
