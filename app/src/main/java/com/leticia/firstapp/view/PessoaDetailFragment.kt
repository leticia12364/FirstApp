package com.leticia.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.leticia.firstapp.R
import com.leticia.firstapp.databinding.FragmentPessoaDetailBinding
import com.leticia.firstapp.viewmodel.PessoaViewModel

class PessoaDetailFragment : Fragment(){

    //Chamar a viewmodel para pegar os dados
    private val viewModel: PessoaViewModel by viewModels()

    //Criar o binding para pegar os elementos da tela
    private var _binding: FragmentPessoaDetailBinding? = null
    private val binding: FragmentPessoaDetailBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Configurar o binding
        _binding = FragmentPessoaDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    //Chamar a função onViewCreated onde vamos implementar o código
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Pegar o id da pessoa que foi enviado pela AllPessoasFragment
        //Setar a pessoa para ser carregada
        arguments?.let{
            viewModel.getPessoa(it.getInt("pessoaId"))
        }


        //Carregar as informações da pessoa selecionada
        viewModel.pessoa.observe(viewLifecycleOwner){pessoa->
            binding.tvName.text = pessoa.nome
            binding.tvIdade.text = pessoa.idade.toString() + " anos"
            binding.tvFaixa1.text = pessoa.faixaEtaria
            if (pessoa.sexo == "Masculino"){
                binding.ivMasculino.visibility = View.VISIBLE
                binding.ivFeminino.visibility = View.GONE
            }else{
                binding.ivFeminino.visibility = View.VISIBLE
                binding.ivMasculino.visibility = View.GONE
            }

        }

    }
}
