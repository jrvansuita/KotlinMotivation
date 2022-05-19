package com.vansuita.motivation.data

import com.vansuita.motivation.R
import kotlin.random.Random

enum class PhraseCategory(val id: Int) {
    ALL(R.id.image_all), HAPPY(R.id.image_happy), SUNNY(R.id.image_sunny)
}

class Phrase(var description: String, var category: PhraseCategory)


class MockPhrases {
    companion object {
        val LIST = listOf(
            Phrase(
                "Not knowing it was impossible, he went there and did it.",
                PhraseCategory.HAPPY
            ),
            Phrase(
                "You are not defeated when you lose, you are defeated when you give up!",
                PhraseCategory.HAPPY
            ),
            Phrase("When it's darker, we see more stars!", PhraseCategory.HAPPY),
            Phrase(
                "Insanity is doing the same thing over and over and expecting a different result.",
                PhraseCategory.HAPPY
            ),
            Phrase(
                "Don't stop when you're tired, stop when you're done.",
                PhraseCategory.HAPPY
            ),
            Phrase(
                "What can you do now that has the biggest impact on your success?",
                PhraseCategory.HAPPY
            ),
            Phrase("The best way to predict the future is to invent it.", PhraseCategory.SUNNY),
            Phrase("You miss every chance you don't take.", PhraseCategory.SUNNY),
            Phrase(
                "Failure is the condiment that gives the flavor of success.",
                PhraseCategory.SUNNY
            ),
            Phrase(
                "As long as we are not committed, there will be hesitation!",
                PhraseCategory.SUNNY
            ),
            Phrase(
                "If you don't know where you want to go, any path will do.",
                PhraseCategory.SUNNY
            ),
            Phrase("If you believe, it makes all the difference.", PhraseCategory.SUNNY),
            Phrase(
                "Risks must be taken, because the greatest danger is to risk nothing!",
                PhraseCategory.SUNNY
            )
        )
    }

    fun get(category: PhraseCategory?): Phrase {
        val filtered = LIST.filter { (it.category == category || category == PhraseCategory.ALL) }

        val rand = Random.nextInt(filtered.size)

        return filtered[rand]
    }
}