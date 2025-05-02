package com.example.quizapp.db.user_management;

/**
 * <p>Created on 01.05.2025</p>
 *
 * @author Maciej
 * @version 0.1
 */
public class CurrentUserData {

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CurrentUserData.username = username;
    }

    private static String username;
    private static boolean LoggedIn = false;

    public static boolean isLoggedIn() {
        return LoggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        LoggedIn = loggedIn;
    }
}
