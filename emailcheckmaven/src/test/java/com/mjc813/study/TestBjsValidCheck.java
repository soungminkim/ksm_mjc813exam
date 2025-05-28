package com.mjc813.study;

import com.bjs.BjsValidCheck;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestBjsValidCheck {
    @Test
    public void testMjcValidCheck(){
        BjsValidCheck mvc = new BjsValidCheck();
        assertThat(mvc.isValidPhoneNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-39a2-0203")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-1111-2222")).isEqualTo(true);

        assertThat(mvc.isValidZipNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("010-39a2-0203")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("12345")).isEqualTo(true);
        assertThat(mvc.isValidZipNumber("01234")).isEqualTo(false);

        assertThat(mvc.isValidEmail(null)).isEqualTo(false);
        assertThat(mvc.isValidEmail("")).isEqualTo(false);
        assertThat(mvc.isValidEmail("a@b.c.d")).isEqualTo(false);
        assertThat(mvc.isValidEmail("a@b.c.d.com")).isEqualTo(true);
    }
}
