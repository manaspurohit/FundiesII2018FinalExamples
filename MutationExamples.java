
void F1(Posn p1, Posn p2) {
	p2.x = p1.x;
	p1.x = 5;

	// At this point
	// What is p2.x?
	// What is p1.x?
}

void test0() {
	F1(new Posn(3, 2), new Posn(1, 4));
}


void F2(Posn p1, Posn p2) {
	p1 = p2;
	p2.y = 6;
	p1.x = 7;

	// At this point
	// What is p1? What is p2?
}

void test1() {
	Posn point = new Posn(0, 0);
	F2(point, point);
	point --> ?
}


void F3(Posn p1, Posn p2) {
	Posn temp = p1;
	p1 = p2;
	p2 = temp;
}

void test2() {
	Posn p = new Posn(3, 4);
	Posn q = new Posn(6, 8);
	F3(p, q);
	p.x --> ?
}


void F4(Posn p1, Posn p2) {
	p1.y = p2.x;
	p2.x = p1.x;
	p1.y = 3;

	// What is p1?
	// What is p2?
}

void test3() {
	Posn p = new Posn(3, 4);
	Posn q = new Posn(8, 9);
	F4(p, q);
	// What is p? What is q?
}