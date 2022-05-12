package forecast;

import java.util.Objects;

public class GetForecast {

    private Coordinates coord;
    private Weather weather;
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

    public Weather getWeather() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetForecast that = (GetForecast) o;
        return coord.equals(that.coord) && Objects.equals(weather, that.weather) && Objects.equals(base, that.base) && Objects.equals(main, that.main) && Objects.equals(visibility, that.visibility) && Objects.equals(wind, that.wind) && Objects.equals(clouds, that.clouds) && Objects.equals(dt, that.dt) && Objects.equals(sys, that.sys) && Objects.equals(timezone, that.timezone) && id.equals(that.id) && Objects.equals(name, that.name) && Objects.equals(cod, that.cod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coord, weather, base, main, visibility, wind, clouds, dt, sys, timezone, id, name, cod);
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
