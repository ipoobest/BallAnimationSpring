package com.learnandroid.superpoohh.ballanimation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learnandroid.superpoohh.ballanimation.R;
import com.learnandroid.superpoohh.ballanimation.model.AnimationItem;

import java.util.List;

/**
 * Created by superpoohh on 6/6/2017.
 */

public class AnimationAdapter extends RecyclerView.Adapter<AnimationAdapter.AnimationHolder> {

    private List<AnimationItem> mItems;
    private AnimationItemClickListener listener;

    public AnimationAdapter(List<AnimationItem> mItems) {
        this.mItems = mItems;
    }

    @Override
    public AnimationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);
        return new AnimationHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimationHolder holder, int position) {
        AnimationItem item = mItems.get(position);
        holder.setTitle(item.getTitle());
        holder.setDescription(item.getDescription());
        holder.setupItemViewClickListener();
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void setAnimationClickListener(AnimationItemClickListener listener) {
        this.listener = listener;
    }

    public interface AnimationItemClickListener {
        void onAnimationItemClick(AnimationItem item);
    }

    class AnimationHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        private TextView tvTitle, tvDescription;

        public AnimationHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_name);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
        }

        public void setTitle(String title) {
            tvTitle.setText(title);
        }

        public void setDescription(String description) {
            tvDescription.setText(description);
        }

        public void setupItemViewClickListener() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onAnimationItemClick(mItems.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
