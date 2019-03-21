package sda.lukaszs.weatherfx.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private Location location;
    private Current current;

    @JsonProperty("location")
    public Location getLocation() { return location; }
    @JsonProperty("location")
    public void setLocation(Location value) { this.location = value; }

    @JsonProperty("current")
    public Current getCurrent() { return current; }
    @JsonProperty("current")
    public void setCurrent(Current value) { this.current = value; }
}
