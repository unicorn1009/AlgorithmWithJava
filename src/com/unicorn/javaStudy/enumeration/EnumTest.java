package com.unicorn.javaStudy.enumeration;

import java.util.Arrays;

/**
 * <p>
 *     枚举类
 * </p>
 * Created on 2021-01-29.
 *
 * @author Unicorn
 */
public class EnumTest {
    public static void main(String[] args) {
        Season season = Season.Autumn;
        System.out.println(season);

        Season1 winter = Season1.Winter;
        System.out.println(winter);

        /*
             枚举类继承自Enum
             常用方法
             1. values(): 获取枚举类中所有枚举对象
             2. valueOf(String str): 返回与参数同名的枚举对象
             3. toString()
         */
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));

        Season1 summer = Season1.valueOf("Summer");
        System.out.println(summer);


    }
}

enum Season{
    Spring,
    Summer,
    Autumn,
    Winter;
}

enum Season1{
    Spring("春天", "春暖花开"),
    Summer("夏天", "夏日炎炎"),
    Autumn("秋天", "秋风习习"),
    Winter("冬天", "冬天雪地");

    // 属性
    private String seasonName;
    private String seasonInfo;

    // 构造函数
    private Season1(String seasonName, String seasonInfo) {
        this.seasonName = seasonName;
        this.seasonInfo = seasonInfo;
    }

    // 重写toString 可选
    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonInfo='" + seasonInfo + '\'' +
                '}';
    }

    // get方法 可选
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonInfo() {
        return seasonInfo;
    }

}