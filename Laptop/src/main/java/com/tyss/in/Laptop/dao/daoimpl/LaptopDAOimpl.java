package com.tyss.in.Laptop.dao.daoimpl;

import com.tyss.in.Laptop.dao.LaptopDAO;
import com.tyss.in.Laptop.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
public class LaptopDAOimpl implements LaptopDAO {

    private final EntityManager theManager;
@Autowired
    public LaptopDAOimpl(EntityManager theManager)
    {
        this.theManager=theManager;
    }

    @Override
    @Transactional
    public void save(Laptop theLaptop) {
    theManager.persist(theLaptop);
    }

    @Override
    public Laptop findById(int theId) {
        return theManager.find(Laptop.class,theId);
    }

    @Override
    public Laptop findByBrand(String theBrand) {
        return null;
    }

    @Override
    public Laptop findByImei(long theImei) {

        Query q = theManager.createQuery("SELECT e FROM Laptop e WHERE e.imei = :imei");
        q.setParameter("imei", theImei);

        return (Laptop) q.getSingleResult();
    }

    @Override
    public List<Laptop> fetchAll() {
        Query q=theManager.createQuery("Select l from Laptop l");
        return q.getResultList();
    }

    @Override
    @Transactional
    public void updateRam(int Id) {
        Scanner sc = new Scanner(System.in);
        Laptop foundLaptop = theManager.find(Laptop.class,Id);
        if (foundLaptop==null)
        {
            System.out.println("Laptop not Found");
        }else {
            System.out.println("Upgrade the RAM : ");
            foundLaptop.setRam(sc.next());
        }
    }

    @Override
    @Transactional
    public void updateRom(int Id) {
        Scanner sc = new Scanner(System.in);
        Laptop foundLaptop = theManager.find(Laptop.class,Id);
        if (foundLaptop==null)
        {
            System.out.println("Laptop not Found");
        }else {
            System.out.println("Upgrade the ROM : ");
            foundLaptop.setRom(sc.next());
        }
    }
    public void update(int Id)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the choice Code Wanted to make an Update");
        System.out.println("1. Update RAM");
        System.out.println("1. Update ROM");

        int choice =sc.nextInt() ;
        switch (choice){
            case 1:
                updateRam(Id);
                break;
            case 2:
                updateRom(Id);
                break;
            default:
                System.out.println("Invalid Choice Code");
        }
    }

    @Override
    @Transactional
    public void remove(int Id) {

    }
}
