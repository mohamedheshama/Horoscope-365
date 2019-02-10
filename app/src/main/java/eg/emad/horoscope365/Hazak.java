package eg.emad.horoscope365;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Arrays;

import eg.emad.horoscope365.Utils.Config;

public class Hazak extends AppCompatActivity {

    static String API_URL;
    static TextView txtHoroscope;
    static TextView title;
    Context context;

    static Config config;
    static String choice;
    static String borgName;
    int borgIndex;
    Dialog copyDialog;
    BottomNavigationView bottom;
    static ProgressBar loading_indicator;
    private static final String TAG = "Hazak";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hazak);

        Intent intent = getIntent();
        borgName = intent.getStringExtra("borgName");
        borgIndex = intent.getIntExtra("borgIndex", -1);
        borgIndex--;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);

        getSupportActionBar().setTitle("");
        int actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        title=  findViewById(actionBarTitleId);
        // title.setTextColor(Integer.parseInt("000"));
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#F0F8FF\">" +borgName + "</font>"));

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6347")));

        context = this;
        bottom = findViewById(R.id.nav);
        bottom.getMenu().findItem(R.id.itemday).setChecked(true);
        bottom.setSelected(true);

        config = new Config();

        txtHoroscope = findViewById(R.id.hazakHoroscope);
        loading_indicator = findViewById(R.id.loading_indicator);

        txtHoroscope.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                copyDialog = new Dialog(context);
                copyDialog.setContentView(R.layout.dialog_copy);

                Button copy = copyDialog.findViewById(R.id.btnCopy);
                copy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipboardManager cManager = (ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData cData = ClipData.newPlainText("text", txtHoroscope.getText());
                        cManager.setPrimaryClip(cData);
                        Toast.makeText(context, "text copied", Toast.LENGTH_SHORT).show();
                        copyDialog.dismiss();
                    }
                });
                copyDialog.show();
                return true;
            }
        });


        final MenuItem year = bottom.getMenu().getItem(2);
        final MenuItem month = bottom.getMenu().getItem(1);
        final MenuItem day = bottom.getMenu().getItem(0);

        year.setTitle(config.getCurrentYear());
        month.setTitle(config.getMonthInArabic());
        day.setTitle(config.setDayName());

        // initially
        new TestParse().execute("Daily");

        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                loading_indicator.setVisibility(View.VISIBLE);
                switch (item.getItemId())
                {
                    case R.id.itemyear:
                        Log.d(TAG, "onNavigationItemSelected: ITEM YEAR");
                       new TestParse().execute("Monthly");

                        break;
                    case R.id.itemmonth:
                        //Log.d(TAG, "onNavigationItemSelected: ITEM Month");
                        new TestParse().execute("Weekly");

                        break;
                    case R.id.itemday:
                        //Log.d(TAG, "onNavigationItemSelected: ITEM DAY");
                        new TestParse().execute("Daily");

                        break;
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }


    class TestParse extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... horoscope) {
            try {
                String result="";
                String time ="";


                String astrology = Arrays.toString(horoscope).substring(1,Arrays.toString(horoscope).length()-1);
                Log.d(TAG, "doInBackground: "+astrology);

                String link = "http://www.al-abraj.com/Abraj/"+ astrology+"/General/"+config.getBorgNameInEnglish(borgName)+"/"+time;

                Document document =  Jsoup.connect(link).get();
                Elements elementText = document.getElementsByClass("HoroDailyText");
                Log.d(TAG, "doInBackground: " + link);
                Log.d(TAG, "doInBackground: "+ elementText.text());
                result = elementText.text();
                return result;

            } catch (Exception e) {
                Log.d(TAG, "Exception : "+ e.getMessage());
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d(TAG, "onPostExecute: "+ s);
            loading_indicator.setVisibility(View.GONE);
            if (s!=null){
                txtHoroscope.setText(s);
            }else {
                txtHoroscope.setText("Couldn`t connect to internet !");
            }
        }
    }

    public String detectURL(String period, String horoscope){
        // period {weekly, today, year}
        return "http://www.al-abraj.com/Abraj/"+period+"/General/"+horoscope;
    }
}
