import javax.swing.*;
import java.util.*;
import java.io.* ;
/**
 * This class has methods that checks GroceryItem foodCodes with NutritionList foodCodes,
 * display ArrayList to textArea methods, a getArrayList method and clear methods.
 * @author Sarah Ferrolino (500768674)
 */
public class SongScanner
{
	ArrayList<SongItem> items = new ArrayList<SongItem>();
	ArrayList<SongItem> unsorted = new ArrayList<SongItem>();
	//NutritionChart chart = new NutritionChart();
	SongList chart = new SongList();
	public JTextArea area;

	//public SongScanner() throws FileNotFoundException
	//{
	//	chart = new SongList();
	//}

	/**
	 * Checks if next food item code matches code in list and increases measure
	 * or if item code does not match, adds new item to list.
	 * @param foodCode 
	 */
	/*
	public void scanFoodCode(String song)
	{
		SongItem itemFound = null;
		if(items.size() == 0)
		{
			itemFound = chart.getSong(song);
			items.add(itemFound);
		}
		for(int i = 0; i < items.size(); i++)
		{
			if(foodCode == items.get(i).getFoodCode() && itemFound == null)
			{
				items.get(i).increaseMeasure();
				itemFound = items.get(i);
			}
		}		
		if(itemFound == null)
		{
			itemFound = chart.getFoodType(foodCode);
			items.add(itemFound);	
		}

	}*/

	/**
	 * Makes sure to set given textArea to null then appends each element in list in the textArea.
	 * @param area - given textArea
	 */
	public void displayAll(JTextArea area)
	{
		area.setText("");
		for(int i = 0; i < items.size(); i++)
		{
			//String nutrition = items.get(i).getLabel() + ": " + "Cals " + items.get(i).getMeasure()*items.get(i).getCalories() + " Sugar " + items.get(i).getMeasure()*items.get(i).getSugar() + " Fat " + items.get(i).getMeasure()*items.get(i).getFat() + " Carbs " + items.get(i).getMeasure()*items.get(i).getCarbs();
			String title = items.get(i).getLabel();
			String artist = items.get(i).getartist();
			String genre = items.get(i).getgenre();
			area.append("\n\n" + title + "\n\n" + artist + "\n\n" + genre);
		}
	}

	/**
	 * Makes sure to set given textArea to null then appends the sorted elements in the textArea.
	 * @param area - given textArea 
	 * @param list - FoodType ArrayList
	 */
	/*
	public void displaySorted(JTextArea area, ArrayList<FoodType> list)
	{
		area.setText("");

		for(int i = 0; i < list.size(); i++)
		{
			String nutrition = list.get(i).getLabel() + ": " + "Cals " + list.get(i).getMeasure()*list.get(i).getCalories() + " Sugar " + list.get(i).getMeasure()*list.get(i).getSugar() + " Fat " + list.get(i).getMeasure()*list.get(i).getFat() + " Carbs " + list.get(i).getMeasure()*list.get(i).getCarbs();
			area.append(nutrition + "\n");
		}
		list.removeAll(list);
	}
*/
	/**
	 * At the beginning, makes sure that unsorted is ArrayList is empty.
	 * Adds all elements from ArrayList items to new ArrayList unsorted.
	 * @return unsorted - FoodType ArrayList
	 */
	public ArrayList<SongItem> getList()
	{
		unsorted.removeAll(unsorted);
		for(int i = 0; i < items.size(); i++)
		{
			unsorted.add(items.get(i));
		}
		return unsorted;
	}
	
	/**
	 * Clears the given textArea.
	 * @param area - given textArea
	 */
	public void clear(JTextArea area)
	{
		area.setText("");
	}

	/**
	 * Clears sorted ArrayList.
	 * @param list - FoodType ArrayList
	 */
	public void clearSort(ArrayList<SongItem> list)
	{
		list.removeAll(list);
	}

	/**
	 * Clears ArrayList items.
	 */
	public void clearList()
	{
		items.removeAll(items);
	}

}