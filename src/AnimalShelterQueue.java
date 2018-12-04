import java.util.*;

class Entity {
    int order;
    String id;
    Entity before, after;
    public Entity(String id, int order) {
        this.id = id;
        this.order = order;
    }
}

class Cat extends Entity {
    public Cat(String name, int order) {
        super(name, order);
    }
}
class Dog extends Entity {
    public Dog(String name, int order) {
        super(name, order);
    }
}

class EntityQueue {
    
    int capacity, size=0;
    Entity front, rear;
    
    public EntityQueue (int cap) { this.capacity = cap;}
    public boolean isFull() {return this.capacity == this.size;}
    public boolean isEmpty() {return 0 == this.size;}
    
    public boolean enqueue(Entity en) {
        if(isFull()) return false;
        size ++;
        if(rear == null) {
            front = en;
            rear = en;
            front.after = rear;
        } else {
            rear.after = en;
            en.before = rear;
            en.after = null;
            rear = en;
        }
        return true;
    }
    
    public Entity dequeue() {
        if(isEmpty()) return null;
        Entity en = front;
        front = front.after;
        en.after = null;
        size--;
        return en;
    }
    
    public Entity peek() {
       if(isEmpty()) return null;
        Entity en = front;
        return en;
    }
}

public class AnimalShelterQueue 
{ 
    
    EntityQueue cats;
    EntityQueue dogs;
    public AnimalShelterQueue(int cap) {
        cats = new EntityQueue(cap);
        dogs = new EntityQueue(cap);
    }
  
    public boolean enqueue(Entity animal) {
        if(animal instanceof Cat && !cats.isFull()) {
            cats.enqueue(animal);
            return true;
        } else if(animal instanceof Dog && !dogs.isFull()) {
            dogs.enqueue(animal);
            return true;
        }
        return false;
    }
      
    public Entity dequeueAny() {
        
        if (cats.isEmpty() && dogs.isEmpty())
            return null;
        else if(cats.isEmpty())
            return dogs.dequeue();
        else if(dogs.isEmpty())
            return cats.dequeue();
        else {
            Entity cat = cats.peek();
            Entity dog = dogs.peek();
            if(cat.order < dog.order)
                return cats.dequeue();
            else
                return dogs.dequeue();
        }
    }
  
    public Entity dequeueCat() {
        return cats.dequeue();
    }
    public Entity dequeueDog() {
        return dogs.dequeue();
    }
    
	public static void main(String args[]) { 
	    
	    AnimalShelterQueue animals = new AnimalShelterQueue(4);
	    
	    Entity c = new Cat("Cat1", 1);
	    animals.enqueue(c);
	    c = new Dog("Dog1", 2);
	    animals.enqueue(c);
	    c = new Cat("Cat2", 3);
	    animals.enqueue(c);
	    c = new Dog("Dog2", 4);
	    animals.enqueue(c);
	    
	    System.out.println(animals.dequeueDog().id);
	    System.out.println(animals.dequeueAny().id);
	    System.out.println(animals.dequeueAny().id);
	}
} 






















