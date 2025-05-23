package com.mjc.studyjava;

import com.mjc813.mjc_library.MjcPoint;

public class Market {
    public static void main(String[] args) {
        MjcPoint mp = new MjcPoint();
        mp.getMarketPoint();
        mp.addPoint(null, 10);
        mp.addPoint(new MarketInfo(), 50);

        mp.subPoint(null, 20);
        mp.subPoint(new MarketInfo(), 20);
    }
}
