package forecast;

import java.util.Objects;

public class Wind {

    private Float speed;
    private Float deg;
    private Float gust;

    private Wind() {
    }

    public Float getSpeed() {
        return speed;
    }

    public Float getDeg() {
        return deg;
    }

    public Float getGust() {
        return gust;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wind wind = (Wind) o;
        return Objects.equals(speed, wind.speed) && Objects.equals(deg, wind.deg) && Objects.equals(gust, wind.gust);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, deg, gust);
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust +
                '}';
    }
}
