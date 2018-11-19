package com.weibo.ad.sdk;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest
{

    @Test
    public void snake() throws Exception {
        String a = "aaBb";
        assertEquals("aa_bb", Util.snake(a));
        assertEquals("aa_bb", Util.snake(a));
        assertEquals("", Util.snake(""));
        String b = "AaBb";
        assertEquals("aa_bb", Util.snake(b));
    }

    @Test
    public void studly() throws Exception {
        String a = "aa_bb";
        assertEquals("aaBb", Util.studly(a));
        assertEquals("aaBb", Util.studly(a));
        String b = "Aa_Bb";
        assertEquals("aaBb", Util.studly(b));
        assertEquals("", Util.studly(""));

        String c = "aa_bb_cc";
        assertEquals("aaBbCc", Util.studly(c));
    }

}