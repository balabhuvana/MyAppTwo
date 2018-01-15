package bala.test.com.myapptwo

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    internal val _ID = "_id"
    internal val NAME = "name"
    internal val GRADE = "grade"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClickRetrieveStudents()

    }

    fun onClickRetrieveStudents() {
        // Retrieve student records
        val URL = "content://bala.test.com.myappone.StudentsProvider"

        val students = Uri.parse(URL)
        val c = managedQuery(students, null, null, null, "name")


        if (c.moveToFirst()) {
            do {
                Log.d("MainActivity", "" + c.getString(c.getColumnIndex(_ID)))
                Log.d("MainActivity", "" + c.getString(c.getColumnIndex(NAME)))
                Log.d("MainActivity", "" + c.getString(c.getColumnIndex(GRADE)))
                Toast.makeText(applicationContext,
                        c.getString(c.getColumnIndex(_ID)) +
                                ", " + c.getString(c.getColumnIndex(NAME)) +
                                ", " + c.getString(c.getColumnIndex(GRADE)),
                        Toast.LENGTH_SHORT).show()
            } while (c.moveToNext())
        }
    }

}
