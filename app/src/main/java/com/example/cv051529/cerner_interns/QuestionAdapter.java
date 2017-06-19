package com.example.cv051529.cerner_interns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



/**
 * Created by DR051643 on 6/19/2017.
 */

public class QuestionAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Question> mDataSource;

    public QuestionAdapter(Context context, ArrayList<Question> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long)i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = mInflater.inflate(R.layout.list_item_question, viewGroup, false);

        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(R.id.recipe_list_title);

        // Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(R.id.recipe_list_subtitle);

        // Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(R.id.recipe_list_detail);

        // Get thumbnail element
        //ImageView thumbnailImageView =
        //       (ImageView) rowView.findViewById(R.id.recipe_list_verified_thumbnail);

        // 1
        Question question = (Question) getItem(i);

        // 2
        titleTextView.setText(question.title);
        subtitleTextView.setText(question.userEmail);
        SimpleDateFormat datetime = new SimpleDateFormat("MM/dd/YYYY");
        detailTextView.setText(datetime.format(question.date));

        // 3
        //Picasso.with(mContext).load(question.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        return rowView;
    }
}
