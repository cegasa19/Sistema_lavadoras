package p3_interfaces;

import java.util.ArrayList;

import p2_entidad.Lavadora;

public interface LavadoraDAO {
	
	/*actualiza parametros*/
	public int update(Lavadora bean);

	/* Busca en base a un codigo */
	public Lavadora findById(int cod);

	/* metodo usado para listar */
	public ArrayList<Lavadora> listAll();
}
