package br.com.nathanalmeida.plukkit.loaders;

import java.util.Properties;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 21/01/2016 23:14
 */
public interface PlukPropertiesLoader{

    /**
     * Carrega as configurações da classe de um Properties.
     *
     * @param properties Properties a ser carregada.
     */
    void loadFromProperties(Properties properties);

}
