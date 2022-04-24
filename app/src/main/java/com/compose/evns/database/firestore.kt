package com.compose.evns.database

import android.content.ContentValues.TAG
import android.util.Log
import com.compose.evns.ui.elements.GroupInfo
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

val db = Firebase.firestore


fun getGroupInfo(groupId:String,cb:(g:GroupInfo)->Unit){
    db.collection("groups")
        .whereEqualTo("id",groupId)
        .get()
        .addOnSuccessListener { group->
            if(!group.isEmpty){
                val name = group.documents[0]["name"].toString()
                val desc = group.documents[0]["description"].toString()
                val g = GroupInfo(name,desc)
                cb(g)
            }
        }
        .addOnFailureListener { exception ->
            Log.w("groupInfo", "Error getting documents.", exception)
        }
}
public fun getGroups(uid:Number, cb: (List<GroupInfo>) -> Unit) {
    val groups: MutableList<GroupInfo> = mutableListOf<GroupInfo>()

    db.collection("users")
        .whereEqualTo("id", uid)
        .get()
        .addOnSuccessListener { user ->
            if(!user.isEmpty){
                val subscriptions:List<String> = user.documents[0]["subscriptions"] as List<String>
                subscriptions.map {  }
                for( sub in subscriptions){
                    getGroupInfo(sub,cb = fun (g:GroupInfo){
                        System.out.println("adding..."+ g.name)
                        groups.add(g)
                        System.out.println("added: "+groups.toString())
                    })
                }
                System.out.println("for loop done: "+groups.toString())
                cb(groups)
            }
        }
        .addOnFailureListener { exception ->
            Log.w("user", "Error getting documents.", exception)
        }
}