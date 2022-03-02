package edu.cascadia.mobas.pollinatorpathway.UI.Profile;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cascadia.mobas.pollinatorpathway.Database.Box.Box;
import edu.cascadia.mobas.pollinatorpathway.Database.Planting.Planting;
import edu.cascadia.mobas.pollinatorpathway.R;

public class BoxAdapter extends RecyclerView.Adapter<BoxAdapter.BoxViewHolder> {
    private List<Box> mBoxList;

    public static class BoxViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public TextView mTextView2;
        public BoxViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById((R.id));
            mTextView2 = itemView.findViewById((R.id.plantings_description));

        }
    }

    public void updatePlantings(List<Box> BoxList) {
        mBoxList = BoxList;
        notifyDataSetChanged();
    }

    public BoxAdapter(List<Box> BoxList){
        mBoxList = BoxList;
    }

    @Override
    public BoxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantings_item_layout, parent, false);
        BoxViewHolder pvh = new BoxViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull BoxViewHolder holder, int position) {
        Box currentItem = mBoxList.get(position);

        assert currentItem != null;
        holder.mTextView.setText(currentItem.getName());
        holder.mTextView2.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        if (mBoxList != null)
            return mBoxList.size();
        else return 0;
    }
}
