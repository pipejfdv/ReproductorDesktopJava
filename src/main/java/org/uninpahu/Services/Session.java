package org.uninpahu.Services;


public class Session {
    private static String nickname;

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        Session.nickname = nickname;
    }
}
