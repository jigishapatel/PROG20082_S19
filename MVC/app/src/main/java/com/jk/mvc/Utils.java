package com.jk.mvc;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by Jigisha Patel on 2019-06-10.
 */
public class Utils {
    public static boolean isValidEmail(String target){
        return (!TextUtils.isEmpty(target) &&
                Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
