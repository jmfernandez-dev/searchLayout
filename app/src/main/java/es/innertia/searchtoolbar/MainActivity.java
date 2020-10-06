package es.innertia.searchtoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.appbar.MaterialToolbar;


public class MainActivity extends AppCompatActivity {
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPress = findViewById(R.id.btnPress);
        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchFragment();
            }
        });

        toolbar = findViewById(R.id.topAppBar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId() == R.id.menu_search) {
                    openSearchFragment();
                }
                return false;
            }
        });

    }

    private void openSearchFragment() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.enter_from_left)
                .add(R.id.action_container, new BlankFragment())
                .addToBackStack(null);

        ft.commit();
        toolbar.setVisibility(View.GONE);
    }


    public void checkVisivilityToolBar() {

        if (toolbar.getVisibility() == View.GONE) {
            this.toolbar.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        checkVisivilityToolBar();
    }
}