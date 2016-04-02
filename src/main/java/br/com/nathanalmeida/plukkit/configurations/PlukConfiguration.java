package br.com.nathanalmeida.plukkit.configurations;

import org.bukkit.configuration.InvalidConfigurationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 09/Jan/2016 23:03
 * Created by Neitan96 on 09/01/16.
 */
public class PlukConfiguration extends YamlConfigurationUT8{

    /**
     * Arquivo da config
     */
    private File file = null;

    public PlukConfiguration() {}

    /**
     * Inicia a config e ler a parti de um InputStream
     *
     * @param stream InputStream para ser lido
     */
    public PlukConfiguration(InputStream stream) {
        try{
            load(stream);
        }catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
    }

    /**
     * Inicia a cofig e ler a parti de um arquivo
     * O arquivo é armazenado para salvamento futuro
     *
     * @param file Arquivo a ser lido
     */
    public PlukConfiguration(File file) {
        setFile(file);
        reload();
    }

    /**
     * @return Arquivo armazenado
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file Define um arquivo padrão para salvar a config
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Recarrega a config a parti do arquivo padrão
     */
    public void reload() {
        try{
            if(file.exists())
                load(new FileInputStream(file));
        }catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
    }

    /**
     * Salva a config no arquivo padrão
     */
    public void save() {
        try{
            if(file != null) save(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
