package com.example.cv051529.cerner_interns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> {

    public EventAdapter(Context context, ArrayList<Event> events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get event
        Event event = getItem(position);

        //Create convert view if null
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_event, parent, false);
        }

        //Get text views
        TextView titleView =  convertView.findViewById(R.id.title);
        TextView descriptionView = convertView.findViewById(R.id.description);
        TextView locationView = convertView.findViewById(R.id.location);

        //Set values for text views
        titleView.setText(event.title);
        descriptionView.setText(event.description);
        locationView.setText(event.location);

        if (position % 2 == 0) {
            convertView.setBackgroundResource(R.color.colorOffWhite);
        }

        return convertView;
    }
}
