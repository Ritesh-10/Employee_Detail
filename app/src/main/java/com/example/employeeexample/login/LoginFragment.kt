package com.example.employeeexample.login

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.employeeexample.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_register.login
import kotlinx.android.synthetic.main.fragment_register.progress
import kotlinx.android.synthetic.main.fragment_register.register
import kotlinx.android.synthetic.main.fragment_register.user_email
import kotlinx.android.synthetic.main.fragment_register.user_email_container
import kotlinx.android.synthetic.main.fragment_register.user_pass
import kotlinx.android.synthetic.main.fragment_register.user_pass_container

class LoginFragment : Fragment() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth= FirebaseAuth.getInstance()

        if(auth.currentUser!=null)
        {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToEmployeeListFragment()
                )

            }
        }
    override fun onCreateView(
        inflater: LayoutInflater, container:ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
     return inflater.inflate(R.layout.fragment_login,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        register.setOnClickListener{
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            )
        }
        login.setOnClickListener{
            user_email_container.error=null
            user_pass_container.error=null

            val email=user_email.text.toString()
            val pass=user_pass.text.toString()

            if(validateInput(email,pass))
            {
                progress.visibility=View.VISIBLE

                auth.signInWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(requireActivity()){
                        task->
                        progress.visibility=View.INVISIBLE
                        if(task.isSuccessful)
                        {
                            findNavController().navigate(
                                LoginFragmentDirections.actionLoginFragmentToEmployeeListFragment()
                            )
                        }
                        else
                        {
                            val toast= Toast.makeText(
                                requireActivity(),
                                "Authentication failed: {task.exception?.message}",Toast.LENGTH_LONG)
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,0)
                            toast.show()
                            }
                        }
                    }
            }
        }

    private fun validateInput(email: String, pass: String): Boolean {
        var valid = true
        if(email.isBlank())
        {
            user_email_container.error="Please enter an email address"
            valid=false
        }
        if(pass.isBlank())
        {
            user_pass_container.error="Please enter password"
            valid =false
        }
        else if(pass.length<8)
        {
            user_pass_container.error="Password should be 8 character or more"
            valid = false
        }
        return valid
    }

}
