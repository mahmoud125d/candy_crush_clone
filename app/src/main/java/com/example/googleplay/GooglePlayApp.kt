package com.example.googleplay

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        TopBar()
        AppName(appName = "Candy Crush Sage")
        ReviewSection()
        InstallButton()
        ImagesSection()

    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
        )
        Row {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(30.dp))
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
            )
        }


    }
}

@Composable
fun AppName(modifier: Modifier = Modifier, appName: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Image(
            painter = painterResource(id = R.drawable.app_image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(20.dp))
                .weight(3f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(7f)
        ) {
            Text(
                text = appName,
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,

                )
            Text(text = "King", fontSize = 20.sp, color = Color.Blue)
            Text(text = "Contain ads . In-app purchases", color = Color.DarkGray)
        }
    }
}

@Composable
fun ReviewSection(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(20.dp)
    ) {
        items(1) {

            ReviewSector(
                bottomText = "34M reviews",
                bottomIcon = Icons.Default.Info,
                topText = "4.5",
                topIcon = Icons.Default.Star
            )
            Spacer(modifier = Modifier.width(32.dp))
            Separator()
            Spacer(modifier = Modifier.width(32.dp))
            ReviewSector(
                bottomText = "90 MB",
                topIcon = Icons.Default.Download,

                )
            Spacer(modifier = Modifier.width(32.dp))
            Separator()
            Spacer(modifier = Modifier.width(32.dp))
            ReviewSector(
                bottomText = "Rated for 3+",
                bottomIcon = Icons.Default.Info,
                topIcon = Icons.Default.AddBox

            )
            Spacer(modifier = Modifier.width(32.dp))
            Separator()
            Spacer(modifier = Modifier.width(32.dp))
            ReviewSector(
                topText = "1B+",
                bottomText = "Downloads",
            )

        }
    }

}

@SuppressLint("InvalidColorHexValue")
@Composable
fun ReviewSector(modifier: Modifier = Modifier, topText: String? = null, topIcon: ImageVector? = null, bottomText: String, bottomIcon: ImageVector? = null) {
    val defaultWidth = 80.dp
    Column(
        modifier = modifier
            .defaultMinSize(minWidth = defaultWidth),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .defaultMinSize(minWidth = defaultWidth)
                .padding(bottom = 6.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (topText != null) {
                Text(text = topText)
            }
            if (topIcon != null) {
                if (topIcon == Icons.Default.Star) {
                    Icon(
                        imageVector = topIcon,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(16.dp)
                    )
                } else {
                    Icon(
                        imageVector = topIcon,
                        contentDescription = null,
                        tint = Color.Black

                    )
                }

            }
        }
        Row {
            Text(text = bottomText, color = Color.DarkGray)
            if (bottomIcon != null) {
                Icon(
                    imageVector = bottomIcon,
                    contentDescription = null,
                    tint = Color.DarkGray,
                    modifier = Modifier.size(16.dp)
                )
            }

        }
    }
}

@Composable
fun Separator(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .width(2.dp)
        .fillMaxHeight()
        .padding(vertical = 16.dp)
        .background(Color.LightGray)
    ) {

    }
}

@Composable
fun InstallButton(modifier: Modifier=Modifier) {
    Button(onClick = { /*TODO*/ },modifier= modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {
        Text(text = "Install")
    }
}

@Composable
fun ImagesSection(modifier: Modifier=Modifier) {
    LazyRow(modifier=modifier.height(180.dp)){
        items(6){
            BorderedImage(image = painterResource(id = R.drawable.alt_image))
        }
    }
}

@Composable
fun BorderedImage(modifier: Modifier=Modifier,image:Painter) {
    Image(
        painter = image, contentDescription = null,
        modifier=Modifier.aspectRatio(1f).clip(RoundedCornerShape(10.dp)
        )
    )
}