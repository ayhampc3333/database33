package moh.ps.database3a17

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class mydatabase(context: Context) : SQLiteOpenHelper(context, mydatabase.DATABASE_NAME, null , mydatabase.DATABASE_VERSION) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(DATABASE_CREATE)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $DATEBASE_TABLE_NAME")
        onCreate(p0)
    }

    companion object{
        val KEY_ID = "ID"
        val P_NAME = "NAME"
        val P_QUANTITY = "QUANTITY"
        val DATEBASE_TABLE_NAME = "products"

        private val DATABASE_NAME = "data.db"
        private val DATABASE_VERSION = 2

        private val DATABASE_CREATE = "CREATE TABLE $DATEBASE_TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY ," + "$P_NAME TEXT NOT NULL," + "$P_QUANTITY INTEGER);"
    }

    fun addproduct(product:Product){
        val p0=this.writableDatabase
        val values = ContentValues()
        values.put(P_NAME,product.name)

        values.put(P_QUANTITY,product.q)

        p0.insert(DATEBASE_TABLE_NAME,null, values)
        p0.close()

    }

    fun deletproduct(product: Product)/*:Boolean*/ {
        val p0=writableDatabase
        p0.execSQL("delete from $DATEBASE_TABLE_NAME where $P_NAME=\"${product.name}\";")

    }
    fun sarshe(product: Product):ArrayList<Product>{
        var p0String = ArrayList<Product>()
        val p0=writableDatabase
        var query = "select * from $DATEBASE_TABLE_NAME where $P_NAME=\"${product.name}\";"
        val c=p0.rawQuery(query,null)
        p0String= ArrayList(c.count)

        while (c.moveToNext()) {
            val id = c.getInt(c.getColumnIndex(KEY_ID))
            val name = c.getString(c.getColumnIndex(P_NAME))
            val quantity = c.getInt(c.getColumnIndex(P_QUANTITY))
            p0String.add(Product(id,name,quantity))
        }
        c.close()
        return p0String
    }

    fun databaseToString(): ArrayList<Product>{
        var p0String = ArrayList<Product>()
        val p0=writableDatabase
        var query = "select * from $DATEBASE_TABLE_NAME where 1"
        val c=p0.rawQuery(query,null)
        p0String= ArrayList(c.count)
        while (c.moveToNext()) {
            val id = c.getInt(c.getColumnIndex(KEY_ID))
            val name = c.getString(c.getColumnIndex(P_NAME))
            val quantity = c.getInt(c.getColumnIndex(P_QUANTITY))
            p0String.add(Product(id,name,quantity))

        }
        c.close()
        return p0String
    }


}
