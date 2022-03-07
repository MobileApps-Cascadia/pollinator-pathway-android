package edu.cascadia.mobas.pollinatorpathway.UI.Profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.cascadia.mobas.pollinatorpathway.Database.Planting.Planting;
import edu.cascadia.mobas.pollinatorpathway.R;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlantingsAdapter extends RecyclerView.Adapter<PlantingsAdapter.PlantingsViewHolder> {
 private List<Planting> mPlantingsList;

    public static class PlantingsViewHolder extends RecyclerView.ViewHolder{
    public TextView mTextView;
    public TextView mTextView2;
    public ImageView mImageView;

        public PlantingsViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.plantings_title);
            mTextView2 = itemView.findViewById(R.id.plantings_description);
            mImageView = itemView.findViewById(R.id.cardViewImage);
        }
    }

    public void updatePlantings(List<Planting> plantinglist) {
        mPlantingsList = plantinglist;
        notifyDataSetChanged();
    }

    public PlantingsAdapter(List<Planting> plantingslist){
        mPlantingsList = plantingslist;
    }

    @Override
    public PlantingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantings_item_layout, parent, false);
      PlantingsViewHolder pvh = new PlantingsViewHolder(v);
      return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlantingsViewHolder holder, int position) {
        Planting currentItem = mPlantingsList.get(position);

        assert currentItem != null;
        holder.mTextView.setText(currentItem.getName());
        holder.mTextView2.setText(currentItem.getDescription());
        holder.mImageView.setImageResource(currentItem.getImage());
    }

    @Override
    public int getItemCount() {
       if (mPlantingsList != null) return mPlantingsList.size();
       else return 0;
    }
}
