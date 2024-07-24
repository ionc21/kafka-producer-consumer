package trackunit.pipeline.dto;

public record Revenue(double revenue) implements Comparable<Revenue> {
    @Override
    public int compareTo(Revenue other) {
        return Double.compare(this.revenue, other.revenue);
    }
}
