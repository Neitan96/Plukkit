package br.com.nathanalmeida.plukkit.message.binder;

import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;

import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 15/01/2016 17:22
 *
 * Interface MessageBinder representa uma classe que substitui variaveis em string,
 * chamados de binds.
 */
public interface MessageBinder extends PlukConfigLoader{

    /**
     * Adiciona binds padões.
     * Binds padrões são feitos em qualquer String que passe pela classe.
     *
     * @param binds Binds padrões.
     */
    void addDefaultBinds(String... binds);

    /**
     * Faz binds dos valores padrões.
     *
     * @param msg Mensagem para fazer os binds padrões
     * @return Mensagem com os binds, caso a mensagem for nula retornara a null
     */
    String bindDefaults(String msg);

    /**
     * Faz binds dos valores padrões.
     *
     * @param msg As mensagens
     * @return As mensagens com os binds, caso a mensagem for nula retornara a null
     */
    String[] bindDefaults(String[] msg);

    /**
     * Faz binds na mensagem.
     *
     * @param msg A mensagem para fazer os binds
     * @param binds Os binds para fazer,
     *              os binds devem ser pssados primeiro a chave e em seguida o valor,
     *              exemplo:
     *              bindValues(MENSAGEM, "chave1", "valor1", "chave2", "valor2");
     * @return A mensagem com os binds, caso a mensagem seja nula retornara a null.
     */
    String bindValues(String msg, String... binds);

    /**
     * Faz binds nas mensagens.
     *
     * @param msg As mensagens para fazer os binds
     * @param binds Os binds para fazer,
     *              os binds devem ser pssados primeiro a chave e em seguida o valor,
     *              exemplo:
     *              bindValues(MENSAGEM, "chave1", "valor1", "chave2", "valor2");
     * @return As mensagens com os binds, caso a mensagem seja nula retornara a null.
     */
    String[] bindValues(String[] msg, String... binds);

    /**
     * Faz binds na mensagem.
     *
     * @param msg A mensagem para fazer os binds
     * @param binds Os binds para fazer
     * @return A mensagem com os binds, caso a mensagem seja nula retornara a null.
     */
    String bindValues(String msg, Map<String, String> binds);

    /**
     * Faz binds nas mensagens.
     *
     * @param msgs As mensagens para fazer os binds
     * @param binds Os binds para fazer
     * @return As mensagens com os binds, caso a mensagem seja nula retornara a null.
     */
    String[] bindValues(String[] msgs, Map<String, String> binds);

}
