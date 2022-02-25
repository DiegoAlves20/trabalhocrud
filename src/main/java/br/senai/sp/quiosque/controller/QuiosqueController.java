package br.senai.sp.quiosque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senai.sp.quiosque.dao.ConexaoBD;
import br.senai.sp.quiosque.model.Usuario;

@Controller
public class QuiosqueController {

	@RequestMapping("cadastrousuario")
	public String form(Model model) {

		return "cadastroUsuario";
	}

	@RequestMapping(value = "enviar", method = RequestMethod.POST)
	public String enviar(Usuario usuario) {
		System.out.println(usuario.getNome());
		System.out.println(usuario.getCep());
		System.out.println(usuario.getRua());
		System.out.println(usuario.getNumero());
		System.out.println(usuario.getCidade());
		System.out.println(usuario.getEstado());
		System.out.println(usuario.getTelefone());
		System.out.println(usuario.getCelular());
		System.out.println(usuario.getDataNasc());
		System.out.println(usuario.getGenero());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getProdInteresse());

	
		ConexaoBD db = new ConexaoBD();
		if (usuario.getId() == null) {
			db.inserir(usuario);
		} else {
		db.atualizar(usuario);
		}
		
		
		return "redirect:tabelaEstatistica";

	}

	@RequestMapping("tabelaEstatistica")
	public String tabela(Model model) {
		ConexaoBD db = new ConexaoBD();
		model.addAttribute("usuarios", db.tabelas());
		return "tabelaEstatistica";
	}
	@RequestMapping("excluirUsuario")
	public String excluir(long idUsuario) {
		ConexaoBD db = new ConexaoBD();
		db.excluir(idUsuario);
		return "redirect:tabelaEstatistica";
	}
	
	@RequestMapping("alterarUsuario")
	public String alterar(long idUsuario, Model model) {
		ConexaoBD db = new ConexaoBD();
		model.addAttribute("usuario", db.buscar(idUsuario));
		return "forward:cadastrousuario";
	}

}
