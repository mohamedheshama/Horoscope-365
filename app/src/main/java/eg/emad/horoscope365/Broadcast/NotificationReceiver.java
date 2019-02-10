package eg.emad.horoscope365.Broadcast;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import eg.emad.horoscope365.MainActivity;
import eg.emad.horoscope365.R;

/**
 * Created by emad on 2/10/19.
 */

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("ONRECEIVE", "***************************************************");
        showNotification(context);
    }

    private void showNotification(Context context) {


        //handle Notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(
                    "1000",
                    "Allow Horoscope Notifications",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"1000")
                .setColor(R.drawable.horo)
                .setSmallIcon(R.drawable.horoforeground)
                .setContentTitle("Horoscope 365")
                .setContentText("See The Latest Expectations of your Horoscope")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(
                        "See The Latest Expectations of your Horoscope  "))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(PendingIntent.getActivity(context,0,new Intent(context,
                        MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT))
                .setSound(uri);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                &&  Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {

            //   builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        }

        notificationManager.notify(1000,builder.build());
    }

}
