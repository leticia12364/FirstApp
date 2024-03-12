    package com.leticia.firstapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leticia.firstapp.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null

        private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



//        binding.btnEnviar.setOnClickListener{
//            val email = binding.edtEmail.editableText.toString()
//            val telefone = binding.edtTelefone.editableText.toString()
//
//            if(email.contains("@") && email.contains(".com")){
//                binding.tvEmail.text = "E-mail válido"
//            }else{
//                binding.tvEmail.text = "E-mail inválido"
//            }
//
//            if(telefone.length == 11){
//                binding.tvTelefone.text = "Telefone válido"
//            }else{
//                binding.tvTelefone.text = "Telefone inválido"
//            }




    }
}