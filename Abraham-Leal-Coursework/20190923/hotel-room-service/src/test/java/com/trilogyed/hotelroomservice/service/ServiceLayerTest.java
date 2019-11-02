package com.trilogyed.hotelroomservice.service;

import com.trilogyed.hotelroomservice.models.Rewards;
import com.trilogyed.hotelroomservice.models.Room;
import com.trilogyed.hotelroomservice.util.feign.RewardsServiceClient;
import com.trilogyed.hotelroomservice.util.feign.RoomServiceClient;
import com.trilogyed.hotelroomservice.viewmodel.HotelRoomViewModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    private ServiceLayer service;
    private RewardsServiceClient rewardsServiceClient;
    private RoomServiceClient roomServiceClient;

    private static final Room room = new Room(304, "king", (float)229.0);
    private static final Rewards reward = new Rewards(3, "king", (float).2, 300, true);

    @Before
    public void setUp() throws Exception {
        setUpRoomFeignClientMock();
        setUpRewardsFeignClientMock();
        service = new ServiceLayer(roomServiceClient, rewardsServiceClient);
    }

    @Test
    public void findRoom() {

        HotelRoomViewModel hvm = new HotelRoomViewModel();
        hvm.setRoomId(304);
        hvm.setRewardsMember(true);
        hvm.setDoubleBonusDay(true);
        hvm.setBaseRate((float)229.0);
        hvm.setMemberDiscount((float).2);
        hvm.setBaseRewardsPoints(300);
        hvm.setCanDouble(true);
        hvm.setFinalCost((float)183.2);
        hvm.setTotalRewardsPoints(600);

        HotelRoomViewModel hvm2 = service.findRoom(304, true, true);

        assertEquals(hvm, hvm2);

    }

    private void setUpRoomFeignClientMock() {
        roomServiceClient = mock(RoomServiceClient.class);

        doReturn(room).when(roomServiceClient).getRoom(304);

    }

    private void setUpRewardsFeignClientMock() {
        rewardsServiceClient = mock(RewardsServiceClient.class);

        doReturn(reward).when(rewardsServiceClient).getRewards("king");
    }
}