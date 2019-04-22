package eg.emad.horoscope365;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import eg.emad.horoscope365.Utils.Config;

public class Properities extends AppCompatActivity {

    String url ="http://square.github.io/picasso/";

    CircleImageView borgImg;
    ImageView propHeader;
    TextView txtBorg;
    WebView webView ;
    String borgName = "";
    int borgIndex;
    Config config;
    String bor_url;
    private static final String TAG = "Properities";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properities);

        config = new Config();
        Intent intent = getIntent();
        borgName = intent.getStringExtra("borgName");
        borgIndex = intent.getIntExtra("borgIndex", -1);

        StringBuilder toolbarTitle  = new StringBuilder();
        toolbarTitle.append("خصائص ");
        toolbarTitle.append(borgName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6347")));
        // getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#F0F8FF\">"+"خصائص "+borgName+"</font>"));
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#F0F8FF\">"+toolbarTitle+"</font>"));
        Log.i(TAG,borgName);

        borgImg = findViewById(R.id.borgImg);
        txtBorg = findViewById(R.id.txt_borg);
        webView = findViewById(R.id.webViewBorg);
        propHeader = findViewById(R.id.propHeader);

        //   String imgHeader = "https://image.ibb.co/ga5sET/mo.jpg";
        String imgHeader = "https://image.ibb.co/mCRiqU/p035d0qg.jpg";

        bor_url = config.getBorgImageUrl(borgName);
        Picasso.get().load(bor_url).into(borgImg);

        Picasso.get().load(imgHeader).into(propHeader);

        if (!("".equals(borgName))) {
            txtBorg.setText(borgName);
        }
        config.setWebView(getApplicationContext(), webView, config.getMqalatUrl(borgName));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }
}