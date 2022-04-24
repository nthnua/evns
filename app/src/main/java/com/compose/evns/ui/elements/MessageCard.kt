package com.compose.evns.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.evns.R

data class Message(val author:String="", val body:String="",val time:String="")

@Composable
fun MessageCard(msg: Message){
    Card(modifier = Modifier.padding(all = 8.dp).fillMaxWidth(), backgroundColor = Color.LightGray, shape = RoundedCornerShape(8.dp)) {

        Row(modifier = Modifier.padding(all = 4.dp) ){
            Image(painter = painterResource(R.drawable.memoji),
                contentDescription = "Memoji :)",
                modifier = Modifier.size(40.dp).clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column{
                Text("${msg.author}", modifier = Modifier.height(40.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                Text("${msg.body}")
                Spacer(modifier = Modifier.height(20.dp))
                Text("${msg.time}", textAlign = TextAlign.End, modifier = Modifier.align(Alignment.End) )
            }
        }
    }
}