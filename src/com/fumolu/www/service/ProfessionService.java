package com.fumolu.www.service;

import com.fumolu.www.dao.ProfessionDao;
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
    public static Profession choiceProfession(int professionId) {//参数为职业id
        //初始化一个professionDao对象
        ProfessionDao professionDao = new ProfessionDao();
        System.out.println("有这些职业供您选择：");
        //


        Profession profession = null;

        // 让玩家根据数字做出选择，输入有误可以重复选择

        return profession;
    }
    public static void professionShow(){
        // //初始化一个professionDao对象
        ProfessionDao professionDao = new ProfessionDao();
        for (int i = 1; i <=2; i++) {
            //调用professionDao的方法查找数据库中的职业
            Profession p=professionDao.inquiry(i);
            //显示戏数据存在的职业名字，以“序号.职业名”的方式输出显示
            System.out.println((i + 1) + "." +p.getProfessionName());
        }
    }
}
