package com.learnandroid.superpoohh.ballanimation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learnandroid.superpoohh.ballanimation.R;

/**
 * Created by superpoohh on 6/16/2017.
 */

public class DescriptionBottomSheetDialogFragment extends BottomSheetDialogFragment {
    String mString;

   public static DescriptionBottomSheetDialogFragment newInstance(String string) {
        DescriptionBottomSheetDialogFragment fragment = new DescriptionBottomSheetDialogFragment();
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
        View v = inflater.inflate(R.layout.bottom_dialog_sheet, container, false);
        return v;
    }

}
