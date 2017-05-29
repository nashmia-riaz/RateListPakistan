package com.aw.android.ratelistapp.model;

/**
 * Created by AWShades on 5/28/2017.
 */

import com.google.firebase.database.IgnoreExtraProperties;

// [START blog_user_class]
@IgnoreExtraProperties
public class user {

    public String username;
    public String email;

    public user() {}

    public user(String username, String email) {
        this.username = username;
        this.email = email;
    }

}

