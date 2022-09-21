package com.daffa.dailynews

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.NotificationCompat.PRIORITY_DEFAULT
import androidx.drawerlayout.widget.DrawerLayout
import androidx.media.app.NotificationCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.*
import com.daffa.dailynews.R
import com.daffa.dailynews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelId = "12345"
    private val description = "Test Notification"

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

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.lightColor = Color.BLUE
            notificationManager.createNotificationChannel(notificationChannel)
            builder = Notification.Builder(this, channelId)
                .setContentTitle("Wereld Notification")
                .setContentText("Search your destination")
                .setSmallIcon(R.drawable.daily_news)

        }
        notificationManager.notify(12345, builder.build())

        drawerLayout.openDrawer(Gravity.LEFT)
        drawerLayout.closeDrawer(Gravity.LEFT)

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
}