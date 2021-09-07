package com.hengnan.design.abfactory.good;

import com.hengnan.design.abfactory.HtmlDocument;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public class GoodHtmlDocumentImpl implements HtmlDocument {
    @Override
    public String createHtml(String md) {
        return "Good create OK" + md;
    }
}
