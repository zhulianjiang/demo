package com.hengnan.design.abfactory.fast;

import com.hengnan.design.abfactory.WordDocument;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public class FastWordDocumentImpl implements WordDocument {
    @Override
    public String createWord(String md) {
        return "Fast create OK" + md;
    }
}
