package br.com.nathanalmeida.plukkit.gui.core.button;

import br.com.nathanalmeida.plukkit.gui.core.page.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/09/2019 19:22
 */
public class GUISimpleDisplay implements GUIButtonDisplay, PlukConfigLoader{

	public Material material;
	public String title;
	public byte data = 0;
	public int amount = 1;
	public String[] lore;
	public Map<Enchantment, Integer> enchantments;

	public GUISimpleDisplay(Material material, String title, byte data, int amount, String[] lore, Map<Enchantment, Integer> enchantments){
		this.material = material == null ? Material.STONE : material;
		this.title = title;
		this.data = data < 0 ? 0 : data;
		this.amount = Math.max(amount, 1);
		this.lore = lore;
		this.enchantments = enchantments;
	}

	public GUISimpleDisplay(Material material, String title, String... lore){
		this(material, title, (byte) 0, 1, lore, null);
	}

	public GUISimpleDisplay(Material material, String title){
		this(material, title, (String[]) null);
	}

	public GUISimpleDisplay(Material material){
		this(material, null);
	}

	@Override
	public ItemStack makeButtonDisplay(Player player, GUIInventoryHolder holder){
		ItemStack itemStack = new ItemStack(material, amount);
		MaterialData materialData = itemStack.getData();
		ItemMeta itemMeta = itemStack.getItemMeta();

		materialData.setData(data);
		if(title != null)
			itemMeta.setDisplayName(holder.getManager().bindValues(title, holder));
		if(lore != null)
			itemMeta.setLore(Arrays.asList(holder.getManager().bindValues(lore, holder)));
		if(enchantments != null)
			for(Map.Entry<Enchantment, Integer> enchantment : enchantments.entrySet()){
				itemMeta.addEnchant(enchantment.getKey(), enchantment.getValue(), true);
			}

		itemStack.setData(materialData);
		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	@Override
	public void loadFromConfig(ConfigurationSection section){
		String title = null;
		Material material = Material.STONE;
		byte data = 0;
		int amount = 1;
		String[] lore = null;
		Map<Enchantment, Integer> enchantments = null;

		if(section.contains("Title"))
			title = section.getString("Title");

		if(section.contains("Material"))
			material = Material.getMaterial(section.getString("Material").replace(' ', '_'));

		data = (byte) section.getInt("Data", data);

		amount = section.getInt("Amount", amount);

		if(section.contains("Lore"))
			if(section.get("Lore") instanceof String)
				lore = new String[]{section.getString("Lore")};
			else{
				List loreConfig = section.getList("Lore");
				lore = (String[]) loreConfig.toArray(new String[0]);
			}

		if(section.contains("Enchantments")){
			enchantments = new HashMap<>();
			for(String key : section.getConfigurationSection("Enchantments").getKeys(false))
				enchantments.put(Enchantment.getByName(key), section.getInt("Enchantments."+key));
		}

		this.title = title;
		this.material = material;
		this.data = data;
		this.amount = amount;
		this.lore = lore;
		this.enchantments = enchantments;
	}

}
