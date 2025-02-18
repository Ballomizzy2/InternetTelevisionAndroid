package com.example.internettelevision

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    /*override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //var slideshow = SlideShow()
        //slideshow.start()
    }

}

class SlideShow : Thread() {
    private var images = arrayListOf("image1", "image2", "image3")
    override fun run() {
        var slideshowhandler : SlideShowHandler
        while(true) {
            for(i in images.indices) {
                slideshowhandler = SlideShowHandler(images[i])
                MainActivity.getInstance().runOnUiThread(slideshowhandler)
                Thread.sleep(5*1000)
            }
        }
    }
}

class SlideShowHandler(private var name: String) : Runnable {
    override fun run() {
        var id = MainActivity.getInstance().resources.getIdentifier(name,"drawable",MainActivity.getInstance().packageName)
        MainActivity.getInstance().findViewById<ImageView>(R.id.titleImage)?.setImageResource(id)
    }
}