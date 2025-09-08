package com.tyss.in.Laptop.dao;

import com.tyss.in.Laptop.entity.Laptop;

import java.util.List;

public interface LaptopDAO {

    public void save(Laptop theLaptop);

    public Laptop findById(int theId);

    public  Laptop findByBrand(String theBrand);

    public Laptop findByImei(long theImei);

    public List<Laptop> fetchAll();

    public void updateRam(int Id);

    public  void updateRom(int Id);

    public void update(int Id);

    public void remove(int Id);


}
