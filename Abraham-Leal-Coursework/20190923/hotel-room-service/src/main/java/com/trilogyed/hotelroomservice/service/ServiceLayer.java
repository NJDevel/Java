package com.trilogyed.hotelroomservice.service;

import com.trilogyed.hotelroomservice.models.Rewards;
import com.trilogyed.hotelroomservice.models.Room;
import com.trilogyed.hotelroomservice.util.feign.RewardsServiceClient;
import com.trilogyed.hotelroomservice.util.feign.RoomServiceClient;
import com.trilogyed.hotelroomservice.viewmodel.HotelRoomViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    @Autowired
    private RoomServiceClient roomServiceClient;
    @Autowired
    private RewardsServiceClient rewardsServiceClient;

    @Autowired
    public ServiceLayer(RoomServiceClient roomServiceClient, RewardsServiceClient rewardsServiceClient) {
        this.roomServiceClient = roomServiceClient;
        this.rewardsServiceClient = rewardsServiceClient;
    }

    public HotelRoomViewModel findRoom(Integer roomId, Boolean rewardsMember, Boolean doubleBonusDay){
        Room room = roomServiceClient.getRoom(roomId);
        Rewards rewards = rewardsServiceClient.getRewards(room.getRoomType());

        //Build Hotel Room View Model
        HotelRoomViewModel hvm = new HotelRoomViewModel();
        hvm.setRoomId(roomId);
        //Check if customer is a rewards member
        hvm.setRewardsMember(isRewardsMember(rewardsMember));
        //Check if it is a double bonus day
        hvm.setDoubleBonusDay(isDoubleBounusDay(doubleBonusDay));
        hvm.setCanDouble(rewards.getCanDouble());

        hvm.setBaseRate(room.getBaseRate());
        hvm.setMemberDiscount(rewards.getDiscount());
        hvm.setBaseRewardsPoints(rewards.getPoints());
        hvm.setTotalRewardsPoints(getRewardPoints(hvm));
        hvm.setFinalCost(getFinalCost(hvm));

        return hvm;
    }

    //isRewardsMemeber
    private Boolean isRewardsMember(Boolean rewardsMember) {
        if(rewardsMember == true) {
            return true;
        } else if(rewardsMember == null) {
            return false;
        }
            return false;
    }

    //dayIsDoubleBonusDay
    private Boolean isDoubleBounusDay(Boolean doubleBonusDay) {
        if(doubleBonusDay == true) {
            return true;
        } else if(doubleBonusDay == null) {
            return false;
        } else
            return false;
    }

    //Rewards point calculation
    private Integer getRewardPoints(HotelRoomViewModel hvm){
        Integer rewardPoints = 0;
        //If rewardsMember is false, totalRewardPoints is 0.
        if(hvm.getRewardsMember() == false) {
            return 0;
        //If doubleBonusDay is true and canDouble is true on the room, totalRewardsPoints is baseRewardsPoints * 2.
        }
        if(hvm.getDoubleBonusDay() == true && hvm.getCanDouble() == true)
            rewardPoints = hvm.getBaseRewardsPoints() * 2;
            return rewardPoints;
    }

    private Float getFinalCost(HotelRoomViewModel hvm) {
        //If rewardsMember is true, finalCost is baseRate * (1 - memberDiscount)
        if(hvm.getRewardsMember() == true) {
            return hvm.getBaseRate() * (1 - hvm.getMemberDiscount());
        } else
            return hvm.getBaseRate();
    }
}
