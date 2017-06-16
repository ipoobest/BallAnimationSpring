package com.learnandroid.superpoohh.ballanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.learnandroid.superpoohh.ballanimation.adapter.AnimationAdapter;
import com.learnandroid.superpoohh.ballanimation.animations.springforce.position.PositionSpringAnimationActivity;
import com.learnandroid.superpoohh.ballanimation.animations.springforce.rotation.RotationSpringAnimationActivity;
import com.learnandroid.superpoohh.ballanimation.animations.springforce.scale.ScaleSpringAnimationActivity;
import com.learnandroid.superpoohh.ballanimation.model.AnimationItem;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));

        List<AnimationItem> items = new ArrayList<>();

        items.add(new AnimationItem(getString(R.string.position),
                new Intent(this, PositionSpringAnimationActivity.class)));


        items.add(new AnimationItem(getString(R.string.rotation),
                new Intent(this, RotationSpringAnimationActivity.class)));

        items.add(new AnimationItem(getString(R.string.scale),
                new Intent(this, ScaleSpringAnimationActivity.class)));

        recyclerView.setAdapter(new AnimationAdapter(items, this));



    }
}
