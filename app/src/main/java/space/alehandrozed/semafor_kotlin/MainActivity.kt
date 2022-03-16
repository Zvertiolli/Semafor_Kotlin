package space.alehandrozed.semafor_kotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*


class MainActivity : Activity() {
    private var imageSemaphor: ImageView? = null
    var counter: Int = 0
    var timer: Timer? = null
    var isRun = false
    var imageArray: IntArray =
        intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSemaphor = findViewById(R.id.imageViewSemaphor)
    }

    fun onClickStartStop(view: android.view.View) {
        view as ImageButton
        if (!isRun) {
            startStop()
            view.setImageResource(R.drawable.button_stop)
            isRun = true
            counter =0
        } else {
            timer?.cancel()
            imageSemaphor?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            isRun = false

        }

    }

    fun startStop() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread{
                    imageSemaphor?.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 3) counter = 0
                }

            }

        }, 0,1000)
    }
}