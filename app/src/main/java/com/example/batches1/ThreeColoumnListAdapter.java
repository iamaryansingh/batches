package com.example.batches1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColoumnListAdapter extends ArrayAdapter<User> {
    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int aViewResourceid;

    public ThreeColoumnListAdapter(Context context, int textViewResourceId, ArrayList<User> users){
        super(context,textViewResourceId,users);
        this.users=users;
        mInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        aViewResourceid=textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parents){
        convertView=mInflater.inflate(aViewResourceid,null);
        User user = users.get(position);
        if(user!=null){
            TextView id=(TextView) convertView.findViewById(R.id.listid);
            TextView myname=(TextView) convertView.findViewById(R.id.listname);
            TextView phone=(TextView) convertView.findViewById(R.id.phone);
            if (id!=null){
                id.setText((user.getId()));
            }
            if (myname!=null){
                myname.setText((user.getMyname()));
            }
            if (phone!=null){
                phone.setText((user.getPhone()));
            }
        }
        return convertView;
    }
}
