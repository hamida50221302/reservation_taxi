package com.example.hamida.taxi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.*;


public class reservation extends Fragment {


    private ArrayList<ContactPOJO> mArrayList;
    private RecyclerView mRecyclerView1;
    private RecyclerView mRecyclerView2;
    private CustomContactAdapter mAdapter;

    public reservation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_reservation , container , false );


        mRecyclerView1 = (RecyclerView) mRecyclerView1.findViewById( R.id.recyclerView );
        mRecyclerView2 = (RecyclerView) mRecyclerView2.findViewById( R.id.recyclerView2 );
        mArrayList = new ArrayList<>( );

        mAdapter = new CustomContactAdapter( mArrayList ) {
            @Override
            public int getItemCount() {
                return 0;
            }
        };
        mRecyclerView1.setLayoutManager( new LinearLayoutManager( getApplicationContext( ) ) );
        mRecyclerView1.setItemAnimator( new DefaultItemAnimator( ) );

        mRecyclerView1.addItemDecoration( new DividerItemDecoration( Context reservation.this , LinearLayoutManager.VERTICAL ) );
        mRecyclerView1.setAdapter( mAdapter );


        prepareData( );



    }
    private void prepareData() {
        ContactPOJO contact = null;
        contact = new ContactPOJO("getmDistance()","getmTime()","getmCourse()");
        boolean add = mArrayList.add( contact );


        mAdapter.notifyDataSetChanged();
    }

}