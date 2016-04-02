package br.com.nathanalmeida.plukkit.message.manager;

import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;
import br.com.nathanalmeida.plukkit.message.message.PlukMessage;

import java.util.Set;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 11/02/2016 17:13
 */
public interface MessageManager extends PlukConfigLoader{

    /**
     * Procura uma mensagem pela chave dela.
     *
     * @param messageKey Chave da mensagem
     * @return Mensagem encontrada
     */
    PlukMessage find(String messageKey);

    /**
     * Cria uma mensagem e armazena.
     *
     * @param key Chave em que a mensagem vai ser salva
     * @param message Mensagem para criar
     * @return Mensagem que foi criada
     */
    PlukMessage create(String key, String... message);

    /**
     * Cria uma mensagem.
     *
     * @param message Mensagem a ser criada
     * @return Mensagem criada
     */
    PlukMessage create(String... message);

    /**
     * Obtem todas as chaves de todas as mensagens.
     *
     * @return Chaves das mensagens armazenadas
     */
    Set<String> getKeys();

    /**
     * Verifica se existe a chave.
     *
     * @param key Chave para verificação
     * @return Se a chave existe
     */
    boolean hasKey(String key);

}
