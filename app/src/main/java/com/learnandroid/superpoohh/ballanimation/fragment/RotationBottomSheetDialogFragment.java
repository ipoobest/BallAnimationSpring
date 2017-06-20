package com.learnandroid.superpoohh.ballanimation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learnandroid.superpoohh.ballanimation.R;

import io.github.kbiakov.codeview.CodeView;

/**
 * Created by superpoohh on 6/16/2017.
 */

public class RotationBottomSheetDialogFragment extends BottomSheetDialogFragment {
    String mString;
    CodeView codeView;

   public static RotationBottomSheetDialogFragment newInstance(String string) {
        RotationBottomSheetDialogFragment fragment = new RotationBottomSheetDialogFragment();
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
        codeView = (CodeView) v.findViewById(R.id.code_view1);
        codeView.setCode(getString(R.string.listing_rotation_spring), "java");


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
