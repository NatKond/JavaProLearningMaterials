package org.tel.ran.homework13;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("files/ReportTest.json");
        Set<Product> productSet = Parser.parseProducts(Parser.readFile(path));
        Service service = new Service(productSet);
        service.getProducts().forEach(System.out::println);
        System.out.println();

        service = new Service(Parser.parseProducts(Parser.readFile(Paths.get("files/shortReportTest.json"))));
        service.getProducts().forEach(System.out::println);
    }
}
