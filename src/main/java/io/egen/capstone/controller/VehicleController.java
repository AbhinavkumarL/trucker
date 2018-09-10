package io.egen.capstone.controller;

import io.egen.capstone.entity.Location;
import io.egen.capstone.entity.Vehicle;
import io.egen.capstone.service.LocationServiceImpl;
import io.egen.capstone.service.VehicleService;
import io.egen.capstone.service.VehicleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/vehicles")
@Api(description="vehicle Endpoints")
public class VehicleController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @Autowired
    private LocationServiceImpl locationService;

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Puts mock vehicle details to the DataBase",
                    notes = "Accepts an Array of Vehicles List")
    @ApiResponses({
            @ApiResponse(code=200, message = "Data Inserted"),
            @ApiResponse(code=500, message = "Internal Server Error")
    })
    public void insertListVehicles(@RequestBody List<Vehicle> vehicleList) {
        vehicleService.insertListVehicles(vehicleList);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get List of all vehicles",
            notes = "No input, Out put is a List of vehicles")
    @ApiResponses({
            @ApiResponse(code=200, message = "All Vehicles Fetched"),
            @ApiResponse(code=500, message = "Internal Server Error")
    })
    public List<Vehicle> findAll() {
        return vehicleService.findAll();
    }

    @RequestMapping(path = "high-alerts",method = RequestMethod.GET)
    @ApiOperation(value = "Fetch HIGH alert vehicles with in last 2 hours and sort them based on time",
                    notes = "Not input, Out put is a List of vehicles with all necessary details")
    @ApiResponses({
            @ApiResponse(code=200, message = "HIGH Alert Vehicles"),
            @ApiResponse(code=500, message = "Internal Server Error")
    })
    public List<Vehicle> findHighAlertVehicles(){
        return vehicleService.findHighAlertVehicles();
    }


    @RequestMapping(path = "geoLocation/{vin}",method = RequestMethod.GET)
    @ApiOperation(value = "List vehicle`s GeoLocation within last 30 minutes",
            notes = "Input : vehicle Vin as path parma to fetch vehicle`s geo location in the last 30 minutes")
    @ApiResponses({
            @ApiResponse(code=200, message = "Geo Location fetched"),
            @ApiResponse(code=500, message = "Internal Server Error")
    })
    public List<Location> findByVinLast30Mins(@PathVariable("vin") String vin){
        return locationService.findByVinLast30Mins(vin);
    }
}
