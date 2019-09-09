package br.com.nathanalmeida.plukkit.loaders;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 08/09/2019 22:37
 */
public interface PlukObjectLoader{

	/**
	 * Carrega as configurações da classe de um objeto,
	 * feito para classes que pode carrega a parti de varios
	 * tipos de variaveis.
	 */
	void loadFromObject(Object object);

}
