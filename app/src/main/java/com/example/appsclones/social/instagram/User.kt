package com.example.appsclones.social.instagram

import androidx.annotation.DrawableRes
import com.example.appsclones.R

data class User(
    val id: Int,
    val username: String,
    @DrawableRes val image: Int,
    val hasStory: Boolean,
    val post: Post,
) {
    companion object {
        val users = listOf(
            User(4, "Paylak", R.drawable.defprof, true,
                Post(4, R.drawable.postimage4, "October 24", 37456, 2756, 29678, "Nayeq vonc em hesa qyali tali erekheqqq", 4)
            ),
            User(5, "Garnik", R.drawable.prof1, true,
                Post(5, R.drawable.postimage5, "October 19", 19503, 1785, 14670, "Going to hiking", 5)
            ),
            User(2, "Anushik", R.drawable.prof2, true,
                Post(2, R.drawable.postimage2, "October 27", 26549, 1745, 21212, null, 2)
            ),
            User(1, "Gegham", R.drawable.prof4, true,
                Post(1, R.drawable.postimage1, "September 14", 14375, 1347, 12645, null, 1)
            ),
            User(3, "Martin", R.drawable.prof3, true,
                Post(3, R.drawable.postimage3, "September 27", 9870, 876, 5640, null, 3)
            ),
        )
    }
}