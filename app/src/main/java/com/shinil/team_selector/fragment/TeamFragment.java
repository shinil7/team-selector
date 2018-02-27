package com.shinil.team_selector.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.shinil.team_selector.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shinilms
 */

public class TeamFragment extends Fragment
        implements CompoundButton.OnCheckedChangeListener {
    private OnTeamSelectedListener mListener;
    private CheckBox atletico, barcelona, chelsea, juventus, city, liverpool, spurs, bayern, dortmund, psg, real, united, arsenal;
    private Button button;
    private int counter = 0;
    private List<String> teamList = new ArrayList<>();

    public TeamFragment() {
        //required empty public constructor
    }

    public static TeamFragment newInstance() {
        return new TeamFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_refresh).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        atletico = view.findViewById(R.id.atletico);
        atletico.setOnCheckedChangeListener(this);
        barcelona = view.findViewById(R.id.barcelona);
        barcelona.setOnCheckedChangeListener(this);
        chelsea = view.findViewById(R.id.chelsea);
        chelsea.setOnCheckedChangeListener(this);
        juventus = view.findViewById(R.id.juventus);
        juventus.setOnCheckedChangeListener(this);
        city = view.findViewById(R.id.city);
        city.setOnCheckedChangeListener(this);
        liverpool = view.findViewById(R.id.liverpool);
        liverpool.setOnCheckedChangeListener(this);
        spurs = view.findViewById(R.id.spurs);
        spurs.setOnCheckedChangeListener(this);
        bayern = view.findViewById(R.id.bayern);
        bayern.setOnCheckedChangeListener(this);
        dortmund = view.findViewById(R.id.dortmund);
        dortmund.setOnCheckedChangeListener(this);
        psg = view.findViewById(R.id.psg);
        psg.setOnCheckedChangeListener(this);
        real = view.findViewById(R.id.real);
        real.setOnCheckedChangeListener(this);
        united = view.findViewById(R.id.united);
        united.setOnCheckedChangeListener(this);
        arsenal = view.findViewById(R.id.arsenal);
        arsenal.setOnCheckedChangeListener(this);
        button = view.findViewById(R.id.button_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arsenal.isChecked())
                    teamList.add(getString(R.string.arsenal));
                if(atletico.isChecked())
                    teamList.add(getString(R.string.atletico));
                if(barcelona.isChecked())
                    teamList.add(getString(R.string.barcelona));
                if(bayern.isChecked())
                    teamList.add(getString(R.string.bayern));
                if(dortmund.isChecked())
                    teamList.add(getString(R.string.dortmund));
                if(chelsea.isChecked())
                    teamList.add(getString(R.string.chelsea));
                if(juventus.isChecked())
                    teamList.add(getString(R.string.juventus));
                if(liverpool.isChecked())
                    teamList.add(getString(R.string.liverpool));
                if(city.isChecked())
                    teamList.add(getString(R.string.city));
                if(united.isChecked())
                    teamList.add(getString(R.string.united));
                if(psg.isChecked())
                    teamList.add(getString(R.string.psg));
                if(real.isChecked())
                    teamList.add(getString(R.string.real));
                if(spurs.isChecked())
                    teamList.add(getString(R.string.spurs));

                if(mListener != null)
                    mListener.onNextClicked(counter, teamList);
            }
        });
        return view;
    }

    public void onButtonPressed() {
        if(counter > 1) {
            button.setEnabled(true);
            button.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(), R.color.colorAccent));
        } else {
            button.setEnabled(false);
            button.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(), R.color.colorGray));
        }
        if (mListener != null)
            mListener.onTeamSelected(counter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTeamSelectedListener)
            mListener = (OnTeamSelectedListener) context;
        else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTeamSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void addTeam(boolean isChecked) {
        if(isChecked) {
            counter++;
            onButtonPressed();
        } else {
            counter--;
            onButtonPressed();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.atletico :
                addTeam(isChecked);
                break;
            case R.id.barcelona :
                addTeam(isChecked);
                break;
            case R.id.chelsea :
                addTeam(isChecked);
                break;
            case R.id.juventus :
                addTeam(isChecked);
                break;
            case R.id.city :
                addTeam(isChecked);
                break;
            case R.id.liverpool :
                addTeam(isChecked);
                break;
            case R.id.spurs :
                addTeam(isChecked);
                break;
            case R.id.bayern :
                addTeam(isChecked);
                break;
            case R.id.dortmund :
                addTeam(isChecked);
                break;
            case R.id.psg :
                addTeam(isChecked);
                break;
            case R.id.real :
                addTeam(isChecked);
                break;
            case R.id.united :
                addTeam(isChecked);
                break;
            case R.id.arsenal :
                addTeam(isChecked);
                break;
        }
    }

    public interface OnTeamSelectedListener {
        void onTeamSelected(int number);
        void onNextClicked(int count, List<String> teamList);
    }
}
