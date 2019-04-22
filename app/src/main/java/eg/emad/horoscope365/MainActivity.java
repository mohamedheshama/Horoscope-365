package eg.emad.horoscope365;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.ImageView;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;

import java.util.Calendar;

import eg.emad.horoscope365.Broadcast.NotificationReceiver;
import eg.emad.horoscope365.Utils.CheckInternet;

public class MainActivity extends AppCompatActivity {

        ImageView imageView;
        CheckInternet checkInternet;
        Dialog dialog;
        boolean isConnected;

        String JOB_TAG= "firebaseNotification";
        FirebaseJobDispatcher dispatcher;

        private static final String TAG = "MainActivity";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
/**
 *
 * Start Service
 */

    /*dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));

    Job job = dispatcher.newJobBuilder()
            .setService(DailyNotificationService.class)
            .setTag(JOB_TAG)
            .setRecurring(true)
                .setLifetime(Lifetime.FOREVER)
            .setTrigger(Trigger.executionWindow(0,10))
            .setReplaceCurrent(false)
            .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
            .setConstraints(Constraint.ON_ANY_NETWORK)
            .build();
            dispatcher.mustSchedule(job);
*/
            checkInternet = new CheckInternet(this);
            isConnected = checkInternet.checkConnection();

            imageView = findViewById(R.id.imgSplash);
            //   Picasso.get().load("https://image.ibb.co/fcKLfT/chance.png").into(imageView);
            //       Picasso.get().load("https://image.ibb.co/iZWfEo/Horoscope_and_the_12_Zodiac_Signs.jpg").into(imageView);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                        if (isConnected){
                            startActivity(new Intent(getApplicationContext(), Home.class));
                            finish();
                        }
                        else {
                            startActivity(new Intent(getApplicationContext(), NoConnection.class));
                            finish();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            NotifyDaily();
        }
    public void NotifyDaily() {

        Log.i(TAG,"NotifyDaily Started");
        Calendar calender = Calendar.getInstance();
        calender.set(Calendar.HOUR_OF_DAY,0);
        calender.set(Calendar.MINUTE,1);


        Intent intente = new Intent(MainActivity.this, NotificationReceiver.class);
        Log.i(TAG,"Intent Initialized");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intente,PendingIntent.FLAG_ONE_SHOT);
        Log.i(TAG,"PendingIntent Initialized");

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Log.i(TAG,"AlarmManager Initialized");

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calender.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

        //  sendBroadcast(intente);
        Log.i(TAG,"setRepeating ");
    }
}