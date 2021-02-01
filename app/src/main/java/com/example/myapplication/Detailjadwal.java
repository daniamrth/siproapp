package com.example.myapplication;

import com.google.firebase.Timestamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Detailjadwal{

    private String title, location, waktu;
    private com.google.firebase.Timestamp start;
    Map<String, Timestamp> time;


    public Detailjadwal(){

    }

    public Detailjadwal(String title, String location, String waktu, com.google.firebase.Timestamp start,Map<String, Timestamp> time ) {
        this.title = title;
        this.location = location;
        this.waktu = waktu;
        this.start = start;
        this.time = time;

//        this.title = title;
    }
//
//    public String getStart(){
//        return start;s
//    }
//
//    public String getJudul(){
//        return title;
//    }
//
//
    public String getLocation(){
        return location;
    }


    public String getTitle(){
        return title;
    }

    public String getWaktu(){
        return waktu;
    }

    public Timestamp getStart() {
        return start;
    }

    public Map<String, Timestamp> getTime() {
        return time;
    }
}