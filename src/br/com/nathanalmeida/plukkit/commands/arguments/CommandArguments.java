package br.com.nathanalmeida.plukkit.commands.arguments;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Pattern;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 05/04/2016 01:26
 */
public class CommandArguments{

    protected String[] args;

    public CommandArguments(String... args){
        this.args = args;
    }

    public int length(){
        return args.length;
    }

    public String[] args(){
        return args.clone();
    }

    /**
     * Obtem um OfflinePlayer de acordo com a index do argumento passado.
     * Irá obter o argumento de acordo com a index passada e depois pegar
     * o OfflinePlayer pelo nome passado no argumento.
     *
     * @param index Index do argumento
     * @return OfflinePlayer
     */
    public OfflinePlayer getOfflinePlayer(int index){
        //noinspection deprecation
        return args.length > index
                ? Bukkit.getOfflinePlayer(args[index]) : null;
    }

    /**
     * Obtem um Player de acordo com a index do argumento passado.
     * Irá obter o argumento de acordo com a index passada e depois pegar
     * o Player pelo nome passado no argumento.
     *
     * @param index Index do argumento
     * @return OfflinePlayer
     */
    public Player getPlayer(int index){
        //noinspection deprecation
        return args.length > index
                ? Bukkit.getPlayer(args[index]) : null;
    }

    /**
     * Transforma o argumento em um Integer.
     * Caso o argumento não for um Integer ele retornara a null.
     *
     * @param index Index do argumento a ser transformado
     * @return Integer transformado
     */
    public Integer getInt(int index){
        if(args.length > index)
            try{
                return Integer.parseInt(args[index]);
            }catch (Exception e){
                return null;
            }

        return null;
    }

    /**
     * Transforma o argumento em um Double.
     * Caso o argumento não for um Double ele retornara a null.
     *
     * @param index Index do argumento a ser transformado
     * @return Double transformado
     */
    public Double getDouble(int index){
        if(args.length > index)
            try{
                return Double.parseDouble(args[index]);
            }catch (Exception e){
                return null;
            }

        return null;
    }

    /**
     * Obtem um boolean de um argumento.
     * Caso o argumento for "yes", "y", "ok", "all", "sim", "true" ou "1"
     * retornara a true se não for retornara a false.
     *
     * @param index Index do argumento
     * @return Boolean
     */
    public boolean getBoolean(int index){
        String arg = args[index];
        return args.length > index && (
                arg.equalsIgnoreCase("yes")
                        || arg.equalsIgnoreCase("y")
                        || arg.equalsIgnoreCase("ok")
                        || arg.equalsIgnoreCase("all")
                        || arg.equalsIgnoreCase("sim")
                        || arg.equalsIgnoreCase("true")
                        || arg.equalsIgnoreCase("1"));
    }

    /**
     * Transforma um argumento em data em formato YYYY-MM-DD.
     * Se a data estiver no formato DD/MM/YYYY ele traformara em YYYY-MM-DD
     * caso não uma data ele retornara a null.
     *
     * @param index Index do argumento
     * @return Data no formato YYYY-DD-MM
     */
    public String getDate(int index){
        String arg = args[index];
        if(arg != null
                && (arg.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{2,4}$")
                || arg.matches("^[0-9]{2,4}-[0-9]{1,2}-[0-9]{1,2}$")))
            return arg.replaceAll("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{2,4}$", "$3-$2-$1");

        return null;
    }

    /**
     * Pega um plugin de acordo com a index do argumento passado.
     * Ele irá pega um plugin pelo nome passado no argumento.
     *
     * @param index Index do argumento
     * @return Plugin
     */
    public JavaPlugin getPlugin(int index){
        return args.length > index
                ? (JavaPlugin) Bukkit.getPluginManager().getPlugin(args[index]) : null;
    }

    /**
     * Obtem uma mensagem.
     * Irá juntar todos os argumentos separados por espaço
     * a começando pelo argumento passado.
     *
     * Exemplo:
     * Se o argumento passado for 2 ele irá juntar os argumento 2, 3, 4, 5....
     *
     * @param indexStart Inicio da mensagem
     * @return Mensagem inteira
     */
    public String getMessage(int indexStart){
        StringBuilder builder = new StringBuilder();
        for (int i = indexStart; i < args.length; i++) {
            if(i != indexStart)
                builder.append(" ");
            builder.append(args[i]);
        }
        return builder.toString();
    }

    /**
     * Obtem um mundo de acordo com a index do argumento passado.
     * Ele irá pegar um mundo pelo nome passado no argumento.
     *
     * @param index Index do argumento
     * @return Mundo
     */
    public World getWorld(int index){
        return args.length > index
                ? Bukkit.getWorld(args[index]) : null;
    }

    /**
     * Obtem um lista de acordo com a index do argumento passado.
     * Ele irá obter o argumento passado e fazer um split no argumento,
     * caso o argumento não for passado irá retorna a uma array vazia.
     *
     * @param index Index do argumento
     * @param glue String para quebrar em lista o argumento
     * @return Lista
     */
    public String[] getList(int index, String glue){
        return args.length > index
                ? args[index].split(Pattern.quote(glue)) : new String[0];
    }

}
