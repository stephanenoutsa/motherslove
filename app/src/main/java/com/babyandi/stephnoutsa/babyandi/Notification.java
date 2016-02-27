package com.babyandi.stephnoutsa.babyandi;



public class Notification {

    // Private variables
    int _nid;
    String nday;
    String nmessage;

    // Empty constructor
    public Notification() {

    }

    // Constructor
    public Notification(int _nid, String nday, String nmessage) {
        this._nid = _nid;
        this.nday = nday;
        this.nmessage = nmessage;
    }

    // Constructor
    public Notification(String nday, String nmessage) {
        this.nday = nday;
        this.nmessage = nmessage;
    }

    // Getter and Setter methods
    public int get_nid() {
        return _nid;
    }

    public void set_nid(int _nid) {
        this._nid = _nid;
    }

    public String getNday() {
        return nday;
    }

    public void setNday(String nday) {
        this.nday = nday;
    }

    public String getNmessage() {
        return nmessage;
    }

    public void setNmessage(String nmessage) {
        this.nmessage = nmessage;
    }

}
