package com.example.assignment_4;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int lastExpandedGroup = -1;
    private ExpandableListView expandableListView;
    private CustomExpandableListAdapter adapter;
    private List<String> groupList;
    private HashMap<String, List<String>> childMap;
    private int[] images = {R.drawable.img_1, R.drawable.img, R.drawable.img_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        expandableListView = findViewById(R.id.expandableListView);

        // Prepare data
        prepareData();

        // Set up adapter
        adapter = new CustomExpandableListAdapter(this, groupList, childMap, images);
        expandableListView.setAdapter((ExpandableListAdapter) adapter);

        // Set listeners
        setListeners();
    }

    private void prepareData() {
        groupList = new ArrayList<>();
        childMap = new HashMap<>();

        groupList.add("Tulip");
        groupList.add("Rose");
        groupList.add("Orchid");

        List<String> tulipList = new ArrayList<>();
        tulipList.add("Scientific Name: Tulipa");
        tulipList.add("Genus: Tulipa");
        tulipList.add("Species: T. gesneriana");

        List<String> roseList = new ArrayList<>();
        roseList.add("Scientific Name: Rosa");
        roseList.add("Genus: Rosa");
        roseList.add("Species: R. indica");

        List<String> orchidList = new ArrayList<>();
        orchidList.add("Scientific Name: Orchidaceae");
        orchidList.add("Genus: Orchis");
        orchidList.add("Species: O. mascula");

        childMap.put(groupList.get(0), tulipList);
        childMap.put(groupList.get(1), roseList);
        childMap.put(groupList.get(2), orchidList);
    }

    private void setListeners() {
        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if (lastExpandedGroup != -1 && lastExpandedGroup != groupPosition) {
                expandableListView.collapseGroup(lastExpandedGroup); // Collapse previously expanded group
            }
            lastExpandedGroup = groupPosition;
        });

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String child = childMap.get(groupList.get(groupPosition)).get(childPosition);
            Toast.makeText(MainActivity.this, "Clicked: " + child, Toast.LENGTH_SHORT).show();
            return true;
        });

        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            Toast.makeText(MainActivity.this, "Group Clicked: " + groupList.get(groupPosition), Toast.LENGTH_SHORT).show();
            return false;
        });
    }
}