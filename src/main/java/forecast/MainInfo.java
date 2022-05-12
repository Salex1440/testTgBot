package forecast;

import java.util.Objects;

public class MainInfo {

    private Integer temp;
    private Integer feels_like;
    private Integer temp_min;
    private Integer temp_max;
    private Integer pressure;
    private Integer humidity;
    private Integer sea_level;
    private Integer grnd_level;

    private MainInfo() {
    }

    public Integer getTemp() {
        return temp;
    }

    public Integer getFeels_like() {
        return feels_like;
    }

    public Integer getTemp_min() {
        return temp_min;
    }

    public Integer getTemp_max() {
        return temp_max;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getSea_level() {
        return sea_level;
    }

    public Integer getGrnd_level() {
        return grnd_level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainInfo mainInfo = (MainInfo) o;
        return Objects.equals(temp, mainInfo.temp) && Objects.equals(feels_like, mainInfo.feels_like) && Objects.equals(temp_min, mainInfo.temp_min) && Objects.equals(temp_max, mainInfo.temp_max) && Objects.equals(pressure, mainInfo.pressure) && Objects.equals(humidity, mainInfo.humidity) && Objects.equals(sea_level, mainInfo.sea_level) && Objects.equals(grnd_level, mainInfo.grnd_level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temp, feels_like, temp_min, temp_max, pressure, humidity, sea_level, grnd_level);
    }

    @Override
    public String toString() {
        return "MainInfo{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", sea_level=" + sea_level +
                ", grnd_level=" + grnd_level +
                '}';
    }
}
