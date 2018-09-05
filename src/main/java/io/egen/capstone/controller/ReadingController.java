package io.egen.capstone.controller;

import io.egen.capstone.entity.Reading;
import io.egen.capstone.service.ReadingServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/readings")
@Api(description="Vehicle Readings Endpoints")
public class ReadingController {

    @Autowired
    private ReadingServiceImpl readingService;


    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Posts the real time vehicle feed to Database",
            notes = "Accepts the vehicle readings as a JSON with embaded Tires")
    @ApiResponses({
            @ApiResponse(code=200, message = "Data Inserted"),
            @ApiResponse(code=500, message = "Internal Server Error")
    })
    public Reading vehicleReadings(@RequestBody Reading reading){
        return readingService.create(reading);
    }

}
