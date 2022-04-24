package com.compose.evns.ui.pages

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.compose.evns.database.getGroups
import com.compose.evns.ui.elements.GroupInfo

@Composable
fun Groups(){
    val (groups, setGroups) = remember { mutableStateOf(listOf<GroupInfo>()) }
    getGroups(1, cb = fun(gs){
        System.out.println(gs.toString())
        setGroups(gs)
    })
    Text(groups.toString())
}