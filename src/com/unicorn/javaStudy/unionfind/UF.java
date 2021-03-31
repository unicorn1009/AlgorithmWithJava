package com.unicorn.javaStudy.unionfind;

/**
 * <p>
 *     并查集接口
 * </p>
 * Created on 2021/03/31 15:53
 *
 * @author Unicorn
 */
public interface UF {
    int getSize();
    boolean connected(int p, int q);
    void union(int p ,int q);
}
