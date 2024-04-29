package com.leticia.firstapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leticia.firstapp.R
import com.leticia.firstapp.databinding.ListItemPessoaBinding
import com.leticia.firstapp.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa) -> Unit):
    RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>(){

        //Criar uma lista vazia de pessoas
        private var pessoaList: List<Pessoa> = arrayListOf()

    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
            RecyclerView.ViewHolder(binding.root){

                //Carrrega as informações da pessoa na lista
                fun bind(pessoa: Pessoa, clickListListener: (Pessoa) -> Unit) {
                    binding.tvNome.text = pessoa.nome
                    binding.tvIdade.text = pessoa.idade.toString() + " anos"
                    binding.tvFaixa.text = pessoa.faixaEtaria

                    //Método 1 para esconder ou mostrar uma imagem

                    if(pessoa.sexo == "Masculino"){
                        binding.imgMasculino.visibility = View.VISIBLE
                        binding.imgFeminino.visibility = View.GONE
                    } else{
                        binding.imgMasculino.visibility = View.GONE
                        binding.imgFeminino.visibility = View.VISIBLE
                    }

                    //Método 2 para mostrar uma imagem desejada
//                    if(pessoa.sexo == "Masculino") {
//                        binding.imgMasculino.setImageResource(R.drawable.masculino_1_removebg_preview)
//
//                    }else{
//                        binding.imgMasculino.setImageResource(R.drawable.feminino_1_removebg_preview)
//                    }

                    //Configura o click de algum item lista
                    binding.root.setOnClickListener {
                        clickListListener(pessoa)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        //Configurar binding lista
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }

    //Carrega a lista de pessoas para serem exibidas
    fun updatePessoas(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}