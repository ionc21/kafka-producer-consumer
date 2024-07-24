package trackunit.pipeline.dto;

public record TotalRevenue(Double revenue) implements Comparable<TotalRevenue> {
    @Override
    public int compareTo(TotalRevenue other) {
        return Double.compare(this.revenue, other.revenue);
    }
}
