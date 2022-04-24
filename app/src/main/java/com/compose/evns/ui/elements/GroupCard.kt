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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.evns.R
import com.compose.evns.ui.theme.EvnsTheme

data class GroupInfo(val name:String,val desc:String)

@Composable
fun GroupCard(info:GroupInfo){
    Card(modifier = Modifier.padding(all = 8.dp).fillMaxWidth().height(20.dp), backgroundColor = Color.LightGray, shape = RoundedCornerShape(8.dp)) {

        Row(modifier = Modifier.padding(all = 4.dp) ){
            Spacer(modifier = Modifier.width(8.dp))
            Column{
                Text("${info.name}", modifier = Modifier.height(40.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                Text("${info.desc}")
            }
        }
    }
}
@Preview
@Composable
fun GroupCard(){
    EvnsTheme {
        Card(
            modifier = Modifier.padding(all = 8.dp).fillMaxWidth().height(20.dp),
            backgroundColor = Color.LightGray,
            shape = RoundedCornerShape(8.dp)
        ) {

            Row(modifier = Modifier.padding(all = 4.dp)) {
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        "${"Developer Student Club"}",
                        modifier = Modifier.height(40.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("${"Google Developer Student Clubs (GDSC) are community groups for college and university students interested in Google developer technologies. Students from all undergraduate or graduate programs with an interest in growing as a developer are welcome."}")
                }
            }
        }
    }
}