package com.example.employeeexample.ui

import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

const val MESSAGE_BASE_PATH ="message"

class ChatFragment : Fragment()
{
 private lateinit var auth: FirebaseAuth
 private lateinit var dbRef:FirebaseDatabase


}