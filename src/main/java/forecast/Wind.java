package forecast;

import java.util.Objects;

public class Wind {

    private Integer speed;
    private Integer deg;
    private Integer gust;

    private Wind() {
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public Integer getGust() {
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
