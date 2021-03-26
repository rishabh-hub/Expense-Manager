package com.example.expensemanager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expensemanager.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final ArrayList<String> DataSet1;
    private final ArrayList<String> localDataSet;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView tag;
        private final CardView cardView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.Name);
            tag = (TextView) view.findViewById(R.id.tag1);
            cardView = view.findViewById(R.id.cardView);


        }

        public TextView getTextView() {
            return textView;
        }
        public TextView getTextView2() {return tag;}



    }

    /**
     * Initialize the dataset of the Adapter.
     *  @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     * @param str
     */
    public CustomAdapter(ArrayList<String> dataSet, ArrayList<String> str) {
        localDataSet = dataSet;
        DataSet1 = str;


    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cards, viewGroup, false);


        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet.get(position));
        viewHolder.getTextView2().setText(DataSet1.get(position));
        viewHolder.cardView.setCardBackgroundColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return DataSet1.size();
    }
}


