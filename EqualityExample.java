class Person {
	String name;
	Dog dog;

	@Override
	public int hashCode() {
		return this.name.hashCode() + dog.hashCode();
	}

	@Override
	public boolean equals(Object that) {
		if (that instance of Person) {
			Person person = (Person)that;
			return this.name.equals(person.name) &&
					this.dog.equals(person.dog);
		}
		return false;
	}

}

class Dog {
	String name;
	int years;

	@Override
	public int hashCode() {
		return (name.hashCode() * 13) + (years * 43);
	}

	@Override
	public boolean equals(Object that) {
		if (that instance of Dog) {
			Dog dog = (Dog)that;
			return this.name.equals(dog.name) &&
					this.years == dog.years;

		}
		return false;
	}
}

hashCode !=  -->  equals !=
hashCode ==  -->  equals != OR ==
equals ==    -->  hashCode ==
equals !=    -->  hashCode == OR !=