package org.tel.ran._2025_01_28.lesson05;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private LocalDate dataOfBirth;


    public Person(LocalDate dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public LocalDate getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(LocalDate dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public int getAge() {
        return Period.between(dataOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Person)) return false;
        Person p = (Person) object;
        return this.getDataOfBirth().equals(p.dataOfBirth);
    }

}

