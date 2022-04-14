package com.example.android_demo_kotlin

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CAMERA
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_permission.checkpermission
import kotlinx.android.synthetic.main.activity_permission.requestpermission


class PermissionActivity : AppCompatActivity() {

    val PERMISSION_REQUEST_CODE = 100
    lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        checkpermission.setOnClickListener {
            view = it
            if (checkPermission()) {
                Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(view, "Please request permission.", Snackbar.LENGTH_LONG).show();
            }
        }

        requestpermission.setOnClickListener {
            view = it
            if (!checkPermission()) {
                requestPermission();
            } else {
                Snackbar.make(it, "Permission already granted.", Snackbar.LENGTH_LONG).show();
            }
        }
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(applicationContext, ACCESS_FINE_LOCATION)
        val result1 = ContextCompat.checkSelfPermission(applicationContext, CAMERA)
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION, CAMERA), PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.size > 0) {
                    val locationAccepted = grantResults[0] === PackageManager.PERMISSION_GRANTED
                    val cameraAccepted = grantResults[1] === PackageManager.PERMISSION_GRANTED
                    if (locationAccepted && cameraAccepted)
                        Snackbar.make(view, "Permission Granted, Now you can access location data and camera.", Snackbar.LENGTH_LONG).show();
                    else if(cameraAccepted) {
                        Snackbar.make(view, "Permission Granted, Now you can access camera.", Snackbar.LENGTH_LONG).show();
                    } else if (locationAccepted){
                        Snackbar.make(view, "Permission Granted, Now you can access location data.", Snackbar.LENGTH_LONG).show();
                    }
                    else {
                        Snackbar.make(view, "Permission Denied, You cannot access location data and camera.", Snackbar.LENGTH_LONG).show();
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            if(shouldShowRequestPermissionRationale(CAMERA)){
                                AlertDialog.Builder(this).setMessage("Open Setting Apps").
                                setPositiveButton("ok", DialogInterface.OnClickListener{
                                        dialog, which ->
                                    startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                                        data = Uri.fromParts("package","com.example.android_demo_kotlin" , null)
                                    })
                                }).
                                setNegativeButton("Cancel", null)
                                    .create().show()
                            }
                        }
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            if(shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)){
                                showMessageOKCancel("You need to allow access to both the permissions",
                                    DialogInterface.OnClickListener { dialog, which ->
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            requestPermissions(
                                                arrayOf(ACCESS_FINE_LOCATION),
                                                PERMISSION_REQUEST_CODE
                                            )
                                        }
                                    })
                            }
                        }
                    }
                }

            }

        }
    }
    private fun showMessageOKCancel(message: String, okListener: DialogInterface.OnClickListener) {
         AlertDialog.Builder(this).setMessage(message).setPositiveButton("OK", okListener).setNegativeButton("Cancel", null).create().show()
    }
}