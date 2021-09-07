package com.hengnan.design.abfactory.good;

import com.hengnan.design.abfactory.AbstractFactory;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public class GoodFactory implements AbstractFactory {
    @Override
    public String createHtml(String md) {
        GoodHtmlDocumentImpl goodHtmlDocument = new GoodHtmlDocumentImpl();
        return goodHtmlDocument.createHtml(md);
    }

    @Override
    public String createWord(String md) {
        GoodWordDocumentImpl goodWordDocument = new GoodWordDocumentImpl();
        return goodWordDocument.createWord(md);
    }
}
