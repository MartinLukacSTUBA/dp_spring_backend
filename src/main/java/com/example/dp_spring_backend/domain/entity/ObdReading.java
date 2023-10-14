package com.example.dp_spring_backend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Entity
@Table(name = "obd_readings")
public class ObdReading implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Version
    private long version;
    private double latitude, longitude;
    private long timestamp;

    @Column(name = "vin", nullable = false)
    private String vin;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> readings;

    public ObdReading() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setReadings(Map<String, String> readings) {
        this.readings = readings;
    }

}
