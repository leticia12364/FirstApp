    package com.leticia.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.IResultReceiver._Parcel
import com.leticia.firstapp.databinding.ActivityMainBinding
import com.leticia.firstapp.databinding.TelaLinearBinding
import java.time.LocalDateTime

    class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null

        private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        binding.btnEnviar.setOnClickListener {
//            var nome = binding.edtName.editableText.toString()
//            binding.tvName.text = "Nome: " + nome
//
//            var anoNascimento = binding.edtIdade.editableText.toString()
//            val anoAtual = LocalDateTime.now().year
//            var idade = anoAtual - anoNascimento.toInt()
//
//            binding.tvIdade.text = "Idade: ${idade}"
//        }

        binding.btnEnviar.setOnClickListener{
            val email = binding.edtEmail.editableText.toString()
            val telefone = binding.edtTelefone.editableText.toString()

            if(email.contains("@") && email.contains(".com")){
                binding.tvEmail.text = "E-mail válido"
            }else{
                binding.tvEmail.text = "E-mail inválido"
            }

            if(telefone.length == 11){
                binding.tvTelefone.text = "Telefone válido"
            }else{
                binding.tvTelefone.text = "Telefone inválido"
            }



        }
    }
}