package com.example.hibernateAndJPA.Service;

import com.example.hibernateAndJPA.Entities.City;

import java.util.List;

public interface ICityService {
    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);
}
