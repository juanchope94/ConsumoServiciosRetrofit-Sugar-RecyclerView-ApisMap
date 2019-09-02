
package com.juan.enciclav20;

import com.orm.SugarRecord;

import java.util.List;

public class Example extends SugarRecord {

    private Integer date;
    private List<Station> stations = null;

    public Example() {
    }


    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

}
