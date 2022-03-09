package edu.cascadia.mobas.pollinatorpathway.UI.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import edu.cascadia.mobas.pollinatorpathway.R;
import edu.cascadia.mobas.pollinatorpathway.databinding.FragmentHomeBinding;
import edu.cascadia.mobas.pollinatorpathway.databinding.FragmentLoginBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.testQR.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_QRcode2);
        });

        return root;
    }


}