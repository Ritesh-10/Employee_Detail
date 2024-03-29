@file:Suppress("DEPRECATION")

package com.example.employeeexample.ui


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.employeeexample.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun createFile(context: Context, folder: String, ext: String): File {
    val timeStamp: String =
        SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val filesDir: File? = context.getExternalFilesDir(folder)
    val newFile = File(filesDir, "$timeStamp.$ext")
    newFile.createNewFile()
    return newFile
}


fun Activity.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, msg, duration).show()
}

class MainActivity : AppCompatActivity() {
    //private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
        //setSupportActionBar(toolbar)
        //supportActionBar?.title=""

        //supportActionBar?.setDisplayShowHomeEnabled(true)
        //supportActionBar?.setIcon(R.mipmap.ic_launcher)


      //  val navController = findNavController(R.id.nav_host_fragment)
        //appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(this, navController, appBarConfiguration)
        //toolbar.setupWithNavController(navController,appBarConfiguration)

    //override fun onSupportNavigateUp(): Boolean {
      //  val navController = findNavController(R.id.nav_host_fragment)
        //return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    //}
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}

