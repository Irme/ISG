package game;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	{


	};
	private static int gottenX;
	private static int gottenY;
	DrawBoard db = new DrawBoard();
	int coor []= {-10, -10};
	/**
	 * Launch the application.
	 */

	private class DrawCanvas extends JPanel {
		// Override paintComponent to perform your own painting
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);     // paint parent's background
			int FX = 121;
			int FY = 71;


			BufferedImage chessboard;
			try {
				chessboard = ImageIO.read(new File("chessboard.png"));
				BufferedImage bk = ImageIO.read(new File("blackknight.png")); //Loading the image
				BufferedImage wk = ImageIO.read(new File("whiteknight.png"));	
				g.drawImage(chessboard, FX, FY, null);//Actually drawing the image
				db.drawB(g, bk, wk);
				if(coor[0] != -10)
					
					g.drawRect(FX+26*coor[0], FY+26*coor[1], 26, 26);
				for (int i = 0; i < (Board.moves.size()); i = i+2){
					g.drawRect(FX+26*Board.moves.get(i), FY+26*Board.moves.get(i+1), 26, 26);
				}
				repaint();




			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}


	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GameFrame() throws IOException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 450);
		setSize(450,350);
		DrawCanvas canvas = new DrawCanvas();
		canvas.setBorder(new EmptyBorder(5, 5, 5, 5));
		canvas.setLayout(new BorderLayout(0, 0));
		setContentPane(canvas);
		setVisible(true);
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public synchronized void mouseClicked(MouseEvent e) {
				//System.out.println(e.getX() + " " +e.getY() );
				gottenX = e.getX();
				gottenY = e.getY();
				coor = db.highlight(gottenX, gottenY);
				Board.coor = coor;
		
				
				//if (coor[0] != -10 )
				//Board.Move(coor[0], coor[1]);
			}
		});
		canvas.getMouseListeners();


	}

}
