import javax.swing.* ;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.*;

public class SongFrame extends JFrame {
	   
	private static final int AREA_ROWS = 20;
	private static final int AREA_COLUMNS = 18;

	private JList listy = new JList();
	private JTextArea songArea, playlistArea ;
	Font font = new Font("Arial", Font.PLAIN, 13);
	//Creates a list for songs.
	SongList songs1 = new SongList() ; 
	SongList songs2 = new SongList() ;
	SongList songs3 = new SongList();
	String title = "";
	String artist = "";
	String genre = "";
	JTextArea tester = new JTextArea();
	
	SongList myCart = new SongList();
	SongScanner myScanner = new SongScanner() ;
	SongPlaylist register = new SongPlaylist() ; 
	SongPlaylist register2 = new SongPlaylist() ; 
			
			
	/**
	 	Constructs the frame.
	 */
	public SongFrame() {
		
		songArea = new JTextArea(AREA_ROWS, AREA_COLUMNS) ;
		songArea.setEditable(false) ;
		songArea.setFont(font);
		playlistArea = new JTextArea(AREA_ROWS, AREA_COLUMNS) ;
		playlistArea.setEditable(false);
		
		createLoginPanel() ;
	}


	/**
	 	Creates the first account login panel.
	 */
	private void createLoginPanel() {
		
		JPanel accountPanel = new JPanel(new BorderLayout()) ;
		accountPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 50));
		
		JPanel inPanel = new JPanel(new BorderLayout()) ;
		JPanel left = new JPanel(new BorderLayout()) ;
		JPanel right = new JPanel(new BorderLayout()) ;
		
		inPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 15));
		left.setBackground(Color.BLACK);
		left.setBorder(BorderFactory.createLineBorder(Color.BLACK, 90));
		right.setBackground(Color.BLACK);
		right.setBorder(BorderFactory.createLineBorder(Color.BLACK, 110));
		
		JLabel titleLabel = new JLabel("<html><br/>Song Player System</html>", SwingConstants.CENTER) ;
		titleLabel.setFont(new Font("Phosphate", Font.PLAIN, 50));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setOpaque(true);
		titleLabel.setBackground(Color.BLACK);
		
		JLabel accountLabel = new JLabel("<html><br/>User Login</html>", SwingConstants.CENTER) ;
		accountLabel.setFont(new Font("Futura", Font.BOLD, 15));
		accountLabel.setForeground(Color.WHITE);
		
		JLabel userLabel = new JLabel("Username: ") ;
		userLabel.setForeground(Color.WHITE);
		
		JTextField username = new JTextField() ;
		username.setBackground(Color.WHITE);
		username.setColumns(10);
		
		JLabel passLabel = new JLabel("Password: ") ;
		passLabel.setForeground(Color.WHITE);
		
		JTextField password = new JTextField() ;
		password.setBackground(Color.WHITE);
		password.setColumns(10);
		
		JButton signInButton = new JButton("Sign In") ;
		
		JLabel errorLabel = new JLabel("Incorrect. Please try again.") ;
		errorLabel.setForeground(Color.red);
		errorLabel.setVisible(false);
		
		
		ImageIcon image = new ImageIcon("music_waves.jpeg");
		JLabel imageLabel = new JLabel(image) ;
		
		   GroupLayout accountLayout = new GroupLayout(inPanel);
		   inPanel.setLayout(accountLayout);
		   
		   accountLayout.setHorizontalGroup(accountLayout.createParallelGroup(Alignment.LEADING).
				   addGroup(accountLayout.createSequentialGroup().
						  addGap(20).
						  addGroup(accountLayout.createParallelGroup(Alignment.LEADING).
								  addComponent(userLabel).
								  addComponent(passLabel)).
						  addGroup(accountLayout.createParallelGroup(Alignment.LEADING).
								  addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).
								  addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))).
				   addGroup(Alignment.LEADING, accountLayout.createSequentialGroup().addGap(50).addComponent(errorLabel)).
				   addGroup(Alignment.LEADING, accountLayout.createSequentialGroup().addGap(85).addComponent(signInButton).addContainerGap(300, Short.MAX_VALUE)));
		   
		   accountLayout.setVerticalGroup(accountLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(accountLayout.createSequentialGroup()
							.addGroup(accountLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(userLabel))
							.addGap(10)
							.addGroup(accountLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passLabel))
							.addGap(15)
							.addComponent(errorLabel) 
							.addGap(15)
							.addComponent(signInButton)
							.addGap(15))
				);
		   
		accountPanel.setBackground(Color.BLACK);
		inPanel.setBackground(Color.BLACK);
		left.setBackground(Color.BLACK);
		right.setBackground(Color.BLACK);
		accountPanel.add(accountLabel, BorderLayout.NORTH) ;
		accountPanel.add(inPanel, BorderLayout.CENTER) ;
		add(left, BorderLayout.WEST) ;
		add(right, BorderLayout.EAST) ;
		add(accountPanel, BorderLayout.CENTER) ;
		add(titleLabel, BorderLayout.NORTH) ;
		add(imageLabel, BorderLayout.SOUTH);
		
		//Creates the action listener for the Sign in button
		class coloursListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event) {
				String user = username.getText();
				String pass = password.getText();
				
				if(user.equals("team4") && pass.equals("cps406")) {
					createGreyPanel() ;
					createSongListPanel() ;
					createScanItemsPanel() ;
					createSongPlaylistPanel() ;
					createSongInfoPanel() ;
					titleLabel.setVisible(false) ;
					accountLabel.setVisible(false) ;
					userLabel.setVisible(false);
					username.setVisible(false);
					passLabel.setVisible(false);
					password.setVisible(false);
					signInButton.setVisible(false);
					inPanel.setVisible(false);
					left.setVisible(false);
					right.setVisible(false);
					accountPanel.setVisible(false);
					imageLabel.setVisible(false);
				}
				else {
					errorLabel.setVisible(true); //else show the error message
				}
				
			}
		}
		ActionListener listener = new coloursListener() ;
		signInButton.addActionListener(listener);
	}

	//GREY PANEL START
	private void createGreyPanel() {
			JPanel p1 = new JPanel(new GridLayout(0,1));
			add(p1, BorderLayout.NORTH);
			p1.setPreferredSize(new Dimension(500, 100));
			p1.setBackground(Color.BLACK);
			//GREY PANEL END
			JLabel welcomeMsg = new JLabel("WELCOME");
			JLabel quote = new JLabel("STREAM, LISTEN, REPEAT.");
			welcomeMsg.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 40));
			quote.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 12));
			welcomeMsg.setForeground(Color.WHITE);
			welcomeMsg.setHorizontalAlignment(JLabel.CENTER);
			quote.setHorizontalAlignment(JLabel.CENTER);
			quote.setForeground(Color.WHITE);
			p1.add(welcomeMsg);
			p1.add(quote);
	}

	/**
	 	Creates the song list panel.
	 */
	private void createSongListPanel() {
		
		//Fill and display the songs.
		songs1.fill() ;
		songs1.display(songArea) ;
		
		//Drop down menu labels + new JComboBox
		String[] genres = new String[] {"All Songs", "Pop", "Hip-Hop", "R&B", "Rock", "Jazz", "KPop"};
		JComboBox<String> SongGenres = new JComboBox<>(genres);
		SongGenres.setSelectedIndex(0);
		
		//Creates the Grocery Cart panel and label
		JLabel groceryLabel = new JLabel("   SONG LIST") ;
		groceryLabel.setPreferredSize(new Dimension(170, 30));
		groceryLabel.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 20));
		groceryLabel.setForeground(Color.WHITE);
		
		//Creates the skip button
		JButton skipButton = new JButton("SKIP") ;
		skipButton.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 14));
		//Creates the action listener for the skip button
		class AddSkipListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event) {
				try {
					songs1.removeTopItem() ;
				}
				catch (IndexOutOfBoundsException exception) {
					
				}
			}
		}
		ActionListener listener = new AddSkipListener() ;
		skipButton.addActionListener(listener);
		
		//Add Drop down menu 
			SongGenres.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent event) {
					if(event.getSource() == SongGenres) {
						JComboBox hey = (JComboBox)event.getSource();
						String selectedGenre = (String) hey.getSelectedItem();
						songs1.clear();
			       			songs1.fill() ;
						if (selectedGenre.equals("All Songs")) {
			        	    songs2 = (songs1.getAllSongs(songs1));
						} 
						
						else if (selectedGenre.equals("Pop")) {
					           songs2 = (songs1.getPopSongs(songs1));
					       }
						
						else if (selectedGenre.equals("Hip-Hop")) {
				        	   songs2 = (songs1.getHipHopSongs(songs1));
						}
							
						else if (selectedGenre.equals("R&B")) {
				       	    songs2 = (songs1.getRnBSongs(songs1));
						}
							
						else if (selectedGenre.equals("Rock")) {
			        	    songs2 = (songs1.getRockSongs(songs1));
						}
							
						else if (selectedGenre.equals("Jazz")) {
				       	    songs2 = (songs1.getJazzSongs(songs1));
						}
							
						else if (selectedGenre.equals("KPop")) {
				       	    songs2 = (songs1.getKPopSongs(songs1));
						}
						songs1 = songs2;
						songArea.setText("");
			            songs1.display(songArea);
					}
				}
			});	
			
		//Creates panel
		JPanel songPanel = new JPanel(new BorderLayout()) ;
		JPanel labelButton = new JPanel(new FlowLayout()) ;
		labelButton.add(groceryLabel, BorderLayout.NORTH) ; 
		labelButton.add(skipButton, BorderLayout.CENTER) ;
		labelButton.add(SongGenres);
		songPanel.add(labelButton, BorderLayout.NORTH) ;
		labelButton.setBackground(Color.BLACK);
		labelButton.setPreferredSize(new Dimension(250, 100));
		
		//Make scrollable
		JScrollPane scrollPane = new JScrollPane(songArea) ;
		songPanel.add(scrollPane, BorderLayout.CENTER) ;
		
		//add the song panel to the west of the frame
		add(songPanel, BorderLayout.WEST) ;
		
	}
	
	/**
	 	Creates the scan items panel.
	 */
	
	ArrayList<Double> times = new ArrayList<Double>() ; //for total time
	NumberFormat decimal = new DecimalFormat("#0.00") ;
	
	private void createScanItemsPanel() {
		
		
		//Create ScanItems panel
		JPanel scanItems = new JPanel() ;
		JPanel middle = new JPanel();
		JPanel middle2 = new JPanel();
		middle.setPreferredSize(new Dimension(250, 60));
		middle2.setPreferredSize(new Dimension(250, 40));
		middle.setBackground(Color.BLACK);
		middle2.setBackground(Color.BLACK);
		//Create scan button
		JButton scanButton = new JButton("+") ;
		scanButton.setPreferredSize(new Dimension(40,40));
		scanButton.setFont(new Font("Arial", Font.BOLD, 14));
		
		//Creates the action listener for the scan item button
		class ScanItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event) {
				
				try {
					double time = songs1.getNextItemCart().gettime() ; //get the time of the next item we are going to add to the playlist
					SongItem nextItem = songs1.getNextItemCart();
					register.scanItem(nextItem) ; //add that item we are going to remove
					songs1.removeTopItem() ; //removed top item from songs
					register.displayAll(playlistArea);
					
					//testAREA
					register2.scanItem(nextItem);
					songs3.addItem(nextItem);
					
					//
					
					//update total time
					times.add(time) ;
					double totaltime = 0  ;
					for (double p : times) {
						totaltime += p ;
					}
				
				}
				catch (IndexOutOfBoundsException exception) {
					
				}
			}
		}
		ActionListener listener = new ScanItemListener() ;
		scanButton.addActionListener(listener);
		
		ImageIcon pic2 = new ImageIcon("icon.png");
		ImageIcon play = new ImageIcon("Webp.net-resizeimage-4.png");
		JLabel eh = new JLabel(pic2);
		JButton ok1 = new JButton("PLAY PLAYLIST");
		ActionListener nutrition = new ClickListener2();
		ok1.addActionListener(nutrition);
		
		//scanItems.setLayout(layout);
		//Add button to the panel and frame
		//ImageIcon pic2 = new ImageIcon("blue.png");
		
		scanItems.add(scanButton, BorderLayout.NORTH) ;
		scanItems.add(middle, BorderLayout.CENTER);
		scanItems.add(new JLabel(pic2), BorderLayout.SOUTH);
		//PLAY PLAYLIST BUTTON
		scanItems.add(ok1);
		scanItems.add(new JLabel(play), BorderLayout.SOUTH);
		scanItems.setBackground(Color.BLACK);
		scanItems.setPreferredSize(new Dimension(50, 100));
		add(scanItems, BorderLayout.CENTER) ;
	}
	
	/**
	 	Creates the song playlist panel.
	 */
	
	private void createSongPlaylistPanel() {
		
		//Creates the playlist/register panel and label
		JLabel registerLabel = new JLabel("    PLAYLIST") ;
		registerLabel.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 20));
		registerLabel.setPreferredSize(new Dimension(150, 30));
		registerLabel.setForeground(Color.WHITE);
		playlistArea.setFont(font);
		//Creates the clear button
		JButton checkoutButton = new JButton("CLEAR") ;
		checkoutButton.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 14));
			
		//Creates action listener for the clear button
		class CheckoutListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event) {
				register.clear() ;
				times.clear() ;
				register.displayAll(playlistArea);
			}
		}
	
		ActionListener listener = new CheckoutListener() ;
		checkoutButton.addActionListener(listener);
		
		JButton removeButton = new JButton("REMOVE");
		removeButton.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 14));
		//Creates the action listener for the remove button
				class AddRemoveListener implements ActionListener
				{
					public void actionPerformed(ActionEvent event) {
						try {
							register.removeTopItemRegister() ;
						}
						catch (IndexOutOfBoundsException exception) {
							
						}
						register.displayAll(playlistArea);
					}
				}
				ActionListener RemoveListener = new AddRemoveListener() ;
				removeButton.addActionListener(RemoveListener);		
				
		//Creates panel
		JPanel registerPanel = new JPanel(new BorderLayout()) ;
		JPanel labelButton = new JPanel(new FlowLayout()) ;
		labelButton.add(registerLabel, BorderLayout.CENTER) ;
		labelButton.add(checkoutButton, BorderLayout.CENTER) ;
		labelButton.add(removeButton, BorderLayout.SOUTH);
		
		registerPanel.add(labelButton, BorderLayout.NORTH) ;
				
		//Make scrollable
		JScrollPane scrollPane = new JScrollPane(playlistArea) ;
		registerPanel.add(scrollPane, BorderLayout.CENTER) ;	
		labelButton.setBackground(Color.BLACK);
		labelButton.setPreferredSize(new Dimension(250, 100));
		
		//add the register/playlist panel to the east of the frame
		add(registerPanel, BorderLayout.EAST) ;
	}
	
	//CLICKLISTENER FOR "PLAY PLAYLIST"
	class ClickListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//myScanner.clear(tester);
			try {
				SongItem nextItem = songs3.getNextItemCart();
				tester.setText(register2.displaySong(nextItem));
				songs3.removeTopItem();
				
			} catch (IndexOutOfBoundsException exception) {}

		}
	}
	
	
	private void createSongInfoPanel()
	{
	
		JPanel trackR = new JPanel();
		trackR.setPreferredSize(new Dimension(550, 150));
		trackR.setBackground(Color.BLACK);
		
		JLabel info = new JLabel("		TITLE: " );
		//JLabel t1 = new JLabel("	" + this.title);
		info.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 14));
		info.setForeground(Color.WHITE);
		
		JLabel artist = new JLabel("		ARTIST:	" + this.artist);
		//JLabel t2 = new JLabel("	" + this.artist);
		artist.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 14));
		artist.setForeground(Color.WHITE);
		
		JLabel genre = new JLabel("		GENRE:	" + this.genre);
		//JLabel t3 = new JLabel("	" + this.genre);
		genre.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 14));
		genre.setForeground(Color.WHITE);
		
		JPanel songInfo = new JPanel();
		songInfo.setBackground(Color.BLACK);

		songInfo.add(info);
		songInfo.add(artist);
		songInfo.add(genre);
	
		tester = new JTextArea();
		tester.setPreferredSize(new Dimension(400,150));
		//trackR.add(ok1);
		trackR.add(tester);
		//trackR.add(ok1);
		tester.setBackground(Color.BLACK);
		tester.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 13));
		tester.setForeground(Color.WHITE);
		tester.append("\n\nTITLE: \n\nARTIST: \n\nGENRE: ");

		add(trackR, BorderLayout.SOUTH);
		
		
	} 
}

