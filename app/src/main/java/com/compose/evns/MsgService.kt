package com.compose.evns

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.compose.evns.ui.elements.Message
import com.google.firebase.firestore.FirebaseFirestore

object MsgService {
    private val db=FirebaseFirestore.getInstance()
    fun getMsgs(messages: SnapshotStateList<Message>){
        db.collection("test").get().addOnSuccessListener {
            messages.updateList(it.toObjects(Message::class.java))
        }.addOnFailureListener{
            messages.updateList(listOf())
        }
    }
}