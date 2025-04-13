package org.tel.ran.homework13;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Parser {

    private static final Map<String, ProductCategory> PRODUCT_CATEGORY_MAP = Map.of("FOOD", ProductCategory.FOOD, "DRINKS", ProductCategory.DRINKS, "SNACKS", ProductCategory.SNACKS);

    private Parser() {
    }

    public static String readFile(Path path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                sb.append(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static Set<Product> parseProducts(String jsonArrayString) {
        JSONArray jsonArray = new JSONArray(jsonArrayString);
        Set<Product> productSet = new HashSet<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ProductCategory category = PRODUCT_CATEGORY_MAP.get(jsonObject.get("CATEGORY").toString().replaceAll("#\\d+", ""));
                String name = jsonObject.get("NAME").toString().replaceAll("#\\d+", "");
                String factory = jsonObject.get("FACTORY").toString().replaceAll("#\\d+", "");
                int quantity = Integer.parseInt(jsonObject.get("QUANTITY").toString());
                boolean isPacked = Boolean.parseBoolean(jsonObject.get("ISPACKED").toString());
                boolean isAdv = Boolean.parseBoolean(jsonObject.get("ISADV").toString());
                double price = Double.parseDouble(jsonObject.get("PRICE").toString());
                double margin = Double.parseDouble(jsonObject.get("MARGIN").toString());
                boolean isDebt = Boolean.parseBoolean(jsonObject.get("ISDEBT").toString());
                productSet.add(new Product(category, name, factory, quantity, isPacked, isAdv, price, margin, isDebt));
            } catch (Exception e) {
                logExceptionToFile(e);
            }
        }
        return productSet;
    }

    public static void logExceptionToFile(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String stackTraceAsString = sw.toString();
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("files/error_log.txt"))) {
            bufferedWriter.write(stackTraceAsString);
        } catch (IOException ioException) {
            e.printStackTrace();
        }
    }
}
