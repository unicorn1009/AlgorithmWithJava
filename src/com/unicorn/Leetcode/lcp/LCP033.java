package com.unicorn.Leetcode.lcp;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-04-10 10:53 下午
 */
public class LCP033 {
    public static void main(String[] args) {
//        int[] bucket = {1,3}, vat = {6,8};
        int[] bucket = {9,0,1}, vat = {0,2,2};

        // [2,27,24,75]
        //[53,52,28,82]
        //[3710,6067,2993,70,2340,2748,9385,3027,3456,5246,9739,1220,9539,9074,4729,7051,8462,6908,3649,9996,8890,2980,4350,7350,6344,6759,4420,269,9341,648,7737,8133,3717,2766,5807,4338,2077,5775,4905,7262,1258,613,3837,3475,437,3739,9814,4790,2075,7722,3290,5685,3499,6992,4421,934,6004,5763,3463,6138,8818,445,4778,4979,126,3969,2994,87,3739,8582,9559,8326,9132,257,8928,9147,1615,4665,9828,3925,6435,5326,836,519,298,600,5503,273,9580,5383,8966,4810,1386,7207,8060,678,8837,6946,1210,945]
        //[6304,6509,4276,9645,6455,8167,9667,4385,8872,7889,9936,4413,9922,9894,8065,7627,9225,9907,7055,9996,9439,3351,9317,8363,9383,6850,4621,5389,9508,3391,9650,8363,8719,5594,8770,5403,7107,9941,9254,9355,4614,4640,4896,8759,4397,8441,9870,9906,2396,8092,6939,9432,8182,9090,8029,4930,7772,7066,7279,7778,9529,2947,6552,6930,5260,8470,8478,1371,9453,9767,9888,9964,9960,3990,9391,9377,3063,5374,9880,7684,7864,7078,2622,3754,617,9773,9415,8026,9883,5735,9233,6715,9105,7932,9178,1081,9340,7284,6621,1965]
//        int[] bucket = {6}, vat = {90};

        System.out.println(storeWater1(bucket, vat));
    }
    public static int storeWater(int[] bucket, int[] vat) {
        int ans = 0;
        // 升级+倒水
        double x = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (vat[i] == 0) continue;
            if (bucket[i] == 0){
                bucket[i]++;
                ans++;
            }
            double pre = Math.ceil(vat[i] * 1.0 / bucket[i]);
            int upCount = 1;
            while (Math.ceil(vat[i]*1.0 / (bucket[i]+1)) + upCount <= pre){
                bucket[i]++;
                ans++;
                pre = Math.ceil(vat[i] * 1.0 / bucket[i]) + upCount;
                upCount++;
            }
            x = Math.max(x, Math.ceil(vat[i] * 1.0 / bucket[i]));
        }
        ans += (int) x;
        return ans;

    }

    public static int storeWater1(int[] bucket, int[] vat) {
        // 只要操作次数最多的一组达到最优即可
        int x = 0;
        for (int i = 0; i < bucket.length; i++) {
            // 判断每一组数最少需要操作多少次
            if (vat[i] == 0) continue;
            int count = 0;
            if (bucket[i] == 0){
                bucket[i]++;
                count++;
            }
            double pre = Math.ceil(vat[i] * 1.0 / bucket[i]);
            int upCount = 1;
            int temp = bucket[i];
            int origin = bucket[i];
            while (Math.ceil(vat[i]*1.0 / (bucket[i]+1)) + upCount <= pre){
                if (Math.ceil(vat[i]*1.0 / (bucket[i]+1)) + upCount < pre){
                    // 更新bucket
                    temp = bucket[i]+1;
                }
                bucket[i]++;
                pre = Math.ceil(vat[i] * 1.0 / bucket[i]) + upCount;
                upCount++;
            }
            x = Math.max(x, temp-origin+count+(int) Math.ceil(vat[i] * 1.0 / temp));
        }
        return x;

    }
}
