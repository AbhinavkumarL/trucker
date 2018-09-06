package io.egen.capstone.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer alertId;
    private String priority;
    private String category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vin")
    private Vehicle vehicle;

    public Alert() {

    }

    public Alert(String priority, String category, Vehicle vehicle){
        this.priority = priority;
        this.category = category;
        this.vehicle = vehicle;
    }

    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertId=" + alertId +
                ", priority='" + priority + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
