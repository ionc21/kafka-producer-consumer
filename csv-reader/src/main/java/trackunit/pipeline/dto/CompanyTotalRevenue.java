package trackunit.pipeline.dto;

import java.util.Comparator;
import java.util.Map;

public record CompanyTotalRevenue(Company company, TotalRevenue totalRevenue) {
    public CompanyTotalRevenue(Map.Entry<Company, TotalRevenue> entry) {
        this(entry.getKey(), entry.getValue());
    }

    public static Comparator<? super CompanyTotalRevenue> compareByValue() {
        return Comparator.comparing(CompanyTotalRevenue::totalRevenue);
    }
}
