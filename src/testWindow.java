import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class testWindow extends JFrame {
	private static Connection connection;
	private static JList monsterTable;
	private static JList selectTable;
	private static DefaultListModel monsterList;
	private static DefaultListModel selectList;
	private static DefaultListModel partyList;
	private static final JTabbedPane mainPane = new JTabbedPane(JTabbedPane.TOP);
	private static final JPanel homePane = new JPanel();
	private static final JPanel playerPane = new JPanel();
	private static final JPanel monsterPane = new JPanel();
	private static final JPanel battlePane = new JPanel();
	private final JList partyTable = new JList();
	private final JList enemyTable = new JList();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public testWindow() {		
		
		this.setBounds(10, 10, 600, 800);
		getContentPane().add(mainPane);
		mainPane.setBounds(10, 0, 800, 600);
		setupHomePane();
		setupPlayerPane();
		setupBattlePane();
		setupMonsterPane();
		
	}
	
	public void setupHomePane() {
		homePane.setBounds(10, 11, 800, 600);
		mainPane.add("Home", homePane);	
	}
	
	public void setupPlayerPane() {
		playerPane.setBounds(10, 11, 800, 600);
		mainPane.add("Players", playerPane);	
	}
	
	public void setupBattlePane() {
		battlePane.setBorder(null);
		battlePane.setBounds(10, 11, 800, 600);			
		mainPane.add("Battle", battlePane);
		battlePane.setLayout(null);
		partyTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		partyTable.setBounds(10, 30, 180, 125);
		
		battlePane.add(partyTable);
		enemyTable.setBounds(10, 194, 180, 125);
		
		battlePane.add(enemyTable);
		
		JLabel partyLbl = new JLabel("Party");
		partyLbl.setFont(new Font("SketchFlow Print", Font.BOLD, 12));
		partyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		partyLbl.setLabelFor(partyTable);
		partyLbl.setBounds(70, 10, 50, 14);
		battlePane.add(partyLbl);
		
		JLabel enemyLbl = new JLabel("Enemy");
		enemyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		enemyLbl.setFont(new Font("SketchFlow Print", Font.BOLD, 12));
		enemyLbl.setBounds(70, 173, 50, 14);
		battlePane.add(enemyLbl);
		
	}
	
	public void setupMonsterPane() {
		
		monsterPane.setBounds(10, 11, 800, 600);
		mainPane.add("Monster Database", monsterPane);
		JButton getList = new JButton("Get All Monsters");    
		getList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getList.setBounds(10, 304, 224, 40);
		getList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					getInfo();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					
				}
			}
		});
		monsterPane.setLayout(null);
		monsterPane.add(getList);

		monsterList = new DefaultListModel();		
		monsterTable = new JList(monsterList);
		monsterTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		monsterTable.setBounds(10, 11, 780, 282);
		monsterTable.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	selectList.addElement(monsterTable.getSelectedValue().toString());		        	
		        }
		    }
		});
		monsterPane.add(monsterTable);
		
		selectList = new DefaultListModel();
		selectTable = new JList(selectList);
		selectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectTable.setBounds(10, 355, 780, 234);
		selectTable.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	selectList.removeElement(selectTable.getSelectedValue().toString());		        	
		        }
		    }
		});
		monsterPane.add(selectTable);
		
		JButton FightBtn = new JButton("Fight");
		FightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPane.setSelectedComponent(battlePane);
			}
		});
		FightBtn.setBounds(298, 304, 224, 40);
		monsterPane.add(FightBtn);	
	}
	
	public void getInfo() throws ClassNotFoundException {
		try {
		      Class.forName("org.sqlite.JDBC" );
		  } catch (Exception e) {
		      System.err.println("ERROR: failed to load sqlite JDBC driver.");
		      e.printStackTrace();
		      return;
		  }
		try
	    {
		      
		  Connection connection = null;
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sean.beckstead\\MySQLiteDB\\test.db");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.   
	      monsterList.addElement("test");  
	      monsterList.clear();
	      ResultSet rs = statement.executeQuery("select * from Monsters");
	      while(rs.next())
	      {        
	    	  // read the result set
	    	  monsterList.addElement("Name: " + rs.getString("Name") + " | " + "Type: " + rs.getString("Type") + " | " + "Level: " + rs.getInt("Level") + " | " + "HP: " + rs.getInt("HP"));
	    	 	       
	      }
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    } 
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	}
}
