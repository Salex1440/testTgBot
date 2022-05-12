package forecast;

import java.util.Objects;

public class SysInfo {

    private Integer type;
    private Long id;
    private String country;
    private Long sunrise;
    private Long sunset;

    private SysInfo() {
    }

    public Integer getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysInfo sysInfo = (SysInfo) o;
        return Objects.equals(type, sysInfo.type) && id.equals(sysInfo.id) && Objects.equals(country, sysInfo.country) && Objects.equals(sunrise, sysInfo.sunrise) && Objects.equals(sunset, sysInfo.sunset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, country, sunrise, sunset);
    }

    @Override
    public String toString() {
        return "SysInfo{" +
                "type=" + type +
                ", id=" + id +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
