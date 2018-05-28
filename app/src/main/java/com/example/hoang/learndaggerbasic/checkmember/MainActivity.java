package com.example.hoang.learndaggerbasic.checkmember;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hoang.learndaggerbasic.R;
import com.example.hoang.learndaggerbasic.app.MyApp;
import com.example.hoang.learndaggerbasic.data.offline.MemberDataManager;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {
    private EditText memberId;
    private Button submitButton;

    @Inject @Named("local")
    MemberDataManager memberDataManager;
    @Inject @Named("mm-dd-yyy")
    String currentDate  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    Toast.makeText(getApplicationContext(), result + "---"+currentDate, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
