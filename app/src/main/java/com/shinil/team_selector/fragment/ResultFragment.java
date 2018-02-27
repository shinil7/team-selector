package com.shinil.team_selector.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.shinil.team_selector.R;
import com.shinil.team_selector.adapter.ResultListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shinilms
 */

public class ResultFragment extends Fragment {
    public static final String RESULT_PARAM = "result";
    private List<String> result;

    public ResultFragment() {
        //required empty public constructor
    }

    public static ResultFragment newInstance(List<String> result) {
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(RESULT_PARAM, (ArrayList<String>) result);
        resultFragment.setArguments(bundle);
        return resultFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            result = getArguments().getStringArrayList(RESULT_PARAM);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        ListView listView = view.findViewById(R.id.lis_view);
        ResultListAdapter adapter = new ResultListAdapter(getActivity(), R.layout.item_result, result);
        listView.setAdapter(adapter);
        return view;
    }
}
