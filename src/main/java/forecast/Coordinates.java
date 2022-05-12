package forecast;

import java.util.Objects;

public class Coordinates {

    private Double lon;
    private Double lat;

    private Coordinates() {
    }

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(lon, that.lon) && Objects.equals(lat, that.lat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lon, lat);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
