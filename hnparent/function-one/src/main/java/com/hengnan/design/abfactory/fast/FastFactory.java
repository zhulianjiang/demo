package com.hengnan.design.abfactory.fast;

import com.hengnan.design.abfactory.AbstractFactory;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public class FastFactory implements AbstractFactory {

    @Override
    public String createHtml(String md) {
        FastHtmlDocumentImpl fastHtmlDocument = new FastHtmlDocumentImpl();
        return fastHtmlDocument.createHtml(md);
    }

    @Override
    public String createWord(String md) {
        FastWordDocumentImpl fastWordDocument = new FastWordDocumentImpl();
        return fastWordDocument.createWord(md);
    }
}
