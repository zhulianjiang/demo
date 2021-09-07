package com.hengnan.design.factory;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public class NamberFactoryImpl implements NamberFactory {
    @Override
    public Boolean parse(int numA, int numB) {
        return numA > numB;
    }
}
