package br.senai.sp.quiosque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import br.senai.sp.quiosque.model.Usuario;

public class ConexaoBD {
	
	private Connection conexao;
	public ConexaoBD() {
		conexao = ConnectionFactory.conectar();
	}

	public void inserir(Usuario usuario) {
		String sql = "Insert into cadastrousuarios"+"(nome, cep, rua, numero, cidade, estado, telefone, celular, dataNasc, genero, email, pdtinteresse)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement startando;
		try {
			startando = conexao.prepareStatement(sql);
			startando.setString(1, usuario.getNome());
			startando.setInt(2, usuario.getCep());
			startando.setString(3, usuario.getRua());
			startando.setInt(4, usuario.getNumero());
			startando.setString(5, usuario.getCidade());
			startando.setString(6, usuario.getEstado());
			startando.setInt(7, usuario.getTelefone());
			startando.setInt(8, usuario.getCelular());
			startando.setDate(9,new Date(usuario.getDataNasc().getTimeInMillis()));
			startando.setString(10, usuario.getGenero());
			startando.setString(11, usuario.getEmail());
			startando.setString(12, usuario.getProdInteresse());
			
			startando.execute();
			startando.close();
			conexao.close(); 
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Usuario> tabelas(){
		String sql = "select * from cadastrousuarios order by nome asc";
		PreparedStatement startamento;
		List<Usuario> tabela = new ArrayList<Usuario>();
		try {
			startamento = conexao.prepareStatement(sql);
			ResultSet rs = startamento.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getLong("id"));
				u.setNome(rs.getString("nome"));
				u.setCep(rs.getInt("cep"));
				u.setRua(rs.getString("rua"));
				u.setNumero(rs.getInt("numero"));
				u.setCidade(rs.getString("cidade"));
				u.setEstado(rs.getString("estado"));
				u.setTelefone(rs.getInt("telefone"));
				u.setCelular(rs.getInt("celular")); 
				u.setGenero(rs.getString("genero"));
				u.setEmail(rs.getString("email"));
				u.setProdInteresse(rs.getString("pdtinteresse"));
				Calendar nascimento = Calendar.getInstance();
				Date nascBd = rs.getDate("dataNasc");
				nascimento.setTimeInMillis(nascBd.getTime());
				u.setDataNasc(nascimento);
				tabela.add(u);
			}
			rs.close();
			startamento.close();
			conexao.close();
			return tabela;
				} catch (Exception e) {
					throw new RuntimeException(e);
			}
	    }
	
	public void excluir(long idUsuario) {
		String sql ="delete from cadastrousuarios where id = ?";
		PreparedStatement startamento;
		try {
			startamento = conexao.prepareStatement(sql);
			startamento.setLong(1, idUsuario);
			startamento.execute();
			startamento.close();
			conexao.close();
			
				} catch (Exception e) {
						throw new RuntimeException(e);
			}
		}
	
	public void atualizar(Usuario usuario) {
		String sql = "update cadastrousuarios set nome = ?, cep = ?, rua = ?, numero = ?, cidade = ?, estado = ?, telefone = ?, celular = ?, dataNasc = ?, genero = ?, email = ?, pdtinteresse = ?  where id = ?";
		PreparedStatement startando;
		try {
			
			startando = conexao.prepareStatement(sql);
			startando.setString(1, usuario.getNome());
			startando.setInt(2, usuario.getCep());
			startando.setString(3, usuario.getRua());
			startando.setInt(4, usuario.getNumero());
			startando.setString(5, usuario.getCidade());
			startando.setString(6, usuario.getEstado());
			startando.setInt(7, usuario.getTelefone());
			startando.setInt(8, usuario.getCelular());
			startando.setDate(9,new Date(usuario.getDataNasc().getTimeInMillis()));
			startando.setString(10, usuario.getGenero());
			startando.setString(11, usuario.getEmail());
			startando.setString(12, usuario.getProdInteresse());
			startando.execute();
			startando.close();
			conexao.close(); 
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscar(long idusuario) {
	String sql = "select * from cadastrousuarios where id = ?";
	PreparedStatement startamento;
	Usuario u = null;
	
	try {
		startamento = conexao.prepareStatement(sql);
		startamento.setLong(1, idusuario);
		ResultSet rs = startamento.executeQuery();
		while (rs.next()) {
			u = new Usuario();
			u.setId(rs.getLong("id"));
			u.setNome(rs.getString("nome"));
			u.setCep(rs.getInt("cep"));
			u.setRua(rs.getString("rua"));
			u.setNumero(rs.getInt("numero"));
			u.setCidade(rs.getString("cidade"));
			u.setEstado(rs.getString("estado"));
			u.setTelefone(rs.getInt("telefone"));
			u.setCelular(rs.getInt("celular")); 
			u.setGenero(rs.getString("genero"));
			u.setEmail(rs.getString("email"));
			u.setProdInteresse(rs.getString("pdtinteresse"));
			Calendar nascimento = Calendar.getInstance();
			Date nascBd = rs.getDate("dataNasc");
			nascimento.setTimeInMillis(nascBd.getTime());
			u.setDataNasc(nascimento);
			
		}
		rs.close();
		startamento.close();
		conexao.close();
		return u;
			} catch (Exception e) {
				throw new RuntimeException(e);
		}
	
}

}




