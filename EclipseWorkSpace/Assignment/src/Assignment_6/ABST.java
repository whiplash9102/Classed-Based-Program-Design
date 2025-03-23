package Assignment_6;
import tester.*;

abstract class ABST<T> {
	Comparator<T> order;

	ABST(Comparator<T> order) {
		this.order = order;
	}

	boolean present(T data) {
		return false;
	}

	boolean isLeaf() {
		return false;
	}
	
	boolean sameLeaf(Leaf<T> that) {
		return false;
	}
	
	boolean sameNode(Node<T> that) {
		return false;
	}

	// abstract
	abstract T getLeftMost();
	abstract ABST<T> getRight();
	abstract ABST<T> insert(T data);
	abstract boolean sameTree(ABST<T> T);
	abstract boolean sameData(ABST<T> T);
	abstract boolean sameDataHelper(Node<T> that);
}

class Leaf<T> extends ABST<T> {

	Leaf(Comparator<T> order) {
		super(order);
	}

	boolean isLeaf() {
		return true;
	}

	@Override
	public ABST<T> insert(T data) {
		return new Node<>(this.order, data, new Leaf<>(this.order), new Leaf<>(this.order));
	}

	@Override
	T getLeftMost() {
		throw new RuntimeException("No leftmost item of an empty tree");
	}

	@Override
	ABST<T> getRight() {
		// TODO Auto-generated method stub
		throw new RuntimeException("No right of an empty tree");
	}

	@Override
	boolean sameTree(ABST<T> T) {
		// TODO Auto-generated method stub
		return T.isLeaf();
	}

	
	boolean sameLeaf(Leaf<T> T) {
		return true;
		}

	@Override
	boolean sameDataHelper(Node<T> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean sameData(ABST<T> T) {
		// TODO Auto-generated method stub
		return T.sameLeaf(this);
	}
}

class Node<T> extends ABST<T> {

	T data;
	ABST<T> left;
	ABST<T> right;

	Node(Comparator<T> order, T data, ABST<T> left, ABST<T> right) {
		super(order);
		this.data = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public ABST<T> insert(T data) {
		// TODO Auto-generated method stub
		int cmp = order.compare(data, this.data);
		if (cmp < 0) {
			return new Node<>(order, this.data, left.insert(data), right);
		}
		else {
			return new Node<>(order, this.data, left, right.insert(data));
		}
	}

	@Override
	boolean present(T data) {
		// TODO Auto-generated method stub
		int cmp = order.compare(data, this.data);
		if (cmp == 0) {
			return true;
		}
		else if (cmp < 0) {
			return left.present(data);
		}
		else {
			return right.present(data);
		}
	}

	@Override
	T getLeftMost() {
		if (this.left.isLeaf()) {
			return data;
		}
		else {
			return this.left.getLeftMost();
		}
	}

	@Override
	ABST<T> getRight() {
		if (this.left.isLeaf()) {
			return this.right;
		}
		else {
			return new Node<>(this.order, this.data, this.left.getRight(), this.right);
		}
	}

	@Override
	boolean sameTree(ABST<T> T) {
		// TODO Auto-generated method stub
		return this.equals(T);
	}
	
	boolean sameNode(Node<T> that) {
		return this.present(that.data) &&
				that.right.sameData(this.left)&&
				that.left.sameData(this.right);
	}

	@Override
	boolean sameData(ABST<T> T) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean sameDataHelper(Node<T> that) {
		// TODO Auto-generated method stub
		return false;
	}
}

class ExamplesBST {
	ExamplesBST() {
	}

	Comparator<Book> titleOrder = new BooksByTitle();
	Comparator<Book> authoreOrder = new BooksByAuthor();
	Comparator<Book> priceOrder = new BooksByPrice();

	Book b1 = new Book("Java Programming", "Alice Smith", 40);
	Book b2 = new Book("Data Structures", "Bob JohnSon", 50);
	Book b3 = new Book("Algorithms", "Charlie Davis", 60);
	Book b4 = new Book("Machine Learnig", "David White", 70);

	ABST<Book> nodeInsert = new Node<>(priceOrder, b3, new Leaf<>(priceOrder),
			new Leaf<>(priceOrder));
	ABST<Book> node1 = new Node<>(priceOrder, b1, new Leaf<>(priceOrder), new Leaf<>(priceOrder));
	ABST<Book> node2 = new Node<>(priceOrder, b2, new Leaf<>(priceOrder), new Leaf<>(priceOrder));
	ABST<Book> node4 = new Node<>(priceOrder, b4, node1, new Leaf<>(priceOrder));
	ABST<Book> node3 = new Node<>(priceOrder, b3, node1, node2);
	ABST<Book> node5 = new Node<>(priceOrder, b3, node2, node4);
	ABST<Book> node2expected = new Node<>(priceOrder, b2, new Leaf<>(priceOrder), nodeInsert);

	IList<Book> list1 = new ConsList<>(b1,
			new ConsList<>(b2, new ConsList<>(b3, new ConsList<>(b4, new MtList<>()))));

	IList<Book> list3 = new ConsList<>(b1, new ConsList<>(b1, new ConsList<>(b2, new MtList<>())));

	boolean testInsert(Tester t) {
		return t.checkExpect(node2.insert(b3), node2expected);
	}

	boolean testPresent(Tester t) {
		return t.checkExpect(node2expected.present(b3), true)
				&& t.checkExpect(node2.present(b3), false);
	}

	boolean testLeftMost(Tester t) {
		return t.checkExpect(node2expected.getLeftMost(), b2);
	}
//
//	boolean testRight(Tester t) {
//		ABST<Book> expectedRightTree = new Node<>(priceOrder, b3, new Leaf<>(priceOrder), node1);
//		return t.checkExpect(node4.getRight(), expectedRightTree);
//	}

	boolean testSametree(Tester t) {
		return t.checkExpect(node1.sameTree(node1), true)
				&& t.checkExpect(node3.sameTree(node4), false);
	}

	boolean testSameData(Tester t) {
		return t.checkExpect(node3.sameData(node4), false) && t.checkExpect(node1.sameData(node1), true)
				&& t.checkExpect(node3.sameData(node3), true);
	}
}
