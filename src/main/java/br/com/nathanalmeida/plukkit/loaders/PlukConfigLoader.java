package br.com.nathanalmeida.plukkit.loaders;

import org.bukkit.configuration.ConfigurationSection;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 27/12/2015 03:17
 */
public interface PlukConfigLoader{

    /**
     * Carrega as configurações da classe de uma config.
     *
     * @param section Config a ser carregada.
     */
    void loadFromConfig(ConfigurationSection section);

}
