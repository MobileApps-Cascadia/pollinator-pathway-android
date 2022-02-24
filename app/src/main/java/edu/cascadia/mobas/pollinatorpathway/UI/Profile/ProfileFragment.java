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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.cascadia.mobas.pollinatorpathway.Database.Planting.Planting;
import edu.cascadia.mobas.pollinatorpathway.R;
import edu.cascadia.mobas.pollinatorpathway.databinding.FragmentProfileBinding;
import edu.cascadia.mobas.pollinatorpathway.databinding.PlantingsItemLayoutBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding fragmentProfileBinding;
    private ProfileViewModel mViewModel;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       fragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false);

        LiveData<Planting> plantinglist = new LiveData<Planting>() {
            @Override
            protected void setValue(Planting value) {
                super.setValue(value);
            }

            @Nullable
            @Override
            public Planting getValue() {
                return super.getValue();
            }
        };


        RecyclerView mRecyclerView = fragmentProfileBinding.recyclerview;
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager= new GridLayoutManager(getContext(), 2);
        RecyclerView.Adapter mAdapter= new PlantingsAdapter(plantinglist);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
        return fragmentProfileBinding.getRoot();
    }

}