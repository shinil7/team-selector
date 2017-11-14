package com.shinil.team_selector.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shinil.team_selector.util.NavigationUtil;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NavigationUtil.navigateToSelectionActivity(getApplicationContext());
        finish();
    }
}
