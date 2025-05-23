package com.mjc.studyjava;


import com.mjc813.mjc_library.IMarketInfo;
import com.mjc813.mjc_library.MjcPoint;

public class Market {
    public static void main(String[] args) {
        MjcPoint mjcPoint = new MjcPoint();
        IMarketInfo marketInfo = new MarketInfo();

        mjcPoint.addPoint(marketInfo, 10);

        mjcPoint.subPoint(marketInfo,10);

        mjcPoint.subPoint(marketInfo, 25);
    }
}
