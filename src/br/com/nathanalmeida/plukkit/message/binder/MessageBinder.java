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
     * Faz o bind somente de uma key e um valor.
     * Essa função não faz os binds padrões.
     *
     * @param msg Mensagem para fazer o bind.
     * @param key Chave do do bind
     * @param value Valor do bind.
     * @return Mensagem feita o bind.
     */
    String bindValue(String msg, String key, String value);

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
    default String[] bindDefaults(String[] msg){
        if(msg == null) return null;

        for (int i = 0; i < msg.length; i++){
            msg[i] = bindDefaults(msg[i]);
        }

        return msg;
    }

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
    default String bindValues(String msg, String... binds){
        if(msg == null) return null;

        for(int  i = 1; i < binds.length; i = i+2)
            msg = bindValue(msg, binds[i-1], binds[i]);

        return bindDefaults(msg);
    }

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
    default String[] bindValues(String[] msg, String... binds){
        if(msg == null) return null;

        for (int i = 0; i < msg.length; i++){
            msg[i] = bindValues(msg[i], binds);
        }

        return msg;
    }

    /**
     * Faz binds na mensagem.
     *
     * @param msg A mensagem para fazer os binds
     * @param binds Os binds para fazer
     * @return A mensagem com os binds, caso a mensagem seja nula retornara a null.
     */
    default String bindValues(String msg, Map<String, String> binds){
        if(msg == null) return null;

        for (Map.Entry<String, String> bind : binds.entrySet())
            msg = bindValue(msg, bind.getKey(), bind.getValue());

        return bindValues(msg);
    }

    /**
     * Faz binds nas mensagens.
     *
     * @param msgs As mensagens para fazer os binds
     * @param binds Os binds para fazer
     * @return As mensagens com os binds, caso a mensagem seja nula retornara a null.
     */
    default String[] bindValues(String[] msgs, Map<String, String> binds){
        for (int i = 0; i < msgs.length; i++){
            msgs[i] = bindValues(msgs[i], binds);
        }
        return msgs;
    }

}
