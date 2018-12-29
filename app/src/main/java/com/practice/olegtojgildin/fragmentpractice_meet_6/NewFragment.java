package com.practice.olegtojgildin.fragmentpractice_meet_6;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by olegtojgildin on 29/12/2018.
 */

public class NewFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context context = getActivity().getApplicationContext();
        LinearLayout layout = new LinearLayout(context);
        layout.setBackgroundColor(Color.LTGRAY);
        TextView text = new TextView(context);
        EditText editText=getActivity().findViewById(R.id.editTextFirstFragment);
        layout.addView(text);
        layout.setGravity(1);
        text.setTextSize(50);
        text.setText(editText.getText().toString());
        return layout;
    }
    public static NewFragment newInstance(){
        return new NewFragment();
    }
}
