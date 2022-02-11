package edu.cascadia.mobas.pollinatorpathway.ui.Maps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.cascadia.mobas.pollinatorpathway.R;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            // Existing pollinator coordinates
            LatLng initialView = new LatLng(47.5, -122.125);
            LatLng twentyOneAcres = new LatLng(47.44596, -122.09256);
            LatLng songaia = new LatLng (47.47389, -122.10399);
            LatLng coastal = new LatLng (47.75539016612721, -122.15313690518046);
            LatLng hawthorn = new LatLng (47.46088, -122.06274);
            LatLng redBarn = new LatLng (47.39252, -122.0345);
            //Add markers on map for pollinators
            googleMap.addMarker(new MarkerOptions().position(twentyOneAcres).title("21 Acres"));
            googleMap.addMarker(new MarkerOptions().position(songaia)
                    .title("Songaia Co-Housing Community"));
            googleMap.addMarker(new MarkerOptions().position(coastal).title("Coastal Bank"));
            googleMap.addMarker(new MarkerOptions().position(hawthorn).title("Hawthorn Farm"));
            googleMap.addMarker(new MarkerOptions().position(redBarn).title("Red Barn Farm"));
            //zoom level and initial animation
            float zoomLevel = (float)9.8;
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(initialView, zoomLevel));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}