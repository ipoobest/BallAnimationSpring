package com.learnandroid.superpoohh.ballanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.learnandroid.superpoohh.ballanimation.adapter.AnimationAdapter;
import com.learnandroid.superpoohh.ballanimation.animations.springforce.position.PositionSpringAnimationActivity;
import com.learnandroid.superpoohh.ballanimation.animations.springforce.rotation.RotationSpringAnimationActivity;
import com.learnandroid.superpoohh.ballanimation.animations.springforce.scale.ScaleSpringAnimationActivity;
import com.learnandroid.superpoohh.ballanimation.model.AnimationItem;

import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity implements AnimationAdapter.AnimationItemClickListener {
    private RecyclerView recyclerView;
    private AnimationAdapter animationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        animationAdapter = new AnimationAdapter(createAnimationItemList());
        animationAdapter.setAnimationClickListener(this);
        recyclerView.setAdapter(animationAdapter);
    }

    @Override
    public void onAnimationItemClick(AnimationItem item) {
        startActivity(item.getIntent());
    }

    private List<AnimationItem> createAnimationItemList() {
        return Arrays.asList(
                new AnimationItem(getString(R.string.position), "hello",
                        new Intent(this, PositionSpringAnimationActivity.class)),
                new AnimationItem(getString(R.string.rotation), "hello",
                        new Intent(this, RotationSpringAnimationActivity.class)),
                new AnimationItem(getString(R.string.scale), "hello",
                        new Intent(this, ScaleSpringAnimationActivity.class))
        );
    }
}
