package edu.cascadia.mobas.pollinatorpathway.ui.QRcode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.cascadia.mobas.pollinatorpathway.R;

public class QRcode extends Fragment {

    private QRcodeViewModel mViewModel;

    public static QRcode newInstance() {
        return new QRcode();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.qrcode_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(QRcodeViewModel.class);
        // TODO: Use the ViewModel
    }

}