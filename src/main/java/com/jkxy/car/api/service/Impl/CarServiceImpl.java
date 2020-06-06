package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public boolean buyCar(Car car) {
        List<Car> list = carDao.findByCar(car);
        if (list.size() > 0) {
            carDao.deleteById(list.get(0).getId());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Car> findByCarBrand(String brand,int currentPage,int pageSize) {
        String firstName = brand.substring(0,1);
        if (null != firstName) {
            List<Car> list = carDao.findByCarBrand(brand,currentPage,pageSize);
            return list;
        } else {
            return null;
        }
    }

}
