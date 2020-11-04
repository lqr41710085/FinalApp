package com.example.finalapp;

public class Item {
    //ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,TYPE TEXT,NOTE TEXT,FOOD REAL,ENTERTAIN REAL,TRAFFIC REAL," +
    //  "CLOTHES REAL,HOUSE REAL,STUDY REAL,MEDICAL REAL,WAGE REAL,PARTIME REAL,PACKET REAL,OTHERS REAL,COUNT REAL
    private int id;
    private String date,type;//in out
    private String note;
    private float food,entertain,traffic,clothes,house,study,medical,otherout,wage,partime,packet,otherin;

    public Item(String date, String type, String note, float food, float entertain, float traffic, float clothes, float house,
                float study, float medical, float otherout){
        super();

        this.date=date;
        this.type=type;
        this.note=note;
        this.food=food;
        this.entertain=entertain;
        this.traffic=traffic;
        this.clothes=clothes;
        this.house=house;
        this.study=study;
        this.medical=medical;
        this.otherout=otherout;


    }
    public Item(String date, String type, String note, float wage, float partime, float packet, float otherin){
        super();
        this.date=date;
        this.type=type;
        this.note=note;
        this.wage=wage;
        this.partime=partime;
        this.packet=packet;
        this.otherin=otherin;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getFood() {
        return food;
    }

    public void setFood(float food) {
        this.food = food;
    }

    public float getEntertain() {
        return entertain;
    }

    public void setEntertain(float entertain) {
        this.entertain = entertain;
    }

    public float getTraffic() {
        return traffic;
    }

    public void setTraffic(float traffic) {
        this.traffic = traffic;
    }

    public float getClothes() {
        return clothes;
    }

    public void setClothes(float clothes) {
        this.clothes = clothes;
    }

    public float getHouse() {
        return house;
    }

    public void setHouse(float house) {
        this.house = house;
    }

    public float getStudy() {
        return study;
    }

    public void setStudy(float study) {
        this.study = study;
    }

    public float getMedical() {
        return medical;
    }

    public void setMedical(float medical) {
        this.medical = medical;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public float getPartime() {
        return partime;
    }

    public float getOtherout() {
        return otherout;
    }

    public void setOtherout(float otherout) {
        this.otherout = otherout;
    }

    public float getOtherin() {
        return otherin;
    }

    public void setOtherin(float otherin) {
        this.otherin = otherin;
    }

    public void setPartime(float partime) {
        this.partime = partime;
    }

    public float getPacket() {
        return packet;
    }

    public void setPacket(float packet) {
        this.packet = packet;
    }







}
