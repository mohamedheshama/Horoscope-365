package eg.emad.horoscope365.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by emad on 2/10/19.
 */

public class CheckInternet {
    Context context;
    public CheckInternet(Context context)
    {
        this.context= context;
    }

    public boolean checkConnection()
    {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager !=null)
        {
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info !=null && info.isConnected())
            {return true;}

        }
        return false;
    }
}
