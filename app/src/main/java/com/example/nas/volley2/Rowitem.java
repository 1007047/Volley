package com.example.nas.volley2;

/**
 * Created by NAS on 11/27/2015.
 */
public class Rowitem {

    private String name;
    private String wifi_type;
    private String bssid;
    private String key;
    private String latitude;
    private String longitude;




    private String half;
    private String one;
    private String two;
    private String five;
    private String ten;
    private String twenty;
    private String twenty_four;


    public String getHalf() {
        return half;
    }

    public void setHalf(String half) {
        this.half = half;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTwenty() {
        return twenty;
    }

    public void setTwenty(String twenty) {
        this.twenty = twenty;
    }

    public String getTwenty_four() {
        return twenty_four;
    }

    public void setTwenty_four(String twenty_four) {
        this.twenty_four = twenty_four;
    }

    public Rowitem(String name, String wifi_type, String bssid, String key, String latitude, String longitude, String half, String one, String two, String five, String ten, String twenty, String twenty_four) {

        this.name=name;
        this.wifi_type=wifi_type;

        this.bssid=bssid;
        this.key=key;
        this.latitude=latitude;
        this.longitude=longitude;

        this.half=half;
        this.one=one;
        this.two=two;
        this.five=five;
        this.ten=ten;
        this.twenty=twenty;
        this.twenty_four=twenty_four;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getWifi_type() {
        return wifi_type;
    }

    public void setWifi_type(String wifi_type) {
        this.wifi_type = wifi_type;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public Rowitem(String name,String wifi_type,String bssid,String key,String latitude,String longitude)
    {

        this.name=name;
        this.wifi_type=wifi_type;
        this.bssid=bssid;
        this.key=key;
        this.latitude=latitude;
        this.longitude=longitude;

    }



}