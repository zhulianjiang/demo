package com.hengnan.design.factory;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public interface NamberFactory {

    NamberFactoryImpl namberFactoryImpl = new NamberFactoryImpl();

    Boolean parse(int numA, int numB);

    static NamberFactory getFactory() {
        return namberFactoryImpl;
    }

}
