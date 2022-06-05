package com.ako.completcontact.Notes

import android.content.Context
import android.content.Intent
import android.view.*
import android.view.ActionMode.Callback
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.ako.completcontact.*
import kotlinx.android.synthetic.main.activity_write_note.view.*
import kotlinx.android.synthetic.main.eachnotes.view.*
import kotlin.Boolean as Boolean1
var s=1
class NotesAdapter(val cont: Context, val note:ArrayList<db>,val inter:SelectItem)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
           val view=LayoutInflater.from(cont).inflate(R.layout.eachnotes,parent,false)
        return ViewHolder(view)
     }
    override fun getItemCount(): Int {
      return  note.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      //  holder.itemView.currentdate.text=note[position].date
        holder.itemView.writednotetitle.text= note[position].title
        holder.itemView.writednotebody.text=note[position].body
        holder.itemView.eachnotes.setOnClickListener{
            if(check==0){
                val int= Intent(cont,writeNote::class.java)
                int.putExtra("Keys",note[position].id)
                cont.startActivity(int)
            }else{

                if(holder.itemView.selected.visibility==View.GONE){
                    holder.itemView.selected.visibility=View.VISIBLE
                    select.add(note[position].id)
                    s++
                }else
                if(holder.itemView.selected.visibility==View.VISIBLE) {
                    s--
                    select.remove(note[position].id)
                    holder.itemView.selected.visibility=View.GONE
                }
                inter.click(s)
            }
        }
        holder.itemView.eachnotes.setOnLongClickListener {
            check=1
            select.add(note[position].id)
            inter.Select(note[position].id)
            holder.itemView.selected.visibility=View.VISIBLE
            true
        }
    }

}

