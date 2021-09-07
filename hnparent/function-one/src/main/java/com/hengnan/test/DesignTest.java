package com.hengnan.test;

import com.hengnan.design.abfactory.AbstractFactory;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public class DesignTest {

    public static void main(String[] args) {
        try {
            AbstractFactory factory = AbstractFactory.createFactory("good");
            String html = factory.createHtml("html");
            String word = factory.createWord("word");
            System.out.println(html);
            System.out.println(word);
        } catch (Exception e) {

        }

//        String htmlResult = factory.createHtml("html");
//        String wordResult = factory.createWord("word");

//        NamberFactory factory = NamberFactory.getFactory();
//        Boolean flag = factory.parse(8, 7);
//        System.out.println(flag);

    }
}
