package edu.cascadia.mobas.pollinatorpathway.UI.SetUp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.cascadia.mobas.pollinatorpathway.databinding.FragmentSetupBinding;


public class SetUpFragment extends Fragment {

    private SetUpViewModel dashboardViewModel;
    private FragmentSetupBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(SetUpViewModel.class);

        binding = FragmentSetupBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}