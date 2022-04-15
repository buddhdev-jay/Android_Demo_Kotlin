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
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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
                Snackbar.make(view, getString(R.string.toast_permission_granted) , Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(view, getString(R.string.toast_request_permission), Snackbar.LENGTH_LONG).show();
            }
        }

        requestpermission.setOnClickListener {
            view = it
            if (!checkPermission()) {
                requestPermission();
            } else {
                Snackbar.make(it, getString(R.string.toast_permission_granted), Snackbar.LENGTH_LONG).show();
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
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        Snackbar.make(view, getString(R.string.toast_permission_granted_location_data), Snackbar.LENGTH_LONG).show();
                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                        } else {
                            popUpDialog()
                        }
                    }
                    if (grantResults[1] == PackageManager.PERMISSION_GRANTED){
                        Snackbar.make(view, getString(R.string.toast_permission_granted_camera), Snackbar.LENGTH_LONG).show();
                    } else if (grantResults[1] == PackageManager.PERMISSION_DENIED){
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                        } else {
                            popUpDialog()
                        }
                    }
                }

            }

        }
    }
    private fun popUpDialog() {
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setTitle(getString(R.string.open_settings))
            setMessage(getString(R.string.grant_permission_settings))
            setIcon(android.R.drawable.ic_dialog_alert)
            setPositiveButton(getString(R.string.btn_text_settings)) { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                val uri: Uri = Uri.fromParts(getString(R.string.package_keyword), packageName, null)
                intent.data = uri
                startActivity(intent)
            }
                .setNegativeButton(getString(R.string.btn_text_cancel)) { dialog, whichButton ->
                    dialog.dismiss()
                }
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.apply {
            setCancelable(true)
            show()
        }
    }
}