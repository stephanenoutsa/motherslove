package com.babyandi.stephnoutsa.babyandi;

/**
 * Created by stephnoutsa on 8/10/16.
 */
public class HIVR {

    // Private variables
    int _hivid, hivnumber;

    // Empty Constructor
    public HIVR() {

    }

    // Constructor
    public HIVR(int _hivid, int hivnumber) {
        this._hivid = _hivid;
        this.hivnumber = hivnumber;
    }

    // Constructor
    public HIVR(int hivnumber) {
        this.hivnumber = hivnumber;
    }

    //Getter and Setter methods
    public int get_hivid() {
        return _hivid;
    }

    public void set_hivid(int _hivid) {
        this._hivid = _hivid;
    }

    public int getHivnumber() {
        return hivnumber;
    }

    public void setHivnumber(int hivnumber) {
        this.hivnumber = hivnumber;
    }
}
