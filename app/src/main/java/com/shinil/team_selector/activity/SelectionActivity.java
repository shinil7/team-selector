package com.shinil.team_selector.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.shinil.team_selector.R;
import com.shinil.team_selector.fragment.PlayerFragment;
import com.shinil.team_selector.fragment.ResultFragment;
import com.shinil.team_selector.fragment.TeamFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectionActivity extends AppCompatActivity
        implements TeamFragment.OnTeamSelectedListener,
        PlayerFragment.OnPlayerSelectedListener {

    private TextView textView;
    private List<String> teamList;
    private List<String> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        textView = (TextView) findViewById(R.id.text_view);
        initToolbar();
        addFragment();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);
    }

    private void addFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, TeamFragment.newInstance());
        ft.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }

    @Override
    public void onTeamSelected(int number) {
        textView.setText(number+"");
    }
    @Override
    public void onNextClicked(int count, List<String> teamList) {
        this.teamList = teamList;
        textView.setText(0+"/"+teamList.size());
        replaceFragment(PlayerFragment.newInstance(count));
    }

    @Override
    public void onPlayerSelected(int count, int player_no) {
        textView.setText(count+"/"+player_no);
    }
    @Override
    public void onSubmitClicked(List<String> playerList) {
        textView.setVisibility(View.GONE);
        for(String player : playerList) {
            result.add(player + ":" + getRandom(teamList) + " ");
        }
        replaceFragment(ResultFragment.newInstance(result));
    }

    private String getRandom(List<String> list) {
        int random = new Random().nextInt(list.size());
        String team = list.get(random);
        teamList.remove(random);
        return team;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exitByBackKey() {
        new AlertDialog.Builder(this)
                .setMessage("Do you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.dismiss();
                    }
                }).show();
    }
}
