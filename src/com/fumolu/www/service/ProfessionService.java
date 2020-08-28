package com.fumolu.www.service;

import com.fumolu.www.data.ProfessionData;
import com.fumolu.www.model.Profession;
import com.fumolu.www.utils.ScannerUtil;

/**
 * 跟职业相关的功能
 */
public class ProfessionService {

    /**
     * 选择职业
     *
     * @return 返回玩家选中的职业
     */
    public static Profession choiceProfession() {

        System.out.println("有这些职业供您选择：");

        // 输出游戏数据ProfessionData中存在的职业信息
        for (int i = 0; i < ProfessionData.professions.length; i++) {
            // 让每个职业以“序号.职业名”的方式输出显示
            System.out.println((i + 1) + "." + ProfessionData.professions[i].getProfessionName());
        }

        Profession profession = null;

        // 让玩家根据数字做出选择，输入有误可以重复选择

        return profession;
    }


}
