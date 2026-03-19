package com.learn.oops;

public class Polymorphism {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.makeSound();
		dog.makeSound("Tom");

		Animal animal = dog;
		animal.makeSound();

		Animal animal2 = new Animal();
		animal2.makeSound();

	}

}

class Animal {
	public void makeSound() {
		System.out.println("Animal sound");
	}
}

class Dog extends Animal {
	
	// method overriding : runtime polymorphism
	@Override
	public void makeSound() {
		System.out.println("Woof!");
	}

	// method overloading : compile time polymorphism
	public void makeSound(String name) {
		System.out.println("Dog Name : " + name + " make sound : Woof");
	}
}

class Cat extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Meow!");
	}
}