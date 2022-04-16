package com.compose.evns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.compose.evns.ui.elements.Message
import com.compose.evns.ui.elements.MessageCard
import com.compose.evns.ui.theme.EvnsTheme
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EvnsTheme {
                Scaffold() {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        MessageCard(Message("Admin","Hellooo.",Date().toString()))
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