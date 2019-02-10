package eg.emad.horoscope365.Utils;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import eg.emad.horoscope365.R;

/**
 * Created by emad on 2/10/19.
 */

public class Config {
    WebView webView;
    static String mqalatURL = "https://www.google.com";
    static String borg_URL = "";
    String ch = "DDD";

    public String getCurrentYear() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }
    public String getMonthInArabic()
    {
        Calendar calendar = Calendar.getInstance();
        String tempMonth = new SimpleDateFormat("MMM").format(calendar.getTime());
        tempMonth = tempMonth.toLowerCase();
        String month;
        if ("jan".equals(tempMonth)) {
            month = "يناير";
        }else if ("feb".equals(tempMonth)) {
            month = "فبراير";
        }else if ("mar".equals(tempMonth)) {
            month = "مارس";
        }else if ("apr".equals(tempMonth)) {
            month = "أبريل";
        }else if ("may".equals(tempMonth)) {
            month = "مايو";
        }else if ("jun".equals(tempMonth)) {
            month = "يونيه";
        }else if ("jul".equals(tempMonth)) {
            month = "يوليو";
        }else if ("aug".equals(tempMonth)) {
            month = "أغسطس";
        }else if ("sep".equals(tempMonth)) {
            month = "سبتمبر";
        }else if ("oct".equals(tempMonth)) {
            month = "أكتوبر";
        }else if ("nov".equals(tempMonth)) {
            month = "نوفمبر";
        }else if ("dec".equals(tempMonth)) {
            month = "ديسمبر";
        }else {
            month = "هذا الشهر";
        }
        return tempMonth;
    }

    public String getMqalatUrl(String borgName)
    {
        String url = "" ;
        if ("برج الحمل".equals(borgName))
        {
            url = "file:///android_asset/haml.html";
            return url;
        }else if ("برج الثور".equals(borgName))
        {
            url = "file:///android_asset/toor.html";
            return url;
        }else if ("برج الجوزاء".equals(borgName))
        {
            url = "file:///android_asset/gwzaa.html";
            return url;
        }else if ("برج السرطان".equals(borgName))
        {
            url = "file:///android_asset/srtan.html";
            return url;
        }else if ("برج الأسد".equals(borgName))
        {
            url = "file:///android_asset/asad.html";
            return url;
        }else if ("برج العذراء".equals(borgName))
        {
            url = "file:///android_asset/azraa.html";
            return url;
        }else if ("برج الميزان".equals(borgName))
        {
            url = "file:///android_asset/meezan.html";
            return url;
        }else if ("برج العقرب".equals(borgName))
        {
            url = "file:///android_asset/arab.html";
            return url;
        }else if ("برج القوس".equals(borgName))
        {
            url = "file:///android_asset/qoos.html";
            return url;
        }else if ("برج الحوت".equals(borgName))
        {
            url = "file:///android_asset/hoot.html";
            return url;
        }else if ("برج الجدي".equals(borgName))
        {
            url = "file:///android_asset/gady.html";
            return url;
        }else if ("برج الدلو".equals(borgName))
        {
            url = "file:///android_asset/dlw.html";
            return url;
        }
        return "";
    }
    public String getBorgNameInEnglish(String borgName)
    {
        String borgEnglish = "" ;
        if ("برج الحمل".equals(borgName))
        {
            borgEnglish = "Aries";
            return borgEnglish;
        }else if ("برج الثور".equals(borgName))
        {
            borgEnglish = "Taurus";
            return borgEnglish;
        }else if ("برج الجوزاء".equals(borgName))
        {
            borgEnglish = "Gemini";
            return borgEnglish;
        }else if ("برج السرطان".equals(borgName))
        {
            borgEnglish = "Cancer";
            return borgEnglish;
        }else if ("برج الأسد".equals(borgName))
        {
            borgEnglish = "Leo";
            return borgEnglish;
        }else if ("برج العذراء".equals(borgName))
        {
            borgEnglish = "Virgo";
            return borgEnglish;
        }else if ("برج الميزان".equals(borgName))
        {
            borgEnglish = "Libra";
            return borgEnglish;
        }else if ("برج العقرب".equals(borgName))
        {
            borgEnglish = "Scorpio";
            return borgEnglish;
        }else if ("برج القوس".equals(borgName))
        {
            borgEnglish = "Sagittarius";
            return borgEnglish;
        }else if ("برج الحوت".equals(borgName))
        {
            borgEnglish = "Pisces";
            return borgEnglish;
        }else if ("برج الجدي".equals(borgName))
        {
            borgEnglish = "Capricorn";
            return borgEnglish;
        }else if ("برج الدلو".equals(borgName))
        {
            borgEnglish = "Aquarius";
            return borgEnglish;
        }
        return "";
    }
    public String getBorgNameInArabic(String borgName)
    {
        String borgEnglish = "" ;
        if ("Aries".equals(borgName))
        {
            borgEnglish = "الحمل";
            return borgEnglish;
        }else if ("Taurus".equals(borgName))
        {
            borgEnglish = "الثور";
            return borgEnglish;
        }else if ("Gemini ".equals(borgName))
        {
            borgEnglish = "الجوزاء";
            return borgEnglish;
        }else if ("Cancer".equals(borgName))
        {
            borgEnglish = "السرطان";
            return borgEnglish;
        }else if ("Leo ".equals(borgName))
        {
            borgEnglish = "الأسد";
            return borgEnglish;
        }else if ("Virgo".equals(borgName))
        {
            borgEnglish = "العذراء";
            return borgEnglish;
        }else if ("Libra".equals(borgName))
        {
            borgEnglish = "الميزان";
            return borgEnglish;
        }else if ("Scorpio".equals(borgName))
        {
            borgEnglish = "العقرب";
            return borgEnglish;
        }else if ("Sagittarius".equals(borgName))
        {
            borgEnglish = "القوس";
            return borgEnglish;
        }else if ("Pisces".equals(borgName))
        {
            borgEnglish = "الحوت";
            return borgEnglish;
        }else if ("Capricorn".equals(borgName))
        {
            borgEnglish = "الجدي";
            return borgEnglish;
        }else if ("Aquarius".equals(borgName))
        {
            borgEnglish = "الدلو";
            return borgEnglish;
        }
        return "";
    }
    public String getBorgNameInFranko(String borgName)
    {
        String borgEnglish = "" ;
        if ("برج الحمل".equals(borgName))
        {
            borgEnglish = "haml";
            return borgEnglish;
        }else if ("برج الثور".equals(borgName))
        {
            borgEnglish = "toor";
            return borgEnglish;
        }else if ("برج الجوزاء".equals(borgName))
        {
            borgEnglish = "gwzaa";
            return borgEnglish;
        }else if ("برج السرطان".equals(borgName))
        {
            borgEnglish = "srtan";
            return borgEnglish;
        }else if ("برج الأسد".equals(borgName))
        {
            borgEnglish = "asd";
            return borgEnglish;
        }else if ("برج العذراء".equals(borgName))
        {
            borgEnglish = "azraa";
            return borgEnglish;
        }else if ("برج الميزان".equals(borgName))
        {
            borgEnglish = "mezan";
            return borgEnglish;
        }else if ("برج العقرب".equals(borgName))
        {
            borgEnglish = "arab";
            return borgEnglish;
        }else if ("برج القوس".equals(borgName))
        {
            borgEnglish = "qoos";
            return borgEnglish;
        }else if ("برج الحوت".equals(borgName))
        {
            borgEnglish = "hoot";
            return borgEnglish;
        }else if ("برج الجدي".equals(borgName))
        {
            borgEnglish = "gdy";
            return borgEnglish;
        }else if ("برج الدلو".equals(borgName))
        {
            borgEnglish = "dlw";
            return borgEnglish;
        }
        return "";
    }

    public String getMoovBorgImageUrl(String borgName)
    {
        String url = "" ;
        if ("برج الحمل".equals(borgName))
        {
            url = "https://image.ibb.co/iP1Ub8/aries.png";
            return url;
        }else if ("برج الثور".equals(borgName))
        {
            url = "https://image.ibb.co/hHyLio/taurus.png";
            return url;
        }else if ("برج الجوزاء".equals(borgName))
        {
            url = "https://image.ibb.co/bHdxUT/gemini.png";
            return url;
        }else if ("برج السرطان".equals(borgName))
        {
            url = "https://image.ibb.co/igtWpT/cancer.png";
            return url;
        }else if ("برج الأسد".equals(borgName))
        {
            url = "https://image.ibb.co/bJAY3o/leo.png";
            return url;
        }else if ("برج العذراء".equals(borgName))
        {
            url = "https://image.ibb.co/kexrpT/ivirgo.png";
            return url;
        }else if ("برج الميزان".equals(borgName))
        {
            url = "https://image.ibb.co/ikk0io/libra.png";
            return url;
        }else if ("برج العقرب".equals(borgName))
        {
            url = "https://image.ibb.co/gz2P9T/scorpio.png";
            return url;
        }else if ("برج القوس".equals(borgName))
        {
            url = "https://image.ibb.co/eRfY3o/sagittariu.png";
            return url;
        }else if ("برج الحوت".equals(borgName))
        {
            url = "https://image.ibb.co/cMSrpT/pisces.png";
            return url;
        }else if ("برج الجدي".equals(borgName))
        {
            url = "https://image.ibb.co/nKRUb8/capricorn.png";
            return url;
        }else if ("برج الدلو".equals(borgName))
        {
            url = "https://image.ibb.co/fCuhw8/aquarius.png";
            return url;
        }
        return "Some Error";
    }


    public String getBorgImageUrl(String borgName)
    {
        String url = "" ;
        if ("برج الحمل".equals(borgName))
        {
            url = "https://image.ibb.co/kiz30T/haml.jpg";
            return url;
        }else if ("برج الثور".equals(borgName))
        {
            url = "https://image.ibb.co/nC3VfT/toor.jpg";
            return url;
        }else if ("برج الجوزاء".equals(borgName))
        {
            url = "https://image.ibb.co/gpBGLT/gowzaa.jpg";
            return url;
        }else if ("برج السرطان".equals(borgName))
        {
            url = "https://image.ibb.co/mehdZo/srtan.jpg";
            return url;
        }else if ("برج الأسد".equals(borgName))
        {
            url = "https://image.ibb.co/eL9gn8/asd.jpg";
            return url;
        }else if ("برج العذراء".equals(borgName))
        {
            url = "https://image.ibb.co/i3DwLT/azraa.jpg";
            return url;
        }else if ("برج الميزان".equals(borgName))
        {
            url = "https://image.ibb.co/kUaAfT/meezan.jpg";
            return url;
        }else if ("برج العقرب".equals(borgName))
        {
            url = "https://image.ibb.co/hp4suo/3a2rab.jpg";
            return url;
        }else if ("برج القوس".equals(borgName))
        {
            url = "https://image.ibb.co/iSfMn8/qoos.jpg";
            return url;
        }else if ("برج الحوت".equals(borgName))
        {
            url = "https://image.ibb.co/cnzsuo/hooy.jpg";
            return url;
        }else if ("برج الجدي".equals(borgName))
        {
            url = "https://image.ibb.co/n9fnS8/gdy.jpg";
            return url;
        }else if ("برج الدلو".equals(borgName))
        {
            url = "https://image.ibb.co/g1bSS8/dlw.jpg";
            return url;
        }
        return "Some Error";
    }

    public String getDay()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String Day = new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime());
        Day = Day.toLowerCase();
        return Day;
    }
    public String setDayName()
    {
        String Day = getDay();
        String rDay = null;

        if ("sat".equals(Day)) {
            rDay = "Saturday";
        }else if ("sun".equals(Day)) {
            rDay = "Sunday";
        }else if ("mon".equals(Day)) {
            rDay = "Monday";
        }else if ("tue".equals(Day)) {
            rDay = "Tuesday";
        }else if ("wed".equals(Day)) {
            rDay = "Wednesday";
        }else if ("thu".equals(Day)) {
            rDay = "Thursday";
        }else if ("fri".equals(Day)) {
            rDay = "Friday";
        }
        if (rDay !=null){
            rDay.trim();
        }
        else {
            rDay="Some Error";
        }
        return rDay;
    }

    public String getImgHeaderUrl()
    {
        String Day = getDay();
        String url = null;
        if ("sat".equals(Day)) {
            //       url= "https://image.ibb.co/nAdXS8/saturday.jpg";
            url= "https://image.ibb.co/k81ocK/sater.png";
        }else if ("sun".equals(Day)) {
            //      url= "https://image.ibb.co/jCcWLT/Sunday_Article_2a.png";
            url= "https://image.ibb.co/drSpjz/sun.png";
        }else if ("mon".equals(Day)) {
            //         url= "https://image.ibb.co/nnYXS8/23_15_21_images.jpg";
            url= "https://image.ibb.co/hQukPz/mon.png";
        }else if ("tue".equals(Day)) {
            //         url= "https://image.ibb.co/bXuBLT/23_16_39_images.jpg";
            url= "https://image.ibb.co/eYXGWe/tues.png";
        }else if ("wed".equals(Day)) {
            //        url= "https://image.ibb.co/hcEd0T/23_18_34_92e34f3c4a7ee693160871d7e02a9c3a_handwritten_wednesday_design.jpg";
            url= "https://image.ibb.co/dGSGWe/wed.png";
        }else if ("thu".equals(Day)) {
            //       url= "https://image.ibb.co/hGExS8/b381c8dbc89da28772a892c987eb9c02_happy_thursday_poster_design.jpg";
            url= "https://image.ibb.co/eBErxK/thurs.png";
        }else if ("fri".equals(Day)) {
            //       url = "https://image.ibb.co/gcpd0T/happy_friday.jpg";
            url = "https://image.ibb.co/fV0EHK/fri.png";
        }
        if (url !=null){
            url.trim();
        }
        else {
            url="Some Error";
        }
        return url;
    }


    public static String getBorg(int day, int month)
    {
        String astro_sign="";

        if (month == 12){

            if (day < 22)
                astro_sign = "برج القوس";
            else
                astro_sign ="برج الجدي";
        }

        else if (month == 1){
            if (day < 20)
                astro_sign = "برج الجدي";
            else
                astro_sign = "برج الدلو";
        }

        else if (month == 2){
            if (day < 19)
                astro_sign = "برج الدلو";
            else
                astro_sign = "برج الحوت";
        }

        else if(month == 3){
            if (day < 21)
                astro_sign = "برج الحوت";
            else
                astro_sign = "برج الحمل";
        }
        else if (month == 4){
            if (day < 20)
                astro_sign = "برج الحمل";
            else
                astro_sign = "برج الثور";
        }

        else if (month == 5){
            if (day < 21)
                astro_sign = "برج الثور";
            else
                astro_sign = "برج الجوزاء";
        }

        else if( month == 6){
            if (day < 21)
                astro_sign = "برج الجوزاء";
            else
                astro_sign = "برج السرطان";
        }

        else if (month == 7){
            if (day < 23)
                astro_sign = "برج السرطان";
            else
                astro_sign = "برج الأسد";
        }

        else if( month == 8){
            if (day < 23)
                astro_sign = "برج الأسد";
            else
                astro_sign = "برج العذراء";
        }

        else if (month == 9){
            if (day < 23)
                astro_sign = "برج العذراء";
            else
                astro_sign = "برج الميزان";
        }

        else if (month == 10){
            if (day < 23)
                astro_sign = "برج الميزان";
            else
                astro_sign = "برج العقرب";
        }

        else if (month == 11){
            if (day < 22)
                astro_sign = "برج العقرب";
            else
                astro_sign = "برج القوس";
        }

        return astro_sign;
    }


    public void setWebView(Context context, WebView webView, String url)
    {
//        this.webView = webView;

        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.canGoBack();
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setInitialScale(2);


        webView.getSettings().setLoadsImagesAutomatically(true);
        // webView.getSettings().setBuiltInZoomControls(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        if (!url.equals(null)) {
            webView.loadUrl(url);
        } else {
            Toast.makeText(context, "Url Empty", Toast.LENGTH_SHORT).show();
        }
    }
    class myBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }

    /*
        haml  toor   gwzaa   srtan   asd  azraa  mezan   arab  qoos gdy   dlw    hoot
     */
    public String getRelationship(Context context ,String first, String second){
        String returnedWord = "";
        if ("haml".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlHaml);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.hamlToor);
                    break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.hamlGwzaa);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.hamlSrtan);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.hamlAsd);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.hamlAzraa);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.hamlMezan);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.hamlArab);                break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.hamlQoos);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.hamlGdy);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.hamlDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.hamlHoot);                break;
            }
        }
        if ("toor".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlToor);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorToor);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.toorGwzaa);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.toorGwzaa);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.toorAsd);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.hamlAzraa);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.hamlMezan);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.hamlArab);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.hamlQoos);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.hamlGdy);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.hamlDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.hamlHoot);              break;
            }
        }if ("gwzaa".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlGwzaa);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorGwzaa);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaGwzaa);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.gwzaaSrtan);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.gwzaaAsd);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.gwzaaAzraa);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.gwzaaMezan);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.gwzaaArab);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.gwzaaQoos);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.gdyGdy);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.gdyDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.gdyHoot);
            }
        }if ("srtan".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlSrtan);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorSrtan);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaSrtan);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.srtanSrtan);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.srtanAsd);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.srtanAzraa);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.srtanMezan);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.srtanArab);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.srtanQoos);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.srtanGdy);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.srtanDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.srtanHoot);
            }
        }if ("asd".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlAsd);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.hamlToor);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaAsd);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.srtanAsd);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.asdAsd);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.asdAzraa);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.asdMezan);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.asdArab);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.asdQoos);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.asdGdy);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.asdDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.asdHoot);
            }
        }if ("azraa".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlAzraa);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorAzraa);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaAzraa);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.srtanAzraa);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.asdAzraa);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.azraaAzraa);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.azraaMezan);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.azraaArab);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.azraaQoos);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.azraaGdy);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.azraaDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.azraaHoot);
            }
        }if ("mezan".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlMezan);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorMezan);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaMezan);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.srtanMezan);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.asdMezan);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.azraaMezan);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.mezanMezan);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.mezanArab);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.mezanQoos);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.mezanQoos);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.mezanDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.mezanHoot);
            }
        }if ("arab".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlArab);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorArab);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaArab);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.srtanArab);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.asdArab);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.azraaArab);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.mezanArab);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.arabArab);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.arabQoos);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.arabGdy);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.arabDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.arabHoot);
            }
        }if ("qoos".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlQoos);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorQoos);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaQoos);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.srtanQoos);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.arabQoos);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.azraaQoos);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.mezanQoos);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.arabQoos);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.qoosQoos);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.qoosGdy);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.qoosDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.qoosHoot);
            }
        }if ("gdy".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlGdy);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorGdy);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaGdy);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.srtanGdy);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.asdGdy);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.azraaGdy);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.mezanGdy);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.arabGdy);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.qoosGdy);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.gdyGdy);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.gdyDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.gdyHoot);
            }
        }if ("dlw".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlDlw);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorDlw);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaDlw);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.srtanDlw);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.asdDlw);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.azraaDlw);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.mezanDlw);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.arabDlw);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.qoosDlw);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.gdyDlw);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.dlwDlw);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.dlwHoot);
            }
        }if ("hoot".equals(first)) {

            switch (second) {
                case "haml":
                    returnedWord = context.getResources().getString(R.string.hamlHoot);
                    break;
                case "toor":
                    returnedWord = context.getResources().getString(R.string.toorHoot);                break;
                case "gwzaa":
                    returnedWord = context.getResources().getString(R.string.gwzaaHoot);                break;
                case "srtan":
                    returnedWord = context.getResources().getString(R.string.srtanHoot);                break;
                case "asd":
                    returnedWord = context.getResources().getString(R.string.asdHoot);                break;
                case "azraa":
                    returnedWord = context.getResources().getString(R.string.azraaHoot);                break;
                case "mezan":
                    returnedWord = context.getResources().getString(R.string.mezanHoot);                break;
                case "arab":
                    returnedWord = context.getResources().getString(R.string.arabHoot);              break;
                case "qoos":
                    returnedWord = context.getResources().getString(R.string.qoosHoot);                break;
                case "gdy":
                    returnedWord = context.getResources().getString(R.string.gdyHoot);                break;
                case "dlw":
                    returnedWord = context.getResources().getString(R.string.dlwHoot);                break;
                case "hoot":
                    returnedWord = context.getResources().getString(R.string.hootHoot);
            }
        }
        return returnedWord;
    }

    public StringBuilder returnHtml(String body){
        StringBuilder builder = new StringBuilder();

        builder.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\" /> \n" +
                "<body dir=\"rtl\"; \n" +
                "style=\"text-align:justify;\">");

        //builder.append("<html><body dir=\\\"rtl\\\"; style=\\\"text-align:justify;\\\">");
        builder.append(body);
        builder.append("</body>\n" +
                "</html>");

        return builder;
    }
}
