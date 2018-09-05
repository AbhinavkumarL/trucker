package io.egen.capstone.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int alertId;

    private String priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VehicleVin")
    private Vehicle VehicleVin;

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Vehicle getVehicleVin() {
        return VehicleVin;
    }

    public void setVehicleVin(Vehicle vehicleVin) {
        VehicleVin = vehicleVin;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertId=" + alertId +
                ", priority='" + priority + '\'' +
                ", VehicleVin=" + VehicleVin +
                '}';
    }
}
