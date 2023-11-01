package annk.example.listbox.gmail

import java.util.Date

data class Mail(var title : String, var content : String, var sender : String, var date : Date, var seen : Boolean, var favorite : Boolean) { }