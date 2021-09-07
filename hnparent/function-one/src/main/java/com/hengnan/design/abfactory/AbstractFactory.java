package com.hengnan.design.abfactory;

import com.hengnan.design.abfactory.fast.FastFactory;
import com.hengnan.design.abfactory.good.GoodFactory;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public interface AbstractFactory {

    String createHtml(String md);

    String createWord(String md);

    public static AbstractFactory createFactory(String name) throws IllegalAccessException {
        if (name.equalsIgnoreCase("fast")) {
            return new FastFactory();
        } else if (name.equalsIgnoreCase("good")) {
            return new GoodFactory();
        } else {
            throw new IllegalAccessException("Invalid factory name");
        }
    }


}
