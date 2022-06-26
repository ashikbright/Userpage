package com.ashik.userpage;

public class datamodel {
    int image,edit;
    String header,nm;

    public datamodel(int image, String header,String nm,int edit) {
        this.image = image;
        this.header = header;
        this.nm=nm;
        this.edit=edit;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public int getEdit() {
        return edit;
    }

    public void setEdit(int edit) {
        this.edit = edit;
    }
}