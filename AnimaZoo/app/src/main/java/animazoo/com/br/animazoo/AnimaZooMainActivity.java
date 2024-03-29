package animazoo.com.br.animazoo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import animazoo.com.br.animazoo.activities.MammalsScrollingActivity;
import animazoo.com.br.animazoo.activities.RepitileScrollingActivity;
import animazoo.com.br.animazoo.adapters.ImageAdapter;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class AnimaZooMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String DEBUG = "Debug: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_anima_zoo_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        GridView gridView = (GridView) findViewById(R.id.gridViewMenu);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Toast.makeText(AnimaZooMainActivity.this, "" + position, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        Log.d(DEBUG, "Position: " + position);
                        Toast.makeText(AnimaZooMainActivity.this, R.string.mammals,
                                Toast.LENGTH_SHORT).show();
                        Intent itMammals = new Intent(getApplicationContext(), MammalsScrollingActivity.class);
                        startActivity(itMammals);

                        break;
                    case 1:
                        Log.d(DEBUG, "Position: " + position);
                        Toast.makeText(AnimaZooMainActivity.this, R.string.reptile,
                                Toast.LENGTH_SHORT).show();
                        Intent itRepitile = new Intent(getApplicationContext(), RepitileScrollingActivity.class);
                        startActivity(itRepitile);
                        break;
                    case 2:
                        Log.d(DEBUG, "Position: " + position);
                        Toast.makeText(AnimaZooMainActivity.this, R.string.fish,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Log.d(DEBUG, "Position: " + position);
                        Toast.makeText(AnimaZooMainActivity.this, R.string.bugs,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Log.d(DEBUG, "Position: " + position);
                        Toast.makeText(AnimaZooMainActivity.this, R.string.birds,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Log.d(DEBUG, "Position: " + position);
                        Toast.makeText(AnimaZooMainActivity.this, R.string.amphibians,
                                Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.anima_zoo_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
