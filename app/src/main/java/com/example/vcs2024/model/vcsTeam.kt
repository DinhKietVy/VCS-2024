package com.example.vcs2024.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.vcs2024.R

class vcsTeam(@StringRes val name: Int, val member: Array<String>,@DrawableRes val image: Int) {
}

val teams = listOf(
    vcsTeam(R.string.gam,arrayOf("Levi","Kiaya","Blazes","Emo","Pyshiro","Elio"), R.drawable.gam),
    vcsTeam(R.string.viking, arrayOf("Kratos","Gury","Kati","Shogun","Kairi"),R.drawable.viking),
    vcsTeam(R.string.teamwhale, arrayOf("Sparda","BeanJ","Gloryy","Artemis","Harky","Bie"),R.drawable.team_whale),
    vcsTeam(R.string.cerberus, arrayOf("Pun","ikigai","Richard I","Slowz","Hieu3"),R.drawable.cerberus_esports_29logo_square),
    vcsTeam(R.string.MGN, arrayOf("Ryuk","Rigel","Sorn","Froggy","Nogo","Sty1e","Zodiac"),R.drawable.mgn_blue_esportslogo_profile),
    vcsTeam(R.string.rainbow, arrayOf("Yuki","2T","Spot","Hyo","Artifact","EasyLove","K1ller","N0way","Zin"),R.drawable.rainbow_warriorslogo_square),
    vcsTeam(R.string.flash, arrayOf("Yoshino","Marcus","Draktharr","Jane","Puddin","Soraaa"),R.drawable.team_flashlogo_profile),
    vcsTeam(R.string.secret, arrayOf("Hasmed","Hiro02","Qiang","Aress","Eddie","Taki"),R.drawable.team_secret_29logo_profile)
)