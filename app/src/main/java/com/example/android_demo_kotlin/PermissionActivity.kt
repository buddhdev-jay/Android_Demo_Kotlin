package com.example.android_demo_kotlin

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CAMERA
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import com.example.android_demo_kotlin.utils.ONE
import com.example.android_demo_kotlin.utils.ZERO
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
                Snackbar.make(view, getString(R.string.toast_permission_granted), Snackbar.LENGTH_LONG).show();
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
        val resultLocation = ContextCompat.checkSelfPermission(applicationContext, ACCESS_FINE_LOCATION)
        val resultCamera = ContextCompat.checkSelfPermission(applicationContext, CAMERA)
        return  resultLocation == PackageManager.PERMISSION_GRANTED && resultCamera == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION, CAMERA), PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.size > ZERO) {
                    if (grantResults[ZERO] == PackageManager.PERMISSION_GRANTED) {
                        Snackbar.make(view, getString(R.string.toast_permission_granted_location_data), Snackbar.LENGTH_LONG).show();
                    } else if (grantResults[ZERO] == PackageManager.PERMISSION_DENIED) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                            popUpDialog()
                        }
                    }
                    if (grantResults[ONE] == PackageManager.PERMISSION_GRANTED) {
                        Snackbar.make(view, getString(R.string.toast_permission_granted_camera), Snackbar.LENGTH_LONG).show();
                    } else if (grantResults[ONE] == PackageManager.PERMISSION_DENIED) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                            popUpDialog()
                        }
                    }
                }

            }
        }
    }

    private fun popUpDialog() {
        val builder = AlertDialog.Builder(this)
        var alertDialog: AlertDialog? = null
        builder.apply {
            setTitle(getString(R.string.open_settings))
            setMessage(getString(R.string.grant_permission_settings))
            setIcon(android.R.drawable.ic_dialog_alert)
            setPositiveButton(getString(R.string.btn_text_settings)) { dialog, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri: Uri = Uri.fromParts(getString(R.string.package_keyword), packageName, null)
                intent.data = uri
                alertDialog?.dismiss()
                resultLauncher.launch(intent)

            }.setNegativeButton(getString(R.string.btn_text_cancel)) { dialog, whichButton ->
                    dialog.dismiss()
                }
        }
        alertDialog = builder.create()
        alertDialog.apply {
            setCancelable(true)
            show()
        }

    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (!checkPermission()) {
                popUpDialog()
            } else {
                Toast.makeText(this, getString(R.string.toast_granted), Toast.LENGTH_SHORT).show()
            }
        }
}