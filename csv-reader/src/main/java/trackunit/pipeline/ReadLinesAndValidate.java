package trackunit.pipeline;

import trackunit.pipeline.dto.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static trackunit.pipeline.dto.Data.sumRevenue;

public class ReadLinesAndValidate {

    public static void main(String[] args) {
        var csvFile = Path.of("csv-reader/files/fortune500.csv");
        var lines = readLines(csvFile);
        System.out.println("#lines: " + lines.size());

        lines.stream().forEach(System.out::println);

        var data = lines.stream()
                .map(Line::new)
                .filter(Line::isNotComment)
                .flatMap(Data::of)
                .toList();
        System.out.println("#data: " + data.size());

        //the company with the highest revenue
        var maxRevenuePerCompany = data.stream()
                .max(Data.compareByRevenue())
                .orElseThrow();
        System.out.println("the company with the highest revenue: " + maxRevenuePerCompany);

        //the company with the highest cumulated revenue
        Map<Company, TotalRevenue> totalRevenuePerCompany = data.stream()
                .collect(Collectors.groupingBy(Data::company, sumRevenue()));

        var maxTotalRevenuePerCompany = totalRevenuePerCompany.entrySet().stream()
                .map(CompanyTotalRevenue::new)
                .max(CompanyTotalRevenue.compareByValue())
                .orElseThrow();

        System.out.println("the company with the highest cumulated revenue: " + maxTotalRevenuePerCompany);
    }

    private static List<String> readLines(Path csvFile) {

        try (var is = Files.newInputStream(csvFile);
             var reader = new BufferedReader(new InputStreamReader(is));
             var stream = reader.lines()) {
            return stream.toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
