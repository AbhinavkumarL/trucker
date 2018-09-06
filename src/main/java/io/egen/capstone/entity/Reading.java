package io.egen.capstone.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reading implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer readingId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "vin")
//    private Vehicle vehicle;
    private String vin;
    private Float fuelVolume;
    private Integer speed;
    private Integer engineHp;
    private Boolean checkEngineLightOn;
    private Boolean engineCoolantLow;
    private Boolean cruiseControlOn;
    private Integer engineRpm;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tireId")
    private Tire tire;

//
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "locationId")
//    private Location location;


    public Reading() {
    }

    public Reading(String vin, Float fuelVolume, Integer speed, Integer engineHp, Boolean checkEngineLightOn,
                   Boolean engineCoolantLow, Boolean cruiseControlOn, Integer engineRpm) {

        this.vin = vin;
        this.fuelVolume = fuelVolume;
        this.speed = speed;
        this.engineHp = engineHp;
        this.checkEngineLightOn = checkEngineLightOn;
        this.engineCoolantLow = engineCoolantLow;
        this.cruiseControlOn = cruiseControlOn;
        this.engineRpm = engineRpm;
    }

    public Integer getReadingId() {
        return readingId;
    }

    public void setReadingId(Integer readingId) {
        this.readingId = readingId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    //    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    public Float getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(Float fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(Integer engineHp) {
        this.engineHp = engineHp;
    }

    public Boolean getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(Boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public Boolean getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(Boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public Boolean getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(Boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public Integer getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(Integer engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }

//    @Override
//    public String toString() {
//        return "Reading{" +
//                "readingId=" + readingId +
//                ", vin='" + vin + '\'' +
//                ", fuelVolume=" + fuelVolume +
//                ", speed=" + speed +
//                ", engineHp=" + engineHp +
//                ", checkEngineLightOn=" + checkEngineLightOn +
//                ", engineCoolantLow=" + engineCoolantLow +
//                ", cruiseControlOn=" + cruiseControlOn +
//                ", engineRpm=" + engineRpm +
//                ", tire=" + tire +
////                ", location=" + location +
//                '}';
//    }
}
