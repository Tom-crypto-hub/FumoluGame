package com.fumolu.www.model;

/**
 * 游戏场景，包含敌人
 */
public class Place {
    // 地名
    private String placeName;

    // 场景介绍
    private  String placeIntroduction;

    // 区域敌人
    private Enemy enemys[] = new Enemy[10];

    public Place() {
    }

    public Place(String placeName, String placeIntroduction) {
        this.placeName = placeName;
        this.placeIntroduction = placeIntroduction;
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

    public Enemy[] getEnemys() {
        return enemys;
    }

    public void setEnemys(Enemy[] enemys) {
        this.enemys = enemys;
    }
}
