package com.example.hamida.taxi;

public class ContactPassager {
    private String mDistance;
    private String mTime;
    private String mDistination;
    private String mName;


    public ContactPassager() {} //default constructor
    // Argum;                                   ent Constructor
    public ContactPassager(String distination, String time, String distance,String name) {
        mDistance = distance;
        mTime = time;
        mDistination = distination;
        mName =name;
    }

    public String getmDistance() {
        return mDistance;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmDistination() {
        return mDistination;
    }
    public String getmName() {
        return mName;
    }

    public void setmDistance(String mDistance) {
        this.mDistance = mDistance;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public void setmDistination(String mDistination) {
        this.mDistination= mDistination;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }

}
