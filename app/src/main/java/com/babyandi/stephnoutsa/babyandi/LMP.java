package com.babyandi.stephnoutsa.babyandi;



public class LMP {

    // Private variables
    int _lmpid;
    String lmpdate;

    // Empty constructor
    public LMP() {

    }

    // Constructor
    public LMP(int _lmpid, String lmpdate) {
        this._lmpid = _lmpid;
        this.lmpdate = lmpdate;
    }

    // Constructor
    public LMP(String lmpdate) {
        this.lmpdate = lmpdate;
    }

    // Getter and Setter methods
    public int get_lmpid() {
        return _lmpid;
    }

    public void set_lmpid(int _lmpid) {
        this._lmpid = _lmpid;
    }

    public String getLmpdate() {
        return lmpdate;
    }

    public void setLmpdate(String lmpdate) {
        this.lmpdate = lmpdate;
    }

}
