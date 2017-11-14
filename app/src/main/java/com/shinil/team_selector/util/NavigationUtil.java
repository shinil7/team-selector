package com.shinil.team_selector.util;

import android.content.Context;
import android.content.Intent;

import com.shinil.team_selector.activity.SelectionActivity;

/**
 * Created by shinil on 10/11/17
 */

public class NavigationUtil {

    public static void navigateToSelectionActivity(Context context) {
        Intent intent = new Intent(context, SelectionActivity.class);
        context.startActivity(intent);
    }
}
