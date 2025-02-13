package org.tel.ran._2025_02_13.lesson09;

import java.util.List;

public class Example<T, R> {
    private T field1;
    private R field2;
    private List<T> list;

    public Example() {
    }

    public Example(T field1, R field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public T getField1() {
        return field1;
    }

    public void setField1(T field1) {
        this.field1 = field1;
    }

    public R getField2() {
        return field2;
    }

    public void setField2(R field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "Example{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                '}';
    }
}
