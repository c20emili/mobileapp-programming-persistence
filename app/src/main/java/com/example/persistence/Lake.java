package com.example.persistence;

public class Lake {
    private long id;
    private String name;
    private int size;
    private int depth;
    //default
    public Lake()
    {
        id=-1;
        name = "Missing name";
        size = -1;
        depth = -1;
    }

    public Lake(long i, String n, int s, int d) {
        id = i;
        name = n;
        size = s;
        depth = d;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getSize() {
        return size;
    }
    public String info(){
        String txt = "Name: "+name+" / Area: "+size+" Meters / Depth: "+depth+" Meters";
        return txt;
    }

    @Override
    public String toString(){
        return name;
    }
}
