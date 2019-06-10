package com.appdemudancas.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import com.appdemudancas.model.Cnh;

public class DaoCnh implements IDaoCnh {

	@Override
	public void criarCnh(Cnh cnh) throws SQLException, IOException {

		Connection con = ConnectionManager.getInstance().getConnection();

		String query = "INSERT INTO cnh(" 
				+ "numero_cnh,foto_cnh) " 
				+ "VALUES(?,?);";

		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, cnh.getNumero());
		pstm.setBlob(2, imagemParaInputStream(cnh.getFoto()));

		pstm.executeUpdate();

		con.close();

	}

	@Override
	public Cnh buscarCnh(Cnh cnh) throws SQLException, IOException {
		
		Connection con = ConnectionManager.getInstance().getConnection();
		
		Cnh auxCnh = new Cnh();
		
		String query = "SELECT * FROM carro WHERE "
				+ "cnh.numero_cnh=?;";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, cnh.getNumero());
		
		
		ResultSet resultado = pstm.executeQuery();
		
		
		auxCnh.setNumero(resultado.getString("numero_cnh"));
		auxCnh.setFoto(blobParaBufferedImage(
				resultado.getBlob("foto_cnh")));
		
		con.close();
		
		return auxCnh;
	}

	@Override
	public void alterarCnh(Cnh cnh) throws SQLException, IOException {
		Connection con = ConnectionManager.getInstance().getConnection();
		
		String query = "UPDATE cnh SET numero_cnh = ?, foto_cnh = ? WHERE numero_cnh = ?;";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, cnh.getNumero());
			pstm.setBlob(2, imagemParaInputStream(cnh.getFoto()));
		} catch (SQLException ex) {
			throw new SQLException (ex);
		}
		
	}

	@Override
	public void removeCnh(Cnh cnh) throws SQLException {
		Connection con = ConnectionManager.getInstance().getConnection();
		String query = "DELETE FROM cnh WHERE numero_cnh = ?;";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, cnh.getNumero());
		pstm.executeUpdate();
		con.close();

	}

	private InputStream imagemParaInputStream(BufferedImage bufferedImage) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", baos);
		InputStream inputStream = new ByteArrayInputStream(baos.toByteArray());

		return inputStream;
	}
	
	private BufferedImage blobParaBufferedImage(java.sql.Blob blob) throws IOException, SQLException {

		InputStream inputStream = blob.getBinaryStream();  
		BufferedImage bufferedImage = ImageIO.read(inputStream);

		return bufferedImage;
	}

}
