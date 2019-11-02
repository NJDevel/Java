package com.example.motoinventoryservice.controller;

import com.example.motoinventoryservice.controller.util.feign.VinLookupClient;
import com.example.motoinventoryservice.model.Motorcycle;
import com.example.motoinventoryservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class MotoInventoryController {

    @Autowired
    private ServiceLayer serviceLayer;

    @Autowired
    private final VinLookupClient client;

    MotoInventoryController(VinLookupClient client) {
        this.client = client;
    }

    @RequestMapping(value = "/vehicle/{vin}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, String> getVehicleInformation(@PathVariable String vin) {

        return client.getVehicleInformation(vin);
    }

    @RequestMapping(value = "/motorcycles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Motorcycle createMotorcycle(@RequestBody @Valid Motorcycle motorcycle) {

        return serviceLayer.saveMotorcyle(motorcycle);
    }

    @RequestMapping(value = "/motorcycles", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Motorcycle> findAllMotorcycles() {

        return serviceLayer.findAllMotorcycles();
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Motorcycle getMotorcycle(@PathVariable int motoId) {
        if (motoId < 1) {
           throw new IllegalArgumentException("MotoId must be greater than 0.");
        }
            return serviceLayer.findMotorcycle(motoId);
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMotorcycle(@PathVariable("motoId") int motoId) {

        serviceLayer.removeMotorcycle(motoId);
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateMotorcycle(@RequestBody @Valid Motorcycle motorcycle, @PathVariable int motoId) {
        if (motoId != motorcycle.getId()) {
            throw new IllegalArgumentException("Motorcycle ID on path must match the ID in the Motorcycle object.");
        }
       serviceLayer.updateMotorcycle(motorcycle);
    }
/**
Example of Controller routing API without using a non-feign client, constructing URI programmatically
 */
//    @RequestMapping(value = "/vehicle/{vin}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Map<String, String> getVehicleInformation(@PathVariable String vin) {
//        Map<String, String> vehicleInformation = new HashMap();
//        List<ServiceInstance> instances = discoveryClient.getInstances(vinLookupServiceName);
//        String vinServiceURI = serviceProtocol + instances.get(0).getHost()  + ":" +
//                instances.get(0).getPort() + servicePath + vin;
//
//        vehicleInformation = restTemplate.getForObject(vinServiceURI, Map.class);
//        return vehicleInformation;

    /**
     * Required variables for above controller method to work found below
     *     @Autowired
     *     private DiscoveryClient discoveryClient;
     *     private RestTemplate restTemplate = new RestTemplate();
     *     @Value("${vinLookupServiceName}")
     *     private String vinLookupServiceName;
     *     @Value("${serviceProtocol}")
     *     private String serviceProtocol;
     *     @Value("${servicePath}")
     *     private String servicePath;
     */
}
