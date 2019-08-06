package stackqueue;

import java.util.LinkedList;

import fundamental.data_structure.Queue;
import list.Node;

public class AnimalShelter {
	private LinkedList<Animal> list;
	private 
	
	private Node<Animal> before_oldest_dog;
	private Node<Animal> before_oldest_cat;
	
	
	
	public AnimalShelter() {
		this.list = new LinkedList<Animal>();
		this.before_oldest_dog = null;
		this.before_oldest_cat = null;
	}
	
	
	
	public void enqueue(Animal animal) {
		this.list.add(animal);
	}
	
	public Animal dequeueAny() {
		
	}
	
	public Dog dequeueDog() {
			
	}
	
	public Cat dequeueCat() {
		
	}
	
	
	
	public void setOldestDog() {
		
	}
	
	public void setOldestCat() {
		
	}
}
