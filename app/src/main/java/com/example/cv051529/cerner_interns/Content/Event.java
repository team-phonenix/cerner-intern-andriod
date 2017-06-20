package com.example.cv051529.cerner_interns.Content;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by cv051529 on 6/19/17.
 */

public class Event {
    public final int id;
    public final String title;
    public final String description;
    public final String location;
    public final String startTime;
    public final String endTime;

    public Event(int id, String title, String description, String location,
                     String startTime, String endTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return title;
    }

    public static ArrayList<Event> createEvents(JSONArray jsonArray) {
        ArrayList<Event> events = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject obj = jsonArray.getJSONObject(i);
                Event event = new Event(obj.getInt("id"), obj.getString("title"), obj.getString("description"),
                        obj.getString("location"), obj.getString("startTime"), obj.getString("endTime"));
                events.add(event);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return events;
    }
}
