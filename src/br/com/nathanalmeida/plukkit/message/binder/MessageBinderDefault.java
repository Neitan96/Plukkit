package br.com.nathanalmeida.plukkit.message.binder;

import com.google.common.base.Joiner;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 21/01/2016 22:50
 */
public class MessageBinderDefault implements MessageBinder{

    public static final MessageBinder BINDER_DEFAULT = new MessageBinderDefault();

    public static final String BINDS_PREFIX = "{";
    public static final String BINDS_SUFIX = "}";

    public List<String> bindsDefault = null;


    public String bindValue(String str, String key, String value){
        return str != null && key != null && value != null ?
                str.replace(BINDS_PREFIX +key+ BINDS_SUFIX, value) : str;
    }


    @Override
    public void addDefaultBinds(String... binds){
        if(bindsDefault == null)
            bindsDefault = new ArrayList<>();

        Collections.addAll(bindsDefault, binds);
    }

    @Override
    public String bindDefaults(String msg){
        if(msg == null || bindsDefault == null) return msg;

        for(int i = 1; i < bindsDefault.size(); i = i+2)
            msg = bindValue(msg, bindsDefault.get(i-1), bindsDefault.get(i));

        return msg;
    }

    @Override
    public void loadFromConfig(ConfigurationSection section){
        List<String> binds = new ArrayList<>();

        for (String key : section.getKeys(true)){
            if(section.isList(key)){
                binds.add(key);
                binds.add(Joiner.on(", ").join(section.getStringList(key)));
            }else if(!section.isConfigurationSection(key)){
                binds.add(key);
                binds.add(section.getString(key));
            }
        }

        bindsDefault.addAll(binds);
    }

}
