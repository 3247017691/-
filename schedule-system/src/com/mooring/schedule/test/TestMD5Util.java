package com.mooring.schedule.test;

import com.mooring.schedule.util.MD5Util;
import org.junit.jupiter.api.Test;

public class TestMD5Util {
    @Test
    public void testEncrypt(){
        String encrypt = MD5Util.encrypt("123456");
        System.out.println(encrypt);
    }
}
