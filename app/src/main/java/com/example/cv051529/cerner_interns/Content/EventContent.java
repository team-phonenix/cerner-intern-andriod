package com.example.cv051529.cerner_interns.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class EventContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<EventItem> ITEMS = new ArrayList<EventItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<Integer, EventItem> ITEM_MAP = new HashMap<Integer, EventItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createEventItem(i));
        }
    }

    private static void addItem(EventItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static EventItem createEventItem(int position) {
        return new EventItem(position, "Test Event", "Test Description", "Cerner", "Today", "Tomorrow");
    }


    /**
     * An event item representing whats in the DB
     */
    public static class EventItem {
        public final int id;
        public final String title;
        public final String description;
        public final String location;
        public final String startTime;
        public final String endTime;

        public EventItem(int id, String title, String description, String location,
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
    }
}
