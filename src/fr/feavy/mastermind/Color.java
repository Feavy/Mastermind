package fr.feavy.mastermind;

public enum Color {

	NO_COLOR(0, 0, 0, 0, 0),
	YELLOW(1, 255, 235, 59, 1),
	BLUE(2, 3, 169, 244, 1),
	RED(3, 244, 67, 54, 1),
	GREEN(4, 76, 175, 80, 1),
	WHITE(5, 255, 255, 255, 1),
	BLACK(6, 33, 33, 33, 1);
	
	private int id;
	private java.awt.Color color;
	
	Color(int id, int r, int g, int b, int a) {
		this.id = id;
		if(a == 1)
			this.color = new java.awt.Color(r, g, b);
		else
			this.color = new java.awt.Color(r, g, b, a);
	}
	
	public java.awt.Color getColor() {
		return color;
	}
	
	public int id() {
		return id;
	}
	
	public static Color fromID(int id) {
		for(Color c : Color.values()) 
			if(c.id == id)
				return c;
		return NO_COLOR;
	}
	
}
