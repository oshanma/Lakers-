package edu.nku.lakers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val names =
        listOf("LeBron", "Luka", "Austin", "Rui", "Jaxson", "Jarred", "Gabe", "Bronny")
    private val lastNames =
        listOf("James", "Doncic", "Reaves", "Hachimura", "Hayes", "Vanderbilt", "Vincent", "James")

    // Actual basketball positions
    private val position = listOf(
        "SF/PF",  // LeBron James
        "PG/SG",  // Luka Doncic
        "SG",     // Austin Reaves
        "PF",     // Rui Hachimura
        "C",      // Jaxson Hayes
        "PF",     // Jarred Vanderbilt
        "PG",     // Gabe Vincent
        "PG/SG"   // Bronny James
    )

    // Years in NBA
    private val year = listOf(
        21,  // LeBron James
        6,   // Luka Doncic
        3,   // Austin Reaves
        5,   // Rui Hachimura
        5,   // Jaxson Hayes
        6,   // Jarred Vanderbilt
        5,   // Gabe Vincent
        0    // Bronny James (Rookie)
    )

    // Jersey Numbers
    private val jerseyNum = listOf(
        6,  // LeBron James
        77, // Luka Doncic
        15, // Austin Reaves
        28, // Rui Hachimura
        11, // Jaxson Hayes
        2,  // Jarred Vanderbilt
        7,  // Gabe Vincent
        9   // Bronny James
    )

    private val pictureUrls = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/LeBron_James_2020.jpg/200px-LeBron_James_2020.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Luka_Dončić_2021.jpg/200px-Luka_Dončić_2021.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Austin_Reaves_2023.jpg/200px-Austin_Reaves_2023.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Rui_Hachimura_2019.jpg/200px-Rui_Hachimura_2019.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Jaxson_Hayes_2020.jpg/200px-Jaxson_Hayes_2020.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Jarred_Vanderbilt_2023.jpg/200px-Jarred_Vanderbilt_2023.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Gabe_Vincent_2023.jpg/200px-Gabe_Vincent_2023.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Bronny_James_2023.jpg/200px-Bronny_James_2023.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val characters = mutableListOf<LakersCharacters>()


        for (i in names.indices) {
            characters.add(createCharacter(i))
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LakersCharactersAdapter(characters)
    }

    private fun createCharacter(id: Int): LakersCharacters {
        return LakersCharacters(
            year = year[id],
            jerseyNum = jerseyNum[id],
            name = "${names[id]} ${lastNames[id]}",
            position = position[id],
            pictureUrl = pictureUrls[id]
        )
    }
}