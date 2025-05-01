package com.example.quizapp.db.user_management;

import android.content.Context;
import com.example.quizapp.db.data.Data;
import com.example.quizapp.db.enums.DataTables;

/**
 * <p>Created on 01.05.2025</p>
 *
 * @author Maciej
 * @version 0.1
 */
public class UserAuthentication {

    public static boolean authenticateUser(String username, String password, Context context) {

        String data = Data.getData(DataTables.USER, context);

        if (data == null || data.isEmpty() || !data.contains(username)) {
            return false; // No data found
        }

        String[] credentials = data.split(";");

        for (String credential : credentials) {

            String[] parts = credential.split(",");

            if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                CurrentUserData.setUsername(username);
                return true; // User authenticated
            }
        }

        return false; // User not found or password mismatch
    }
}
