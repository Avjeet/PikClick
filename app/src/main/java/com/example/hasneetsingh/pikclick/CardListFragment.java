package com.example.hasneetsingh.pikclick;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardListFragment extends android.app.ListFragment {


    public CardListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("Allen Olsen","Google.com"));
        cards.add(new Card("Tony Martin","Master Card"));

        CardAdapter adapter = new CardAdapter(getActivity(),cards);
        setListAdapter(adapter);
    }
}
