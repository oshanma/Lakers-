package edu.nku.lakers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.nku.classapp.R

class LakersCharactersAdapter(private val characters: List<LakersCharacters>) :
    RecyclerView.Adapter<LakersCharactersAdapter.LakersCharactersViewHolder>() {

    class LakersCharactersViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        val characterName: TextView = itemView.findViewById(R.id.character_name)
        val characterAge: TextView = itemView.findViewById(R.id.character_age)
        val characterPosition: TextView = itemView.findViewById(R.id.character_position)
        val characterJersey: TextView = itemView.findViewById(R.id.character_jersey_number)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = LakersCharactersViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.character_card_view,
            parent,
            false
        )
    )

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(
        holder: LakersCharactersViewHolder,
        position: Int
    ) {
        val character = characters[position]
        holder.characterName.text = character.name
        holder.characterAge.text = holder.itemView.context.getString(R.string.age, character.year)
        holder.characterPosition.text =
            holder.itemView.context.getString(R.string.position, character.position)
        holder.characterJersey.text =
            holder.itemView.context.getString(R.string.jersey_number, character.jerseyNum)

        // Load image using Glide (or use Picasso)
        Glide.with(holder.itemView.context)
            .load(character.pictureUrl)
            .placeholder(R.drawable.ic_launcher_background) // Default image
            .error(R.drawable.ic_launcher_foreground) // Error image
            .into(holder.characterImage)

    }

}