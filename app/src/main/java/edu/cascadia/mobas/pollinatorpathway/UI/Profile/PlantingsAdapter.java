package edu.cascadia.mobas.pollinatorpathway.UI.Profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cascadia.mobas.pollinatorpathway.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlantingsAdapter extends RecyclerView.Adapter<PlantingsAdapter.PlantingsViewHolder> {
 private ArrayList<PlantingItem> mPlantingsList;

    public static class PlantingsViewHolder extends RecyclerView.ViewHolder{
    public TextView mTextView;
        public PlantingsViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById((R.id.plantings_title));
        }
    }

    public PlantingsAdapter(ArrayList<PlantingItem> plantingslist){
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
        PlantingItem currentItem = mPlantingsList.get(position);

        holder.mTextView.setText(currentItem.getPlantingText());
    }

    @Override
    public int getItemCount() {
        return mPlantingsList.size();
    }
}
