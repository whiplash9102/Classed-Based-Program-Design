package Assignment_5;

public interface IBullets {

}

class MtBullets implements IBullets {
	
}

class ConsLoBullet implements IBullets {
	Bullet first;
	IBullets rest; 
	
	ConsLoBullet(Bullet first, IBullets rest){
		this.first = first; 
		this.rest = rest;
	}
}
