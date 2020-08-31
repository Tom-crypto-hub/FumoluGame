package com.fumolu.www.service;

import com.fumolu.www.dao.EnemyDao;
import com.fumolu.www.dao.ProfessionDao;
import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Place;

import java.util.ArrayList;

/**
 * 跟场景相关的方法
 */
public class PlaceService {
    private static EnemyDao enemyDao = new EnemyDao();
    private static ProfessionDao professionDao = new ProfessionDao();

    /**
     * 选择场景
     *
     * @return 返回玩家选中的场景
     */
    public static Place choicePlace(int placeId) {
        // 1.定义一个场景对象以便后面返回
        Place place = null;
        // 2.让玩家根据数字做出选择
        switch (placeId){
            case 0:
                place = new Place(0, "新手村", "在这里的都是弱鸡");
                generate(place);
                break;
            case 1:
                place= new Place(1, "洛阳郊外", "传闻这里经常有盗匪出没");
                generate(place);
                break;
            case 2:
                place= new Place(2, "阴曹地府", "难辨五指的黑暗中危机四伏");
                generate(place);
                break;
            default:
                place=null;
                break;
        }
        //3.返回选择的场景对象
        return place;
    }

    public static void generate(Place place){
        ArrayList<Enemy> list = place.getEnemys();
        for(int i = place.getID() * 3 + 1; i <= (place.getID() + 1) * 3; i++){
            Enemy enemy = enemyDao.inquiryEnemy(i);
            enemy.setEnemy_id(i);
            if(enemy.getID() % 3 == 0){
                enemy.setProfession(professionDao.inquiry(3));
            }else {
                enemy.setProfession(professionDao.inquiry(2));
            }
            list.add(enemy);
        }
        place.setEnemys(list);
    }
}
