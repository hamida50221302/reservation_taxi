package com.example.hamida.taxi;

public class ContactPOJO {

    private String mDistance;
    private String mTime;
    private String mCourse;
    private String metat;


    public ContactPOJO() {} //default constructor
    // Argum;                                   ent Constructor
    public ContactPOJO(String distance, String time, String couse) {
        mDistance = distance;
        mTime = time;
        mCourse = couse;
    }

    public String getmDistance() {
        return mDistance;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmCourse() {
        return mCourse;
    }

    public void setmDistance(String mDistance) {
        this.mDistance = mDistance;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public void setmCourse(String mCourse) {
        this.mCourse = mCourse;
    }

}
