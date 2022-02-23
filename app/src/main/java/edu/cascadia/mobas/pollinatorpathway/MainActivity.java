package edu.cascadia.mobas.pollinatorpathway;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.cascadia.mobas.pollinatorpathway.databinding.ActivityMainBinding;
import edu.cascadia.mobas.pollinatorpathway.Database.PnwppDb;
import edu.cascadia.mobas.pollinatorpathway.UI.Profile.PlantingItem;
import edu.cascadia.mobas.pollinatorpathway.UI.Profile.PlantingsAdapter;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ActivityMainBinding binding;
    private PnwppDb mPnwppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<PlantingItem> plantinglist = new ArrayList<>();
        plantinglist.add(new PlantingItem("21 Acres"));
        plantinglist.add(new PlantingItem("Songaia Co-House"));
        plantinglist.add(new PlantingItem("Coastal Bank"));
        plantinglist.add(new PlantingItem("Hawthorn Farm"));
        plantinglist.add(new PlantingItem("Red Barn Farm"));

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new PlantingsAdapter(plantinglist);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        binding = ActivityMainBinding.inflate(getLayoutInflater()); 
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_setup, R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        mPnwppDatabase = PnwppDb.getInstance(getApplicationContext());
    }
}