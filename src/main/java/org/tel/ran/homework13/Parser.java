package org.tel.ran.homework13;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public final class Parser {

    private Parser() {
    }

    public static Set<Product> parseProductsFromFile(Path path) {

        JSONArray jsonArray = new JSONArray(readFile(path));
        Set<Product> productSet = new HashSet<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                productSet.add(parseJsonObjectToProduct(jsonObject));

            } catch (Exception e) {
                logExceptionToFile(e);
            }
        }
        return productSet;
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
            logExceptionToFile(e);
        }
        return sb.toString();
    }

    private static void logExceptionToFile(Exception e) {
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

    private static Product parseJsonObjectToProduct(JSONObject jsonObject) {
        String[] idAndName = jsonObject.get("NAME").toString().split("#");
        int id = Integer.parseInt(idAndName[1]);
        return new Product()
                .setId(id)
                .setProductCategory(ProductCategory.valueOf(jsonObject.get("CATEGORY").toString().replace("#" + id, "")))
                .setName(idAndName[0])
                .setFactory(jsonObject.get("FACTORY").toString().replace("#" + id, ""))
                .setQuantity(Integer.parseInt(jsonObject.get("QUANTITY").toString()))
                .setPacked(Boolean.parseBoolean(jsonObject.get("ISPACKED").toString()))
                .setAdv(Boolean.parseBoolean(jsonObject.get("ISADV").toString()))
                .setPrice(Double.parseDouble(jsonObject.get("PRICE").toString()))
                .setMargin(Double.parseDouble(jsonObject.get("MARGIN").toString()))
                .setDebt(Boolean.parseBoolean(jsonObject.get("ISDEBT").toString()));
    }
}
