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
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {
    public static final String ARG_PARAM1 = "result";
    private List<String> result;

    public ResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ResultFragment.
     */
    public static ResultFragment newInstance(List<String> result) {
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ARG_PARAM1, (ArrayList<String>) result);
        resultFragment.setArguments(bundle);
        return resultFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            result = getArguments().getStringArrayList(ARG_PARAM1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        ListView listView = view.findViewById(R.id.lis_view);
        ResultListAdapter adapter = new ResultListAdapter(getActivity(), R.layout.item_result, result);
        listView.setAdapter(adapter);
        return view;
    }
}
