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
public class ManageUsers {

    public static boolean addUser(String username, String password, Context context){
        return Data.setData(Data.getData(DataTables.USER, context) + username + "," + password + ";", DataTables.USER, context);
    }
}
