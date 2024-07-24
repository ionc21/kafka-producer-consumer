package trackunit.pipeline.dto;

import java.util.Comparator;
import java.util.stream.*;

public record Data(int year, Company company, Revenue revenue, int rank) {

    public static Stream<Data> of(Line line) {
        try {
            return Stream.of(new Data(line.year(), new Company(line.name()), new Revenue(line.revenue()), line.rank()));
        } catch (NumberFormatException nfe) {
            return Stream.empty();
        }
    }

    public static Comparator<? super Data> compareByRevenue() {
        return Comparator.comparing(Data::revenue);
    }

    public static Collector<Data, Object, TotalRevenue> sumRevenue() {
        return Collectors.collectingAndThen(
                Collectors.summingDouble(data -> data.revenue.revenue()),
                TotalRevenue::new
        );
    }
}
