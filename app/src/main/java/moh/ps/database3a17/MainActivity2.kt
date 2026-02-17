package moh.ps.database3a17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    lateinit var mydatabase: mydatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mydatabase=mydatabase(this)
        printData()
    }

    fun sarshe(view: View){
        val name= sarsheeee.text.toString()
        if (sarsheeee.text.isEmpty() ){
            Toast.makeText(this,"يرجى ادخال اسم منتج بطريقة صحيحة",Toast.LENGTH_SHORT).show()
        }else{
            val adapter = cuostom(this,mydatabase.sarshe(name) as ArrayList<Product>)
            listview.adapter=adapter
        }
    }
    fun printData(){
        val adapter = cuostom(this,mydatabase.databaseToString() as ArrayList<Product>)
        listview.adapter=adapter
    }

}