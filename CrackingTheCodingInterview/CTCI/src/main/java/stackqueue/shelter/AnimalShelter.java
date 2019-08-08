package stackqueue.shelter;

import java.util.LinkedList;

public class AnimalShelter {
	private LinkedList<Dog> dogs;
	private LinkedList<Cat> cats;
	
	private int arrival_stamp;
	
	
	
	public AnimalShelter() {
		this.dogs = new LinkedList<Dog>();
		this.cats = new LinkedList<Cat>();
		
		this.arrival_stamp = Integer.MIN_VALUE;
	}
	
	
	
	public void enqueue(Dog dog) {
		dog.arrival_stamp = this.arrival_stamp;
		this.increment();
		
		this.dogs.addFirst(dog);
	}
	
	public void enqueue(Cat cat) {
		cat.arrival_stamp = this.arrival_stamp;
		this.increment();
		
		this.cats.addFirst(cat);
	}

	
	
	public Animal dequeueAny() {
		Animal animal = null;
		
		if (this.dogs.isEmpty()) {
			if (!this.cats.isEmpty()) {
				animal = this.cats.removeLast();
			}
		} else if (this.cats.isEmpty()) {
			animal = this.dogs.removeLast();
		} else {
			if (this.dogs.peekLast().arrival_stamp < this.cats.peekLast().arrival_stamp) {
				animal = this.dogs.removeLast();
			} else {
				animal = this.cats.removeLast();
			}
		}
		
		return animal;
	}
	
	public Dog dequeueDog() {
		Dog dog = null;
		
		if (!this.dogs.isEmpty()) {
			dog = this.dogs.removeLast();
		}
		
		return dog;
	}
	
	public Cat dequeueCat() {
		Cat cat = null;
		
		if (!this.cats.isEmpty()) {
			cat = this.cats.removeLast();
		}
		
		return cat;
	}
	
	
	
	private void increment() {
		this.arrival_stamp++;
	}
}
