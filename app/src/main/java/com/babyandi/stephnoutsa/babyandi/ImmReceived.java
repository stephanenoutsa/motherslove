package com.babyandi.stephnoutsa.babyandi;



public class ImmReceived {

    // Private variables
    int _drid;
    int dnumber;

    // Empty constructor
    public ImmReceived() {

    }

    // Constructor
    public ImmReceived(int _drid, int dnumber) {
        this._drid = _drid;
        this.dnumber = dnumber;
    }

    // Constructor
    public ImmReceived(int dnumber) {
        this.dnumber = dnumber;
    }

    // Getter and Setter methods
    public int get_drid() {
        return _drid;
    }

    public void set_drid(int _drid) {
        this._drid = _drid;
    }

    public int getDnumber() {
        return dnumber;
    }

    public void setDnumber(int dnumber) {
        this.dnumber = dnumber;
    }
}
