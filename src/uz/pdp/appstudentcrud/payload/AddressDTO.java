package uz.pdp.appstudentcrud.payload;

import uz.pdp.appstudentcrud.entity.Address;
import uz.pdp.appstudentcrud.entity.Group;

public class AddressDTO{

    private String city;
    private String region;
    private String street;
    private Integer id;

    public AddressDTO(String city, String region, String street, Integer id) {
        this.city = city;
        this.region = region;
        this.street = street;
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", street='" + street + '\'' +
                ", id=" + id +
                '}';
    }
}
