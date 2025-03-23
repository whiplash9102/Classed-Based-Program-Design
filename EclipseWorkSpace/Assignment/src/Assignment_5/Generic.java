package Assignment_5;
import java.awt.Color;
import tester.Tester;

class Bullet {
	int x; 
	int y; 
	int velocity;
	int radius;
	Color color;
	
	Bullet(int x, int y, int velocity, int radius, Color color){
		this.x = x;
		this.y = y; 
		this.velocity = velocity;
		this.radius = radius;
		this.color = color;
	}
	
	Bullet move() {
		return new Bullet(x + velocity, y + velocity, velocity, radius, color);
	}
	
	// Check if the bullet collideWithShip
	boolean collideWithShip(Ship s) {
		return ((Math.hypot(this.x, s.x) <= 0.1) && Math.hypot(this.y, s.y) <= 0.1);
 	}
	
	// Explode the bullet and ship: 
	
}

class Ship {
	int x;
	int y;
	int velocity;
	int radius;
	
	Ship(int x, int y, int velocity, int radius){
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.radius = radius;
	}
}

class ExamplesGame {
	Bullet b1 = new Bullet(12, 12, 10, 4, Color.red);
	Bullet b2 = new Bullet(12, 13, 10, 5, Color.red);
}
		