package com.fumolu.www.data;

import com.fumolu.www.model.Enemy;

public class EnemyData {
    public static Enemy enemys[][] = new Enemy[3][3];

    static{

        enemys[0][0] = new Enemy("小黄鸡", 5, 5, 3, 0, 20);
        enemys[0][1] = new Enemy("野猪", 8, 5, 5, 2, 30);
        enemys[0][2] = new Enemy("狼王", 15, 15, 15, 2, 50);

        enemys[1][0] = new Enemy("土匪", 20, 25, 20, 5, 40);
        enemys[1][1] = new Enemy("山贼", 25, 20, 25, 8, 30);
        enemys[1][2] = new Enemy("匪首", 40, 25, 50, 5, 100);

        enemys[2][0] = new Enemy("牛头马面", 40, 50, 60, 0, 80);
        enemys[2][1] = new Enemy("黑白无常", 60, 50, 100, 20, 180);
        enemys[2][2] = new Enemy("阎王", 90, 100, 2000, 1000, 10000);

    }

}
