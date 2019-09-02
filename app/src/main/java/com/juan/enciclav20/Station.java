
package com.juan.enciclav20;

import com.orm.SugarRecord;

import java.util.List;

public class Station extends SugarRecord {

    private String iden;
    private String name;
    private String desc;
    private List<Item> items = null;

    public String getIdentid() {
        return iden;
    }

    public void setIdentid(String iden) {
        this.iden = iden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Station() {
    }

    public Station(String iden, String name, String desc, List<Item> items) {
        this.iden = iden;
        this.name = name;
        this.desc = desc;
        this.items = items;
    }
}
