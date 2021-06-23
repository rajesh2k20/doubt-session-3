package cfc_question;
import java.util.*;
public class target {
	static int counter2=0;
	public static void main(String[] args) {
	    int size = 4;
	    int noOfKnightsToPlace = 4;
		System.out.println("place 'n' no. of knights so that no knight can kill other & return arraylist having all possible configurations : ");
        int[][] board1 = new int[size][size];
        ArrayList<ArrayList<ArrayList<Integer>>> output = placeKnightsArraylist(board1, size,0, 0, 0, noOfKnightsToPlace);
        //System.out.println(output);
        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                for (int k = 0; k < output.get(i).get(j).size(); k++) {
                    System.out.print(output.get(i).get(j).get(k));
                }
                System.out.println();
            }
            System.out.println();
            counter2++;
            
        }
        System.out.println("No of configurations (with return type) : " +  counter2);
        System.out.println();
	}

    private static ArrayList<ArrayList<ArrayList<Integer>>> placeKnightsArraylist(int[][] board, int boardSize, int row, int col, int n, int m) {

        if (m == 0) {  // corner case
            ArrayList<ArrayList<ArrayList<Integer>>> base = new ArrayList<>();
            return base;
        }

        if (m == 1) { // base condition

            ArrayList<ArrayList<ArrayList<Integer>>> base = new ArrayList<ArrayList<ArrayList<Integer>>>(boardSize);

            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                	 ArrayList<ArrayList<Integer>> configuration = new ArrayList<ArrayList<Integer>>();
                    for(int k=0; k < boardSize; k ++) {
                        ArrayList<Integer> newArr = new ArrayList<>();
                        for (int l = 0; l < boardSize; l++) {
                            newArr.add(0);
                        }
                        configuration.add(newArr);
                    }
                    configuration.get(i).set(j, 1);
                    //configuration.get(i).add(j, 1);
                     base.add(configuration);
                }
            }

            return base;
        }

        ArrayList<ArrayList<ArrayList<Integer>>> ans = placeKnightsArraylist(board, boardSize, row, col, n , m-1);
        ArrayList<ArrayList<ArrayList<Integer>>> finalAns = new ArrayList<>();

        for (int i = 0; i < ans.size(); i++) {
            ArrayList<ArrayList<Integer>> myans = ans.get(i);
            //ArrayList<ArrayList<Integer>> dummy = new ArrayList<ArrayList<Integer>>();
            //System.out.println("myans is "+ myans);
            int r1=0;
            int c1=0;
            for(int t=0;t<boardSize;t++) {
            	for(int q=0;q<boardSize;q++) {
            		if(myans.get(t).get(q)==1) {
            			r1=t;
            			c1=q;
            		}
            	}
            }
          
            for(int p = r1;  p < myans.size(); p++) {
                for (int q = 0; q < myans.size(); q++) {
                    //board[p][q] = myans.get(p).get(q);
                	if(p==r1 && q<=c1) {
                		continue;
                	}
                    if (isSafeChessBoardReturn(myans, p, q)) {
                        myans.get(p).set(q, 1);
                        ArrayList<ArrayList<Integer>> dummy = new ArrayList<ArrayList<Integer>>();
                        for (int r = 0; r < myans.size(); r++) {
                            ArrayList<Integer> dummy2 = new ArrayList<>();
                            for (int s = 0; s < myans.size(); s++) {
                                dummy2.add(myans.get(r).get(s));
                            }
                            dummy.add(dummy2);
                        }
                        myans.get(p).set(q, 0);
                        finalAns.add(dummy);
                    }
                }
                //finalAns.add(myans);
                //myans.get(p).set(, 0);
            }
            ///finalAns.add(myans);
            //myans =
        }

        return finalAns;
    }

    private static boolean isSafeChessBoardReturn(ArrayList<ArrayList<Integer>> board, int row, int column) {
        final int[][] knightsMoves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}}; //knight move in L shape ie 2-1 ie takes 2 steps then 1 step( 2 step can be on a row or on a column)

        if (board.get(row).get(column) == 1) {
            return false;
        }

        for (int[] moves : knightsMoves) {
            if (row + moves[0] >= 0 && column + moves[1] >= 0 && row + moves[0] <= board.size() - 1 && column + moves[1] <= board.get(0).size() - 1) {
                if (board.get(row + moves[0]).get(column + moves[1]) == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}


