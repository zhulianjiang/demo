package com.hengnan.design.abfactory.good;

import com.hengnan.design.abfactory.WordDocument;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public class GoodWordDocumentImpl implements WordDocument {
    @Override
    public String createWord(String md) {
        return "Good create OK" + md;
    }
}
