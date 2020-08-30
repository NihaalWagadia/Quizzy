package com.puzz.quizzydizzy

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.puzz.quizzydizzy.questionList.Question
import kotlinx.android.synthetic.main.level_card.view.*

class AdapterLevel(val arrayList: ArrayList<Question>, val mContext: Context) :
    RecyclerView.Adapter<AdapterLevel.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(question: Question) {
            if(!question.questionStat) {
                itemView.problemName.text = question.challengeNumber
                itemView.locking_question.setImageResource(question.lock_image)
                itemView.alpha = 0.5f
            }
            else{
                itemView.problemName.text = question.challengeNumber
                itemView.locking_question.setImageResource(android.R.color.transparent)
                itemView.alpha = 1.0f

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.level_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
//        holder.itemView.alpha = arrayList[position].opaque
        holder.itemView.setOnClickListener {
            if (arrayList[position].questionStat) {
                val intent = Intent(mContext, PlayAct::class.java)
                intent.putExtra("openLevel", position)
                mContext.startActivity(intent)
            }
        }
    }

}