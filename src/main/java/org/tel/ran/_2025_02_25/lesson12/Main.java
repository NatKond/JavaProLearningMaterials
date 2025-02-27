package org.tel.ran._2025_02_25.lesson12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String test1 = """
                The little lizard leisurely lounged under the lemon tree.
                Bouncing bunnies boldly bounded beyond the broken bridge.
                Daring dogs danced delightfully despite daunting downpours.
                Several students studied sincerely, searching for success.""";
        System.out.println(test1);
        Pattern pattern1 = Pattern.compile("\\b[Ll]\\w*"); // words starting with letter b
        Matcher matcher1 = pattern1.matcher(test1);
        while (matcher1.find()) {
            System.out.println(matcher1.start() + "-" + matcher1.end() + ": " + matcher1.group());
        }

        String test2 = """
                The ancient {artifact} was hidden inside a {cave}.
                When Sarah found it, she whispered, "Unbelievable!" and later added, "This is historic!"
                Among the ruins, she noticed a /mysterious/ symbol and a /secret/ passage.
                She consulted the (map) for clues, but the (directions) were unclear.""";
        Pattern pattern2 = Pattern.compile("\"(\\w+&&\\p{L}*)\"");
        Matcher matcher2 = pattern2.matcher(test2);
        while (matcher2.find()) {
            System.out.println(matcher2.start() + ":" + matcher2.group());
        }

        String s1 = "Егор Алла Александр";
        System.out.println(s1);
        Pattern pattern3 = Pattern.compile("А.+?а");
        Matcher matcher3 = pattern3.matcher(s1);
        while (matcher3.find()) {
            System.out.println(matcher3.group());
        }
        String s2 = "Иван Иванович купил 3 яблока по цене 25.50 рубля за штуку. В магазине также были груши (4 штуки)," +
                " но они стоили 30.75 рубля. 21:35:54 Он решил оплатить картой Mastercard с номером 1234-5678-9012-3456." +
                "В тот же день он отправил 1234567890123456 email другу на адрес ivan_ivanov@example.com, elena2501@mail.ru, led.rom.93@gmail.com" +
                "а также зашёл на сайт https://shop.example.ru. Вечером в 19:45 он позвонил по номеру +7 (495) 123-45-67," +
                "чтобы заказать доставку.";
        // Pattern pattern4 = Pattern.compile("\\d+\\.\\d+"); // regex for price
        // Pattern pattern4 = Pattern.compile("\\d+:\\d+"); // regex for time
        // Pattern pattern4 = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-\\d{4}"); // regex for card number
        // Pattern pattern4 = Pattern.compile("\\+[\\d\\s-()]{7,}"); // regex for phone number
        // Pattern pattern4 = Pattern.compile("[\\w.]{6,}@[A-Za-z\\d]{3,}\\.(ru|com|de|pl)"); // regex for email
        // Pattern pattern4 = Pattern.compile("https?://[A-Za-z._\\d]+"); // regex for site
        // Pattern pattern4 = Pattern.compile("[А-Я][а-я]+\\s[А-Я][а-я]+"); // find name and surname
        Pattern pattern4 = Pattern.compile("(яблок([иао])|груш([аи]))");
        // Pattern pattern4 = Pattern.compile("[А-Я][а-я]+\\s[А-Я][а-я]+"); // regex for price
        Matcher matcher4 = pattern4.matcher(s2);
        while (matcher4.find()) {
            System.out.println(matcher4.start() + "-" + matcher4.end() + ": " + matcher4.group());
        }
        System.out.println(Arrays.toString(findAllNumbers(s2)));
    }
    /**
     * Дан текст в котором есть слова и числа, вывести все числа в виде массива
     */
    private static double[] findAllNumbers(String s){
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(s);
        List<Double> outputList = new ArrayList<>();
        while (matcher.find()){
            outputList.add(Double.parseDouble(matcher.group()));
        }
        double[] output = new double[outputList.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = outputList.get(i);
        }
        return output;
    }
}
