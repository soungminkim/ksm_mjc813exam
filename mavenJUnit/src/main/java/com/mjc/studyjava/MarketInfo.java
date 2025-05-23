package com.mjc.studyjava;

import com.mjc813.mjc_library.IMarketInfo;

public class MarketInfo implements IMarketInfo {


    @Override
    public String getMessageOfMarketInfo() {
        return "MJC Market 입니다. T.02)1234-5678";
    }

    @Override
    public String getMessageOfNotValidData() {
        return "부정확한 값입니다.";
    }

}
