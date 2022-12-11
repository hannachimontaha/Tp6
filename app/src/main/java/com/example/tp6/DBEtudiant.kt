package com.example.tp6

import android.provider.BaseColumns




object DBEtudiant {

    class EtudiantEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "etudiant"
            val COLUMN_ETUDIANT_ID = "id"
            val COLUMN_NAME_NOM = "nom"
            val COLUMN_NAME_PRENOM = "prenom"
            val COLUMN_NAME_PHONE = "phone"
            val COLUMN_NAME_EMAIL = "email"
            val COLUMN_NAME_LOGIN = "login"
            val COLUMN_NAME_MDP = "mdp"

        }
    }
}