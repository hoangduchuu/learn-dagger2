package com.example.hoang.learndaggerbasic.welcome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hoang.learndaggerbasic.R;
import com.example.hoang.learndaggerbasic.app.MyApp;
import com.example.hoang.learndaggerbasic.models.MessageGenerator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hoang on 30/05/2018 nhe.
 */

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.tvResultAtWelcome)
    TextView tvResultAtWelcome;

    @Inject
    MessageGenerator messageGenerator;
    @BindView(R.id.tvMessage)
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        MyApp.getApp().getMemberAppComponent().inject(this);

        tvResultAtWelcome.setText(getIntent().getStringExtra("result"));

        tvMessage.setText(messageGenerator.getWelcomeMessage());


    }
}
