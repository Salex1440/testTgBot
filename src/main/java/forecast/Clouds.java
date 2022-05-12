package forecast;

import java.util.Objects;

public class Clouds {

    private Integer all;

    private Clouds() {
    }

    public Integer getAll() {
        return all;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clouds clouds = (Clouds) o;
        return Objects.equals(all, clouds.all);
    }

    @Override
    public int hashCode() {
        return Objects.hash(all);
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
