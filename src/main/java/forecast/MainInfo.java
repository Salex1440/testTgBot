package forecast;

import java.util.Objects;

public class MainInfo {

    private Float temp;
    private Float feels_like;
    private Float temp_min;
    private Float temp_max;
    private Float pressure;
    private Float humidity;
    private Float sea_level;
    private Float grnd_level;

    private MainInfo() {
    }

    public Float getTemp() {
        return temp;
    }

    public Float getFeels_like() {
        return feels_like;
    }

    public Float getTemp_min() {
        return temp_min;
    }

    public Float getTemp_max() {
        return temp_max;
    }

    public Float getPressure() {
        return pressure;
    }

    public Float getHumidity() {
        return humidity;
    }

    public Float getSea_level() {
        return sea_level;
    }

    public Float getGrnd_level() {
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
