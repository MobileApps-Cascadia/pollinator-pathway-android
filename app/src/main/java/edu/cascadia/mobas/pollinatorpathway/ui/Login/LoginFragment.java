package edu.cascadia.mobas.pollinatorpathway.ui.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cascadia.mobas.pollinatorpathway.R;
import edu.cascadia.mobas.pollinatorpathway.databinding.FragmentLoginBinding;



public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;
    private FragmentLoginBinding binding;

    Button mlogin;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        loginViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mlogin = (Button) root.findViewById(R.id.button2);

        mlogin.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_navigation_login_to_profileFragment);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}