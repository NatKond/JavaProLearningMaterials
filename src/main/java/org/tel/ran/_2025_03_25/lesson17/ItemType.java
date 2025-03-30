package org.tel.ran._2025_03_25.lesson17;

import java.util.function.UnaryOperator;

public enum ItemType {
    ELECTRONICS {
        @Override
        public UnaryOperator<Double> discountFunction() {
            return price -> price * 0.9;
        }
    },
    CLOTHING {
        @Override
        public UnaryOperator<Double> discountFunction() {
            return price -> (price * 0.2 < 500) ? price * 0.8 : price - 500;
        }
    },
    GROCERIES {
        @Override
        public UnaryOperator<Double> discountFunction() {
            return price -> price - 50;
        }
    },
    BOOKS {
        @Override
        public UnaryOperator<Double> discountFunction() {
            return price -> (price > 1000) ? price * 0.95 : price;
        }
    };

    public abstract UnaryOperator<Double> discountFunction();
}
