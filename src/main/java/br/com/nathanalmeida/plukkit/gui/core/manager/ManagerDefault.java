package br.com.nathanalmeida.plukkit.gui.core.manager;

import br.com.nathanalmeida.plukkit.gui.core.action.ActProcessorCmdConsole;
import br.com.nathanalmeida.plukkit.gui.core.action.ActProcessorCmdPlayer;
import br.com.nathanalmeida.plukkit.gui.core.action.ActProcessorToPage;
import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionProcessor;
import br.com.nathanalmeida.plukkit.gui.core.binder.BinderPlayerInfos;
import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.core.binder.MultiBinder;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.holder.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
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
public class ManagerDefault implements GUIManager, Listener{

    protected final JavaPlugin plugin;
    protected final MultiBinder binders = new MultiBinder();

    protected final Map<String, GUIActionProcessor> processors = new HashMap<>();

    protected final List<GUIPage> pages = new ArrayList<>();
    protected GUIPage pageHome = null;


    public ManagerDefault(JavaPlugin plugin){
        this.plugin = plugin;

        addActionProcessor("ToPage", new ActProcessorToPage());
        addActionProcessor("CommandPlayer", new ActProcessorCmdPlayer());
        addActionProcessor("CommandConsole", new ActProcessorCmdConsole());

        addBinder(new BinderPlayerInfos());

        Bukkit.getPluginManager().registerEvents(this, plugin);
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


    @EventHandler(priority = EventPriority.HIGH)
    private void onClickEvent(InventoryClickEvent event){
        Inventory inventory = event.getInventory();

        if(!(inventory.getHolder() instanceof GUIInventoryHolder)
                || !(event.getWhoClicked() instanceof Player))
            return;

        GUIInventoryHolder holder = (GUIInventoryHolder) inventory.getHolder();

        if(holder.getPage().getManager() != this)
            return;

        event.setCancelled(true);

        GUIButton button = holder.getButton(event.getSlot());

        if(button != null)
            button.onClick(((Player) event.getWhoClicked()), event);

    }

    @Override
    public void closeAllInventories(){
        for(Player player : Bukkit.getOnlinePlayers()){

            Inventory[] inventories = new Inventory[]{
                    player.getOpenInventory().getTopInventory(),
                    player.getOpenInventory().getBottomInventory()
            };

            for(Inventory inventory : inventories){
                InventoryHolder holder = inventory.getHolder();
                if(holder instanceof GUIInventoryHolder){
                    GUIInventoryHolder holderGUI = (GUIInventoryHolder) holder;
                    if(holderGUI.getPage().getManager() != this) continue;
                    player.closeInventory();
                }
            }

        }
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        closeAllInventories();
    }

}
