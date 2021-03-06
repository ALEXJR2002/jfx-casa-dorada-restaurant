package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1;
	private String name;
	private long id;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<PriceBySize> pricesBySizes;
	private boolean availability;
	private Type type;
	private int cont;
	private int total;
	private User creator;
	private User modifier;
	
	/**
	 * @param name
	 * @param availability
	 */
	public Product(String name, long id, ArrayList<Ingredient> ingredients, Type t, User creator) {  //selectedType = getValue del choiceBox
		this.name = name;
		this.id = id;
		this.ingredients = ingredients;
		this.pricesBySizes = new ArrayList<PriceBySize>();
		this.availability = true;
		type = t;
		this.creator = creator;
		modifier = creator;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public boolean addIngredient(Ingredient i) {
		boolean added = false;
		added = ingredients.add(i);
		return added;
	}
	
	public boolean deleteIngredient(Ingredient i) {
		boolean deleted = false;
		deleted = ingredients.remove(i);
		return deleted;
	}
	
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String newType) {
		type.setName(newType);
	}
	/**
	 * @return the cont
	 */
	public int getCont() {
		return cont;
	}

	/**
	 * @param cont the cont to set
	 */
	public void setCont(int amount) {
		cont += amount;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total += total;
	}

	/**
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}
	/**
	 * @return the modifier
	 */
	public User getModifier() {
		return modifier;
	}
	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(User modifier) {
		this.modifier = modifier;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the pricesBySizes
	 */
	public ArrayList<PriceBySize> getPricesBySizes() {
		return pricesBySizes;
	}
	
	/**
	 * @param pricesBySizes the pricesBySizes to set
	 */
	public void setPricesBySizes(ArrayList<PriceBySize> pricesBySizes) {
		this.pricesBySizes = pricesBySizes;
	}

	public ArrayList<String> getSizes() {
		ArrayList<String> sizes = new ArrayList<String>();
		for(int i = 0; i<pricesBySizes.size(); i++) {
			sizes.add(pricesBySizes.get(i).getSize());
		}
		return sizes;
	}
	
	public boolean addPriceBySize(PriceBySize pbs) {
		boolean added = false;
		added = pricesBySizes.add(pbs);
		return added;
	}
	
	public boolean deletePriceBySize(PriceBySize pbs) {
		boolean deleted = false;
		deleted = pricesBySizes.remove(pbs);
		return deleted;
	}
}
