package com.estudoskotlin.businesscard.screen

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estudoskotlin.businesscard.R
import com.estudoskotlin.businesscard.ui.theme.BusinessCardTheme

@Composable
fun MyBusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        abstract class SquashedOval : Shape() {
            fun createOutline(
                size: Size,
                layoutDirection: LayoutDirection,
                density: Density
            ): Outline {
                val path = androidx.compose.ui.graphics.Path().apply {
                    addOval(
                        Rect(
                            left = size.width / 4f,
                            top = 0f,
                            right = size.height * 3 / 4f,
                            bottom = size.height
                        )
                    )
                }
                return Outline.Generic(path = path)
            }
        }
        Card(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.eu),
                    contentDescription = stringResource(id = R.string.foto_graduacao_text),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(300.dp)
                        .width(250.dp)
                )
                Text(
                    text = stringResource(R.string.full_name_text),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(
                            top = 24.dp,
                            bottom = 8.dp
                        ),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.profession_text),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF3ddc84),
                    modifier = Modifier
                        .padding(bottom = 26.dp)
                )
            }
        }

        Card(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    tint = Color(0xFF3ddc84),
                    contentDescription = "Ícone Telefone",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(10.dp)
                )
                Text(
                    text = stringResource(R.string.fone_text),
                    textAlign = TextAlign.Start
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    tint = Color(0xFF3ddc84),
                    contentDescription = "Ícone Share",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(10.dp)
                )
                Text(
                    text = stringResource(R.string.instagram_text),
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    tint = Color(0xFF3ddc84),
                    contentDescription = "Ícone E-mail",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(10.dp)
                )
                Text(
                    text = stringResource(R.string.email_text),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyBusinessCardPreview() {
    BusinessCardTheme {
        MyBusinessCard()
    }
}