package com.compose.evns

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.evns.ui.elements.Message
import com.compose.evns.ui.elements.MessageCard
import com.compose.evns.ui.theme.EvnsTheme
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Firebase.firestore
        setContent {
            EvnsTheme {
                Scaffold(
                    floatingActionButton = {
                        ExtendedFloatingActionButton(
                            text = { Text("Add test") },
                            onClick = {
                                val user = hashMapOf(
                                    "first" to "Ada",
                                    "last" to "Lovelace",
                                    "born" to 1815
                                )

                                db.collection("test")
                                    .add(user)
                                    .addOnSuccessListener { documentReference ->
                                        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
                                    }
                                    .addOnFailureListener { e ->
                                        Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
                                    }}
                        )
                    },
                ) {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        //MessageCard(Message("Admin","Hellooo.",Date().toString()))
                        Button(
                            onClick = { Fetch(db,this) },
                            // Uses ButtonDefaults.ContentPadding by default
                            contentPadding = PaddingValues(
                                start = 20.dp,
                                top = 12.dp,
                                end = 20.dp,
                                bottom = 12.dp
                            )){
                            // Inner content including an icon and a text label
                            Text("View")
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

fun Fetch(db : FirebaseFirestore,activity: MainActivity){
    db.collection("test")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Toast.makeText(activity, "${document.id} => ${document.data}", Toast.LENGTH_SHORT).show()
            }
        }
        .addOnFailureListener { exception ->
            Toast.makeText(activity, "Fail", Toast.LENGTH_SHORT).show()
        }
}