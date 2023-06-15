package com.example.multiactivitycats;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView shortDescTextView;
        public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameText);
            shortDescTextView = (TextView) itemView.findViewById(R.id.subtitleText);
            imageView = (ImageView) itemView.findViewById(R.id.logoImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }
    }

    /***** Creating OnItemClickListener *****/

    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    private OnItemClickListener listener;
    private List<Cat> mCat;

    public CatAdapter(List<Cat> cats) {
        mCat = cats;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.cat_list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CatAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Cat cat = mCat.get(position);


        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(cat.getBreed());
        TextView textView2 = holder.shortDescTextView;
        textView2.setText(cat.getShortDescription());
        ImageView image = holder.imageView;
        Context context = holder.itemView.getContext();
        String imageName = cat.getThumbnail();
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        image.setImageResource(imageId);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mCat.size();
    }
}
