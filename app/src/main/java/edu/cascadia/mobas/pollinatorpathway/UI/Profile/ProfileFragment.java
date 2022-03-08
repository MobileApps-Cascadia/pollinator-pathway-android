package edu.cascadia.mobas.pollinatorpathway.UI.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cascadia.mobas.pollinatorpathway.Database.Box.Box;
import edu.cascadia.mobas.pollinatorpathway.Database.Planting.Planting;
import edu.cascadia.mobas.pollinatorpathway.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding fragmentProfileBinding;
    private FragmentProfileBinding fragmentProfileBindingBox;
    private ProfileViewModel mViewModel;
    private ProfileViewModel mBoxViewModel;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //inflate planting and box fragments
       fragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false);
       fragmentProfileBindingBox = FragmentProfileBinding.inflate(inflater, container, false);

        //create planting and box view models
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        mBoxViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        //populate planting and box viewModel via list
        LiveData<List<Planting>> plantinglist = mViewModel.getAllPlantings();
        LiveData<List<Box>> boxList = mBoxViewModel.getBoxes();

        //create planting and box recycler views
        RecyclerView mRecyclerView = fragmentProfileBinding.recyclerview;
        RecyclerView mBoxRecyclerView = fragmentProfileBindingBox.recyclerview;

        //create grid layout for planting and box views
        RecyclerView.LayoutManager mLayoutManager= new GridLayoutManager(getContext(), 2);
        RecyclerView.LayoutManager mBoxLayoutManager = new GridLayoutManager(getContext(), 2);

        //instantiate planting and box adapters
        PlantingsAdapter mAdapter= new PlantingsAdapter(plantinglist.getValue());
        BoxAdapter mBoxAdapter = new BoxAdapter(boxList.getValue());

        //set planting and box layout managers
        mRecyclerView.setLayoutManager(mLayoutManager);
        mBoxRecyclerView.setLayoutManager(mBoxLayoutManager);

        //set planting and box adapters
        mBoxRecyclerView.setAdapter(mBoxAdapter);
        mRecyclerView.setAdapter(mAdapter);

        //checking to see if planting data has been changed
        plantinglist.observe(getViewLifecycleOwner(), plantings -> {
           if (plantings != null) mAdapter.updatePlantings(plantings);
        });

        //Live data updater for list of boxes
        boxList.observe(getViewLifecycleOwner(), boxes -> {
            if (boxes != null)
                mBoxAdapter.updateBoxes(boxes);
                });

        return fragmentProfileBinding.getRoot();
    }
}