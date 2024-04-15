package com.leticia.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.leticia.firstapp.databinding.FragmentPessoaBinding
import com.leticia.firstapp.service.model.Pessoa
import com.leticia.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()
    private var _binding: FragmentPessoaBinding? = null
    private val binding: FragmentPessoaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {
            var nome = binding.edtName.editableText.toString()
            var anoNascimento = binding.edtIdade.editableText.toString()


            if (nome!= "" && anoNascimento != "") {


                val anoAtual = LocalDateTime.now().year
                var idade = anoAtual - anoNascimento.toInt()
                var faixaEtaria = ""
                var sexo = ""

                if (idade <= 12){
                    faixaEtaria = "Criança"
                } else if (idade <= 17){
                    faixaEtaria = "Adolescente"
                }else if(idade <= 64){
                    faixaEtaria = "Adulto"
                } else{
                    faixaEtaria = "Idoso"
                }

                if (binding.masculino.isChecked){
                    sexo = "Masculino"
                }else{
                    sexo = "Feminino"
                }

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade,
                    faixaEtaria = faixaEtaria,
                    sexo = sexo
                )

                viewModel.insert(pessoa)

                binding.edtName.editableText.clear()
                binding.edtIdade.editableText.clear()
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }
            //override fun onItemSelected(parent: AdapterView?,view: View?,position: Int, id: Long{
            //Toast.makeText(requireContext(), sexos[position], Toast.LENGTH_LONG).show()
        }
    }
}

