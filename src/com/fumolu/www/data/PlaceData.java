package com.fumolu.www.data;

import com.fumolu.www.model.Place;

/**
 * 保存着游戏中的场景信息
 */
public class PlaceData {
    // 存储职业信息的数组
    public static Place places[] = new Place[3];

    static {

        // 地区一：新手村
        Place place1 = new Place("新手村", "在这里的都是弱鸡");
        places[0] = place1;
        places[0].setEnemys(EnemyData.enemys[0]);

        // 地区二：洛阳郊外
        Place place2 = new Place("洛阳郊外", "传闻这里经常有盗匪出没");
        places[1] = place2;
        places[1].setEnemys(EnemyData.enemys[1]);

        // 地区三：阴曹地府
        Place place3 = new Place("阴曹地府", "难辨五指的黑暗中危机四伏");
        places[2] = place3;
        places[2].setEnemys(EnemyData.enemys[2]);

    }

}
