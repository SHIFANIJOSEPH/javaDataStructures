
import java.util.Scanner;
class n_queen
{
	static int ctr = 0;
	public static void printBoard(int [] qpos )
	{
		int row;
		int col;
		for( row = 0; row < qpos.length; row +=1, System.out.println())
		{
			for( col = 0; col < qpos.length; col += 1)
			{
			System.out.printf("%c " , qpos [ row ] == col ? 'Q' : '-' );
					
			}
		}
	}		
     public static boolean isSafe ( int [] qpos, int qno, int pos )
	 {
	      int row;
		  int col;
		  
	     // left diag
		 for( row = qno - 1, col = pos -1 ; row >= 0 && col >= 0; row-=1, col-=1)
		 {
		    if ( qpos [ row ] == col ) 
			   return false;
		 }
		 // top
		 for( row = qno - 1, col = pos ; row >= 0 && col >= 0; row-=1)
		 {
		    if ( qpos [ row ] == col ) 
			   return false;
		 }
		 // right diag
		 for( row = qno-1, col = pos + 1 ; row >= 0 && col < qpos.length; row-=1, col+=1 )
		 {
		    if ( qpos [ row ] == col ) 
			   return false;
		 }
		 
		 return true;
		 
	 }
     public static void n_queen_solver_helper ( int [] qpos , int qno, int noq )
	 {
	 
	     // check
		 if ( qno == noq  )
		 {
		    System.out.printf("Solved!!!!!! %d\n",++ctr);;
			printBoard( qpos );
			return;
		 }
	     // enumerate all the choices
		 // 0 to noq -1 
		 int pos;
		 for( pos = 0 ; pos < noq ; pos += 1)
		 {
		    // constraint
			if ( isSafe( qpos, qno, pos ) == true )
			{
			   qpos [ qno ] = pos;
			   n_queen_solver_helper ( qpos, qno + 1, noq );
			   qpos [ qno ] = -1;
			}
			
		 }
	 }
     public static void n_queen_solver ( int noq )
	 {
	     // arm 
		 
		 // set an environment
		 int [] qpos = new int [ noq ];
		 int qpos_ind;
		 for( qpos_ind = 0; qpos_ind < noq ; qpos_ind+=1)
		     qpos [ qpos_ind ]  = -1;
			 
	    // call the helper - recursive

        n_queen_solver_helper ( qpos, 0, noq );
		
		 
	 }
     public static void main(String [] args)
	 {
	    int noq ;// number of queens
        Scanner kbd = new Scanner ( System.in );
	    noq  = kbd.nextInt();
		n_queen_solver( noq);
	 }
}
