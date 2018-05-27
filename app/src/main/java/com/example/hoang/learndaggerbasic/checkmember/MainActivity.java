package com.example.hoang.learndaggerbasic.checkmember;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hoang.learndaggerbasic.R;
import com.example.hoang.learndaggerbasic.app.MyApp;
import com.example.hoang.learndaggerbasic.data.MemberDataManager;
import com.example.hoang.learndaggerbasic.di.DaggerMemberAppComponent;
import com.example.hoang.learndaggerbasic.di.MemberDataModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private EditText memberId;
    private Button submitButton;

    @Inject
    MemberDataManager memberDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerMemberAppComponent
//                .builder()
//                .memberDataModule(new MemberDataModule())
//                .build().inject(this);
        MyApp.getApp().getMemberAppComponent().inject(this);

        memberId = (EditText) findViewById(R.id.etMemberId);
        submitButton = (Button) findViewById(R.id.btnSubmit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if ((memberId.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(), "Member ID is empty", Toast.LENGTH_SHORT).show();
                } else {

                    String input = memberId.getText().toString();
                    String result = memberDataManager.checkMemberStatus(input);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
