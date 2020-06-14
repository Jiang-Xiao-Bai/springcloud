package com.ssm.springboot.DemoTests;

/**
 * @author zhaohf
 * @date 2020/5/10 15:12
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "12345o98989";
        boolean matches = str.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(.{6,})$");
        System.out.println(matches);
    }
}
