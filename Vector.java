import java.awt.image.BufferedImage;
import java.util.ArrayList;
/*
* Simple vector class.
*/

class Vector {
	public double length, dydx;
	public double intercept;
	public int[] direction, tail, tip, midpoint = new int[2];
	public ArrayList<Integer[]> points = new ArrayList<Integer[]>();

	/*
	* Constructor
	*/
	public Vector(int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		this.tail = new int[] {x1, y1};
		this.tip = new int [] {x2, y2};
		this.midpoint = new int[] {dx/2, dy/2};
		this.direction = new int[] { dx, dy};
		this.dydx = (dx != 0) ? dy / dx : 1000000;
		this.intercept = this.midpoint[1] - ((double) this.dydx * this.midpoint[0]);
		this.length = Math.round(Math.sqrt(Math.pow((dx),2) + Math.pow((dy),2)));
		populatePoints();
	}

	/*
	* Basic vector methods for Dot Product and determining the angle between two vectors
	*/
	public double dotProduct(Vector v) {
		return (this.direction[0] * v.direction[0]) + (this.direction[1] * v.direction[1]);
	}

	public double angleBetween(Vector v) {
		return Math.round(Math.toDegrees(Math.acos(this.dotProduct(v) / (this.length * v.length))));
	}

	public boolean parallelTo(Vector v) {
		return this.angleBetween(v) == 0.0;
	}

	public boolean orthogonalTo(Vector v) {
		return this.angleBetween(v) == 90.0;
	}

	/*
	* Test two vectors for equality
	*/
	public boolean equals(Vector u) {
		boolean tailsMatch = this.tail[0] == u.tail[0] && this.tail[1] == u.tail[1];
		boolean tipsMatch = this.tip[0] == u.tip[0] && this.tip[1] == u.tip[1];
		return (tailsMatch && tipsMatch);
	}

	/*
	* Determine if a vector contains a certain point.
	*/
	public boolean containsPoint(int x, int y) {
      	// endpoint
      	if ( ( this.tail[0] == x && this.tail[1] == y) || (this.tip[0] == x && this.tip[1] == y) ) {
			return true;
		}

		//flat vector
		if ( ( x >= this.minX() && x <= this.maxX() && this.direction[1] == 0) && (y == this.tail[1] || y == this.tip[1])) {
			return true;
		}

		//vertical vector
		if ( ( y >= this.minY() && y <= this.maxY() && this.direction[0] == 0) && (x == this.tail[0] || x == this.tip[0])) {
			return true;
		}

		//other cases
		for (Integer[] point : points) {
			if (point[0] == x && point[1] == y) {
				return true;
			}
		}

		return false;
  	}

	/*
	*	Draw the vector representation of a vector on a BufferedImage.
	* 	TODO: Make this smarter!
	*/

	public BufferedImage draw(BufferedImage bi, int color) {
		int xlim = this.tail[0] + (int) this.length;
		int ylim = this.tail[1] + (int) this.length;
	    for (int i = 0; i < xlim; i++) {
			for (int j = 0; j < ylim; j++) {
				if (this.containsPoint(i,j)) {
					if (i < bi.getWidth() && j < bi.getHeight()) {
						bi.setRGB(i,j,color);
					}
				}
			}
		}
		return bi;
	}

	/*
	* Greatest Common Factor method. Used for determining the partial changes with respect to X and Y. 
	*/
	public int gcf(int x, int y) {
	    x = -1*x > 0 ? -1*x : x;
		y = -1*y > 0 ? -1*y : y;

		if (y == 0 || x == 0) {
		    return 1;
		} else if (y % x == 0) {
				return x;
		} else {
			int i = x - 1;
			while (i >= 2) {
				if (x % i == 0 && y % i == 0) {
						return i;
				}
				i--;
			}
		}
		return 1;
	}

	public int signOf(int i) {
		return i >= 0 ? 1 : -1; 
	}

	public int maxX() {
		return this.tail[0] > this.tip[0] ? this.tail[0] : this.tip[0];
	}

	public int maxY() {
		return this.tail[1] > this.tip[1] ? this.tail[1] : this.tip[1];
	}

	public int minX() {
		return this.tail[0] < this.tip[0] ? this.tail[0] : this.tip[0];
	}

	public int minY() {
		return this.tail[1] < this.tip[1] ? this.tail[1] : this.tip[1];
	}

	/*
	* Fill the ArrayList, points, with the coordinates that compose this vector.
	*/
	public void populatePoints() {
		int normalize = gcf(this.direction[0],this.direction[1]);
		for (int i = 0; Math.abs(i) <= Math.abs(this.direction[0]) && this.points.size() < this.length;) {
			for (int j = 0; Math.abs(j) <= Math.abs(this.direction[1]);) {
				points.add(new Integer[] {this.tail[0] + i,this.tail[1] + j});
				i += this.direction[0] != 0 ? this.direction[0]/normalize : 0;
				j += this.direction[0] != 0 ? this.direction[1]/normalize : 1;
			}
		}
		/**
		* see the points printed
		\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
		* System.out.println(this.toString());
		* for (Integer[] point : points) { 
		* 	System.out.println(String.format("%d, %d",point[0],point[1]));
		* }
		/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\				  	 
		*/
	}

	/*
	* Print the vector information
	*/
	public String toString() {
		String str = "Length: " + this.length + " Direction: <" + this.direction[0] + ", " + this.direction[1] + ">" +
							 "\n" + "Tail o---- : (" + this.tail[0] + ", " + this.tail[1] + ") Tip ----> : (" + this.tip[0] + ", " + this.tip[1] + ")";
		return str;
	}
}
