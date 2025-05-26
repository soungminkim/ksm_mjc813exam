package com.mjc813.studyjava.lib;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestCalculate {
    @Test
    public void testCalculate() {
        int[] a = new int[] {1, 2, 3, 4, 5,6,7,8,9,10};
        Calculate cal = new Calculate();
        assertThat(cal.add(1,3)).isEqualTo(4);
        assertThat(cal.add(-4,4)).isEqualTo(0);
        assertThat(cal.sub(1,3)).isEqualTo(-2);
        assertThat(cal.sub(-4,4)).isEqualTo(-8);
        assertThat(cal.mul(1,3)).isEqualTo(3);
        assertThat(cal.mul(4,3)).isEqualTo(12);
        assertThat(cal.div(4,3)).isEqualTo(1);
        assertThat(cal.div(1,3)).isEqualTo(0);
        assertThat(cal.mod(1,3)).isEqualTo(1);
        assertThat(cal.mod(3,3)).isEqualTo(0);

        assertThat(cal.square(3,2)).isEqualTo(9);
        assertThat(cal.square(3,3)).isEqualTo(27);

        int[] input = {1,2,3,4,5,6,7,8,9,10};
        int result = cal.sumarray(input);
        assertThat(result).isEqualTo(55);
    }
}
