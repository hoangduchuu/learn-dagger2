package com.example.hoang.learndaggerbasic.data.offline;

import android.content.SharedPreferences;

import com.example.hoang.learndaggerbasic.data.online.NetWorkManager;
import com.example.hoang.learndaggerbasic.models.Member;

import java.util.ArrayList;

/**
 * Created by hoang on 27/05/2018 nhe.
 */
public class MemberDataManager {

    private String memberStatus;
    private ArrayList<Member> members = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    public static final String COUNTER_KEY = "counter";
    private int currentCount;



    public MemberDataManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;

        populateData();
    }

    public MemberDataManager(SharedPreferences sharedPreferences, NetWorkManager netWorkManager) {
        this.sharedPreferences = sharedPreferences;

        populateData();
    }


    public String checkMemberStatus(String userInput) {

        memberStatus = "Access Denied";

        for (Member m : members) {


            if ((m.getMemberId().equals(userInput))) {

                updateAccessCount();
                memberStatus = "Access Granted + : " + currentCount;


            }


        }


        return memberStatus;
    }

    private void updateAccessCount() {
        sharedPreferences.edit().putInt(COUNTER_KEY, getCurrentCount() + 1).apply();
    }

    public int getCurrentCount() {
        return currentCount = sharedPreferences.getInt(COUNTER_KEY, -1);
    }


    private void populateData() {

        members.add(new Member("123", "Tom", "tom@gmail.com"));
        members.add(new Member("127", "Sam", "sam@gmail.com"));
        members.add(new Member("670", "Jack", "jack@gmail.com"));
        members.add(new Member("230", "Frank", "frank@gmail.com"));
        members.add(new Member("118", "Mary", "mary@gmail.com"));
        members.add(new Member("602", "Sara", "sara@gmail.com"));


    }


}
