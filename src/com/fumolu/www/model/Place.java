package com.fumolu.www.model;

import java.util.ArrayList;

/**
 * 游戏场景，包含敌人
 */
public class Place {
    private int ID;
    // 地名
    private String placeName;

    // 场景介绍
    private  String placeIntroduction;

    // 区域敌人
    private ArrayList<Enemy> enemys = new ArrayList<>();

    public Place() {
    }

    public Place(int ID, String placeName, String placeIntroduction) {
        this.ID = ID;
        this.placeName = placeName;
        this.placeIntroduction = placeIntroduction;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceIntroduction() {
        return placeIntroduction;
    }

    public void setPlaceIntroduction(String placeIntroduction) {
        this.placeIntroduction = placeIntroduction;
    }

    public ArrayList<Enemy> getEnemys() {
        return enemys;
    }

    public void setEnemys(ArrayList<Enemy> enemys) {
        this.enemys = enemys;
    }
}
