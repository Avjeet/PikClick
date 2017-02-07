package com.example.hasneetsingh.pikclick;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by AVJEET on 07-02-2017.
 */

public class CardAdapter extends ArrayAdapter<Card> {
    ViewHolder viewHolder=null;
    Context mContext;
    ArrayList<Card> mCards;

    CardAdapter(Activity activity,ArrayList<Card> cards ){
        super(activity,0, cards);
        mContext=activity.getBaseContext();
        mCards=cards;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView=convertView;

        Card currentCard= getItem(position);
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            viewHolder=new ViewHolder((TextView) listItemView.findViewById(R.id.name_circle),(TextView) listItemView.findViewById(R.id.name_textView),(TextView) listItemView.findViewById(R.id.company_textView));
            listItemView.setTag(viewHolder);
        }else{
            listItemView.getTag();
        }
        viewHolder.circleTextView.setText(currentCard.getFirstChar());
        viewHolder.nameTextView.setText(currentCard.getName());
        viewHolder.cNameTextView.setText(currentCard.getCompanyName());
    return listItemView;
    }
}
class ViewHolder{
    public TextView circleTextView;
    public TextView nameTextView;
    public TextView cNameTextView;

    ViewHolder(TextView mag,TextView name,TextView cName){
        circleTextView=mag;
        nameTextView=name;
        cNameTextView=cName;

    }
}
