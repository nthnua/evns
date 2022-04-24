package com.compose.evns

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.evns.ui.elements.Message
import com.compose.evns.ui.elements.MessageCard
import com.compose.evns.ui.theme.EvnsTheme
import com.compose.evns.ui.theme.Purple500
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Firebase.firestore
        val OpenForm = mutableStateOf(false)
        setContent {
            EvnsTheme {
                Scaffold(
                    floatingActionButton = {
                        ExtendedFloatingActionButton(
                            text = { Text("Insert") },
                            onClick =   { OpenForm.value=true
                                },
                            backgroundColor = LightGray
                        )
                    },
                ) {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        //MessageCard(Message("Admin","Hellooo.",Date().toString()))
                        DisplayMessages()
                        if(OpenForm.value) {
                            ShowAlertDialog(OpenForm)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EvnsTheme {
        MessageCard(Message("Admin","Hello everyone \n" +
                "Want to display ipl heroics , then put on your helmets and March towards  the pitch\n" +
                "\n" +
                "Inter Branch Mens Cricket Match \uD83C\uDFCF\uD83C\uDFCFis been conducted this year.\n" +
                "Interested students  of CSE branch do join the below mentioned WhatsApp group \n" +
                "Futher information will be provided in group itself\n" +
                "https://chat.whatsapp.com/I18vdJDFSfQHfNGBnu3fpq\n" +
                "\n" +
                "So till then practice ur shots and precise ur line and lengths\n" +
                "\n" +
                "Contact details\n" +
                "Mohith : 70198 99149\n" +
                "Preeth Jain : 6366299788\n" +
                "Nishan : 93536 26903",
            time = Date().toString()))

    }
}

@Composable
fun DisplayMessages(){
    val context= LocalContext.current
    val messages= remember { mutableStateListOf(Message())  }

    MsgService.getMsgs(messages)
    
    LazyColumn{
        items(messages){ item :Message ->
            MessageCard(msg = item)
            
        }

    }
}



fun <T> SnapshotStateList<T>.updateList(newList: List<T>){
    clear()
    addAll(newList)
}