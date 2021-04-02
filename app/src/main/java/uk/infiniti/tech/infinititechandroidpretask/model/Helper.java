package uk.infiniti.tech.infinititechandroidpretask.model;

import android.content.Context;
import android.net.ConnectivityManager;

public class Helper {

    private Context context;

    public Helper(Context context) {
        this.context = context;
    }

    public  boolean isInternetAvailable() {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
