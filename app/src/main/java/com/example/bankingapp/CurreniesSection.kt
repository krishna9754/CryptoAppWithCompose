package com.example.bankingapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.ui.theme.GreenStart


val currencies: List<Currency> = listOf(
    Currency(
        name = "USD",
        buy = "23.25f",
        sell = "23.25f",
        icon = Icons.Rounded.Face
    ),

    Currency(
        name = "EUR",
        buy = "13.25f",
        sell = "13.25f",
        icon = Icons.Rounded.Face
    ),

    Currency(
        name = "YEN",
        buy = "12.25f",
        sell = "12.25f",
        icon = Icons.Rounded.Face
    ),

    Currency(
        name = "USD",
        buy = "23.25f",
        sell = "23.25f",
        icon = Icons.Rounded.Face
    ),

    Currency(
        name = "ESP",
        buy = "23.25f",
        sell = "23.25f",
        icon = Icons.Rounded.Face
    ),


)


@Preview
@Composable
fun CurreniesSection(){
    var isVisible by remember{
        mutableStateOf(true)
    }

    var iconState by remember{
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp),
        contentAlignment = Alignment.BottomCenter)
    {

    Column(
        modifier = Modifier.padding(bottom = 40.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        iconState = if (isVisible) {
                            Icons.Rounded.KeyboardArrowUp
                        } else {
                            Icons.Rounded.KeyboardArrowDown
                        }
                    }
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = iconState, contentDescription = "Curr",
                    tint = MaterialTheme.colorScheme.onSecondary
                 )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "Currencies" ,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold
                )
        }
        Spacer(modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer))


        if (isVisible) {
            BoxWithConstraints(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(MaterialTheme.colorScheme.background)
            ) {
                val boxWithConstraintsScore = this
                val width = boxWithConstraintsScore.maxWidth / 3

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Currency",
                            modifier = Modifier.width(width),
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 18.sp
                        )

                        Text(
                            text = "Buy",
                            modifier = Modifier.width(width),
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "Sell",
                            modifier = Modifier.width(width),
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center

                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn {
                        items(currencies.size) { index ->
                            CurrencyItem(index = index, width = width)
                        }
                    }

                }
            }
        }
        }
    }
}


@Composable
fun CurrencyItem(
    index: Int,
    width: Dp
){
    val currency = currencies[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
          modifier = Modifier
              .clip(RoundedCornerShape(8.dp))
              .background(GreenStart)
              .padding(4.dp)
        ){
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = currency.icon, contentDescription = "Currency",
                tint = Color.White
            )
        }

        Text(modifier = Modifier
            .width(width)
            .padding(start = 8.dp),
            text = currency.name,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )

        Text(modifier = Modifier
            .width(width),
            text = currency.buy,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )

        Text(modifier = Modifier
            .width(width),
            text = currency.sell,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )
    }
}