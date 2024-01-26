package com.example.bankingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleStart

val financeList: List<Finance> = listOf(
    Finance(
        icon = Icons.Rounded.Star,
        name = " My\nBusiness",
        background = OrangeStart
    ),

    Finance(
        icon = Icons.Rounded.Warning,
        name = " My\nWallet",
        background = BlueStart
    ),

    Finance(
        icon = Icons.Rounded.Star,
        name = " My\nAnalytics",
        background = PurpleStart
    ),

    Finance(
        icon = Icons.Rounded.MailOutline,
        name = " My\nTransaction",
        background = GreenStart
    ),
)


@Preview
@Composable
fun FinanceSection() {
    Column(modifier = Modifier.padding(top = 270.dp)) {
        Text(
            text = "Finance",
            fontSize = 24.sp,
               color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 19.dp)
        )
       LazyRow{
           items(financeList.size){
               FinanceItem(it)
           }
       }
    }
}


@Composable
fun FinanceItem(index: Int) {
    val finance = financeList[index]
    var lastItempadding = 0.dp
    if(index == financeList.size -1){
        lastItempadding = 16.dp
    }
    Box(modifier = Modifier.padding(start = 3.dp, end = 12.dp))
    Column(modifier = Modifier
        .clip(RoundedCornerShape(25.dp))
        .size(120.dp)
        .clickable { }
        .background(MaterialTheme.colorScheme.secondaryContainer)
        .padding(12.dp),
        verticalArrangement = Arrangement.SpaceBetween,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(6.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(finance.background)
        ) {
            Icon(
                imageVector = finance.icon,
                contentDescription = null,
                tint = Color.White,
            )
        }
        Text(text = finance.name,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 5.dp))
   }
}