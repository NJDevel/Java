package com.example.motoinventoryservice.service;

import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.dao.MotoInventoryDaoJdbcTemplateImpl;
import com.example.motoinventoryservice.model.Motorcycle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    ServiceLayer service;
    MotoInventoryDao motoInventoryDao;

    @Before
    public void setUp() throws Exception {
        setUpMotoInventoryDaoMock();

        service = new ServiceLayer(motoInventoryDao);
    }

    @Test
    public void saveFindDeleteMotorcyle() {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setVin("12345");
        motorcycle.setMake("Honda");
        motorcycle.setModel("Gold Wing");
        motorcycle.setYear("2019");
        motorcycle.setColor("Black");
        motorcycle = service.saveMotorcyle(motorcycle);

        Motorcycle fromService = service.findMotorcycle(motorcycle.getId());

        //Asserts the Save motorcyle and the get motorcyle
        assertEquals(motorcycle, fromService);


        //Test Deletion of motorcycle
        Motorcycle motorcycle1 = new Motorcycle();
        motorcycle1.setId(3);
        motorcycle1.setVin("99887");
        motorcycle1.setMake("Ducati");
        motorcycle1.setModel("Multistrada");
        motorcycle1.setYear("2009");
        motorcycle1.setColor("Yellow");

        service.saveMotorcyle(motorcycle1);
        service.removeMotorcycle(3);
        motorcycle = service.findMotorcycle(3);

        assertNull(motorcycle);

    }

    @Test
    public void updateMotorcycle() {
        Motorcycle motorcycle1 = new Motorcycle();
        motorcycle1 = service.findMotorcycle(2);

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setId(2);
        motorcycle.setVin("54321");
        motorcycle.setMake("Ducati");
        motorcycle.setModel("Hypermotard");
        motorcycle.setYear("2015");
        motorcycle.setColor("Red");

        service.updateMotorcycle(motorcycle);

        assertEquals(motorcycle, motorcycle1);

    }

    @Test
    public void findAllMotorcycles() {
        assertEquals(1, service.findAllMotorcycles().size());
    }

    private void setUpMotoInventoryDaoMock() {
        motoInventoryDao = mock(MotoInventoryDaoJdbcTemplateImpl.class);
        //Mock saving a motorcycle
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setId(1);
        motorcycle.setVin("12345");
        motorcycle.setMake("Honda");
        motorcycle.setModel("Gold Wing");
        motorcycle.setYear("2019");
        motorcycle.setColor("Black");

        Motorcycle motorcycle1 = new Motorcycle();
        motorcycle1.setVin("12345");
        motorcycle1.setMake("Honda");
        motorcycle1.setModel("Gold Wing");
        motorcycle1.setYear("2019");
        motorcycle1.setColor("Black");

        doReturn(motorcycle).when(motoInventoryDao).addMotorcycle(motorcycle1);

        //Mock getting all motorcycles
        List<Motorcycle> motoList = new ArrayList<>();
        motoList.add(motorcycle);

        doReturn(motoList).when(motoInventoryDao).getAllMotorcycles();

        //Mock the get motorcycle
        doReturn(motorcycle).when(motoInventoryDao).getMotorcycle(1);

        //Mock update
        Motorcycle motorcycleUpdate = new Motorcycle();
        motorcycleUpdate.setId(2);
        motorcycleUpdate.setVin("54321");
        motorcycleUpdate.setMake("Ducati");
        motorcycleUpdate.setModel("Hypermotard");
        motorcycleUpdate.setYear("2015");
        motorcycleUpdate.setColor("Red");

        doNothing().when(motoInventoryDao).updateMotorcycle(motorcycleUpdate);
        doReturn(motorcycleUpdate).when(motoInventoryDao).getMotorcycle(2);

        //Mock delete
        Motorcycle motorcycleDelete = new Motorcycle();
        motorcycleDelete.setId(3);
        motorcycleDelete.setVin("99887");
        motorcycleDelete.setMake("Ducati");
        motorcycleDelete.setModel("Multistrada");
        motorcycleDelete.setYear("2009");
        motorcycleDelete.setColor("Yellow");

        doNothing().when(motoInventoryDao).deleteMotorcycle(3);
        doReturn(null).when(motoInventoryDao).getMotorcycle(3);

    }
}