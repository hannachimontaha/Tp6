package com.example.tp6


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class etudiantAdapter(private val listData: MutableList<EtudiantModel>, private val listener: OnItemClickListener):
    RecyclerView.Adapter<etudiantAdapter.ViewHolder>() {

    private var ps : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.etudiantmodel, parent, false)
        val holder = ViewHolder(view)
        return holder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val etudiant : EtudiantModel = listData[position]
        holder.bind(etudiant)
        /*  val nom : String = listData[position]
          holder.bind(nom) */

    }


    override fun getItemCount(): Int {
        return listData.size
    }



    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView),
        View.OnClickListener {
        private var nom: TextView = itemView.findViewById(R.id.nom1)
        private var prenom: TextView = itemView.findViewById(R.id.prenom1)
        private var tel: TextView = itemView.findViewById(R.id.tel1)
        private var email: TextView = itemView.findViewById(R.id.email1)
        private var login: TextView = itemView.findViewById(R.id.login1)
        private var password: TextView = itemView.findViewById(R.id.password1)


        init {
            ItemView.setOnClickListener(this)
        }

        fun bind(etudiantModel: EtudiantModel){
            nom.text = etudiantModel.nom
            prenom.text = etudiantModel.prenom
            tel.text = etudiantModel.phone
            email.text = etudiantModel.email
            login.text = etudiantModel.login
            password.text = etudiantModel.password
        }


        override fun onClick(p0: View?) {
            ps = adapterPosition
            if (ps != RecyclerView.NO_POSITION){
                listener.OnItemClick(ps)
            }
        }

    }



    interface OnItemClickListener {
        fun OnItemClick(position: Int)
    }

}