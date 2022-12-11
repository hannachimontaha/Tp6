import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EtudiantDbHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    public val db=writableDatabase

    companion object {

        public val DATABASE_VERSION = 1
        public val DATABASE_NAME = "PFE.db"
        public val TABLE_NAME = "etudiant"
        public val COLUMN_ETUDIANT_ID = "id"
        public val COLUMN_NAME_NOM = "nom"
        public val COLUMN_NAME_PRENOM = "prenom"
        public val COLUMN_NAME_PHONE = "phone"
        public val COLUMN_NAME_EMAIL = "email"
        public val COLUMN_NAME_LOGIN = "login"
        public val COLUMN_NAME_MDP = "mdp"




        public val SQL_CREATE_ENTRIES =
            " CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ETUDIANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME_NOM + " TEXT," +
                    COLUMN_NAME_PRENOM + " TEXT," +
                    COLUMN_NAME_PHONE + " TEXT," +
                    COLUMN_NAME_EMAIL + " TEXT," +
                    COLUMN_NAME_LOGIN + " TEXT," +
                    COLUMN_NAME_MDP + " TEXT)"



        public val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL(SQL_CREATE_ENTRIES)
        }

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}