package com.example.tp6
import EtudiantDbHelper
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.NonCancellable.cancel

class MainActivity : AppCompatActivity() {

    lateinit var nom : EditText
    lateinit var prenom : EditText
    lateinit var tel : EditText
    lateinit var email : EditText
    lateinit var login : EditText
    lateinit var password : EditText
    lateinit var valider : Button
    lateinit var annuler : Button
    lateinit var etudiantDbhelper: EtudiantDbHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nom = findViewById(R.id.nom)
        prenom = findViewById(R.id.prenom)
        tel = findViewById(R.id.tel)
        email = findViewById(R.id.email)
        login = findViewById(R.id.login)
        password = findViewById(R.id.password)
        valider = findViewById(R.id.valider)
        annuler = findViewById(R.id.annuler)
        etudiantDbhelper = EtudiantDbHelper(this)

    }

    fun addUser(view: View) {
        if (nom.text.length == 0 || prenom.text.length == 0 || tel.text.length == 0 || email.text.length == 0 || login.text.length == 0 || password.text.length == 0) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Tous les champs doivent être remplis")
            builder.setTitle("Attention")
            builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, id -> cancel() })
            builder.show()
        }
        else{
            val nom = nom.text.toString()
            val prenom = prenom.text.toString()
            val tel = tel.text.toString()
            val email = email.text.toString()
            val login = login.text.toString()
            val password = password.text.toString()


            val db = etudiantDbhelper.db
            val values = ContentValues()
            values.put(EtudiantDbHelper.COLUMN_NAME_NOM, nom)
            values.put(EtudiantDbHelper.COLUMN_NAME_PRENOM, prenom)
            values.put(EtudiantDbHelper.COLUMN_NAME_PHONE, tel)
            values.put(EtudiantDbHelper.COLUMN_NAME_EMAIL, email)
            values.put(EtudiantDbHelper.COLUMN_NAME_LOGIN, login)
            values.put(EtudiantDbHelper.COLUMN_NAME_MDP, password)

            val newrow = db.insert(EtudiantDbHelper.TABLE_NAME, null, values)
            //Toast.makeText(this, newrow.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListEtudiant::class.java)
            startActivity(intent)

        }

    }

    fun annuler(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Voulez vous vraiment remettre à zero les champs?")
        builder.setTitle("Attention")
        builder.setPositiveButton("OUI") { dialog, id ->
            nom.setText("")
            prenom.setText("")
            tel.setText("")
            email.setText("")
            login.setText("")
            password.setText("")

        }
        builder.setNegativeButton("NON", DialogInterface.OnClickListener { dialogInterface, id -> cancel() })
        builder.show()

    }


}