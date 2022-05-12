package forecast;

import java.util.Objects;

public class Weather {

    private Long id;
    private String main;
    private String description;
    private String icon;

    private Weather() {
    }

    public Long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(id, weather.id) && Objects.equals(main, weather.main) && Objects.equals(description, weather.description) && Objects.equals(icon, weather.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, main, description, icon);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
