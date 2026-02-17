package moh.ps.database3a17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mydatebase:mydatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mydatebase=mydatabase(this)
        listB.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }

    fun add(view: View) {
        val nameProduct=nameproducer.text.toString()
        val quantity=numBox.text.toString().toInt()
        if ( nameproducer.text.isEmpty() || numBox.text.isEmpty()){
            Toast.makeText(this,"يرجى ادخال البيانات بشكل صحيح",Toast.LENGTH_SHORT).show()
        }else {
            mydatebase.addproduct(Product(0,nameProduct,quantity))
            numBox.text.clear()
            nameproducer.text.clear()


        }
    }
    fun delete(view: View) {
        val nameproduct = nameproducer.text.toString()
        mydatebase.deletproduct(nameproduct)
        if (nameproducer.text.isEmpty()){
            Toast.makeText(this,"يرجى ادخال البيانات بشكل صحيح",Toast.LENGTH_SHORT).show()
        }
        numBox.text.clear()
        nameproducer.text.clear()
    }
}