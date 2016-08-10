package com.babyandi.stephnoutsa.babyandi;

/**
 * Created by stephnoutsa on 8/10/16.
 */
public class HEPR {

    // Private variables
    int _hepid, hepnumber;

    // Empty Constructor
    public HEPR() {

    }

    // Constructor
    public HEPR(int _hepid, int hepnumber) {
        this._hepid = _hepid;
        this.hepnumber = hepnumber;
    }

    // Construtor
    public HEPR(int hepnumber) {
        this.hepnumber = hepnumber;
    }

    // Getter and Setter methods
    public int get_hepid() {
        return _hepid;
    }

    public void set_hepid(int _hepid) {
        this._hepid = _hepid;
    }

    public int getHepnumber() {
        return hepnumber;
    }

    public void setHepnumber(int hepnumber) {
        this.hepnumber = hepnumber;
    }
}
