package com.lsq.pojo;
//实体类
public class Db1 {
    private String frame;
    private String sqllanguage;
    private String container;
    private String protocol;
    private int id;

    public Db1() {
    }

    public Db1(String frame, String sqllanguage, String container, String protocol, int id) {
        this.frame = frame;
        this.sqllanguage = sqllanguage;
        this.container = container;
        this.protocol = protocol;
        this.id = id;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSqllanguage() {
        return sqllanguage;
    }

    public void setSqllanguage(String sqllanguage) {
        this.sqllanguage = sqllanguage;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Db1{" +
                "frame='" + frame + '\'' +
                ", sqllanguage='" + sqllanguage + '\'' +
                ", container='" + container + '\'' +
                ", protocol='" + protocol + '\'' +
                ", id=" + id +
                '}';
    }
}
