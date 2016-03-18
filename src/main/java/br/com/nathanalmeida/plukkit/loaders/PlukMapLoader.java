package br.com.nathanalmeida.plukkit.loaders;

import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 21/01/2016 23:20
 */
public interface PlukMapLoader{

    /**
     * Carrega as configurações da classe de um Map.
     *
     * @param map Map a ser carregado.
     */
    void loadFromProperties(Map<String, String> map);

}
