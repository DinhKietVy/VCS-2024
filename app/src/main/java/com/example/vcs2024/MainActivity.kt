package com.example.vcs2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vcs2024.model.teams
import com.example.vcs2024.model.vcsTeam
import com.example.vcs2024.ui.theme.VCS2024Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VCS2024Theme {
                vcsApp()
            }
        }
    }
}

@Composable
private fun ItemButton(expanded: Boolean, onClick: ()-> Unit,modifier: Modifier=Modifier) {
    IconButton(onClick = onClick,modifier=modifier) {
        Icon(imageVector = if(expanded == false) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp, contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary)

    }
}


@Composable
fun vcsApp(modifier: Modifier=Modifier) {
    Scaffold(topBar = { TopBar()}) {
        it ->
        LazyColumn(modifier = modifier.fillMaxWidth(), contentPadding = it) {
            items(teams) {
                Teamitem(vcs = it)
            }
        }
    }
}

@Composable
fun Teamitem(vcs: vcsTeam,modifier: Modifier=Modifier) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(targetValue = if(expanded) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.primaryContainer)
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(8.dp),){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth().animateContentSize(animationSpec = spring(dampingRatio = Spring.DampingRatioNoBouncy, stiffness = Spring.StiffnessMedium)).background(color=color)
        ) {
            Box(modifier.size(width = 80.dp, height = 100.dp)) {
                Image(
                    painter = painterResource(id = vcs.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                )
            }
            Text(
                text = stringResource(id = vcs.name),
                style = MaterialTheme.typography.bodyLarge
            )
            ItemButton(expanded = expanded, onClick = { if (expanded == false) expanded = true else expanded = false })
            if (expanded) {
                Text(text = vcs.member.joinToString())
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier=Modifier) {
    CenterAlignedTopAppBar(title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier.size(width = 60.dp, height = 50.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.vcs_spring_2024_logo),
                    contentDescription = null
                )
            }
            Text(text = "VCS 2024", style = MaterialTheme.typography.displayLarge)
        }
    })
}


@Preview
@Composable
fun GreetingPreview() {
    VCS2024Theme {
        vcsApp()
    }
}

@Preview
@Composable
fun GreetingDarkPreview() {
    VCS2024Theme(darkTheme = true) {
        vcsApp()
    }
}