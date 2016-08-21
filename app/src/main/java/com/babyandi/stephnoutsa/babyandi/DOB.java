package com.babyandi.stephnoutsa.babyandi;



public class DOB {

    // Private variables
    int _did;
    String dday;

    // Empty constructor
    public DOB() {

    }

    // Constructor
    public DOB(int _did, String dday) {
        this._did = _did;
        this.dday = dday;
    }

    // Constructor
    public DOB(String dday) {
        this.dday = dday;
    }

    // Getter and setter methods
    public int get_did() {
        return _did;
    }

    public void set_did(int _did) {
        this._did = _did;
    }

    public String getDday() {
        return dday;
    }

    public void setDday(String dday) {
        this.dday = dday;
    }
}
