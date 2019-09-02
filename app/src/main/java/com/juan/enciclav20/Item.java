
package com.juan.enciclav20;


import com.orm.SugarRecord;

public class Item  extends SugarRecord {

    private Integer ide;
    private Integer ordenar;
    private String name;
    private String address;
    private String description;
    private String lat;
    private String lon;
    private String type;
    private Integer capacity;
    private Integer bikes;
    private Integer places;
    private String picture;
    private Integer bikesState;
    private Integer placesState;
    private Integer closed;
    private Integer cdo;

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    private Long serial;

    public Item() {
    }

    public void setId(Integer ide) {
        this.ide = ide;
    }


    public Integer getIden() { return ide;   }

    public Item(Integer ide, Integer ordenar, String name, String address, String description, String lat, String lon, String type, Integer capacity, Integer bikes, Integer places, String picture, Integer bikesState, Integer placesState, Integer closed, Integer cdo) {
        this.ide = ide;
        this.ordenar = ordenar;
        this.name = name;
        this.address = address;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
        this.type = type;
        this.capacity = capacity;
        this.bikes = bikes;
        this.places = places;
        this.picture = picture;
        this.bikesState = bikesState;
        this.placesState = placesState;
        this.closed = closed;
        this.cdo = cdo;
    }

    public Integer getOrder() {
        return ordenar;
    }

    public void setOrder(Integer ordenar) {
        this.ordenar = ordenar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getBikes() {
        return bikes;
    }

    public void setBikes(Integer bikes) {
        this.bikes = bikes;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getBikesState() {
        return bikesState;
    }

    public void setBikesState(Integer bikesState) {
        this.bikesState = bikesState;
    }

    public Integer getPlacesState() {
        return placesState;
    }

    public void setPlacesState(Integer placesState) {
        this.placesState = placesState;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }


    public Integer getCdo() {
        return cdo;
    }

    public void setCdo(Integer cdo) {
        this.cdo = cdo;
    }

}
