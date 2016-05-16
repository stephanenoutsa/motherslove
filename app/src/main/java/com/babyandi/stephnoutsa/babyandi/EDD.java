package com.babyandi.stephnoutsa.babyandi;



public class EDD {

    // Private variables
    int _eddid;
    String eddate;

    // Empty constructor
    public EDD() {

    }

    // Constructor
    public EDD(int _eddid, String edd) {
        this._eddid = _eddid;
        this.eddate = edd;
    }

    // Constructor
    public EDD(String edd) {
        this.eddate = edd;
    }

    // Getter and setter methods
    public int get_eddid() {
        return _eddid;
    }

    public void set_eddid(int _eddid) {
        this._eddid = _eddid;
    }

    public String getEddate() {
        return eddate;
    }

    public void setEdd(String edd) {
        this.eddate = edd;
    }
}
