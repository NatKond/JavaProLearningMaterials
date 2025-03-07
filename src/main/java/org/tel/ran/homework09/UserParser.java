package org.tel.ran.homework09;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserParser {
    public static List<User> parseUsers(String text) {
        String[] usersData = text.replaceAll("\\s+\\[User]", "\n").trim().split("\n{2,}");
        List<User> userList = new ArrayList<>();
        for (String s : usersData) {
            String[] userData = s.split("\\n");
            String name = getStringByRegex(userData[0],"(?<=Name:\\s)[A-Z][a-z]+\\s[A-Z][a-z]+\\b");
            String email = getStringByRegex(userData[1], "(?<=Email:\\s)[\\w.]{6,}@[\\w.]{3,}\\.(ru|com|net|org|uk)\\b");
            String phone = getStringByRegex(userData[2],"(?<=Phone:\\s)\\+[\\d-]{12,}\\b");
            String age = getStringByRegex(userData[3],"(?<=Age:\\s)\\d{1,2}\\b");
            if (name != null && email != null && phone != null && age != null) {
                userList.add(new User(name.split("\\s")[0], name.split("\\s")[1], email, phone, Integer.parseInt(age)));
            }
        }
        return userList;
    }

    private static String getStringByRegex(String info, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(info);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }
}
