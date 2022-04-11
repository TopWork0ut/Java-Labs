package com.iot.lpnu.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.iot.lpnu.tools.GardenTools;
import com.iot.lpnu.tools.TreeTools;
import com.iot.lpnu.enums.OrderOfSOrting;
import com.iot.lpnu.enums.ToolSpecialization;

public class InstrumentShop extends SortingManager {
	private List<GardenTools> listOfTools = new ArrayList<>();

	public List<GardenTools> addToolToTheShop(GardenTools tool) {
		listOfTools.add(tool);

		return listOfTools;
	}

	public List<GardenTools> sellInstruments(ToolSpecialization toolSpecialization, int count) {
		int countOfDesireableToolsInShop = (listOfTools.stream()
				.filter(Element -> Element.getToolSpecialization().equals(toolSpecialization))
				.collect(Collectors.toList())).size();

		if (count > 0) {

			if (countOfDesireableToolsInShop >= count) {
				System.out.format("You've bougth %d instruments", count);
				System.out.println();
				removeToolFromShop(toolSpecialization, count);
			}

			else if (countOfDesireableToolsInShop > 0 && countOfDesireableToolsInShop < count) {
				System.out.format("Sorry, we have only %d tools, so we'll sell you only them",
						countOfDesireableToolsInShop);
				System.out.println();
				removeToolFromShop(toolSpecialization, countOfDesireableToolsInShop);
			}

			else {
				System.out.println("Sorry, we don't have any of these type of instruments, you can choose smth else");
			}
		}

		else {
			System.out.println("You've put unpropriate number to sell tools");
		}
		;

		return listOfTools;
	}

	public List<GardenTools> removeToolFromShop(ToolSpecialization toolSpecialization, int count) {
		List<GardenTools> listWithToolsFromThisSpecialization = listOfTools.stream()
				.filter(Element -> Element.getToolSpecialization().equals(toolSpecialization))
				.collect(Collectors.toList());

		List<GardenTools> secondList = listOfTools.stream()
				.filter(Element -> Element.getToolSpecialization().equals(toolSpecialization))
				.collect(Collectors.toList());

		if (count < 0) {
			System.out.println("We've put the negative number of tools to delete");
		}

		else if (count == 0) {
			System.out.println("We haven't deleted any of the tools");
		}

		else {
			if (listWithToolsFromThisSpecialization.size() == count) {
				System.out.format("We've deleted %d tools from the shop", count);
				System.out.println();
				listOfTools.removeAll(listWithToolsFromThisSpecialization);
			}

			else if (listWithToolsFromThisSpecialization.size() < count) {
				System.out.format("We've deleted only %d tools from the shop, cause list doesn't consist more",
						listWithToolsFromThisSpecialization.size());
				System.out.println();
			}

			else {
				listWithToolsFromThisSpecialization.stream().forEach(tool -> {
					if (secondList.size() != count) {
						secondList.remove(tool);
					}
				});

				listOfTools.removeAll(secondList);
				System.out.format("We've deleted %d tools from the shop", count);
			}
		}
		return listOfTools;
	}

	public float calculatePriceForTool(GardenTools tool, int numberOfTools) {
		if (numberOfTools > 0) {
			return tool.getCostInUaPerOne() * numberOfTools;
		}
		else {
			return 0;
		}		
	}

	public List<GardenTools> getListOfToolsForProfilacticWorksWithTrees(OrderOfSOrting order) {
		List<GardenTools> listOfToolsForProfilacticTrees = listOfTools.stream()
				.filter(tool -> (tool.getToolSpecialization().equals(ToolSpecialization.IS_FOR_TREES) && ((TreeTools)tool).isProfilacticTool() == true))
				.collect(Collectors.toList());
		System.out.println("Tree tools sorted by price");
		System.out.println(getToolsSortedByPrice(listOfToolsForProfilacticTrees, order));
		
		System.out.println(getToolsSortedByWeight(listOfToolsForProfilacticTrees, order));
//		getToolsSortedByPrice(listOfToolsForProfilacticTrees, order);
//		getToolsSortedByWeight(listOfToolsForProfilacticTrees, order);

		return listOfToolsForProfilacticTrees;
	}

}
