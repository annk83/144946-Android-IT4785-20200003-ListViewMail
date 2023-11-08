package annk.example.listbox.gmail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date


open class MainActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<RecyclerView>(R.id.list)
        val arr = arrayOf(
            Mail("mail1", "hello this is first", "ankis", Date(), false, true),
            Mail("mail2", "hello this is first, second, longgggggggggggggggggggggggggg", "annkis", Date(), false, false),
            Mail("mail3", "hello this is first", "annis", Date(), true, false),
            Mail("mail4", "hello this is first", "annkis", Date(), false, false),
            Mail("mail5", "hello this is first", "aasnnis", Date(), true, false),
            Mail("mail6", "hello this is first", "anvsvkis", Date(), false, false),
            Mail("mail7", "hello this is first", "bis", Date(), false, false),
            Mail("mail8", "hello this is first", "cannkis", Date(), false, false),
            Mail("mail9", "hello this is first", "is", Date(), false, false)
        );
       val mLayoutManager = LinearLayoutManager(applicationContext)
        list.setLayoutManager(mLayoutManager)

        list.adapter = object : RecyclerView.Adapter<MailView>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailView {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.mail, parent, false)
                return MailView(view)

            }

            override fun getItemCount(): Int {
                return arr.size
            }

            override fun onBindViewHolder(holder: MailView, position: Int) {
                holder.switchTo(arr[position])
            }

        }

        /*
        list.adapter = object : BaseAdapter() {
            override fun getCount(): Int {
                return arr.size;
            }

            override fun getItem(p0: Int): Mail {
                return arr[p0];
            }

            override fun getItemId(p0: Int): Long {
                return p0.toLong();
            }

            override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
                var k = p1
                if(k == null) {
                    val v = layoutInflater.inflate(R.layout.mail, null)
                    k = v
                }
                val l = k!!
                val m = arr[p0]
                val title = l.findViewById<TextView>(R.id.ti)
                val content = l.findViewById<TextView>(R.id.con)
                val sender = l.findViewById<TextView>(R.id.sender)
                val date = l.findViewById<TextView>(R.id.date)
                title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                sender.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26f)
                content.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17f)
                fit(title, m.title)
                fit(content, m.content)
                fit(sender, m.sender)
                date.text = SimpleDateFormat("hh:mm a").format(m.date)
                var h = m.sender.hashCode() % 360;
                if(h<0) h += 360;
                val c = Color.HSVToColor(arrayOf(h.toFloat(), 1f, 1f).toFloatArray())
                val f = Color.HSVToColor(arrayOf(((h+180)%360).toFloat(), 1f, 1f).toFloatArray())
                l.findViewById<Button>(R.id.avatar).backgroundTintList = ColorStateList.valueOf(c)
                l.findViewById<Button>(R.id.avatar).foregroundTintList = ColorStateList.valueOf(h)
                l.findViewById<Button>(R.id.avatar).text = Character.toUpperCase(sender.text[0]).toString()
                l.findViewById<Button>(R.id.avatar).setTextSize(30f)
                if(m.favorite) l.findViewById<ImageView>(R.id.star).setImageResource(R.drawable.star)
                else l.findViewById<ImageView>(R.id.star).setImageResource(R.drawable.unstar)
                l.findViewById<ImageView>(R.id.star).setOnClickListener {
                    m.favorite = !m.favorite
                    if(m.favorite) l.findViewById<ImageView>(R.id.star).setImageResource(R.drawable.star)
                    else l.findViewById<ImageView>(R.id.star).setImageResource(R.drawable.unstar)
                }

                return l
            }
        }
        */
    }
}