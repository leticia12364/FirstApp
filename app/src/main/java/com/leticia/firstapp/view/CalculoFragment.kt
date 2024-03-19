package com.leticia.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leticia.firstapp.R
import com.leticia.firstapp.databinding.FragmentCalculoBinding
import java.time.LocalDateTime

class CalculoFragment : Fragment() {
    private var _binding: FragmentCalculoBinding? = null
    private val binding: FragmentCalculoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {
            var nome = binding.edtName.editableText.toString()
            binding.tvName.text = "Nome: " + nome

            var anoNascimento = binding.edtIdade.editableText.toString()
            val anoAtual = LocalDateTime.now().year
            var idade = anoAtual - anoNascimento.toInt()
            binding.tvIdade.text = "Idade: ${idade}"
        }
    }
}