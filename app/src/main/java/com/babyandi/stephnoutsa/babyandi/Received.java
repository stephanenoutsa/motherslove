package com.babyandi.stephnoutsa.babyandi;



public class Received {

    // Private variables
    int _rid;
    int number;

    // Empty constructor
    public Received() {

    }

    // Constructor
    public Received(int _rid, int number) {
        this._rid = _rid;
        this.number = number;
    }

    // Constructor
    public Received(int number) {
        this.number = number;
    }

    // Getter and Setter methods
    public int get_rid() {
        return _rid;
    }

    public void set_rid(int _rid) {
        this._rid = _rid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
