package com.example.hasneetsingh.pikclick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hasneetsingh on 08/02/17.
 */

public class NavigationListAdapter extends BaseAdapter {

    String [] drawerListItems;
    Context mContext;

    NavigationListAdapter(Context context){
        mContext = context;
        drawerListItems = context.getResources().getStringArray(R.array.drawer_list_items);
    }


    @Override
    public int getCount() {
        return drawerListItems.length;
    }

    @Override
    public Object getItem(int i) {
        return drawerListItems[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public class ViewHolder{
        TextView navigationListText;
        ImageView navigationListImage;
            ViewHolder(TextView navigationListText,ImageView navigationListImage){
                this.navigationListText = navigationListText;
                this.navigationListImage = navigationListImage;
            }
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row=view;
        ViewHolder holder = null;
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.navigation_single_row,viewGroup,false);
            TextView navigationText = (TextView) row.findViewById(R.id.navigation_text_item);
            ImageView navigationImage = (ImageView) row.findViewById(R.id.navigation_image_item);
            holder = new ViewHolder(navigationText,navigationImage);
            row.setTag(holder);
        }

        holder = (ViewHolder) row.getTag();
        holder.navigationListText.setText(drawerListItems[i]);
        holder.navigationListImage.setImageResource(android.R.drawable.star_big_on);
        return row;
    }

}
