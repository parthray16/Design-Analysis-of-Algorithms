import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Queue;
import java.util.HashSet;

class MyGraph  {	
	ArrayList<Vertex> vertices = new ArrayList<Vertex>();
   boolean directed; 
   int nvertices;
   int nedges; 
   int numComp;
	
   public MyGraph(){
   }
	
   void readfile_graph(String filename) throws FileNotFoundException  {
      int x,y;
        //read the input
      FileInputStream in = new FileInputStream(new File(filename));
      Scanner sc = new Scanner(in);
      int temp = sc.nextInt(); // if 1 directed; 0 undirected
      directed = (temp == 1);
    	nvertices = sc.nextInt();
      for (int i=0; i<=nvertices-1; i++){
         Vertex tempv = new Vertex(i+1);   // kludge to store proper key starting at 1
         vertices.add(tempv);
      }

		nedges = sc.nextInt();   // m is the number of edges in the file
      int nedgesFile = nedges;
		for (int i=1; i<=nedgesFile ;i++)	{
			// System.out.println(i + " compare " + (i<=nedges) + " nedges " + nedges);
         x=sc.nextInt();
			y=sc.nextInt();
         //  System.out.println("x  " + x + "  y:  " + y  + " i " + i);
			insert_edge(x,y,directed);
		}  
		   // order edges to make it easier to see what is going on
		for(int i=0;i<=nvertices-1;i++)	{
			Collections.sort(vertices.get(i).edges);
		}
		sc.close();  
	}
   
   static void process_vertex_early(Vertex v)	{
		timer++;
		v.entry_time = timer;
		//     System.out.printf("entered vertex %d at time %d\n",v.key, v.entry_time);
	}
	
	static void process_vertex_late(Vertex v)	{
		timer++;
		v.exit_time = timer;
		//     System.out.printf("exit vertex %d at time %d\n",v.key , v.exit_time);
	}

	static void process_edge(Vertex x,Vertex y) 	{
		int c = edge_classification(x,y);
		if (c == BACK) System.out.printf("back edge (%d,%d)\n",x.key,y.key);
		else if (c == TREE) System.out.printf("tree edge (%d,%d)\n",x.key,y.key);
		else if (c == FORWARD) System.out.printf("forward edge (%d,%d)\n",x.key,y.key);
		else if (c == CROSS) System.out.printf("cross edge (%d,%d)\n",x.key,y.key);
		else System.out.printf("edge (%d,%d)\n not in valid class=%d",x.key,y.key,c);	
	}
	
	static void initialize_search(MyGraph g)	{
		for(Vertex v : g.vertices)		{
			v.processed = v.discovered = false;
			v.parent = null;
		}
	}
	
	static final int TREE = 1, BACK = 2, FORWARD = 3, CROSS = 4;
	static int timer = 0;
	
	static int edge_classification(Vertex x, Vertex y)	{
		if (y.parent == x) return(TREE);
		if (y.discovered && !y.processed) return(BACK);
		if (y.processed && (y.entry_time > x.entry_time)) return(FORWARD);
		if (y.processed && (y.entry_time < x.entry_time)) return(CROSS);
		System.out.printf("Warning: self loop (%d,%d)\n",x,y);
		return -1;
	}
   
	void insert_edge(int x, int y, boolean directed) 	{
		Vertex one = vertices.get(x-1);
      Vertex two = vertices.get(y-1);
      one.edges.add(two);      
		vertices.get(x-1).degree++;
		if(!directed)
			insert_edge(y,x,true);
		else
			nedges++;
	}
   void remove_edge(Vertex x, Vertex y)  {
		if(x.degree<0)
			System.out.println("Warning: no edge --" + x + ", " + y);
		x.edges.remove(y);
		x.degree--;
	} 

	void print_graph()	{
		for(Vertex v : vertices)	{
			System.out.println("vertex: "  + v.key);
			for(Vertex w : v.edges)
				System.out.print("  adjacency list: " + w.key);
			System.out.println();
		}
	} 

   class Vertex implements Comparable<Vertex> {
      int key;
      int degree;
      int component;
      String color = "black";
      boolean discovered = false;
      boolean processed = false;
      int entry_time = 0;
      int exit_time = 0;
      Vertex parent = null;
      ArrayList<Vertex> edges = new ArrayList<Vertex>();
   
      public Vertex(int tkey){ 
         key = tkey;
      }
      public int compareTo(Vertex other){
         if (this.key > other.key){
            return 1;
         }         else if (this.key < other.key) {
            return -1;
         }
         else 
            return 0;
         }
      }

	Vertex unProcessedV(){	   
      for(Vertex v:  vertices)  {
         if (! v.processed ) return v;
      }
   return null;	
   }

   public ArrayList<HashSet<Integer>> connectCheck(){
	   //method used on Object MyGraph
	   //returns an ArrayList of HashSet where the first set in the ArrayList contains the number of connected components
	   //followed by sets containing the vertices of the connected components
	   	initialize_search(this);
		ArrayList<HashSet<Integer>> comp = new ArrayList<>();
		HashSet<Integer> setNumComp = new HashSet<>();
		numComp = 0;
		for (Vertex v : vertices){
			if (v.discovered == false){
				comp.add(bfs(v));
				numComp++;
			}
		}
		setNumComp.add(numComp);
		comp.add(0, setNumComp);
		return comp;
   }

   public static HashSet<Integer> bfs(Vertex v){
	   //helper static function for connectCheck to use BFS to find connected components
	   HashSet<Integer> set = new HashSet<>();
	   Queue<Vertex> q = new LinkedList<>();
	   v.discovered = true;
	   q.add(v);
	   set.add(v.key);
	   while (q.isEmpty() != true){
		   Vertex source = q.remove();
		   for (Vertex w : source.edges){
			   if (w.discovered == false){
				   w.discovered = true;
				   q.add(w);
				   set.add(w.key);
			   }
		   }
		   source.processed = true;
	   }
	   return set;
   } 

   public boolean bipartiteCheck(){
	   //method used on Object MyGraph
	   //returns true if the graph is bipartite and false if it is not bipartite using BFS
	   initialize_search(this);
	   for (Vertex v : vertices){
		   if (v.discovered == false){
			   Queue<Vertex> q = new LinkedList<>();
			   v.discovered = true;
			   v.color = "black";
			   q.add(v);
			   while (q.isEmpty() != true){
				   Vertex source = q.remove();
				   for (Vertex adjVert : source.edges){
					   if (adjVert.discovered == false){
						   adjVert.discovered = true;
						   if ((source.color).equals("black")){
							   adjVert.color = "red";
						   }   
						   else{
							   adjVert.color = "black";
						   }
						   q.add(adjVert);
					   }
					   else{
						   if ((source.color).equals(adjVert.color)){
							   return false;
						   }
					   }
				   }
			   }
		   }
	   }
	   return true;	
   }
}