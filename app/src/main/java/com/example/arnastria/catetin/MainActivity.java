package com.example.arnastria.catetin;

import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.arnastria.catetin.Fragment.EditorFragment;
import com.example.arnastria.catetin.Fragment.ListFragment;

public class MainActivity extends AppCompatActivity{

    AHBottomNavigation bottomNavigation;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomBar();
        ListFragment listFragment = new ListFragment();
        fragmentManager.beginTransaction().replace(R.id.main_fragment_placeholder,listFragment).commit();
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position){
                    case 0:
                        ListFragment listFragment = new ListFragment();
                        fragmentManager.beginTransaction().replace(R.id.main_fragment_placeholder,listFragment).commit();
                        break;
                    case 1:
                        EditorFragment editorFragment = new EditorFragment();
                        fragmentManager.beginTransaction().replace(R.id.main_fragment_placeholder,editorFragment).commit();
                        break;
                }
                return true;
            }
        });

    }

    void initBottomBar(){
        bottomNavigation = findViewById(R.id.main_bottom_bar);
        AHBottomNavigationItem item1_List = new AHBottomNavigationItem("List",R.drawable.ic_format_list_bulleted_black_24dp);
        AHBottomNavigationItem item2_editor = new AHBottomNavigationItem("Editor",R.drawable.ic_edit_black_24dp);


        bottomNavigation.addItem(item1_List);
        bottomNavigation.addItem(item2_editor);

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        bottomNavigation.setAccentColor(R.color.colorAccent);
    }
}
