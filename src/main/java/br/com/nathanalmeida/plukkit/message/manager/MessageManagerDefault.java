package br.com.nathanalmeida.plukkit.message.manager;

import br.com.nathanalmeida.plukkit.message.binder.MessageBinder;
import br.com.nathanalmeida.plukkit.message.binder.MessageBinderDefault;
import br.com.nathanalmeida.plukkit.message.message.PlukMessage;
import br.com.nathanalmeida.plukkit.message.message.PlukMessageDefault;
import br.com.nathanalmeida.plukkit.message.tag.TagManager;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 11/02/2016 17:33
 */
public class MessageManagerDefault implements MessageManager{

    public static final String DEFAULT_PATH_BINDS = "BindsValues";

    protected final MessageBinder binder = new MessageBinderDefault();
    protected final TagManager tags;

    protected final Map<String, PlukMessage> messages = new HashMap<>();


    public MessageManagerDefault(TagManager tags){
        this.tags = tags;
    }


    @Override
    public PlukMessage find(String messageKey){
        return messages.get(messageKey);
    }

    @Override
    public PlukMessage create(String key, String... message){
        PlukMessage plukMessage = new PlukMessageDefault(message, binder, tags);
        if(key != null) messages.put(key, plukMessage);
        return plukMessage;
    }

    @Override
    public PlukMessage create(String... message){
        return create(null, message);
    }

    @Override
    public Set<String> getKeys(){
        return messages.keySet();
    }

    @Override
    public boolean hasKey(String key){
        return messages.containsKey(key);
    }


    @Override
    public void loadFromConfig(ConfigurationSection section){
        for(String key : section.getKeys(true)){

            if(section.isConfigurationSection(key)) continue;

            if(key.startsWith(DEFAULT_PATH_BINDS+".")){
                String value = section.get(key).toString();
                key = key.substring(DEFAULT_PATH_BINDS.length()+1, key.length());
                binder.addDefaultBinds(key, value);
            }else{
                String[] value;

                if(section.isList(key)){
                    List<String> list = section.getStringList(key);
                    value = list.toArray(new String[list.size()]);
                }else{
                    value = new String[]{section.get(key).toString()};
                }

                PlukMessage message = new PlukMessageDefault(value, binder, tags);

                messages.put(key, message);
            }

        }
    }

}
