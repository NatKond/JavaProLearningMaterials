package org.tel.ran.homework09;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserParser {
    public static List<User> parseUsers(String text) {
        //String[] usersData = text.split("\\s+\\[User\\]");
        String[] usersData = text.replaceAll("\\s+\\[User]", "\n").trim().split("\n{2,}");
        String[] name;
        String email;
        String phone;
        int age;
        List<User> userList = new ArrayList<>();
        for (String s : usersData) {
            name = getName(s);
            email = getEmail(s);
            phone = getPhone(s);
            age = getAge(s);
            if (name != null && email != null && phone != null && age != 0) {
                userList.add(new User(name[0], name[1], email, phone, age));
            }
        }
        return userList;
    }

    private static String[] getName(String text) {
        Pattern namePattern = Pattern.compile("[A-Z][a-z]+\\s[A-Z][a-z]+");
        Matcher nameMatcher = namePattern.matcher(text);
        if (nameMatcher.find()) {
            return nameMatcher.group().split("\\s");
        } else return null;
    }

    private static String getEmail(String text) {
        Pattern emailPattern = Pattern.compile("[\\w.]{6,}@[\\w.]{3,}\\.(ru|com|net|org|uk)");
        Matcher emailMatcher = emailPattern.matcher(text);
        if (emailMatcher.find()) {
            return emailMatcher.group();
        } else return null;
    }

    private static String getPhone(String text) {
        Pattern phonePattern = Pattern.compile("\\+[\\d-]{12,}");
        Matcher phoneMatcher = phonePattern.matcher(text);
        if (phoneMatcher.find()) {
            return phoneMatcher.group();
        } else return null;
    }

    private static int getAge(String text) {
        Pattern agePattern = Pattern.compile("(?<=\\s)\\d{1,2}");
        Matcher ageMatcher = agePattern.matcher(text);
        if (ageMatcher.find()) {
            return Integer.parseInt(ageMatcher.group());
        } else return 0;
    }

    public static List<User> parseUsersOld(String text) {
        //String[] usersData = text.split("\\s+\\[User\\]");
        String[] usersData = text.replaceAll("\\s+\\[User]", "\n").trim().split("\n{2,}");
        Pattern namePattern = Pattern.compile("[A-Z][a-z]+\\s[A-Z][a-z]+");
        Matcher nameMatcher;
        Pattern emailPattern = Pattern.compile("[\\w.]{6,}@[\\w.]{3,}\\.(ru|com|net|org|uk)");
        Matcher emailMatcher;
        Pattern phonePattern = Pattern.compile("\\+[\\d-]{12,}");
        Matcher phoneMatcher;
        Pattern agePattern = Pattern.compile("(?<=\\s)\\d{1,2}");
        Matcher ageMatcher;
        String[] name;
        String email;
        String phone;
        int age;
        List<User> userList = new ArrayList<>();
        for (String s : usersData) {
            nameMatcher = namePattern.matcher(s);
            emailMatcher = emailPattern.matcher(s);
            phoneMatcher = phonePattern.matcher(s);
            ageMatcher = agePattern.matcher(s);
            if (nameMatcher.find()) {
                name = nameMatcher.group().split("\\s");
            } else continue;
            if (emailMatcher.find()) {
                email = emailMatcher.group();
            } else continue;
            if (phoneMatcher.find()) {
                phone = phoneMatcher.group();
            } else continue;
            if (ageMatcher.find()) {
                age = Integer.parseInt(ageMatcher.group());
            } else continue;
            userList.add(new User(name[0], name[1], email, phone, age));
        }
        return userList;
    }
}
