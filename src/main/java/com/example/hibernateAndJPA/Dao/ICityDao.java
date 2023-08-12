package com.example.hibernateAndJPA.Dao;

import com.example.hibernateAndJPA.Entities.City;

import java.util.List;

public interface ICityDao {
    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);

    City getById(int id);


}
