package com.example.quizapp.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityMainBinding;

/**
 * <p>MainActivity is the main entry point of the QuizApp.</p>
 *
 * This activity sets up the navigation components and handles the action bar interactions.
 * It uses View Binding to access the layout elements and provides navigation between fragments.
 *
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Configuration for the AppBar, used to manage navigation UI components.
     */
    private AppBarConfiguration appBarConfiguration;

    /**
     * Called when the activity is first created.
     * Sets up the layout, toolbar, and navigation components.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using View Binding
        com.example.quizapp.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set up the toolbar
        setSupportActionBar(binding.toolbar);

        // Set up navigation controller
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration); // Commented out to avoid exploiting the action bar
    }

    /**
     * Initializes the contents of the Activity's standard option's menu.
     *
     * @param menu The options menu in which you place your items.
     * @return true if the menu should be displayed; false otherwise.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles item selection in the option's menu.
     *
     * @param item The menu item that was selected.
     * @return true if the event was handled; false otherwise.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Get the id of the item
        int id = item.getItemId();

        // Navigating between fragments
        if (id == R.id.action_settings) {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.settingsFragment);
        } else if (id == R.id.action_menu) {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.mainMenuFragment);
        } else if (id == R.id.action_debug) {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.debugFragment);
        }

        // Return the super class
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handles navigation when the user chooses to navigate "Up" within the application's activity hierarchy.
     *
     * @return true if navigation was successful; false otherwise.
     */
    @Override
    public boolean onSupportNavigateUp() {
        // Navigate up to the parent node of the current destination
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}