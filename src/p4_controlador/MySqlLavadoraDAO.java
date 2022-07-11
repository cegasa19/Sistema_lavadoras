package p4_controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import p1_utils.MySqlConexion;
import p2_entidad.Lavadora;
import p3_interfaces.LavadoraDAO;

public class MySqlLavadoraDAO implements LavadoraDAO {

	@Override
	public int update(Lavadora bean) {
		int salida = -1;

		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "update tb_lavadora set precio=?,fondo=?,ancho=?,alto=?,capacidad=? where cod_lav=?";
			pstm = cn.prepareStatement(sql);
			pstm.setDouble(1, bean.getPrecio());
			pstm.setDouble(2, bean.getFondo());
			pstm.setDouble(3, bean.getAncho());
			pstm.setDouble(4, bean.getAlto());
			pstm.setDouble(5, bean.getCapacidad());
			pstm.setInt(6, bean.getCodigo());
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return salida;
	}

	@Override
	public Lavadora findById(int cod) {
		Lavadora lav = null;

		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select modelo,precio,fondo,ancho,alto,capacidad from tb_lavadora where cod_lav=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if(rs.next()) {
				lav = new Lavadora();
				lav.setCodigo(rs.getInt(1));
				lav.setModelo(rs.getString(2));
				lav.setPrecio(rs.getDouble(3));
				lav.setFondo(rs.getDouble(4));
				lav.setAncho(rs.getDouble(5));
				lav.setCapacidad(rs.getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return lav;
	}

	@Override
	public ArrayList<Lavadora> listAll() {
		ArrayList<Lavadora> lista = new ArrayList<Lavadora>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select*from tb_lavadora";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Lavadora lav = new Lavadora();
				lav.setCodigo(rs.getInt(1));
				lav.setModelo(rs.getString(2));
				lav.setPrecio(rs.getDouble(3));
				lav.setFondo(rs.getDouble(4));
				lav.setAncho(rs.getDouble(5));
				lav.setCapacidad(rs.getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
}
