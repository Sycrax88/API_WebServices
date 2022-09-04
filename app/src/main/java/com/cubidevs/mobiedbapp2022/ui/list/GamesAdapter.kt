package com.cubidevs.mobiedbapp2022.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.mobiedbapp2022.R
import com.cubidevs.mobiedbapp2022.databinding.CardViewItemGameBinding
import com.cubidevs.mobiedbapp2022.server.model.FreeGame
import com.squareup.picasso.Picasso

class GamesAdapter(
    private val gamesList: ArrayList<FreeGame>,
    private val onItemClicked: (FreeGame) -> Unit
    ) : RecyclerView.Adapter<GamesAdapter.GameViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_game,parent,false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = gamesList[position]
        holder.bindGame(game)
        holder.itemView.setOnClickListener{ onItemClicked(gamesList[position])}
    }

    override fun getItemCount(): Int = gamesList.size

    fun appendItems(newList: ArrayList<FreeGame>){
        gamesList.clear()
        gamesList.addAll(newList)
        notifyDataSetChanged()
    }

        class  GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            private val binding = CardViewItemGameBinding.bind(itemView)

            fun bindGame(game: FreeGame){
                with(binding){
                    gameTitleTextView.text = game.title
                    genreTextView.text = game.genre
                    platformLabelTextView.text = game.platform
                    Picasso.get().load("https://www.freetogame.com/g/"+game.id.toString()+"/thumbnail.jpg").into(posterImageView)
                }
            }
        }
    }