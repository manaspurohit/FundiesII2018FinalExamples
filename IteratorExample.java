// 1 2 3 4
// 5 6 7
// 8 9 10
// 11 12 13


// 1 5 8 11 2 6 9 12 3 7 10 13

class NIteratorIterator<T> implements Iterator<T> {
	ArrayList<Iterator<T>> iterators;
	int curIndex;

	NIteratorIterator(ArrayList<Iterator<T>> iterators) {
		if (iterators.size() == 0) {
			throw new IllegalArgumentException("No iterators provided");
		}

		this.iterators = iterators;
		this.curIndex = 0;
	}

	public boolean hasNext() {
		if (this.curIndex == 0) {
			for (Iterator<T> it : iterators) {
				if (!it.hasNext()) {
					return false;
				}
			}
		}

		return true;
	}

	public T next() {
		T answer = this.iterators.get(curIndex).next();
		if (curIndex + 1 == this.iterators.size()) {
			curIndex = 0;
		} else {
			curIndex += 1;
		}

		return answer;
	}

}