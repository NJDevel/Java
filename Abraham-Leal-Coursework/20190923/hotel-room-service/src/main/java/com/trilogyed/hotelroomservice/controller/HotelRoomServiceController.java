package com.trilogyed.hotelroomservice.controller;

import com.trilogyed.hotelroomservice.service.ServiceLayer;
import com.trilogyed.hotelroomservice.viewmodel.HotelRoomViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class HotelRoomServiceController {

    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value = "/hotelRewards/{roomId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public HotelRoomViewModel requestHotelRoom(@PathVariable int roomId, @RequestParam(value = "rewardsMember")
            boolean rewardsMember, @RequestParam(value = "doubleBonusDay", required = false) boolean doubleBonusDay) {
        HotelRoomViewModel hvm = serviceLayer.findRoom(roomId, rewardsMember, doubleBonusDay);
        return hvm;
    }

}
