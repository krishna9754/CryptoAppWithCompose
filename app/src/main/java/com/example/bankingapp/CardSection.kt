package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.ui.theme.BlueEnd
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenEnd
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeEnd
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleEnd
import com.example.bankingapp.ui.theme.PurpleStart


val cards: List<Card> = listOf(

    Card(
        cardType = "Visa",
        cardNumber = "4242 4242 4242 4242",
        cardName = "Business",
        balance = "46.334",
        color = getGradiant(PurpleStart, PurpleEnd)
    ),

    Card(
        cardType = "Master Card",
        cardNumber = "3322 4242 4344 4242",
        cardName = "Saving",
        balance = "23.334",
        color = getGradiant(BlueStart, BlueEnd)
    ),

    Card(
        cardType = "Saving Card",
        cardNumber = "3432 5532 4242 4242",
        cardName = "School",
        balance = "06.334",
        color = getGradiant(OrangeStart, OrangeEnd)
    ),

    Card(
        cardType = "Visa",
        cardNumber = "4242 4242 4242 4242",
        cardName = "Trip",
        balance = "40.334",
        color = getGradiant(GreenStart, GreenEnd)
    ),
)

fun getGradiant(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}





@Composable
fun CardSection(){
    LazyRow(modifier = Modifier.padding(top = 80.dp)){
        items(cards.size){index ->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(
    index: Int
){
    val card = cards[index]
    var lastItemPadding = 0.dp
    if(index == cards.size - 1){
        lastItemPadding = 16.dp
    }

    var image = painterResource(id = R.drawable.visa_card)
    if(card.cardName == "Master Card"){
        image = painterResource(id = R.drawable.master_card)
    }

    Box(modifier = Modifier
        .padding(start = 16.dp, end = lastItemPadding))
    {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = image, contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = card.cardName,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 17.sp)

            Text(text = "$ ${card.balance}",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 17.sp)

            Text(text = card.cardNumber,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 18.sp)
        }
    }
}