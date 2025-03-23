package Assignment_6;
interface IList<T> {
	IList<T> append(IList<T> list);
	IList<T> sorted(Comparator <T> order);
	IList<T> insert(T t, Comparator<T> comp);
}

class MtList<T> implements IList<T> {
	@Override
	public IList<T> append(IList<T> other) {
		return other;
	}

	@Override
	public IList<T> sorted(Comparator<T> order) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IList<T> insert(T t, Comparator<T> comp) {
		// TODO Auto-generated method stub
		return new ConsList<>(t, this);
	}

}

class ConsList<T> implements IList<T> {
	T first;
	IList<T> rest;

	ConsList(T first, IList<T> rest) {
		this.first = first;
		this.rest = rest;
	}

	@Override
	public IList<T> append(IList<T> other) {
		return new ConsList<>(this.first, this.rest.append(other));
	}

	@Override
	public IList<T> sorted(Comparator<T> order) {
		// TODO Auto-generated method stub
		return this.rest.insert(this.first, order);
	}

	@Override
	public IList<T> insert(T t, Comparator<T> comp) {
		if (comp.compare(t, this.first) < 0) {
			return new ConsList<>(t, this.rest.insert(t, comp));
		} else {
			return this.rest.insert(first, comp);
		}
	}
}
