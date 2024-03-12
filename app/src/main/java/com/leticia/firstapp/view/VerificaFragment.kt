package com.leticia.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leticia.firstapp.R
import com.leticia.firstapp.databinding.FragmentCalculoBinding
import com.leticia.firstapp.databinding.FragmentVerificaBinding


class VerificaFragment : Fragment() {
    private var _binding: FragmentVerificaBinding? = null
    private val binding: FragmentVerificaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVerificaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {
            val email = binding.edtEmail.editableText.toString()
            val telefone = binding.edtTelefone.editableText.toString()

            if (email.contains("@") && email.contains(".com")) {
                binding.tvEmail.text = "E-mail válido"
            } else {
                binding.tvEmail.text = "E-mail inválido"
            }

            if (telefone.length == 11) {
                binding.tvTelefone.text = "Telefone válido"
            } else {
                binding.tvTelefone.text = "Telefone inválido"
            }

        }
    }
}
