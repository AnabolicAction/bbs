package com.bbs.utils;

import org.junit.Ignore;
import org.junit.Test;

public class ExcelToXmlDataSetTest {

    @Ignore
    @Test
    public void testGenerateDataSetXml() throws Exception {
        ExcelToXmlDataSet.generateDataSetXml("sample-data");
        ExcelToXmlDataSet.generateDataSetXmlIgnoreTestData("sample-data");
    }
}
