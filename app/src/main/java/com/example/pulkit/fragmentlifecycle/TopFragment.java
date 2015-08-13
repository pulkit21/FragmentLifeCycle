package com.example.pulkit.fragmentlifecycle;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pulkit on 8/13/15.
 */
public class TopFragment extends Fragment {

    TextView textView;
    String data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragament,container,false);
        if (savedInstanceState == null) {

        }else {
            data = savedInstanceState.getString("text");
            TextView textView = (TextView) view.findViewById(R.id.showText);
            textView.setText(data);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView) getActivity().findViewById(R.id.showText);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",data);
    }

    public void showContent(String data) {
        this.data = data;
        textView.setText(data);

    }
}
