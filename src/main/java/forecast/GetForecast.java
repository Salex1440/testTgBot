package forecast;

import java.util.Objects;

public class GetForecast {

    private Coordinates coord;
    private Weather[] weather;
    private String base;
    private MainInfo main;
    private Long visibility;
    private Wind wind;
    private Clouds clouds;
    private Long dt;
    private SysInfo sys;
    private Integer timezone;
    private Long id;
    private String name;
    private Integer cod;

    private GetForecast(){
    }

    public Coordinates getCoord() {
        return coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public MainInfo getMain() {
        return main;
    }

    public Long getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Long getDt() {
        return dt;
    }

    public SysInfo getSys() {
        return sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return "GetForecast{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
