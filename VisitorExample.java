interface IIntTree {
	<R> R accept(ITreeVisitor<R> visitor);
}

class Node implements IIntTree {
	int num;
	IIntTree left;
	IIntTree right;

	Node(int num, IIntTree left, IIntTree right) {
		this.num = num;
		this.left = left;
		this.right = right;
	}

	<R> R accept(IFooVisitor<R> visitor) {
		visitor.visitNode(this);
	}
}

class Leaf implements IIntTree {

	<R> R accept(IFooVisitor<R> visitor) {
		visitor.visitLeaf(this);
	}
}

interface IFunc<T, R> {
	R apply(T t);
}

interface ITreeVisitor<R> extends IFunc<IIntTree, R> {
	R visitNode(Node node);
	R visitLeaf(Leaf leaf);
}

class CountNodes implements ITreeVisitor<Integer> {
	Integer apply(IIntTree t) {
		return t.accept(this);
	}

	Integer visitNode(Node node) {
		return 1 + node.left.accept(this) + node.right.accept(this);
	}

	Integer visitLeaf(Leaf leaf) {
		return 0;
	}
}

class SumValues implements ITreeVisitor<Integer> {
	Integer apply(IIntTree t) {
		return t.accept(this);
	}

	Integer visitNode(Node node) {
		return node.num + node.left.accept(this) + node.right.accept(this);
	}

	Integer visitLeaf(Leaf leaf) {
		return 0;
	}
}

class AverageValues implements ITreeVisitor<Double> {
	Double apply(IIntTree t) {
		return t.accept(this);
	}

	Double visitNode(Node node) {
		SumValues sumFunc = new SumValues();
		CountNodes countFunc = new CountNodes();
		double sum = (double)sumFunc.apply(node);
		double count = (double)countFunc.apply(node);
		return sum / count;
	}

	Double visitLeaf(Leaf leaf) {
		return 0;
	}
}