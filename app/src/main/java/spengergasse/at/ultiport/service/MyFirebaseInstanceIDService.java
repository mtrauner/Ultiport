package spengergasse.at.ultiport.service;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by delaroy on 10/8/17.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        try {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            Log.d(TAG, "Refreshed token: " + refreshedToken);


            storeToken(refreshedToken);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void storeToken(String token) {
        //saving the token on shared preferences
        SharedPreference.getInstance(getApplicationContext()).saveDeviceToken(token);
    }
}
