package com.example.pulkit.fragmentlifecycle;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by pulkit on 8/13/15.
 */
public class BottomFragment extends Fragment implements View.OnClickListener{
    Button button;
    Communicator communicator;
    int counter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            counter =0;
        }else {
            counter = savedInstanceState.getInt("Counter",0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment,container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator = (Communicator) getActivity();
        button= (Button) getActivity().findViewById(R.id.clickMe);
        button.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Counter", counter);
    }

    @Override
    public void onClick(View v) {
        counter++;
        communicator.response("Counter " + counter );
    }
}
