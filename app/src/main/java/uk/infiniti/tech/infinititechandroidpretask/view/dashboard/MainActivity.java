package uk.infiniti.tech.infinititechandroidpretask.view.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uk.infiniti.tech.infinititechandroidpretask.R;
import uk.infiniti.tech.infinititechandroidpretask.model.LoginPreferences;
import uk.infiniti.tech.infinititechandroidpretask.model.UserResponse;
import uk.infiniti.tech.infinititechandroidpretask.view.NavigationAdapter;
import uk.infiniti.tech.infinititechandroidpretask.view.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements MainCommunicator.MainView {
    private BottomNavigationView bottomNavigationView;
    private MaterialToolbar topAppBar;
    private DrawerLayout drawerLayout;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter listAdapter;
    private LoginPreferences loginPreferences;
    private Context context = this;
    private MainPresenter presenter;
    private UserResponse userResponse;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this, this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        topAppBar = findViewById(R.id.topAppBar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        loginPreferences = new LoginPreferences(this);

        userResponse = loginPreferences.getUserInfo();
        
        topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.settings:
                        showMessage("Setting");
                        return true;
                    case R.id.logout:
                        SharedPreferences settings = context.getSharedPreferences("UserLoginPref", Context.MODE_PRIVATE);
                        settings.edit().clear().commit();

                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                        //showMessage("Logout");
                        return true;
                    default:
                        return false;
                }
            }
        });

        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> items = new ArrayList<>();
                HashMap<String, List<String>> subItems = new HashMap<>();
                drawerLayout.openDrawer(GravityCompat.START);
                presenter.handelNavigationItems(items,subItems);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            String message = "";

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        //message = "Home";
                        showMessage("Home");
                        item.setChecked(true);
                        break;
                    case R.id.account:
                        //message = "Account";
                        showMessage("Account");
                        item.setChecked(true);
                        break;
                }

                //Toast.makeText(context, message + " Button Pressed", Toast.LENGTH_SHORT).show();
                return false;
            }

        });
    }


    private void showMessage(String message) {
        Toast.makeText(this, message + " Button Pressed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void actOnNavigationItem(List<String> items, HashMap<String, List<String>> subItems) {

        TextView ownerName = findViewById(R.id.userNameTV);
        TextView ownerEmail = findViewById(R.id.userEmailTV);

        ownerName.setText(userResponse.getPayload().getUserInfo().getOwnername());
        ownerEmail.setText(userResponse.getPayload().getUserInfo().getEmail());

        expandableListView = findViewById(R.id.expandableListView);

        listAdapter = new NavigationAdapter(this, items, subItems);
        expandableListView.setAdapter(listAdapter);


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (subItems.get(items.get(groupPosition)) != null && !subItems.get(items.get(groupPosition)).equals("")) {

                    if (expandableListView.isGroupExpanded(groupPosition)) {
                        expandableListView.collapseGroup(groupPosition);
                    } else {
                        expandableListView.expandGroup(groupPosition);
                    }

                } else {
                    expandableListView.collapseGroup(groupPosition);
                    Toast.makeText(v.getContext(), "Subcategory is empty", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedGroupPosition = -1;

            @Override
            public void onGroupExpand(int groupPosition) {

                if (lastExpandedGroupPosition != -1 && groupPosition != lastExpandedGroupPosition) {
                    expandableListView.collapseGroup(lastExpandedGroupPosition);
                }
                lastExpandedGroupPosition = groupPosition;
            }
        });
    }
}