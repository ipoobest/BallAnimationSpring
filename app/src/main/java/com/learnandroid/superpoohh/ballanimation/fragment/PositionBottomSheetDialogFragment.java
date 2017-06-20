package com.learnandroid.superpoohh.ballanimation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learnandroid.superpoohh.ballanimation.R;


import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.classifier.CodeProcessor;

/**
 * Created by superpoohh on 6/16/2017.
 */

public class PositionBottomSheetDialogFragment extends BottomSheetDialogFragment {
    String mString;
    CodeView codeView;
    TextView tvDescription;

   public static PositionBottomSheetDialogFragment newInstance(String string) {
        PositionBottomSheetDialogFragment fragment = new PositionBottomSheetDialogFragment();
        Bundle args = new Bundle();
        args.putString("string", string);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mString = getArguments().getString("string");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_test, container, false);
        CodeProcessor.init(getContext());

        tvDescription = (TextView)v.findViewById(R.id.tv_description);
        tvDescription.setText("position");
        codeView = (CodeView) v.findViewById(R.id.code_view1);
        codeView.setCode(getString(R.string.listing_position_spring), "java");


        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //save state
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState !=null){

        //restore state

        }
    }
}
