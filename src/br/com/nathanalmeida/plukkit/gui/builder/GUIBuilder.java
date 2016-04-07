package br.com.nathanalmeida.plukkit.gui.builder;

import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionProcessor;
import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.core.binder.MultiBinder;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.manager.ManagerDefault;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 07/04/2016 03:45
 */
public class GUIBuilder implements PageAdder{

    protected final JavaPlugin plugin;
    protected final MultiBinder binder = new MultiBinder();

    protected Map<String, GUIActionProcessor> processors = new HashMap<>();
    protected List<GUIPage> pages = new ArrayList<>();
    protected GUIPage pageHome = null;

    public GUIBuilder(JavaPlugin plugin){
        this.plugin = plugin;
    }


    public GUIBuilder addBinder(GUIBinder binder){
        this.binder.add(binder);
        return this;
    }

    public GUIBuilder addPage(GUIPage page){
        if(!pages.contains(page))
            pages.add(page);
        return this;
    }

    @Override
    public void addPage(GUIPage page, boolean setPageHome){
        addPage(page);
        pageHome = page;
    }

    public PageBuilder addPage(String name){
        return new PageBuilder(binder, this, name);
    }

    public GUIBuilder addActionProcessor(String command, GUIActionProcessor processor){
        processors.put(command, processor);
        return this;
    }

    public GUIManager buildGUI(){

        ManagerDefault manager = new ManagerDefault(plugin, binder);

        for(Map.Entry<String, GUIActionProcessor> processor : processors.entrySet())
            manager.addActionProcessor(processor.getKey(), processor.getValue());

        for(GUIPage page : pages)
            manager.addPage(page);

        if(pageHome != null)
            manager.addPage(pageHome, true);

        return manager;
    }

}
