package com.fumolu.www.service;

import com.fumolu.www.dao.PlaceDao;
import com.fumolu.www.dao.PlayerDao;
import com.fumolu.www.data.PlaceData;
import com.fumolu.www.model.Place;
import com.fumolu.www.utils.ScannerUtil;

/**
 * 跟场景相关的方法
 */
public class PlaceService {
    /**
     * 选择场景
     *
     * @return 返回玩家选中的场景
     */
    public static Place choicePlace(int playceId) {
        // 1.定义一个场景对象以便后面返回
        Place place = new Place();
        // 2.让玩家根据数字做出选择
        switch (playceId){
            case 1:
                place= PlaceData.places[0];
                break;
            case 2:
                place= PlaceData.places[1];
                break;
            case 3:
                place= PlaceData.places[2];
                break;
            default:
                place=null;
                break;
        }
        //3.返回选择的场景对象
        return place;
    }
    public static void placeShow(){
        // 输出游戏场景数据PlaceData中存在的场景信息
        for (int i=0;i<=PlaceData.places.length;i++){
            System.out.println(i+1+"."+PlaceData.places[i].getPlaceName());
        }
    }
}
