package com.example.hibernateAndJPA.Service;

import com.example.hibernateAndJPA.Dao.ICityDao;
import com.example.hibernateAndJPA.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService implements ICityService{

    private ICityDao cityDao;

    @Autowired
    public CityService(ICityDao cityDao) {
        this.cityDao=cityDao;
    }

    @Transactional //AOP tekniklerini gerçekleştir.
    @Override
    public List<City> getAll() {
        return this.cityDao.getAll();
    }
    @Transactional

    @Override
    public void add(City city) {
        this.cityDao.add(city);
    }
    @Transactional
    @Override
    public void update(City city) {

    }

    @Transactional
    @Override
    public void delete(City city) {
this.cityDao.delete(city);
    }

    @Override
    @Transactional
    public City getById(int id) {
        return this.cityDao.getById(id);
    }
}
