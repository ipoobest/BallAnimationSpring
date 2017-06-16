package com.learnandroid.superpoohh.ballanimation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learnandroid.superpoohh.ballanimation.model.AnimationItem;

import java.util.List;

/**
 * Created by superpoohh on 6/6/2017.
 */

public class AnimationAdapter extends RecyclerView.Adapter<AnimationAdapter.AnimationHolder> {

    private final List<AnimationItem> mItems;
    private final Context mContext;

    public AnimationAdapter(List<AnimationItem> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
    }

    @Override
    public AnimationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new AnimationHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimationHolder holder, int position) {
        holder.mTitle.setText(mItems.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }



        private TextView mTitle;

        class AnimationHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
            public final TextView mTitle;

            public AnimationHolder(android.view.View itemView) {
                super(itemView);
                mTitle = (TextView) itemView.findViewById(android.R.id.text1);
                mTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(mItems.get(getAdapterPosition()).getIntent());
                    }
                });
            }
        }



}
