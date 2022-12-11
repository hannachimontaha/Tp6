package com.example.tp6

import EtudiantDbHelper
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.database.SQLException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListEtudiant : AppCompatActivity() , etudiantAdapter.OnItemClickListener{

    lateinit var etudiantDbhelper: EtudiantDbHelper
    lateinit var lisetetudiants: MutableList<EtudiantModel>
    lateinit var mRecyclerView : RecyclerView
    lateinit var myAdapter: etudiantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_etudiant)

        etudiantDbhelper = EtudiantDbHelper(this)
        mRecyclerView = findViewById(R.id.recyclerview)
        lisetetudiants = showalletudiants()

        mRecyclerView.layoutManager = GridLayoutManager(this, 1)

        myAdapter = etudiantAdapter(lisetetudiants,this)
        mRecyclerView.adapter = myAdapter
    }

    @SuppressLint("Range")
    fun showalletudiants(): MutableList<EtudiantModel> {
        val etudiants = ArrayList<EtudiantModel>()
        val db = etudiantDbhelper.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + EtudiantDbHelper.TABLE_NAME, null)


            if (cursor?.moveToFirst() == true) {
                while (cursor.isAfterLast == false) {


                    var nom = cursor.getString(cursor.getColumnIndex(EtudiantDbHelper.COLUMN_NAME_NOM))
                    var prenom = cursor.getString(cursor.getColumnIndex(EtudiantDbHelper.COLUMN_NAME_PRENOM))
                    var tel = cursor.getString(cursor.getColumnIndex(EtudiantDbHelper.COLUMN_NAME_PHONE))
                    var email = cursor.getString(cursor.getColumnIndex(EtudiantDbHelper.COLUMN_NAME_EMAIL))
                    var login = cursor.getString(cursor.getColumnIndex(EtudiantDbHelper.COLUMN_NAME_LOGIN))
                    var password = cursor.getString(cursor.getColumnIndex(EtudiantDbHelper.COLUMN_NAME_MDP))
                    var etudiant = EtudiantModel(nom, prenom, tel, email, login, password)
                    etudiants.add(etudiant)
                    cursor.moveToNext()


                }
            }
        }catch (e: SQLException){

        }

        return etudiants;

    }

    override fun OnItemClick(position: Int) {

        Toast.makeText(this, "Item " + position + " clicked" , Toast.LENGTH_LONG).show()
    }
}