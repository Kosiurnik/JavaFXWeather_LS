package sda.lukaszs.weatherfx.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String name;
    private String region;
    private String country;
    private double lat;
    private long lon;
    private String tzID;
    private long localtimeEpoch;
    private String localtime;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("region")
    public String getRegion() { return region; }
    @JsonProperty("region")
    public void setRegion(String value) { this.region = value; }

    @JsonProperty("country")
    public String getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("lat")
    public double getLat() { return lat; }
    @JsonProperty("lat")
    public void setLat(double value) { this.lat = value; }

    @JsonProperty("lon")
    public long getLon() { return lon; }
    @JsonProperty("lon")
    public void setLon(long value) { this.lon = value; }

    @JsonProperty("tz_id")
    public String getTzID() { return tzID; }
    @JsonProperty("tz_id")
    public void setTzID(String value) { this.tzID = value; }

    @JsonProperty("localtime_epoch")
    public long getLocaltimeEpoch() { return localtimeEpoch; }
    @JsonProperty("localtime_epoch")
    public void setLocaltimeEpoch(long value) { this.localtimeEpoch = value; }

    @JsonProperty("localtime")
    public String getLocaltime() { return localtime; }
    @JsonProperty("localtime")
    public void setLocaltime(String value) { this.localtime = value; }
}
