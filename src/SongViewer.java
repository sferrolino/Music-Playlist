import javax.swing.JFrame;

/**
   This program allows the user to view font effects.
*/
public class SongViewer
{  
	//USER: team4
	//PASS: cps406
	private static final int FRAME_WIDTH = 780 ;
	private static final int FRAME_HEIGHT = 680 ;

   public static void main(String[] args)
   {  
      JFrame frame = new SongFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Song Player");
      //sets appropriate size:
      //frame.pack() ;
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setResizable(false);
      frame.setVisible(true);   
   }

}