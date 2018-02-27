package com.shinil.team_selector.fragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
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

public class PlayerFragment extends Fragment
        implements CompoundButton.OnCheckedChangeListener {

    public static final String NUMBER_PARAM = "number";
    private OnPlayerSelectedListener mListener;
    private CheckBox chopra, midhunji, abhi, vivek, thamizh, bheegar, kuumar, sonu, nikhil, sreeraj, giri, sanal, kumman;
    private Button button;
    private int counter = 0;
    private int number;
    private List<String> playerList = new ArrayList<>();

    public PlayerFragment() {
        //required empty public constructor
    }

    public static PlayerFragment newInstance(int number) {
        PlayerFragment playerFragment = new PlayerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NUMBER_PARAM, number);
        playerFragment.setArguments(bundle);
        return playerFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            number = getArguments().getInt(NUMBER_PARAM);
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
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        chopra = view.findViewById(R.id.chopra);
        chopra.setOnCheckedChangeListener(this);
        midhunji = view.findViewById(R.id.midhunji);
        midhunji.setOnCheckedChangeListener(this);
        abhi = view.findViewById(R.id.abhi);
        abhi.setOnCheckedChangeListener(this);
        vivek = view.findViewById(R.id.vivek);
        vivek.setOnCheckedChangeListener(this);
        thamizh = view.findViewById(R.id.thamizh);
        thamizh.setOnCheckedChangeListener(this);
        bheegar = view.findViewById(R.id.bheegar);
        bheegar.setOnCheckedChangeListener(this);
        kuumar = view.findViewById(R.id.kumar);
        kuumar.setOnCheckedChangeListener(this);
        sonu = view.findViewById(R.id.sonu);
        sonu.setOnCheckedChangeListener(this);
        nikhil = view.findViewById(R.id.nikhil);
        nikhil.setOnCheckedChangeListener(this);
        sreeraj = view.findViewById(R.id.sreeraj);
        sreeraj.setOnCheckedChangeListener(this);
        giri = view.findViewById(R.id.giri);
        giri.setOnCheckedChangeListener(this);
        sanal = view.findViewById(R.id.sanal);
        sanal.setOnCheckedChangeListener(this);
        kumman = view.findViewById(R.id.kumman);
        kumman.setOnCheckedChangeListener(this);
        button = view.findViewById(R.id.button_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(abhi.isChecked())
                    playerList.add(getString(R.string.abhi));
                if(bheegar.isChecked())
                    playerList.add(getString(R.string.bheegar));
                if(chopra.isChecked())
                    playerList.add(getString(R.string.chopra));
                if(giri.isChecked())
                    playerList.add(getString(R.string.giri));
                if(kuumar.isChecked())
                    playerList.add(getString(R.string.kumar));
                if(kumman.isChecked())
                    playerList.add(getString(R.string.kumman));
                if(midhunji.isChecked())
                    playerList.add(getString(R.string.midhunji));
                if(nikhil.isChecked())
                    playerList.add(getString(R.string.nikhil));
                if(sanal.isChecked())
                    playerList.add(getString(R.string.sanal));
                if(sreeraj.isChecked())
                    playerList.add(getString(R.string.sreeraj));
                if(sonu.isChecked())
                    playerList.add(getString(R.string.sonu));
                if(thamizh.isChecked())
                    playerList.add(getString(R.string.thamizh));
                if(vivek.isChecked())
                    playerList.add(getString(R.string.vivek));

                if(mListener != null)
                    mListener.onSubmitClicked(playerList);
            }
        });
        return view;
    }

    public void onButtonPressed() {
        if(counter == number) {
            button.setEnabled(true);
            button.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(), R.color.colorAccent));
        } else {
            button.setEnabled(false);
            button.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(), R.color.colorGray));
        }
        if (mListener != null)
            mListener.onPlayerSelected(counter, number);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPlayerSelectedListener)
            mListener = (OnPlayerSelectedListener) context;
        else {
            throw new RuntimeException(context.toString()
                    + " must implement OnPlayerSelectedListener");
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
            case R.id.chopra :
                addTeam(isChecked);
                break;
            case R.id.midhunji :
                addTeam(isChecked);
                break;
            case R.id.abhi :
                addTeam(isChecked);
                break;
            case R.id.vivek :
                addTeam(isChecked);
                break;
            case R.id.thamizh :
                addTeam(isChecked);
                break;
            case R.id.bheegar :
                addTeam(isChecked);
                break;
            case R.id.kumar :
                addTeam(isChecked);
                break;
            case R.id.sonu :
                addTeam(isChecked);
                break;
            case R.id.nikhil :
                addTeam(isChecked);
                break;
            case R.id.sreeraj :
                addTeam(isChecked);
                break;
            case R.id.giri :
                addTeam(isChecked);
                break;
            case R.id.sanal :
                addTeam(isChecked);
                break;
            case R.id.kumman :
                addTeam(isChecked);
                break;
        }
    }

    public interface OnPlayerSelectedListener {
        void onPlayerSelected(int count, int player_no);
        void onSubmitClicked(List<String> playerList);
    }
}
