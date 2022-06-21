package com.example.fitbuddyapp.ui.steps_counter

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fitbuddyapp.R
import java.util.*


class StepsCounterFragment:Fragment(), SensorEventListener {

    private var sensorManager: SensorManager? = null

    private var running=false
    private var totalSteps=0f
    private var previousTotalSteps=0f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadData()
        resetSteps()
        sensorManager=  activity!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val view=inflater.inflate(R.layout.fragment_steps_counter,container,false)
        return view;
    }

        override fun onResume() {
        super.onResume()
        running=true
        val stepSensor=sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor==null)
        {
            Toast.makeText( activity,"No sensor detected on this device", Toast.LENGTH_LONG).show()
        }
        else {
            sensorManager?.registerListener(this,stepSensor, SensorManager.SENSOR_DELAY_UI)
        }

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(running){
            totalSteps=event!!.values[0]
            val currentSteps=totalSteps.toInt()-previousTotalSteps.toInt()

            view!!.findViewById<TextView>(R.id.tv_stepsTaken).text="$currentSteps"
            view!!.findViewById<com.mikhaellopez.circularprogressbar.CircularProgressBar>(R.id.progress_circular).apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }
        }
    }

    fun resetSteps(){
        if(Calendar.getInstance().get(Calendar.HOUR)==0 &&
            Calendar.getInstance().get(Calendar.MINUTE)==0&&
            Calendar.getInstance().get(Calendar.SECOND)==0)
        {
            previousTotalSteps=totalSteps
            view!!.findViewById<TextView>(R.id.tv_stepsTaken).text=0.toString()
            saveData()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy:Int) {

    }

    private fun saveData(){
        val sharedPreferences= activity!!.getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.putFloat("key1",previousTotalSteps)
        editor.apply()
    }

    private fun loadData()    {
        val sharedPreferences= activity!!.getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
       val savedNumber=sharedPreferences.getFloat("key1",0f)
        previousTotalSteps=savedNumber
    }

}