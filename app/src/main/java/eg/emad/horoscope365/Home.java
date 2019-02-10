package eg.emad.horoscope365;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import eg.emad.horoscope365.Adapters.CustomSpinnnerAdapter;
import eg.emad.horoscope365.Adapters.HazakHomeRecycler;
import eg.emad.horoscope365.Adapters.ProperitiesHomeRecycler;
import eg.emad.horoscope365.Model.HomeItem;
import eg.emad.horoscope365.Utils.Config;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView ;
    TextView checkBorg;
    // WebView webView;
    NumberPicker dayPicker ;
    NumberPicker monthPicker;
    Button btnConfirmDialog;

    Config config;
    CustomSpinnnerAdapter customSpinnnerAdapter;
    String borgName;
    ImageView imgHeader;
    TextView today;
    Dialog dialog;
    Dialog secondDialog;
    Spinner spinnerHazak;
    Spinner spinnerProperites;

    RecyclerView hazakRecycler;
    HazakHomeRecycler hazakHomeRecycler;
    RecyclerView properitiesRecycler;
    ProperitiesHomeRecycler properitiesHomeRecycler;

    String []abraj;
    String []horoscope;
    String []horoscopeImages;

    private static final String TAG = "Home";
    ArrayList<HomeItem> homeItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//                   Caused by: java.lang.IllegalStateException: This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.

        config = new Config();
        customSpinnnerAdapter = new CustomSpinnnerAdapter();
        abraj = getResources().getStringArray(R.array.abraj);
        horoscope = getResources().getStringArray(R.array.abraj);
        horoscopeImages = getResources().getStringArray(R.array.abrajImages);

        checkBorg = findViewById(R.id.checkBorg);
        checkBorg.setSelected(true);

        homeItems = new ArrayList<>();
        fillList();

        hazakRecycler = findViewById(R.id.hazakRecycler);
        hazakRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        hazakHomeRecycler = new HazakHomeRecycler(homeItems, getApplicationContext());
        hazakRecycler.setAdapter(hazakHomeRecycler);

        properitiesRecycler = findViewById(R.id.properitiesRecycler);
        properitiesRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        properitiesHomeRecycler = new ProperitiesHomeRecycler(homeItems, getApplicationContext());
        properitiesRecycler.setAdapter(properitiesHomeRecycler);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        LinearLayout constraintLayout = findViewById(R.id.background);
        View items = navigationView.inflateHeaderView(R.layout.nav_header_home);

        imgHeader = items.findViewById(R.id.imgHeader);
        Picasso.get().load(config.getImgHeaderUrl()).into(imgHeader);

        Log.i("imgurl", config.getImgHeaderUrl());

        checkBorg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(Home.this);
                dialog.setContentView(R.layout.my_dialog);

                dayPicker = dialog.findViewById(R.id.dayPicker);
                monthPicker = dialog.findViewById(R.id.monthPicker);
                btnConfirmDialog = dialog.findViewById(R.id.confirmButton);

                dayPicker.setMinValue(1);
                dayPicker.setMaxValue(28);

                monthPicker.setMinValue(1);
                monthPicker.setMaxValue(12);

                monthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                        if (monthPicker.getValue() == 2)
                        {
                            dayPicker.setMinValue(1);
                            dayPicker.setMaxValue(28);
                            dayPicker.setValue(1);
                        }else {
                            dayPicker.setMinValue(1);
                            dayPicker.setMaxValue(31);
                        }
                    }
                });

                btnConfirmDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String borg = config.getBorg(dayPicker.getValue(), monthPicker.getValue());

                        secondDialog = new Dialog(Home.this);
                        secondDialog.setContentView(R.layout.second_dialog);
                        TextView textView = secondDialog.findViewById(R.id.yourBorg);
                        TextView txtClose = secondDialog.findViewById(R.id.closeDialog);
                        txtClose.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                secondDialog.dismiss();
                            }
                        });
                        textView.setText(   "أنت "+borg);
                        dialog.dismiss();
                        secondDialog.show();
                    }
                });
                dialog.show();
            }
        });

        spinnerHazak = (Spinner) navigationView.getMenu().findItem(R.id.abraj).getActionView();
        spinnerHazak.setAdapter(customSpinnnerAdapter.getSpinnerAdapter(this, abraj));
        spinnerHazak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                if (i >0){

                    borgName = (String) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(getApplicationContext(), Hazak.class);
                    intent.putExtra("borgName", borgName);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerProperites = (Spinner) navigationView.getMenu().findItem(R.id.propties).getActionView();
        spinnerProperites.setAdapter(customSpinnnerAdapter.getSpinnerAdapter(this, abraj));
        spinnerProperites.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                if (i >0){

                    borgName = (String) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(getApplicationContext(), Properities.class);
                    intent.putExtra("borgName", borgName);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    public ArrayList<HomeItem> fillList(){
        for (int x=0;x<horoscopeImages.length;x++){
            homeItems.add(new HomeItem(abraj[x+1], horoscopeImages[x]));
        }
        return homeItems;
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent ;
        if (id == R.id.abraj) {

        } else if (id == R.id.propties) {

        } else if (id == R.id.twaf2) {
            intent = new Intent(getApplicationContext(), twafq.class);
            startActivity(intent);
        } else if (id == R.id.dlalat) {
            intent = new Intent(Home.this, Dlalat.class);
            startActivity(intent);
        }/* else if (id == R.id.m2alat) {
            intent = new Intent(Home.this, mqalat.class);
            startActivity(intent);
        } */ else if (id == R.id.terms) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://horoscope365.000webhostapp.com/terms.html"));

            Intent chooser = Intent.createChooser(intent,"Select your favourite browser");
            startActivity(chooser);
            startActivity(intent);
        }/*else if (id == R.id.setting) {
            intent = new Intent(Home.this, setting.class);
            startActivity(intent);
        }*/else if (id == R.id.whatIsAbrag){
            final Dialog  dialog = new Dialog(this, android.R.style.Theme_Dialog);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.whatisabrag);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            dialog.getWindow().setLayout(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);

            TextView txtExit = dialog.findViewById(R.id.ex);
            txtExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
/**
 *
 * package eg.emad.horoscope365;

 import android.os.Bundle;
 import android.support.design.widget.FloatingActionButton;
 import android.support.design.widget.Snackbar;
 import android.view.View;
 import android.support.design.widget.NavigationView;
 import android.support.v4.view.GravityCompat;
 import android.support.v4.widget.DrawerLayout;
 import android.support.v7.app.ActionBarDrawerToggle;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.Toolbar;
 import android.view.Menu;
 import android.view.MenuItem;

 public class MainActivity extends AppCompatActivity
 implements NavigationView.OnNavigationItemSelectedListener {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
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
drawer.addDrawerListener(toggle);
toggle.syncState();

NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
navigationView.setNavigationItemSelectedListener(this);
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
getMenuInflater().inflate(R.menu.main, menu);
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

 */