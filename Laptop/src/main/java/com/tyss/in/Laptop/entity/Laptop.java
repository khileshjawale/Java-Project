package com.tyss.in.Laptop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String brand;

    private long imei;

    private String processor;

    private String ram;

    private String rom;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public Laptop(String brand, long imei, String processor, String ram, String rom) {
        this.brand = brand;
        this.imei = imei;
        this.processor = processor;
        this.ram = ram;
        this.rom = rom;
    }

    public Laptop(){}

    @Override
    public String toString() {
        return "Laptop{" +
                "Id=" + Id +
                ", brand='" + brand + '\'' +
                ", imei=" + imei +
                ", processor='" + processor + '\'' +
                ", ram='" + ram + '\'' +
                ", rom='" + rom + '\'' +
                '}';
    }
}
