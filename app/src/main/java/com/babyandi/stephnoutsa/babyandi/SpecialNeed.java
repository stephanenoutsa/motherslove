package com.babyandi.stephnoutsa.babyandi;



public class SpecialNeed {

    // Private variables
    int _snid;
    String hiv;
    String hepatitis;

    // Empty constructor
    public SpecialNeed() {

    }

    // Constructor
    public SpecialNeed(int _snid, String hiv, String hepatitis) {
        this._snid = _snid;
        this.hiv = hiv;
        this.hepatitis = hepatitis;
    }

    // Constructor
    public SpecialNeed(String hiv, String hepatitis) {
        this.hiv = hiv;
        this.hepatitis = hepatitis;
    }

    // Getter and setter methods
    public int get_snid() {
        return _snid;
    }

    public void set_snid(int _snid) {
        this._snid = _snid;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(String hepatitis) {
        this.hepatitis = hepatitis;
    }
}
