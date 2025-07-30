package com.example.jetnewcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable

fun JetNewDrawContent(closeDrawer: () -> Unit) {

    ModalDrawerSheet {
        IconNavigationDraw(
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 18.dp),
        )

        NavigationDrawerItem(
            label = { Text(text = "Drawer Item") },
            selected = false,
            icon = { Icon(painterResource(R.drawable.ic_home), null) },
            onClick = {
                closeDrawer()
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
        )

        NavigationDrawerItem(
            label = { Text(text = "Drawer Item") },
            selected = false,
            icon = { Icon(painterResource(R.drawable.ic_list_alt), null) },
            onClick = {
                closeDrawer()
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
        )
    }
}

@Composable
fun IconNavigationDraw(modifier: Modifier = Modifier) {
    Row(modifier) {
        Icon(
            painter = painterResource(R.drawable.ic_jetnews_logo),
            contentDescription = "Jetnews Logo",
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = stringResource(R.string.title_navigation_draw),
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}