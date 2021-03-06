package edu.aula12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LocadoraBicicletaControl {
	private static String url = 
			"jdbc:mariadb://localhost:3306/bicicleta?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";
	public List<LocadoraBicicleta> locacoes = new ArrayList<>();
	
	public LocadoraBicicletaControl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionar(LocadoraBicicleta l) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			String sql = "INSERT INTO locacao "
					+ " (nome_cliente, modelo, data, preco) "
					+ " VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, l.getNomeCliente());
			stmt.setString(2, l.getModeloBike());
			long timestamp = l.getDataLocacao().getTime();  //java.util.Date
			java.sql.Date sqld = new java.sql.Date( timestamp );
			stmt.setDate(3, sqld); // java.sql.Date
			stmt.setFloat(4,  l.getPreco());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		//locacoes.add(l);
	}
	
	public LocadoraBicicleta pesquisarPorNome(String nomeCliente) {
		LocadoraBicicleta l = new LocadoraBicicleta();
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM locacao "
					+ " WHERE nome_cliente LIKE ?";			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nomeCliente + "%");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				l.setNomeCliente(rs.getString("nome_cliente"));
				l.setModeloBike(rs.getString("modelo"));
				l.setPreco(rs.getFloat("preco"));
				l.setDataLocacao(rs.getDate("data"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

}
