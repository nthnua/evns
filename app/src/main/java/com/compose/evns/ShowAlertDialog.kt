package com.compose.evns

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.compose.evns.ui.elements.Message
import com.compose.evns.ui.theme.Purple500
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

@Composable
fun ShowAlertDialog(isDialogOpen: MutableState<Boolean>) {
    val authorVal = remember { mutableStateOf("") }
    val bodyVal = remember { mutableStateOf("") }
    val db= FirebaseFirestore.getInstance()
    val context= LocalContext.current
    val focusRequester = remember {
        FocusRequester
    }

    if(isDialogOpen.value) {
        Dialog(onDismissRequest = { isDialogOpen.value = false }) {
            Surface(
                modifier = Modifier
                    .width(300.dp)
                    .height(450.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(5.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = "Message",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )


                    Spacer(modifier = Modifier.padding(10.dp))

                    OutlinedTextField(
                        value = authorVal.value,
                        onValueChange = { authorVal.value = it },
                        label = { Text(text = "Author") },
                        placeholder = { Text(text = "Author") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    OutlinedTextField(
                        value = bodyVal.value,
                        onValueChange = { bodyVal.value = it },
                        label = { Text(text = "Body") },
                        placeholder = { Text(text = "Body") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Spacer(modifier = Modifier.padding(15.dp))

                    Button(
                        onClick = {

                            val msg = Message(
                                author = authorVal.value,
                                body = bodyVal.value,
                                time=   Date().toString()
                                )

                            db.collection("test")
                                .add(msg)
                                .addOnSuccessListener { documentReference ->
                                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                                }
                            isDialogOpen.value = false
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Purple500)
                    ) {
                        Text(
                            text = "Add",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }

}



