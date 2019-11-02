package com.trilogyed.hotelroomservice.util.feign;

import com.trilogyed.hotelroomservice.models.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "room-service")
public interface RoomServiceClient {

    @RequestMapping(value = "/room/{number}", method = RequestMethod.GET)
    public Room getRoom(@PathVariable int number);

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public List<Room> getAllRooms();
}
