package lab4;

public class CartPt {
	int x;
	int y;
	CartPt(int x, int y){
		this.x = x;
		this.y = y;
	}
	double distanceToOrigin() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}
}

