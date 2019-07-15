package com.example.wavanalyser;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Permission {

    final int REQUEST_PERMISSION_CODE=1000;

    public static boolean checkPermissionFromDevice(Context context) {
        int result_from_storage_permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO);
        return (result_from_storage_permission == PackageManager.PERMISSION_GRANTED) &&
                (record_audio_result == PackageManager.PERMISSION_GRANTED);
    }

    public static void RequestPermission(Activity activity){
        ActivityCompat.requestPermissions(activity, new String[]{
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, 1000);
    }


    public void onRequestPermissionsResult(Context context , int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case REQUEST_PERMISSION_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(context, "Permission granted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }
            break;
        }

    }
}
