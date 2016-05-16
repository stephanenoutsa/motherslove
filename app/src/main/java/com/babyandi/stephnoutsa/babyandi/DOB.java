package com.babyandi.stephnoutsa.babyandi;



public class DOB {

    // Private variables
    int _did;
    String dday;
    int dreceived;

    // Empty constructor
    public DOB() {

    }

    // Constructor
    public DOB(int _did, String dday, int dreceived) {
        this._did = _did;
        this.dday = dday;
        this.dreceived = dreceived;
    }

    // Constructor
    public DOB(String dday, int dreceived) {
        this.dday = dday;
        this.dreceived = dreceived;
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

    public int getDreceived() {
        return dreceived;
    }

    public void setDreceived(int dreceived) {
        this.dreceived = dreceived;
    }
}
