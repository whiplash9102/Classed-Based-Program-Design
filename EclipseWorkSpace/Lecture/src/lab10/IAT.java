package lab10;
import tester.Tester;

public interface IAT {
	boolean isSame(IAT other);
	boolean isSameNode(Node other);
	boolean isSameEmpty(EmptyTree other);
}

abstract class AIAT implements IAT {
	public boolean isSameNode(Node other) {
		return false;
	}
	public boolean isSameEmpty(EmptyTree other) {
		return false;
	}
}

class EmptyTree extends AIAT {
	public boolean isSame(IAT other) {
		return other.isSameEmpty(this);
	}
	
	public boolean isSameEmpty(EmptyTree other) {
		return true;
	}
}

class Node extends AIAT {
	int value;
	IAT left, right;
	
	Node(int value, IAT left, IAT right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
	@Override
	public boolean isSame(IAT other) {
		// TODO Auto-generated method stub
		return other.isSameNode(this);
	}

	@Override
	public boolean isSameNode(Node other) {
		// TODO Auto-generated method stub
		return this.value == other.value
				&& this.left.isSame(other.left)
				&& this.right.isSame(other.right);
	}
}

class ExamplesIAT {
	IAT mtlist = new EmptyTree();
	IAT node1 = new Node(1, mtlist, mtlist);

	
	IAT node2 = new Node(1, new EmptyTree(), new EmptyTree());
	
	boolean testIsSame(Tester t) {
		return t.checkExpect(node2.isSame(node1), true) &&
				t.checkExpect(mtlist.isSame(node2), false);
	}
}
