package cn.cherzing.test;

import org.junit.Test;

/**
 * @author Cherzing
 * @date 2024/10/27 0027 13:47
 * @description StringBuilderAndStringBuffer
 */
public class StringBuilderAndStringBuffer {
    @Test
    public void testString(){
        String string = "123abcd";
        StringBuilder stringBuilder = new StringBuilder(string);
        StringBuffer stringBuffer = new StringBuffer(string);
        System.out.println(stringBuffer);
        System.out.println(stringBuilder);
    }
}
