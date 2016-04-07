package br.com.nathanalmeida.plukkit.gui.core.manager;

import br.com.nathanalmeida.plukkit.gui.core.action.ActProcessorCmdConsole;
import br.com.nathanalmeida.plukkit.gui.core.action.ActProcessorCmdPlayer;
import br.com.nathanalmeida.plukkit.gui.core.action.ActProcessorToPage;
import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionProcessor;
import br.com.nathanalmeida.plukkit.gui.core.binder.BinderPlayerInfos;
import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.core.binder.MultiBinder;
import br.com.nathanalmeida.plukkit.gui.core.holder.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.gui.core.holder.InventoryButtonClick;
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

import java.util.*;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 11:22
 */
public class ManagerDefault implements GUIManager, Listener{

    protected final JavaPlugin plugin;
    protected final MultiBinder binders;

    protected final Map<String, GUIActionProcessor> processors = new HashMap<>();

    protected final List<GUIPage> pages = new ArrayList<>();
    protected GUIPage pageHome = null;


    public ManagerDefault(JavaPlugin plugin, MultiBinder binders){
        this.plugin = plugin;
        this.binders = binders;

        addActionProcessor("ToPage", new ActProcessorToPage());
        addActionProcessor("CommandPlayer", new ActProcessorCmdPlayer());
        addActionProcessor("CommandConsole", new ActProcessorCmdConsole());

        addBinder(new BinderPlayerInfos());

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public ManagerDefault(JavaPlugin plugin){
        this(plugin, new MultiBinder());
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
        GUIPage page = null;

        if(pageHome != null){
            page = pageHome;

        }else if(pages.size() > 0){
            page = pages.get(0);
        }

        if(page != null) page.openToPlayer(player, this);
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
            processor.process(this, player, arguments);
    }


    @EventHandler(priority = EventPriority.HIGH)
    private void onClickEvent(InventoryClickEvent event){
        Inventory inventory = event.getInventory();

        if(!(inventory.getHolder() instanceof GUIInventoryHolder)
                || !(event.getWhoClicked() instanceof Player))
            return;

        GUIInventoryHolder holder = (GUIInventoryHolder) inventory.getHolder();

        if(holder.getManager() != this)
            return;

        event.setCancelled(true);

        InventoryButtonClick click = new InventoryButtonClick(holder, event);

        if(click.getButtonClicked() != null)
            click.getButtonClicked().onClick(click);

    }

    @Override
    public void closeAllInventories(){
        Object onlinePlayers = Bukkit.getOnlinePlayers();
        Player[] players;
        //noinspection ConstantConditions
        if(onlinePlayers instanceof Collection){
            //noinspection unchecked
            Collection<Player> playersCollection = (Collection<Player>) onlinePlayers;
            players = playersCollection.toArray(new Player[playersCollection.size()]);
        }else{
            players = ((Player[]) onlinePlayers);
        }

        for(Player player : players){

            Inventory[] inventories = new Inventory[]{
                    player.getOpenInventory().getTopInventory(),
                    player.getOpenInventory().getBottomInventory()
            };

            for(Inventory inventory : inventories){
                InventoryHolder holder = inventory.getHolder();
                if(holder instanceof GUIInventoryHolder){
                    GUIInventoryHolder holderGUI = (GUIInventoryHolder) holder;
                    if(holderGUI.getManager() != this) continue;
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
