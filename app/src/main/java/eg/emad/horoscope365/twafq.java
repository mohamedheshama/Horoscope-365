package eg.emad.horoscope365;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import eg.emad.horoscope365.Adapters.CustomSpinnnerAdapter;
import eg.emad.horoscope365.Utils.Config;

public class twafq extends AppCompatActivity {


    Spinner first_spinner;
    Spinner second_spinner;


    String[] abraj = null;
    String url = "";

    WebView webView;
    TextView bannerTwafq;
    CircleImageView myBorg;
    CircleImageView hereBorg;

    String my_borg = "";
    String her_borg = "";

    String myURL;
    String herURL;
    String body;
    Config config ;
    CustomSpinnnerAdapter customSpinnnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twafq);

        //customize toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6347")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#F0F8FF\">التوافق بين الأبراج</font>"));

        bannerTwafq = findViewById(R.id.bannerTwafq);
        bannerTwafq.setSelected(true);
        first_spinner = findViewById(R.id.first_spinner);
        second_spinner = findViewById(R.id.second_spinner);
        webView = findViewById(R.id.twaf2webview);

        myBorg = findViewById(R.id.imgMyBorg);
        hereBorg = findViewById(R.id.imghereBorg);
        config = new Config();
        customSpinnnerAdapter = new CustomSpinnnerAdapter();

        abraj = getResources().getStringArray(R.array.abraj2);

        first_spinner.setAdapter(customSpinnnerAdapter.getSpinnerAdapter(this, abraj));
        first_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                if (i >0){

                    my_borg = String.valueOf(adapterView.getItemAtPosition(i));
                    myURL = config.getMoovBorgImageUrl(my_borg);
                    Picasso.get().load(myURL).into(myBorg);
                    //first_spinner.setText(my_borg);

                    webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        second_spinner.setAdapter(customSpinnnerAdapter.getSpinnerAdapter(this, abraj));
        second_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                if (i >0){

                    her_borg = String.valueOf(adapterView.getItemAtPosition(i));
                    herURL = config.getMoovBorgImageUrl(her_borg);
                    Picasso.get().load(herURL).into(hereBorg);
                    //second_spinner.setText(her_borg);
                    webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //empty webview when user click any spinner
    }

    public void checkTwaf2(View view) {
        /**
         * here we set Url dependeing on selected Items
         */

        Log.i("RELATIONSHIP",config.getRelationship(this,"haml", "haml"));
        Log.i("RELATIONSHIP",my_borg);
        Log.i("RELATIONSHIP",her_borg);
//        config.setWebView(getApplicationContext(), webView, "https://www.google.com/");
        if (!"".equals(my_borg)){
            if (!"".equals(her_borg)){

                body = config.getRelationship(this,config.getBorgNameInFranko(my_borg), config.getBorgNameInFranko(her_borg));
                StringBuilder builder = config.returnHtml(body);
                //     webView.getSettings().setDefaultTextEncodingName("UTF-8");
                Log.i("RELATIONSHIP", body);

                webView.loadDataWithBaseURL(null, builder.toString(), "text/html", "UTF-8", null);
            }
        }else {
            View parentLayout = findViewById(android.R.id.content);
            final Snackbar snackbar = Snackbar.make(parentLayout, "تأكد من اختيارك للبرجين", Snackbar.LENGTH_LONG);
            snackbar.setAction("EXIT", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            })
                    .setActionTextColor(getResources().getColor(R.color.Tomato ))
                    .show();
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }
}