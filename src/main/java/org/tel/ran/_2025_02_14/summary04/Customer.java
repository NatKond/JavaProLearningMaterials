package org.tel.ran._2025_02_14.summary04;

import java.util.*;

/**
 * Имеется класс Customer c полями: public class Customer {
 * private String name;
 * private String email;
 * private String country;
 * private int bonusAmount;
 * private boolean isEmailConfirmed; }
 */

public class Customer {
    private String name;
    private String email;
    private String country;
    private int bonusAmount;
    private boolean isEmailConfirmed;

    public Customer(String name, String email, String country, int bonusAmount, boolean isEmailConfirmed) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.bonusAmount = bonusAmount;
        this.isEmailConfirmed = isEmailConfirmed;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public int getBonusAmount() {
        return bonusAmount;
    }

    public boolean isEmailConfirmed() {
        return isEmailConfirmed;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("John Doh", "john.doh@gmail.com", "USA", 25, true);
        Customer customer2 = new Customer("Emily Smith", "emily.smith@yahoo.com", "Canada", 30, false);
        Customer customer3 = new Customer("Carlos Ramirez", "carlos.ramirez@outlook.com", "Mexico", 40, true);
        Customer customer4 = new Customer("Sophie Dupont", "sophie.dupont@gmail.com", "France", 28, true);
        Customer customer5 = new Customer("Michael Brown", "michael.brown@hotmail.com", "UK", 35, false);
        Customer customer6 = new Customer("Liu Wei", "liu.wei@163.com", "China", 32, true);
        Customer customer7 = new Customer("Anna Kowalska", "anna.kowalska@wp.pl", "Poland", 27, false);
        Customer customer8 = new Customer("Ivan Petrov", "ivan.petrov@mail.ru", "Russia", 45, true);
        Customer customer9 = new Customer("Fatima Hassan", "fatima.hassan@gmail.com", "UAE", 29, false);
        Customer customer10 = new Customer("Rajesh Kumar", "rajesh.kumar@yahoo.in", "India", 38, true);
        Customer customer11 = new Customer("James Wilson", "james.wilson@gmail.com", "USA", 33, false);
        Customer customer12 = new Customer("Olivia Johnson", "olivia.johnson@hotmail.com", "Canada", 26, true);
        Customer customer13 = new Customer("Diego Hernandez", "diego.hernandez@outlook.com", "Mexico", 37, false);
        Customer customer14 = new Customer("Claire Laurent", "claire.laurent@gmail.com", "France", 31, true);
        Customer customer15 = new Customer("Robert Taylor", "robert.taylor@yahoo.co.uk", "UK", 42, true);
        Customer customer16 = new Customer("Zhang Wei", "zhang.wei@163.com", "China", 29, false);
        Customer customer17 = new Customer("Piotr Nowak", "piotr.nowak@wp.pl", "Poland", 34, true);
        Customer customer18 = new Customer("Dmitry Ivanov", "dmitry.ivanov@mail.ru", "Russia", 39, false);
        Customer customer19 = new Customer("Ahmed Al-Farsi", "ahmed.farsi@gmail.com", "UAE", 28, true);
        Customer customer20 = new Customer("Priya Sharma", "priya.sharma@yahoo.in", "India", 36, false);

        System.out.println(getEmailCountryMap(List.of(customer1, customer2, customer3, customer4, customer5)));
        System.out.println(getEmailNameMap(List.of(customer1, customer2, customer3, customer4, customer5)));
        System.out.println(getConfirmedCountMap(List.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10)));
        System.out.println(getConfirmedCountMap(List.of(customer1, customer3, customer4, customer6, customer8, customer10, customer12, customer14, customer15, customer17, customer19)));
        System.out.println(getConfirmedCountMap(List.of(customer2, customer5, customer7, customer9, customer11, customer13, customer16, customer18, customer20)));
        System.out.println(getListOfCustomersFromCountryMap(List.of(customer1, customer2, customer5, customer11, customer12, customer15)));
        System.out.println(getAccumulatedBonusCustomersFromCountryMap(List.of(customer1, customer2, customer5, customer11, customer12, customer15)));
        System.out.println(getCountrySumBonusMap(List.of(customer1, customer2, customer5, customer11, customer12, customer15)));
    }

    /**
     * На основе списка экземпляров данного класса List customers
     * a. Получить Map email / страна
     *
     * @param customers
     * @return
     */
    public static Map<String, String> getEmailCountryMap(List<Customer> customers) {
        Map<String, String> result = new HashMap<>();
        for (Customer customer : customers) {
            result.put(customer.getEmail(), customer.getCountry());
        }
        return result;
    }

    /**
     * На основе списка экземпляров данного класса List customers
     * b. Получить Map email / покупатель
     *
     * @param customers
     * @return
     */
    public static Map<String, String> getEmailNameMap(List<Customer> customers) {
        Map<String, String> result = new HashMap<>();
        for (Customer customer : customers) {
            result.put(customer.getEmail(), customer.getName());
        }
        return result;
    }

    /**
     * На основе списка экземпляров данного класса List customers
     * c. Получить Map isEmailConfirmed / количество подтвержденных и неподтвержденных email
     *
     * @param customers
     * @return
     */
    public static Map<Boolean, Integer> getConfirmedCountMap(List<Customer> customers) {
        Map<Boolean, Integer> result = new HashMap<>();
        result.put(true, 0);
        result.put(false, 0);
        for (Customer customer : customers) {
            if (customer.isEmailConfirmed()) {
                result.put(true, result.get(true) + 1);
            } else {
                result.put(false, result.get(false) + 1);
            }
        }
        return result;
    }

    /**
     * На основе списка экземпляров данного класса List customers
     * d. Получить Map> страна / список покупателей из данной страны
     *
     * @param customers
     * @return
     */
    public static Map<String, List<Customer>> getListOfCustomersFromCountryMap(List<Customer> customers) {
        Map<String, List<Customer>> result = new HashMap<>();
        for (Customer customer : customers) {
            if (result.containsKey(customer.getCountry())) {
                result.get(customer.getCountry()).add(customer);
            } else {
                result.put(customer.getCountry(), new LinkedList<>(List.of(customer)));
            }
        }
        return result;
    }

    /**
     * На основе списка экземпляров данного класса List customers
     * e. Получить Map страна / суммарный накопленный бонус покупателей из данной страны
     *
     * @param customers
     * @return
     */
    public static Map<String, Integer> getAccumulatedBonusCustomersFromCountryMap(List<Customer> customers) {
        Map<String, Integer> result = new HashMap<>();
        for (Customer customer : customers) {
            if (result.containsKey(customer.getCountry())) {
                result.put(customer.getCountry(), result.get(customer.getCountry()) + customer.getBonusAmount());
            } else {
                result.put(customer.getCountry(), customer.getBonusAmount());
            }
        }
        return result;
    }

    public static Map<String, Integer> getCountrySumBonusMap(List<Customer> customers) {
        Map<String, List<Customer>> countryCustomersMap = getListOfCustomersFromCountryMap(customers);
        Map<String, Integer> result = new HashMap<>();
        Set<Map.Entry<String, List<Customer>>> set = countryCustomersMap.entrySet();
        for (Map.Entry<String, List<Customer>> entry : set) {
            Integer sum = 0;
            for (Customer customer : entry.getValue()) {
                sum += customer.getBonusAmount();
            }
            result.put(entry.getKey(), sum);
        }
        return result;
    }
}

