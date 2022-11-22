package br.com.residencia.reactnative.exceptions;

public class RegistryNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistryNotFoundException (Integer id) {
		super("Registro não encontrado, id = " + id);
	}
}
