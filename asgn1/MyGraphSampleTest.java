import java.util.*;
import java.io.*;

public class MyGraphSampleTest {

   public static void main(String[] args) {
      MyGraph myGraph = new MyGraph();
      boolean isBipartite;
      ArrayList<HashSet<Integer>> connectCheckResult;


      try {
         System.out.println("\n-------Test 1--------");
         myGraph.readfile_graph("Bfstest1.txt");
         isBipartite = myGraph.bipartiteCheck();
         connectCheckResult = myGraph.connectCheck();
         System.out.println(isBipartite);
         System.out.println(connectCheckResult);
      }
      catch (FileNotFoundException e) {
         System.out.print("FILE NOT FOUND");
      }
      
      MyGraph myGraph2 = new MyGraph();
      boolean isBipartite2;
      ArrayList<HashSet<Integer>> connectCheckResult2;


      try {
         System.out.println("\n-------Test 2--------");
         myGraph2.readfile_graph("Bfstest2.txt");
         isBipartite2 = myGraph2.bipartiteCheck();
         connectCheckResult2 = myGraph2.connectCheck();
         System.out.println(isBipartite2);
         System.out.println(connectCheckResult2);
      }
      catch (FileNotFoundException e) {
         System.out.print("FILE NOT FOUND");
      }

      MyGraph myGraph3 = new MyGraph();
      boolean isBipartite3;
      ArrayList<HashSet<Integer>> connectCheckResult3;


      try {
         System.out.println("\n-------Test 3--------");
         myGraph3.readfile_graph("Bfstest3.txt");
         isBipartite3 = myGraph3.bipartiteCheck();
         connectCheckResult3 = myGraph3.connectCheck();
         System.out.println(isBipartite3);
         System.out.println(connectCheckResult3);
      }
      catch (FileNotFoundException e) {
         System.out.print("FILE NOT FOUND");
      }

      MyGraph myGraph4 = new MyGraph();
      boolean isBipartite4;
      ArrayList<HashSet<Integer>> connectCheckResult4;


      try {
         System.out.println("\n-------Test 4--------");
         myGraph4.readfile_graph("Bfstest4.txt");
         isBipartite4 = myGraph4.bipartiteCheck();
         connectCheckResult4 = myGraph4.connectCheck();
         System.out.println(isBipartite4);
         System.out.println(connectCheckResult4);
      }
      catch (FileNotFoundException e) {
         System.out.print("FILE NOT FOUND");
      }

      MyGraph myGraph5 = new MyGraph();
      boolean isBipartite5;
      ArrayList<HashSet<Integer>> connectCheckResult5;


      try {
         System.out.println("\n-------Test 5--------");
         myGraph5.readfile_graph("Bfstest5.txt");
         isBipartite5 = myGraph5.bipartiteCheck();
         connectCheckResult5 = myGraph5.connectCheck();
         System.out.println(isBipartite5);
         System.out.println(connectCheckResult5);
      }
      catch (FileNotFoundException e) {
         System.out.print("FILE NOT FOUND");
      }

      MyGraph myGraph6 = new MyGraph();
      boolean isBipartite6;
      ArrayList<HashSet<Integer>> connectCheckResult6;


      try {
         System.out.println("\n-------Test 6--------");
         myGraph6.readfile_graph("Bfstest6.txt");
         isBipartite6 = myGraph6.bipartiteCheck();
         connectCheckResult6 = myGraph6.connectCheck();
         System.out.println(isBipartite6);
         System.out.println(connectCheckResult6);
      }
      catch (FileNotFoundException e) {
         System.out.print("FILE NOT FOUND");
      }
   }
}
