package stackqueue;

import java.util.LinkedList;

import list.Node;

public class AnimalShelter {
	private LinkedList<Animal> list;
	
	private Node<Animal> before_oldest_dog;
	private Node<Animal> before_oldest_cat;
	
	
	
	public AnimalShelter() {
		this.list = new LinkedList<Animal>();
		this.before_oldest_dog = null;
		this.before_oldest_cat = null;
	}
	
	
	
	public void enqueue(Animal animal) {
		this.list.add(animal);
		
		if (this.before_oldest_dog == null) {
			
		}
		
		if (this.before_oldest_cat == null) {
			
		}
	}
	
	public Animal dequeueAny() {
		this.list.remove();
		return null;
	}
	
	public Dog dequeueDog() {
			return null;
	}
	
	public Cat dequeueCat() {
		return null;
	}
	
	
	
	public void setOldestDog() {
		
	}
	
	public void setOldestCat() {
		
	}
}
