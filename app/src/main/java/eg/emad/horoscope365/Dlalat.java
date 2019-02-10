package eg.emad.horoscope365;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import eg.emad.horoscope365.Adapters.CustomSpinnnerAdapter;
import eg.emad.horoscope365.Utils.Config;

public class Dlalat extends AppCompatActivity {

    Spinner spinner;
    String[] dreams;
    String[] dreamDetails;
    TextView textView;

    CustomSpinnnerAdapter adapter;
    Config config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlalat);
        //customize toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6347")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#F0F8FF\"> دلالات الأحلام</font>"));

        config = new Config();
        adapter = new CustomSpinnnerAdapter();


        dreams =   getResources().getStringArray(R.array.dreams);
        dreamDetails =   getResources().getStringArray(R.array.detailsDreams);
        textView = findViewById(R.id.dreamDetail);

        spinner = findViewById(R.id.Spinner7elm);
        spinner.setAdapter(adapter.getSpinnerAdapter(this, dreams));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                textView.setText(dreamDetails[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }
}
