package io.egen.capstone.controller;

import io.egen.capstone.entity.Vehicle;
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
            @ApiResponse(code=200, message = "Data Inserted"),
            @ApiResponse(code=500, message = "Internal Server Error")
    })
    public List<Vehicle> findAll() {
        return vehicleService.findAll();
    }
}
