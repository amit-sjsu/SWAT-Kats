import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Edge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// A class to represent a graph edge
    class Edge implements Comparable<IEdge>, IEdge
    {
        private int src, dest, weight;
 
        // Comparator function used for sorting edges based on
        // their weight
        public int compareTo(IEdge compareEdge)
        {
            return this.getWeight()-compareEdge.getWeight();
        }

		@Override
		public int getSrc() {
			return src;
		}

		@Override
		public void setSrc(int src) {
			this.src= src;
		}

		@Override
		public int getDest() {
			return dest;
		}

		@Override
		public void setDest(int dest) {
			this.dest = dest;
		}

		@Override
		public int getWeight() {
			return weight;
		}

		@Override
		public void setWeight(int weight) {
			this.weight = weight;
		}
    };
 