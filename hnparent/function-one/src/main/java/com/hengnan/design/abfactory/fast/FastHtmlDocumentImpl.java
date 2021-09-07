package com.hengnan.design.abfactory.fast;

import com.hengnan.design.abfactory.HtmlDocument;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/26
 **/
public class FastHtmlDocumentImpl implements HtmlDocument {
    @Override
    public String createHtml(String md) {
        return "Fast create OK" + md;
    }
}
