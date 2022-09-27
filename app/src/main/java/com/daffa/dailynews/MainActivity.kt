package com.daffa.dailynews

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.*
import com.daffa.dailynews.databinding.ActivityMainBinding
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    private val channelId = "001"

    private var _appBarConfig: AppBarConfiguration? = null
    private val appBarConfig get() = _appBarConfig as AppBarConfiguration

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    lateinit var drawerLayout: DrawerLayout
    lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar?.hide()

        drawerLayout = binding.activityMain
        _appBarConfig = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.newsFragment,
                R.id.esportFragment,
                R.id.talkFragment,
                R.id.reviewFragment
            ), drawerLayout
        )

        val navView = binding.navDrawerMain
        val navController = findNavController(R.id.host_main)

        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)

        drawerLayout.openDrawer(Gravity.LEFT)
        drawerLayout.closeDrawer(Gravity.LEFT)

        createNotificationChannel()
        displayNotificationStart()
    }

    private fun displayNotificationStart() {
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.img_contoh)
            .setContentTitle("Hi!!")
            .setContentText("Welcome back captain")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(1, builder.build())
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.host_main)
        return super.onSupportNavigateUp() || navController.navigateUp(appBarConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.host_main)
        return NavigationUI.onNavDestinationSelected(
            item,
            navController
        ) || super.onOptionsItemSelected(item)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "countdown", NotificationManager.IMPORTANCE_HIGH).apply {
                description = "Notif when countdown end."
            }
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}