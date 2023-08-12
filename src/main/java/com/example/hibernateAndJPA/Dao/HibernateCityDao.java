package com.example.hibernateAndJPA.Dao;

import com.example.hibernateAndJPA.Entities.City;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HibernateCityDao implements ICityDao {

    //CrudRepository crudRepository; // crud için kullanışlı veya JpaRepository. ama EntityManager zaten JPA'nın impl'i.
    //City city = cityRepository.findById(1).orElse(null); //orElse, nullPointer hatalarını engellemek için java8 sonrası var.
    private EntityManager entityManager;


    @Autowired
    public HibernateCityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<City> cities= session.createQuery("from City ",City.class).getResultList();
        return cities;
    }

    @Override
    public void add(City city) { //Id 'si bulunan bir city gelirse update, id'si bulunmayan bir city gelirse ekler.
        Session session = entityManager.unwrap(Session.class);
        session.merge(city); // session.saveOrUpdate(entity); // Deprecated
    }

    @Override
    public void update(City city) {

    }

    @Override
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(city);


    } // hibernate için sessionfactory ve session ile yapıyorduk. artık jpa

    @Override
    public City getById(int id){
        Session session= entityManager.unwrap(Session.class);
        City city=session.get(City.class,id);
        return city;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
