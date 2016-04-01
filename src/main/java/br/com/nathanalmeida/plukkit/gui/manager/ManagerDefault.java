package br.com.nathanalmeida.plukkit.gui.manager;

import br.com.nathanalmeida.plukkit.gui.action.GUIActionProcessor;
import br.com.nathanalmeida.plukkit.gui.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.binder.MultiBinder;
import br.com.nathanalmeida.plukkit.gui.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 11:22
 */
public class ManagerDefault implements GUIManager{

    protected final JavaPlugin plugin;
    protected final MultiBinder binders = new MultiBinder();

    protected final Map<String, GUIActionProcessor> processors = new HashMap<>();

    protected final List<GUIPage> pages = new ArrayList<>();
    protected GUIPage pageHome = null;


    public ManagerDefault(JavaPlugin plugin){
        this.plugin = plugin;
    }


    @Override
    public JavaPlugin getPlugin(){
        return plugin;
    }

    @Override
    public void addBinder(GUIBinder binder){
        binders.add(binder);
    }

    @Override
    public GUIBinder getBinder(){
        return binders;
    }

    @Override
    public void setHome(String name){
        GUIPage page = getPage(name);
        if(page != null) pageHome = page;
    }

    @Override
    public void addPage(GUIPage page, boolean setPageHome){
        addPage(page);
        pageHome = page;
    }

    @Override
    public void addPage(GUIPage page){
        if(!pages.contains(page))
            pages.add(page);
    }

    @Override
    public void removePage(String name){
        GUIPage page = getPage(name);
        if(page != null) pages.remove(page);
    }

    @Override
    public GUIPage getPage(String name){
        for(GUIPage page : pages){
            if(page.getName().equalsIgnoreCase(name))
                return page;
        }
        return null;
    }

    @Override
    public void openToPlayer(Player player){
        GUIPage page = pageHome != null ? pageHome : pages.get(0);
        if(page != null)
            page.openToPlayer(player);
    }

    @Override
    public void addActionProcessor(String command, GUIActionProcessor processor){
        processors.put(command, processor);
    }

    @Override
    public void removeActionProcessor(String command, GUIActionProcessor processor){
        GUIActionProcessor processorRemoved = processors.remove(command);
        if(processorRemoved != processor)
            processors.put(command, processorRemoved);
    }

    @Override
    public void processAction(Player player, String command, String[] arguments, InventoryClickEvent event){
        GUIActionProcessor processor = processors.get(command);
        if(processor != null)
            processor.process(player, arguments, this);
    }

}
