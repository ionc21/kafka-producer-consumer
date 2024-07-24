package trackunit.pipeline.dto;

import java.util.Arrays;

public record Line(String[] elements) {

    public Line {
        elements = Arrays.copyOf(elements, elements.length);
    }

    public Line(String line) {
        this(line.split(","));
    }

    public String[] elements() {
        return Arrays.copyOf(elements, elements.length);
    }

    public boolean isNotComment() {
        return !elements[0].startsWith("#");
    }

    public int year() {
        return Integer.parseInt(elements[0]);
    }

    public String name() {
        return elements[1];
    }

    public Double revenue() {
        return Double.parseDouble(elements[2]);
    }

    public int rank() {
        return Integer.parseInt(elements[3]);
    }
}
