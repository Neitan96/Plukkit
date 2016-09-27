package br.com.nathanalmeida.plukkit.configurations;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 22/01/2016 15:26
 */
public class PluginConfigsManager{

    public static final String DEFAULT_CONFIG = "config.yml";
    public static final String PLUGIN_YML = "plugin.yml";

    protected final JavaPlugin plugin;

    protected final Map<String, PlukConfiguration> configsDir = new HashMap<>();
    protected final Map<String, PlukConfiguration> configsJar = new HashMap<>();


    public PluginConfigsManager(JavaPlugin plugin){
        this.plugin = plugin;
    }


    public boolean configExist(String configName){
        return new File(plugin.getDataFolder(), configName).exists();
    }

    public boolean configExist(){
        return configExist(DEFAULT_CONFIG);
    }


    public PlukConfiguration getConfig(String configName){
        if(!configsDir.containsKey(configName)){

            File configFile = new File(plugin.getDataFolder(), configName);
            PlukConfiguration config = new PlukConfiguration(configFile);

            configsDir.put(configName, config);
        }

        return configsDir.get(configName);
    }

    public PlukConfiguration getConfig(){
        return getConfig(DEFAULT_CONFIG);
    }


    public void reloadConfig(String configName){
        configsDir.remove(configName);
        getConfig(configName);
    }

    public void reloadConfig(){
        reloadConfig(DEFAULT_CONFIG);
    }


    public PlukConfiguration getConfigJar(String configName){
        if(!configsJar.containsKey(configName)){

            InputStream configStream = plugin.getResource(configName);
            if(configStream == null)
                return null;

            PlukConfiguration config = new PlukConfiguration(configStream);

            configsJar.put(configName, config);
        }

        return configsJar.get(configName);
    }

    public PlukConfiguration getConfigPlugin(){
        return getConfigJar(PLUGIN_YML);
    }


    public void clearConfigsCache(){
        configsDir.clear();
        configsJar.clear();
    }


    public boolean saveDefaultsConfigs(String... configsNames){
        boolean configSaved = false;

        for (String configName : configsNames){
            File file = new File(plugin.getDataFolder(), configName);
            if(!file.exists()){
                plugin.saveResource(configName, false);
                configSaved = true;
            }
        }

        return configSaved;
    }

    public boolean setDefaultsConfigs(boolean saveConfigs, String... configsNames){
        boolean configSaved = saveDefaultsConfigs(configsNames);

        for (String configName : configsNames){

            PlukConfiguration configDir = getConfig(configName);
            PlukConfiguration configJar = getConfigJar(configName);

            if(saveConfigs){

                String old = configDir.saveToString();

                configDir.setDefaults(configJar);

                String now = configDir.saveToString();

                if(!now.equals(old))
                    configDir.save();

            }else{
                configDir.setDefaults(configJar);
            }


        }

        return configSaved;
    }

}
