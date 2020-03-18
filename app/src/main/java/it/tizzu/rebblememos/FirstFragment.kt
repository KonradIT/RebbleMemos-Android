package it.tizzu.rebblememos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_first.*
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class FirstFragment : Fragment(), AdapterView.OnItemSelectedListener {

    val icons = arrayOf(
        "NOTIFICATION_REMINDER",
        "ALARM_CLOCK",
        "AMERICAN_FOOTBALL",
        "AUDIO_CASSETTE",
        "BASKETBALL",
        "BIRTHDAY_EVENT",
        "CAR_RENTAL",
        "CLOUDY_DAY",
        "CRICKET_GAME",
        "DINNER_RESERVATION",
        "DISMISSED_PHONE_CALL",
        "GENERIC_CONFIRMATION",
        "GENERIC_EMAIL",
        "GENERIC_QUESTION",
        "GENERIC_WARNING",
        "GLUCOSE_MONITOR",
        "HEAVY_RAIN",
        "HEAVY_SNOW",
        "HOCKEY_GAME",
        "HOTEL_RESERVATION",
        "INCOMING_PHONE_CALL",
        "LIGHT_RAIN",
        "LIGHT_SNOW",
        "LOCATION",
        "MOVIE_EVENT",
        "MUSIC_EVENT",
        "NEWS_EVENT",
        "NOTIFICATION_FLAG",
        "NOTIFICATION_GENERIC",
        "NOTIFICATION_LIGHTHOUSE",
        "PARTLY_CLOUDY",
        "PAY_BILL",
        "RADIO_SHOW",
        "RAINING_AND_SNOWING",
        "REACHED_FITNESS_GOAL",
        "RESULT_DISMISSED",
        "RESULT_FAILED",
        "SCHEDULED_EVENT",
        "SCHEDULED_FLIGHT",
        "SETTINGS",
        "SOCCER_GAME",
        "STOCKS_EVENT",
        "SUNRISE",
        "SUNSET",
        "TIDE_IS_HIGH",
        "TIMELINE_BASEBALL",
        "TIMELINE_CALENDAR",
        "TIMELINE_MISSED_CALL",
        "TIMELINE_SPORTS",
        "TIMELINE_SUN",
        "TIMELINE_WEATHER",
        "TV_SHOW"
    )
    var iconDisplay: ImageView? = null
    val json : JSONObject? = JSONObject()
    val layout : JSONObject? = JSONObject()

    // Creation of the fragment, pretty standard
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val timePickerButton: Button = view.findViewById(R.id.btn_time)
        val timeView: TextView = view.findViewById(R.id.time_display)

        val datePickerButton: Button = view.findViewById(R.id.btn_date)
        val dateView: TextView = view.findViewById(R.id.date_display)

        val sendButton: Button = view.findViewById(R.id.send_to_timeline)

        //Date / Time stuff
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Icon Stuff
        val spinner: Spinner = view.findViewById(R.id.icon_selector)
        val aa = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, icons)
        iconDisplay = view.findViewById(R.id.icon_display)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(aa)
        spinner.onItemSelectedListener = this

        //JSON Stuff

        //Summon the Android Date Picker and save its result into the TextView
        datePickerButton.setOnClickListener {

            val datePicker = DatePickerDialog(
                this.context!!,
                DatePickerDialog.OnDateSetListener { _, year, _, dayOfMonth ->
                    dateView.setText("$dayOfMonth/$month/$year")
                },
                year,
                month,
                day
            )
            datePicker.show()

        }

        timePickerButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)
                timeView.text = SimpleDateFormat("HH:mm").format(calendar.time)
            }
            TimePickerDialog(
                activity,
                timeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            ).show()
        }

        send_to_timeline.setOnClickListener{

        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var name = icons[position]
        when (name)
        {
            "NOTIFICATION_REMINDER" -> iconDisplay!!.setImageResource(R.drawable.notification_reminder)
            "ALARM_CLOCK" -> iconDisplay!!.setImageResource(R.drawable.alarm_clock)
            "AMERICAN_FOOTBALL" -> iconDisplay!!.setImageResource(R.drawable.american_football)
            "AUDIO_CASSETTE" -> iconDisplay!!.setImageResource(R.drawable.audio_cassette)
            "BASKETBALL" -> iconDisplay!!.setImageResource(R.drawable.basketball)
            "BIRTHDAY_EVENT" -> iconDisplay!!.setImageResource(R.drawable.birthday_event)
            "CAR_RENTAL" -> iconDisplay!!.setImageResource(R.drawable.car_rental)
            "CLOUDY_DAY" -> iconDisplay!!.setImageResource(R.drawable.cloudy_day)
            "CRICKET_GAME" -> iconDisplay!!.setImageResource(R.drawable.cricket_game)
            "DINNER_RESERVATION" -> iconDisplay!!.setImageResource(R.drawable.dinner_reservation)
            "DISMISSED_PHONE_CALL" -> iconDisplay!!.setImageResource(R.drawable.dismissed_phone_call)
            "GENERIC_CONFIRMATION" -> iconDisplay!!.setImageResource(R.drawable.generic_confirmation)
            "GENERIC_EMAIL" -> iconDisplay!!.setImageResource(R.drawable.generic_email)
            "GENERIC_QUESTION" -> iconDisplay!!.setImageResource(R.drawable.generic_question)
            "GENERIC_WARNING"-> iconDisplay!!.setImageResource(R.drawable.generic_warning)
            "GLUCOSE_MONITOR" -> iconDisplay!!.setImageResource(R.drawable.glucose_monitor)
            "HEAVY_RAIN" -> iconDisplay!!.setImageResource(R.drawable.heavy_rain)
            "HEAVY_SNOW" -> iconDisplay!!.setImageResource(R.drawable.heavy_snow)
            "HOCKEY_GAME" -> iconDisplay!!.setImageResource(R.drawable.hockey_game)
            "HOTEL_RESERVATION" -> iconDisplay!!.setImageResource(R.drawable.hotel_reservation)
            "INCOMING_PHONE_CALL" -> iconDisplay!!.setImageResource(R.drawable.incoming_phone_call)
            "LIGHT_RAIN" -> iconDisplay!!.setImageResource(R.drawable.light_rain)
            "LIGHT_SNOW" -> iconDisplay!!.setImageResource(R.drawable.light_snow)
            "LOCATION" -> iconDisplay!!.setImageResource(R.drawable.location)
            "MOVIE_EVENT" -> iconDisplay!!.setImageResource(R.drawable.movie_event)
            "MUSIC_EVENT" -> iconDisplay!!.setImageResource(R.drawable.music_event)
            "NEWS_EVENT" -> iconDisplay!!.setImageResource(R.drawable.news_event)
            "NOTIFICATION_FLAG" -> iconDisplay!!.setImageResource(R.drawable.notification_flag)
            "NOTIFICATION_GENERIC" -> iconDisplay!!.setImageResource(R.drawable.notification_generic)
            "NOTIFICATION_LIGHTHOUSE" -> iconDisplay!!.setImageResource(R.drawable.notification_lighthouse)
            "PARTLY_CLOUDY" -> iconDisplay!!.setImageResource(R.drawable.partly_cloudy)
            "PAY_BILL" -> iconDisplay!!.setImageResource(R.drawable.pay_bill)
            "RADIO_SHOW" -> iconDisplay!!.setImageResource(R.drawable.radio_show)
            "RAINING_AND_SNOWING" -> iconDisplay!!.setImageResource(R.drawable.raining_and_snowing)
            "REACHED_FITNESS_GOAL" -> iconDisplay!!.setImageResource(R.drawable.reached_fitness_goal)
            "RESULT_DISMISSED" -> iconDisplay!!.setImageResource(R.drawable.result_dismissed)
            "RESULT_FAILED" -> iconDisplay!!.setImageResource(R.drawable.result_failed)
            "SCHEDULED_EVENT" -> iconDisplay!!.setImageResource(R.drawable.scheduled_event)
            "SCHEDULED_FLIGHT" -> iconDisplay!!.setImageResource(R.drawable.scheduled_flight)
            "SETTINGS" -> iconDisplay!!.setImageResource(R.drawable.settings)
            "SOCCER_GAME" -> iconDisplay!!.setImageResource(R.drawable.soccer_game)
            "STOCKS_EVENT" -> iconDisplay!!.setImageResource(R.drawable.stocks_event)
            "SUNRISE" -> iconDisplay!!.setImageResource(R.drawable.sunrise)
            "SUNSET" -> iconDisplay!!.setImageResource(R.drawable.sunset)
            "TIDE_IS_HIGH" -> iconDisplay!!.setImageResource(R.drawable.tide_is_high)
            "TIMELINE_BASEBALL" -> iconDisplay!!.setImageResource(R.drawable.timeline_baseball)
            "TIMELINE_CALENDAR" -> iconDisplay!!.setImageResource(R.drawable.timeline_baseball)
            "TIMELINE_MISSED_CALL" -> iconDisplay!!.setImageResource(R.drawable.timeline_missed_call)
            "TIMELINE_SPORTS" -> iconDisplay!!.setImageResource(R.drawable.timeline_sports)
            "TIMELINE_SUN" -> iconDisplay!!.setImageResource(R.drawable.timeline_sun)
            "TIMELINE_WEATHER" -> iconDisplay!!.setImageResource(R.drawable.timeline_weather)
            "TV_SHOW" -> iconDisplay!!.setImageResource(R.drawable.tv_show)
        }

    }


}
