package com.nailton.journalapp

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nailton.journalapp.databinding.JournalRowBinding
import java.util.ArrayList

class JournalRecyclerAdapter(val context: Context, private val journalList: List<Journal>)
    : RecyclerView.Adapter<JournalRecyclerAdapter.MyViewHolder>()
{
    // criando suporte de visualizacao usando o binding para acessar informacoes
    class MyViewHolder(var binding: JournalRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(journal: Journal) {
            binding.journal = journal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            JournalRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return journalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val journal: Journal = journalList[position]
        holder.bind(journal)
        val intent = Intent(Intent.ACTION_SEND_MULTIPLE).apply {
            this.putExtra(Intent.EXTRA_TEXT,
                "Usuario: ${journal.username}\n" +
                        "Titulo: ${journal.title}\n" +
                        "Descricao: ${journal.thoughts}"
                )
            this.type = "text/plain"
        }
        holder.binding.journalRowShareButton.setOnClickListener {
            context.startActivity(Intent.createChooser(intent, "Share to..."))
        }
    }
}