package com.example.motoinventoryservice.service;

import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.model.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ServiceLayer {

    private MotoInventoryDao motoInventoryDao;

    @Autowired
    public ServiceLayer(MotoInventoryDao motoInventoryDao) {
        this.motoInventoryDao = motoInventoryDao;
    }

    @Transactional
    public Motorcycle saveMotorcyle(Motorcycle motorcycle) {
        motorcycle = motoInventoryDao.addMotorcycle(motorcycle);
        return motorcycle;
    }

    public Motorcycle findMotorcycle(int motoId) {
        return motoInventoryDao.getMotorcycle(motoId);
    }

    public void removeMotorcycle(int motoId) {
        motoInventoryDao.deleteMotorcycle(motoId);
    }

    public void updateMotorcycle(Motorcycle motorcycle) {
        motoInventoryDao.updateMotorcycle(motorcycle);
    }

    public List<Motorcycle> findAllMotorcycles() {
        return motoInventoryDao.getAllMotorcycles();
    }


}
