package com.example.motoinventoryservice.controller.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "vin-lookup-service")
public interface VinLookupClient {

    @RequestMapping(value = "/vehicle/{vin}", method = RequestMethod.GET)
    public Map<String, String> getVehicleInformation(@PathVariable String vin);

}
