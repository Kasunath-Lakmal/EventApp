package com.example.eventapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

// 18 .steps

public class EventAdapter extends ArrayAdapter<EventModel> {

    //19. CREATE DEFAULT CONSTRUCTOR
// CONTEXT EKA, RESOURCE EKA,LAYOUT EKA), DATA SOURCE EKA [ WAME EDALA DAKUNATA]
    private Context context;
    private int resource;
    List<EventModel> list2;

    EventAdapter(Context context, int resource, List<EventModel> elist) {
        super(context, resource, elist);
        this.context = context;
        this.resource = resource;
        this.list2 = elist;
    }

    //20. CREATE getView() METHOD.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//MEMA method eken thama api dakin eka list item ekk hadala denne.
//21. row_layout EKA JAVA PETHTHTATA CONVERT KARAGANNA ONI (LayoutInflater)
        // CREATE THE OBJECT.
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);
//JAVA PETHTHATA View eken thama data enne.[MEHI resource EKA KIYANNE LAYOUT EKA [row_layout]]
//22. layout eke thiyena TEXTVIEW and IMAGEVIEW java peththta gamu.
        TextView title = row.findViewById(R.id.textView);
        TextView description = row.findViewById(R.id.textView2);
        ImageView imageView = row.findViewById(R.id.onGoing);
//23. LAYOUT EKATA DATA SET KERIMA (TEXTVIEW and IMAGEVIEW)
        EventModel eventModel = list2.get(position);
        title.setText(eventModel.getTitle());
        description.setText(eventModel.getDescription());
        imageView.setVisibility(row.INVISIBLE);
// ADDITIONAL
        if(eventModel.getFinished()>0) {
            imageView.setVisibility(View.VISIBLE);
        }
        return row;
// 24. dan mema adapter eka MainActivity eke thiyena ListView ekata set karanna oniii..
    }


}

