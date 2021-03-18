package com.example.mathlounge;

import android.content.Context;
import android.content.Intent;

public class Utility {
    public static void nextActivity(Context context,Class<?>cls){
        Intent intent=new Intent(context,cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
