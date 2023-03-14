package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.CentroEducativo;

public class ControllerCentroEducativo {

	public static List<CentroEducativo> findAll() {
		List<CentroEducativo> centros = new ArrayList<CentroEducativo>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from curso");
			
			while (rs.next()) {
				CentroEducativo c = new CentroEducativo();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				centros.add(c);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return centros;
	}
}

