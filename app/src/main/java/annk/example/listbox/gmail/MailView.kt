package annk.example.listbox.gmail

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.text.SimpleDateFormat

class MailView(private val view : View) : ViewHolder(view) {
    private val title : TextView
    private val content : TextView
    private val sender : TextView
    private val date : TextView
    private val avatar : Button
    private val fav : ImageView
    init {
        Log.i("info", "create")
        title = view.findViewById<TextView>(R.id.ti)
        content = view.findViewById<TextView>(R.id.con)
        sender = view.findViewById<TextView>(R.id.sender)
        date = view.findViewById<TextView>(R.id.date)
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        sender.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26f)
        content.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17f)
        avatar = view.findViewById(R.id.avatar)
        fav = view.findViewById(R.id.star)
    }

    open fun fit(v : TextView, txt : String) {
        val paint = v.paint;
        var numChars = 1
        while(numChars < txt.length) {
            if(paint.measureText(txt, 0, numChars) < 550)
                ++numChars;
            else break;
        }
        if(numChars < txt.length) v.text = txt.substring(0, numChars) + " ..."
        else v.text = txt
    }

    fun switchTo(m: Mail) {
        fit(title, m.title)
        fit(content, m.content)
        fit(sender, m.sender)
        date.text = SimpleDateFormat("hh:mm a").format(m.date)
        var h = m.sender.hashCode() % 360;
        if(h<0) h += 360;
        val c = Color.HSVToColor(arrayOf(h.toFloat(), 1f, 1f).toFloatArray())
        val f = Color.HSVToColor(arrayOf(((h+180)%360).toFloat(), 1f, 1f).toFloatArray())
        avatar.backgroundTintList = ColorStateList.valueOf(c)
        avatar.foregroundTintList = ColorStateList.valueOf(h)
        avatar.text = Character.toUpperCase(sender.text[0]).toString()
        avatar.setTextSize(30f)
        if(m.favorite) fav.setImageResource(R.drawable.star)
        else fav.setImageResource(R.drawable.unstar)
        fav.setOnClickListener {
            m.favorite = !m.favorite
            if(m.favorite) fav.setImageResource(R.drawable.star)
            else fav.setImageResource(R.drawable.unstar)
        }
    }

}