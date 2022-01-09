package gilded.roses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import gilded.roses.objects.items.Item;
import gilded.roses.objects.items.SimpleItem;
import gilded.roses.objects.shops.MainShop;
import gilded.roses.objects.shops.ShopListener;
import gilded.roses.objects.shops.events.SoldItemEvent;

public class Main {
	
	public static MainShop mainShop = new MainShop();
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String command = "";
		
		sendHelpInfos();
		
		mainShop.addListener(getListener());
		
		while (!(command = sc.nextLine()).equalsIgnoreCase("stop")) {
			if (command.equalsIgnoreCase("view"))
				DisplayInventoryCommand();
			else if (command.equalsIgnoreCase("viewq"))
				DisplayInventoryByQuantityCommand();
			else if (command.equalsIgnoreCase("update"))
				UpdateInventoryCommand();
			else if (command.equalsIgnoreCase("sell") && mainShop.getViewer().GetInventory().size()>0)
				mainShop.sellItem(mainShop.getViewer().GetInventory().get(0));
			else if (command.equalsIgnoreCase("buy"))
				mainShop.buyItem(new SimpleItem("new item", (short)10, (short)3, 5.0));
			else if (command.equalsIgnoreCase("balance"))
				System.out.println("Solde du shop : " + mainShop.getBalance());
			else if (command.equalsIgnoreCase("transmute"))
				mainShop.transmuteItem(new SimpleItem("new item to transmute", (short)20, (short)15, 25.0));
			else
				System.out.println("Command éronnée.");
		}
		
	}

	private static ShopListener getListener() {
		return new ShopListener() {
			@Override
			public void soldItem(SoldItemEvent event) {
				System.out.println("Un objet a été vendu : " + event.getItem().getName() + ", prix : " + event.getItem().getValue());
			}
		};
	}

	private static void sendHelpInfos() {
		System.out.println("----------[ HELP ]----------");
		System.out.println("stop : Arrêter le programme.");
		System.out.println("view : Voir la liste des objets.");
		System.out.println("viewq : Voir la liste des objets par catégorie et quantité.");
		System.out.println("update : Mettre à jour les objets, faire avancer d'un jour.");
		System.out.println("sell : Vendre un objet du shop, si le shop en contient.");
		System.out.println("buy : Faire acheter un objet au shop (prix = 5.0).");
		System.out.println("balance : Récupérer le solde du shop principal.");
		System.out.println("transmute : Transmuter un nouvel objet (aucun retour).");
		System.out.println("----------[ HELP ]----------\n");
	}

	private static void UpdateInventoryCommand() {
		mainShop.updateItems();
		System.out.println("Shop mis à jour, solde : " + mainShop.getBalance());
	}

	private static void DisplayInventoryByQuantityCommand() {
		HashMap<String, ArrayList<Item>> items = mainShop.getViewer().getInventoryByQuantity();
		System.out.println("----------[ INVENTORY ]----------\n");
		if (items.get(Item.TYPE_SIMPLE) != null) showSimpleItems(items.get(Item.TYPE_SIMPLE));
		if (items.get(Item.TYPE_GROWING) != null) showGrowingItems(items.get(Item.TYPE_GROWING));
		if (items.get(Item.TYPE_LIMITED) != null) showLimitedItems(items.get(Item.TYPE_LIMITED));
		if (items.get(Item.TYPE_LEGENDARY) != null) showLegendaryItems(items.get(Item.TYPE_LEGENDARY));
		if (items.get(Item.TYPE_CONJURED) != null) showConjuredItems(items.get(Item.TYPE_CONJURED));
		if (items.get(Item.TYPE_RELIC) != null) showRelicItems(items.get(Item.TYPE_RELIC));
		System.out.println("\n----------[ INVENTORY ]----------");
	}

	private static void showLegendaryItems(ArrayList<Item> list) {
		System.out.println("   LEGENDARY : " + list.size());
		if (!list.isEmpty()) {
			for (Item i : list)
				System.out.println("    [" + i.getSellIn() + "] " + i.getName() + " - Q: " + i.getQuality() + " - V: " + i.getValue());
		}
		System.out.println("   LEGENDARY ");
	}

	private static void showLimitedItems(ArrayList<Item> list) {
		System.out.println("   LIMITED : " + list.size());
		if (!list.isEmpty()) {
			for (Item i : list)
				System.out.println("    [" + i.getSellIn() + "] " + i.getName() + " - Q: " + i.getQuality() + " - V: " + i.getValue());
		}
		System.out.println("   LIMITED");
	}

	private static void showGrowingItems(ArrayList<Item> list) {
		System.out.println("   GROWING : " + list.size());
		if (!list.isEmpty()) {
			for (Item i : list)
				System.out.println("    [" + i.getSellIn() + "] " + i.getName() + " - Q: " + i.getQuality() + " - V: " + i.getValue());
		}
		System.out.println("   GROWING");
	}

	private static void showSimpleItems(ArrayList<Item> list) {
		System.out.println("   SIMPLE : " + list.size());
		if (!list.isEmpty()) {
			for (Item i : list)
				System.out.println("    [" + i.getSellIn() + "] " + i.getName() + " - Q: " + i.getQuality() + " - V: " + i.getValue());
		}
		System.out.println("   SIMPLE");
	}
	
	private static void showConjuredItems(ArrayList<Item> list) {
		System.out.println("   CONJURED : " + list.size());
		if (!list.isEmpty()) {
			for (Item i : list)
				System.out.println("    [" + i.getSellIn() + "] " + i.getName() + " - Q: " + i.getQuality() + " - V: " + i.getValue());
		}
		System.out.println("   CONJURED");
	}
	
	private static void showRelicItems(ArrayList<Item> list) {
		System.out.println("   RELIC : " + list.size());
		if (!list.isEmpty()) {
			for (Item i : list)
				System.out.println("    [" + i.getSellIn() + "] " + i.getName() + " - Q: " + i.getQuality() + " - V: " + i.getValue());
		}
		System.out.println("   RELIC");
	}

	private static void DisplayInventoryCommand() {
		ArrayList<Item> items = mainShop.getViewer().GetInventory();
		if (!items.isEmpty()) {
			for (Item i : items) {
				System.out.println(i.toString());
			}
		}
	}

}
