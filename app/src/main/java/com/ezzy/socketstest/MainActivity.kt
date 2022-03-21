package com.ezzy.socketstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.pusher.client.Pusher
import com.pusher.client.PusherOptions
import com.pusher.client.connection.ConnectionEventListener
import com.pusher.client.connection.ConnectionState
import com.pusher.client.connection.ConnectionStateChange
import kotlinx.coroutines.android.asCoroutineDispatcher
import zerobranch.androidremotedebugger.AndroidRemoteDebugger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options = PusherOptions()
        options.setCluster("us3");
        val pusher = Pusher("4f8ffce94887fb1454cb", options)

        pusher.connect(object : ConnectionEventListener {
            override fun onConnectionStateChange(change: ConnectionStateChange) {
                AndroidRemoteDebugger.Log.i("Pusher", "State changed from ${change.previousState} to ${change.currentState}")
            }

            override fun onError(
                message: String,
                code: String,
                e: Exception
            ) {
                AndroidRemoteDebugger.Log.i("Pusher", "There was a problem connecting! code ($code), message ($message), exception($e)")
            }
        }, ConnectionState.ALL)

        val channel = pusher.subscribe("game-channel")
        channel.bind("game-monitor") { event ->
            AndroidRemoteDebugger.Log.i("Pusher","Received event with data: ${event.data}")
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(this, event.data, Toast.LENGTH_LONG).show()
            }
        }
    }
}