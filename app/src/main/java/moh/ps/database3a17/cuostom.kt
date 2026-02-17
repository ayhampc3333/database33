package moh.ps.database3a17

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item.view.*

class cuostom(context: Context, private var objects: ArrayList<Product>) : ArrayAdapter<Product>(context, R.layout.item, objects) {
    lateinit var mydb: mydatabase


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var l: LayoutInflater =LayoutInflater.from(context)
        var custom:View=l.inflate(R.layout.item,parent,false)
        val r:Product = getItem(position)!!
        custom.textViewtsmem3.text= "ID:${r.id}"
        custom.textViewtsmem2.text="name:${r.name}"
        custom.textViewtsmem.text="Q:${r.q}"
        mydb=mydatabase(context)

        custom.imageViewtsmem.setOnClickListener {

            mydb.deletproduct(r.name)
            objects.removeAt(position)
            notifyDataSetChanged()
        }
        custom.Detailsimage.setOnClickListener {
            val bulider= AlertDialog.Builder(context)
            bulider.setTitle("تفاصيل عن المنتج")
            bulider.setMessage("ID:${r.name} \n \n name:${r.name} \n \n Q:${r.q}")
            bulider.setPositiveButton("موافق"){ _: DialogInterface, _:Int ->

            }
            val dialog=bulider.create()
            dialog.show()
        }

       // var productsimage= mapOf("اكمول" to R.drawable.acamol ,"بنادول" to R.drawable.panadol )
       // var imge=productsimage[r.name]?: R.drawable.nophoto
       // custom.imageView.setImageResource(imge)



        return custom
    }

}