package android.app.hotel;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private MoreFragment moreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);

        moreFragment = new MoreFragment();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_more:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(moreFragment);
                        return true;

                        default:
                            return true;
                }
            }
        });
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
