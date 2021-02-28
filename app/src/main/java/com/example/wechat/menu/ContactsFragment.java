package com.example.wechat.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wechat.R;
import com.example.wechat.adapter.CallListAdapter;
import com.example.wechat.model.CallList;

import java.util.ArrayList;
import java.util.List;


public class ContactsFragment extends Fragment {



    public ContactsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        List<CallList> list = new ArrayList<>();
        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.recyclerViewContactsID);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        list.add(new CallList("1", "Shuvo Talukdar", "10/02/2020 , 9.30 pm","https://akm-img-a-in.tosshub.com/sites/btmt/images/stories/home-loan_660_020117053409_030917101300_103018074036.jpg", "missed"));
        list.add(new CallList("2", "Sima Talukdar", "10/12/2020 , 9.20 am","https://akm-img-a-in.tosshub.com/sites/btmt/images/stories/home-loan_660_020117053409_030917101300_103018074036.jpg", "income"));
        list.add(new CallList("3", "Shafi", "10/02/2020 , 9.30 pm","https://akm-img-a-in.tosshub.com/sites/btmt/images/stories/home-loan_660_020117053409_030917101300_103018074036.jpg", "outcome"));


        recyclerView.setAdapter(new CallListAdapter(list,getContext()));
        return view;

    }
}