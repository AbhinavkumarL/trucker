package io.egen.capstone.entity;

import javax.annotation.Generated;
import javax.persistence.*;

public class VechileLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationId;

    private String latitude;
    private String longitude;
    private String timestamp;

    @ManyToOne
    @JoinColumn(name="vehicleVin")
    private Vehicle vehicle;
}
