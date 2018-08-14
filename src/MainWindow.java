import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
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
import javax.swing.JSpinner;
import javax.swing.AbstractListModel;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private static Connection connection;
	private JList<String> monsterTable;
	private JList<String> selectMTable;
	private DefaultListModel<String> monsterList;
	private DefaultListModel<String> selectMList;
	private DefaultListModel<String> playerList;
	private DefaultListModel<String> selectPList;
	private DefaultListModel<String> sCondList;
	private DefaultListModel<String> aCondList;
	private DefaultListModel<String> partyList;
	private DefaultListModel<String> enemyList;
	private DefaultListModel<String> iniList;
	private DefaultListModel<String> durationList;
	private DefaultListModel<String> cCondList;
	private final JTabbedPane mainPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel homePane = new JPanel();
	private final JPanel playerPane = new JPanel();
	private final JPanel monsterPane = new JPanel();
	private final JPanel battlePane = new JPanel();
	private Player[] players = new Player[50];
	private Monster[] monsters = new Monster[50];
	private JList<String> partyTable;
	private JList<String> enemyTable;
	private JList<String> sCondTable;
	private JList<String> aCondTable;
	private JList<String> iniTable;
	private JList<String> durationTable;
	private JList<String> cCondTable;
	private JSpinner sSpinHp;
	private JSpinner cSpinHp;
	private JLabel sLbl;
	private JTextField sTxtIni;
	private JTextField cTxtIni;
	private JTextArea cTxtAbility;
	private JTextArea sTxtAbility;
	private JList<String> playerTable;
	private JButton getPList;
	private JButton fightPBtn;
	private JList<String> selectPTable;
	private JLabel nameLbl;
	private JLabel sideLbl;
	private JLabel typeLbl;
	private JLabel nameLblc;
	private JLabel sideLblc;
	private JLabel typeLblc;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnStart;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTextField sTxtStr;
	private JTextField sTxtCont;
	private JTextField sTxtDex;
	private JTextField sTxtWis;
	private JTextField sTxtChar;
	private JTextField sTxtIntel;
	private JLabel lblIntelligence;
	private JTextField sTxtAc;
	private JTextField sTxtFort;
	private JTextField sTxtWill;
	private JTextField sTxtRef;
	private JLabel lblFortitude;
	private JLabel lblAc;
	private JLabel lblFortitude_1;
	private JLabel lblWill;
	private JTextField cTxtWill;
	private JTextField cTxtFort;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField cTxtRef;
	private JLabel label_6;
	private JLabel label_7;
	private JTextField cTxtAc;
	private JTextField cTxtIntel;
	private JTextField cTxtChar;
	private JTextField cTxtWis;
	private JTextField cTxtDex;
	private JTextField cTxtStr;
	private JTextField cTxtCont;
	private JTextField sTxtSpeed;
	private JTextField cTxtSpeed;
	
	
	public MainWindow() {		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(10, 10, 1600, 900);
		getContentPane().add(mainPane);
		mainPane.setBounds(10, 0, 1024, 768);
		setupHomePane();
		setupBattlePane();
		setupPlayerPane();
		setupMonsterPane();
		
	}
	
	public void setupHomePane() {
		homePane.setBounds(10, 11, 1024, 768);
		mainPane.add("Home", homePane);	
	}	
	
	public void setupBattlePane() {
		battlePane.setBorder(null);
		battlePane.setBounds(10, 11, 1024, 800);			
		mainPane.add("Battle", battlePane);
		battlePane.setLayout(null);
		partyList = new DefaultListModel<String>();
		partyList.addElement("Select Players");
		sCondList = new DefaultListModel<String>();
		aCondList = new DefaultListModel<String>();
		enemyList = new DefaultListModel<String>();
		enemyList.addElement("Select Enemies");
		

		durationList = new DefaultListModel<String>();
		
		iniList = new DefaultListModel<String>();
		
		cCondList = new DefaultListModel<String>();
	}
	
	public void setupPlayerPane() {
		playerPane.setBounds(10, 11, 1024, 768);
		mainPane.add("Player Database", playerPane);	
		playerPane.setLayout(null);
		
		playerList = new DefaultListModel<String>();
		playerTable = new JList<String>(playerList);
		playerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {
		        	selectPList.addElement(playerTable.getSelectedValue().toString());		        	
		        }
			}
		});
		playerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		playerTable.setBounds(12, 13, 780, 282);
		playerPane.add(playerTable);
		
		getPList = new JButton("Get All Players");
		getPList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {					
					ResultSet tmp = getInfo("Select * from Players");
					playerList.addElement("test");  
					playerList.clear();
					partyList.clear();
				    while(tmp.next())
				    {        
				    	// read the result set
				    	playerList.addElement("Name: " + tmp.getString("Name") + " - " + "Type: " + tmp.getString("Type") + " - " + "Level: " + tmp.getInt("Level") + " - " + "HP: " + tmp.getInt("HP"));
				    }	
				    
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		});
		getPList.setBounds(12, 306, 224, 40);
		playerPane.add(getPList);
		
		fightPBtn = new JButton("Fight");
		fightPBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				partyList.clear();
				players = new Player[50];
				String tmpStr;
				String[] strArr1;
				String[] tmpName;
				ResultSet tmpRs;
				int sameCount = 0;
				for (int i = 0; i < selectPList.getSize(); i++) {
					tmpStr = selectPList.get(i).toString();					
					strArr1 = tmpStr.split("-");
					tmpName = strArr1[0].split(":");					
					try {
						tmpRs = getInfo("Select * from Players Where Name = '" + tmpName[1].toString().trim() + "'");						
						if (i > 0) {
							sameCount = 1;
							for (int x = 0; x < i; x++) {
								if (players[x].getName().contains(tmpName[1].toString().trim())) {									
									sameCount ++;
								}								
							}
							if (sameCount > 1) {
								tmpName[1] = tmpName[1].toString().trim() + sameCount + "";
							}
						}
						players[i] = new Player(tmpName[1].toString().trim(), tmpRs.getString("type"), tmpRs.getInt("hp"), tmpRs.getInt("Speed"), tmpRs.getInt("Initiative"), tmpRs.getInt("Strength"), tmpRs.getInt("Constitution"), tmpRs.getInt("Wisdom"), tmpRs.getInt("Intelligence"), tmpRs.getInt("Dexterity"), tmpRs.getInt("Charisma"), tmpRs.getInt("AC"), tmpRs.getInt("Reflex"), tmpRs.getInt("Fortitude"), tmpRs.getInt("Will"), tmpRs.getString("Abilities"));					
					    partyList.addElement(players[i].getName()); 
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}					
				}
				mainPane.setSelectedComponent(battlePane);
			}
		});
		fightPBtn.setBounds(300, 306, 224, 40);
		playerPane.add(fightPBtn);
		
		selectPList = new DefaultListModel<String>();
		selectPTable = new JList<String>(selectPList);
		selectPTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {
		        	selectPList.removeElement(selectPTable.getSelectedValue().toString());		        	
		        }
			}
		});
		selectPTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectPTable.setBounds(12, 357, 780, 234);
		playerPane.add(selectPTable);
	}
	
	public void setupMonsterPane() {
		
		monsterPane.setBounds(10, 11, 1024, 768);
		mainPane.add("Monster Database", monsterPane);
		JButton getMList = new JButton("Get All Monsters"); 		
		getMList.setBounds(10, 304, 224, 40);
		getMList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {					
					ResultSet tmp = getInfo("Select * from Monsters");
					monsterList.addElement("test");  
				    monsterList.clear();
				    enemyList.clear();
				    while(tmp.next())
				    {        
				    	// read the result set
				    	monsterList.addElement("Name: " + tmp.getString("Name") + " - " + "Type: " + tmp.getString("Type") + " - " + "Level: " + tmp.getInt("Level") + " - " + "HP: " + tmp.getInt("HP"));
				    }	
				    
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		});
		monsterPane.setLayout(null);
		monsterPane.add(getMList);

		monsterList = new DefaultListModel<String>();		
		monsterTable = new JList<String>(monsterList);
		monsterTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		monsterTable.setBounds(10, 11, 780, 282);
		monsterTable.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {
		        	selectMList.addElement(monsterTable.getSelectedValue().toString());		        	
		        }
		    }
		});
		monsterPane.add(monsterTable);
		
		selectMList = new DefaultListModel<String>();
		selectMTable = new JList<String>(selectMList);
		selectMTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectMTable.setBounds(10, 355, 780, 234);
		selectMTable.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {
		        	selectMList.removeElement(selectMTable.getSelectedValue().toString());		        	
		        }
		    }
		});
		monsterPane.add(selectMTable);
		
		JButton fightMBtn = new JButton("Fight");
		fightMBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				enemyList.clear();
				monsters = new Monster[50];
				String tmpStr;
				String[] strArr1;
				String[] tmpName;
				ResultSet tmpRs;
				int sameCount = 0;
				for (int i = 0; i < selectMList.getSize(); i++) {
					tmpStr = selectMList.get(i).toString();					
					strArr1 = tmpStr.split("-");
					tmpName = strArr1[0].split(":");					
					try {
						tmpRs = getInfo("Select * from Monsters Where Name = '" + tmpName[1].toString().trim() + "'");						
						if (i > 0) {
							sameCount = 1;
							for (int x = 0; x < i; x++) {
								if (monsters[x].getName().contains(tmpName[1].toString().trim())) {									
									sameCount ++;
								}								
							}
							if (sameCount > 1) {
								tmpName[1] = tmpName[1].toString().trim() + sameCount + "";
							}
						}
						monsters[i] = new Monster(tmpName[1].toString().trim(), tmpRs.getString("type"), tmpRs.getInt("hp"), tmpRs.getInt("Speed"), tmpRs.getInt("Initiative"), tmpRs.getInt("Strength"), tmpRs.getInt("Constitution"), tmpRs.getInt("Wisdom"), tmpRs.getInt("Intelligence"), tmpRs.getInt("Dexterity"), tmpRs.getInt("Charisma"), tmpRs.getInt("AC"), tmpRs.getInt("Reflex"), tmpRs.getInt("Fortitude"), tmpRs.getInt("Will"), tmpRs.getString("Abilities"));					
					    enemyList.addElement(monsters[i].getName()); 
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					
				}
				mainPane.setSelectedComponent(battlePane);
			}
		});
		fightMBtn.setBounds(298, 304, 224, 40);
		monsterPane.add(fightMBtn);	
		sCondTable = new JList<String>(sCondList);
		sCondTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
		        	sCondList.removeElement(sCondTable.getSelectedValue().toString());		        	
		        }
			}
		});
		sCondTable.setBounds(225, 312, 350, 125);
		battlePane.add(sCondTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 359, 150, 144);
		battlePane.add(scrollPane);
		aCondTable = new JList(new AbstractListModel() {
			String[] values = new String[] {"Blinded", "Dazed", "Deafened", "Dominated", "Dying", "Grabbed", "Helpless", "Immobilized", "Marked", "Petrified", "Poisoned", "Prone", "Reduced AC", "Reduced ATK", "Reduced Reflex", "Reduced Will", "Reduced Fort", "Removed From Play", "Restrained", "Slowed", "Stunned", "Surprised", "Unconsious", "Weakened", ""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(aCondTable);
		aCondTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		aCondTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {
		        	sCondList.addElement(aCondTable.getSelectedValue().toString());		        	
		        }
			}
		});			
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 30, 203, 125);
		battlePane.add(scrollPane_3);
		partyTable = new JList<String>(partyList);		
		scrollPane_3.setViewportView(partyTable);
		partyTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		partyTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				updateChar();
				enemyTable.clearSelection();
				if (partyTable.getSelectedValue().toString() != "Select Players") {
					for (int i = 0; i < partyList.getSize(); i++) {
						if (players[i].getName() == partyTable.getSelectedValue().toString()) {
							sTxtIni.setText(players[i].getInitiative() + "");
							sTxtStr.setText(players[i].getStrength() + "");
							sTxtCont.setText(players[i].getConstitution() + "");
							sTxtDex.setText(players[i].getDexterity() + "");
							sTxtWis.setText(players[i].getWisdom() + "");
							sTxtIntel.setText(players[i].getIntelligence() + "");
							sTxtChar.setText(players[i].getCharisma() + "");
							sTxtAc.setText(players[i].getAc() + "");
							sTxtRef.setText(players[i].getReflex() + "");
							sTxtFort.setText(players[i].getFortitude() + "");
							sTxtWill.setText(players[i].getWill() + "");
							sTxtAbility.setText(players[i].getAbilities());
							sTxtSpeed.setText(players[i].getSpeed() + "");
							sSpinHp.setValue(players[i].getHp());
							nameLbl.setText(players[i].getName());
							typeLbl.setText(players[i].getType());
							sideLbl.setText("Party");
							sCondList.clear();
							String[] tmpCond = players[i].getConditions();
							for (int x = 0; x < tmpCond.length; x++) {
								sCondList.addElement(tmpCond[x]);
							}
						}
					}
				}
			}
		});
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 194, 203, 125);
		battlePane.add(scrollPane_2);
		enemyTable = new JList<String>(enemyList);
		scrollPane_2.setViewportView(enemyTable);
		
		
		
		//Mouse click listeners on Tables
		enemyTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateChar();
				partyTable.clearSelection();				
				if (enemyTable.getSelectedValue().toString() != "Select Enemies") {
					for (int i = 0; i < enemyList.getSize(); i++) {
						if (monsters[i].getName() == enemyTable.getSelectedValue().toString()) {
							sTxtIni.setText(monsters[i].getInitiative() + "");
							sTxtStr.setText(monsters[i].getStrength() + "");
							sTxtCont.setText(monsters[i].getConstitution() + "");
							sTxtDex.setText(monsters[i].getDexterity() + "");
							sTxtWis.setText(monsters[i].getWisdom() + "");
							sTxtIntel.setText(monsters[i].getIntelligence() + "");
							sTxtChar.setText(monsters[i].getCharisma() + "");
							sTxtAc.setText(monsters[i].getAc() + "");
							sTxtRef.setText(monsters[i].getReflex() + "");
							sTxtFort.setText(monsters[i].getFortitude() + "");
							sTxtWill.setText(monsters[i].getWill() + "");
							sTxtAbility.setText(monsters[i].getAbilities());
							sTxtSpeed.setText(monsters[i].getSpeed() + "");
							sSpinHp.setValue(monsters[i].getHp());							
							nameLbl.setText(monsters[i].getName());
							typeLbl.setText(monsters[i].getType());
							sideLbl.setText("Enemy");
							sCondList.clear();
							String[] tmpCond = monsters[i].getConditions();
							for (int x = 0; x < tmpCond.length; x++) {
								sCondList.addElement(tmpCond[x]);
							}
						}
					}
				}				
			}
		});
		
		sTxtIni = new JTextField();
		sTxtIni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateChar();
			}
		});
		sTxtIni.setColumns(10);
		sTxtIni.setBounds(232, 102, 50, 22);
		battlePane.add(sTxtIni);
		
		sSpinHp = new JSpinner();
		sSpinHp.setBounds(531, 102, 44, 22);
		battlePane.add(sSpinHp);
		
		//LABELS
		JLabel lblEnemyHp = new JLabel("HP");
		lblEnemyHp.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyHp.setBounds(531, 80, 44, 16);
		battlePane.add(lblEnemyHp);		
		JLabel lblEnemyIni = new JLabel("Initiative");
		lblEnemyIni.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyIni.setBounds(232, 80, 50, 16);
		battlePane.add(lblEnemyIni);		
		sLbl = new JLabel("Selected Player");
		sLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		sLbl.setBounds(225, 13, 350, 16);
		battlePane.add(sLbl);		
		JLabel label = new JLabel("Active Conditions");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(225, 295, 350, 16);
		battlePane.add(label);
		JLabel partyLbl = new JLabel("Party List");
		partyLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		partyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		partyLbl.setBounds(10, 13, 203, 14);
		battlePane.add(partyLbl);
		JLabel enemyLbl = new JLabel("Enemy List");
		enemyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		enemyLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		enemyLbl.setBounds(10, 177, 203, 14);
		battlePane.add(enemyLbl);
		JLabel conditionLbl = new JLabel("Condition List");
		conditionLbl.setHorizontalAlignment(SwingConstants.CENTER);
		conditionLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		conditionLbl.setBounds(32, 344, 100, 14);
		battlePane.add(conditionLbl);
		nameLbl = new JLabel("Name");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		nameLbl.setBounds(225, 32, 116, 16);
		battlePane.add(nameLbl);		
		sideLbl = new JLabel("Side");
		sideLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sideLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		sideLbl.setBounds(485, 32, 90, 16);
		battlePane.add(sideLbl);		
		typeLbl = new JLabel("Type");
		typeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		typeLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		typeLbl.setBounds(338, 32, 135, 16);
		battlePane.add(typeLbl);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(32, 673, 97, 25);
		battlePane.add(btnApply);
		durationTable = new JList(durationList);
		durationTable.setBounds(36, 516, 80, 144);
		battlePane.add(durationTable);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(1205, 29, 360, 162);
		battlePane.add(scrollPane_1);
		iniTable = new JList<String>(iniList);
		iniTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(iniTable);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tmpStr = iniList.firstElement();				
				String[] tmpArr;
				tmpArr = tmpStr.split(" ");
				iniList.addElement(tmpArr[0] + " " + tmpArr[1]);
				iniList.remove(0);
				tmpStr = iniList.firstElement();
				tmpStr = tmpStr + " <===";
				String[] tmpName = tmpStr.split(" ");
				iniList.set(0, tmpStr);
				boolean foundChar = false;
				for (int i = 0; i < enemyList.getSize(); i++) {
					if (monsters[i].getName().equalsIgnoreCase(tmpName[1].trim())) {
						cTxtIni.setText(monsters[i].getInitiative() + "");
						cTxtStr.setText(monsters[i].getStrength() + "");
						cTxtCont.setText(monsters[i].getConstitution() + "");
						cTxtDex.setText(monsters[i].getDexterity() + "");
						cTxtWis.setText(monsters[i].getWisdom() + "");
						cTxtIntel.setText(monsters[i].getIntelligence() + "");
						cTxtChar.setText(monsters[i].getCharisma() + "");
						cTxtAc.setText(monsters[i].getAc() + "");
						cTxtRef.setText(monsters[i].getReflex() + "");
						cTxtFort.setText(monsters[i].getFortitude() + "");
						cTxtWill.setText(monsters[i].getWill() + "");
						cTxtAbility.setText(monsters[i].getAbilities().toString());
						cTxtSpeed.setText(monsters[i].getSpeed() + "");
						cSpinHp.setValue(monsters[i].getHp());
						nameLblc.setText(monsters[i].getName());
						typeLblc.setText(monsters[i].getType());
						sideLblc.setText("Enemy");
						cCondList.clear();
						String[] tmpCond = monsters[i].getConditions();
						for (int x = 0; x < tmpCond.length; x++) {
							sCondList.addElement(tmpCond[x]);
						}
						foundChar = true;
					}
				}
				if (foundChar == false) {
					for (int i = 0; i < partyList.getSize(); i++) {
						if (players[i].getName().equalsIgnoreCase(tmpName[1].trim())) {
							cTxtIni.setText(players[i].getInitiative() + "");
							cTxtStr.setText(players[i].getStrength() + "");
							cTxtCont.setText(players[i].getConstitution() + "");
							cTxtDex.setText(players[i].getDexterity() + "");
							cTxtWis.setText(players[i].getWisdom() + "");
							cTxtIntel.setText(players[i].getIntelligence() + "");
							cTxtChar.setText(players[i].getCharisma() + "");
							cTxtAc.setText(players[i].getAc() + "");
							cTxtRef.setText(players[i].getReflex() + "");
							cTxtFort.setText(players[i].getFortitude() + "");
							cTxtWill.setText(players[i].getWill() + "");
							cTxtAbility.setText(players[i].getAbilities().toString());
							cTxtSpeed.setText(players[i].getSpeed() + "");
							cSpinHp.setValue(players[i].getHp());
							nameLblc.setText(players[i].getName());
							typeLblc.setText(players[i].getType());
							sideLblc.setText("Party");
							cCondList.clear();
							String[] tmpCond = players[i].getConditions();
							for (int x = 0; x < tmpCond.length; x++) {
								sCondList.addElement(tmpCond[x]);
							}
						}
					}
				}
			}
		});
		btnNext.setBounds(1335, 198, 97, 25);
		battlePane.add(btnNext);
		
		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tmpStr = iniList.firstElement();
				String[] tmpArr;
				tmpArr = tmpStr.split(" ");
				iniList.setElementAt(tmpArr[0] + " " + tmpArr[1], 0);
				tmpStr = iniList.lastElement();
				iniList.insertElementAt(tmpStr, 0);
				iniList.remove(iniList.getSize()-1);
				tmpStr = iniList.firstElement();
				tmpStr = tmpStr + " <===";
				String[] tmpName = tmpStr.split(" ");
				iniList.set(0, tmpStr);
				boolean foundChar = false;
				for (int i = 0; i < enemyList.getSize(); i++) {
					if (monsters[i].getName().equalsIgnoreCase(tmpName[1].trim())) {
						cTxtIni.setText(monsters[i].getInitiative() + "");
						cTxtStr.setText(monsters[i].getStrength() + "");
						cTxtCont.setText(monsters[i].getConstitution() + "");
						cTxtDex.setText(monsters[i].getDexterity() + "");
						cTxtWis.setText(monsters[i].getWisdom() + "");
						cTxtIntel.setText(monsters[i].getIntelligence() + "");
						cTxtChar.setText(monsters[i].getCharisma() + "");
						cTxtAc.setText(monsters[i].getAc() + "");
						cTxtRef.setText(monsters[i].getReflex() + "");
						cTxtFort.setText(monsters[i].getFortitude() + "");
						cTxtWill.setText(monsters[i].getWill() + "");
						cTxtAbility.setText(monsters[i].getAbilities().toString());
						cTxtSpeed.setText(monsters[i].getSpeed() + "");
						cSpinHp.setValue(monsters[i].getHp());
						nameLblc.setText(monsters[i].getName());
						typeLblc.setText(monsters[i].getType());
						sideLblc.setText("Enemy");
						cCondList.clear();
						String[] tmpCond = monsters[i].getConditions();
						for (int x = 0; x < tmpCond.length; x++) {
							cCondList.addElement(tmpCond[x]);
						}
						foundChar = true;
					}
				}
				if (foundChar == false) {
					for (int i = 0; i < partyList.getSize(); i++) {
						if (players[i].getName().equalsIgnoreCase(tmpName[1].trim())) {
							cTxtIni.setText(players[i].getInitiative() + "");
							cTxtStr.setText(players[i].getStrength() + "");
							cTxtCont.setText(players[i].getConstitution() + "");
							cTxtDex.setText(players[i].getDexterity() + "");
							cTxtWis.setText(players[i].getWisdom() + "");
							cTxtIntel.setText(players[i].getIntelligence() + "");
							cTxtChar.setText(players[i].getCharisma() + "");
							cTxtAc.setText(players[i].getAc() + "");
							cTxtRef.setText(players[i].getReflex() + "");
							cTxtFort.setText(players[i].getFortitude() + "");
							cTxtWill.setText(players[i].getWill() + "");
							cTxtAbility.setText(players[i].getAbilities().toString());
							cTxtSpeed.setText(players[i].getSpeed() + "");
							cSpinHp.setValue(players[i].getHp());
							nameLblc.setText(players[i].getName());
							typeLblc.setText(players[i].getType());
							sideLblc.setText("Party");
							cCondList.clear();
							String[] tmpCond = players[i].getConditions();
							for (int x = 0; x < tmpCond.length; x++) {
								cCondList.addElement(tmpCond[x]);
							}
						}
					}
				}
			}
		});
		btnLast.setBounds(1468, 198, 97, 25);
		battlePane.add(btnLast);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean iniChk = true;
				for (int i = 0; i < enemyList.getSize(); i++) {
					if (monsters[i].getInitiative() == 0) {
						iniChk = false;
					}
				}
				for (int i = 0; i < partyList.getSize(); i++) {
					if (players[i].getInitiative() == 0) {
						iniChk = false;
					}
				}
				if (iniChk == true) {
					iniList.clear();
					boolean chk = false;
					Player tmpP;
					Monster tmpM;
					while (chk == false) {
						chk = true;
						for (int i = 0; i < partyList.getSize() -1; i++) {
				            if (players[i].getInitiative() < players[i+1].getInitiative()) {
				                tmpP = players[i+1];
				                players[i+1] = players[i];
				                players[i] = tmpP;
				                chk = false;
				            }
						}
				        for (int i = 0; i < enemyList.getSize() -1; i++) {
					        if (monsters[i].getInitiative() < monsters[i+1].getInitiative()) {
					            tmpM = monsters[i+1];
					            monsters[i+1] = monsters[i];
					            monsters[i] = tmpM;
					            chk = false;
					        } 
				        }
					}
					int iniCountP = 0;
					int iniCountM = 0;
					chk = false;
					boolean outChk = false;
					while (chk == false) {
						if (iniCountP == partyList.getSize() && iniCountM < enemyList.getSize()) {
							iniList.addElement(monsters[iniCountM].getInitiative() + " " + monsters[iniCountM].getName());
							iniCountM ++;
							outChk = true;
						}
						if (iniCountM == enemyList.getSize() && iniCountP < partyList.getSize()) {
							iniList.addElement(players[iniCountP].getInitiative() + " " + players[iniCountP].getName());
							iniCountP ++;
							outChk = true;
						}
						if (iniCountP == partyList.getSize() && iniCountM == enemyList.getSize()) {
							chk = true;
						} 
						if (outChk == false) {
							if (players[iniCountP].getInitiative() < monsters[iniCountM].getInitiative()) {
								iniList.addElement(monsters[iniCountM].getInitiative() + " " + monsters[iniCountM].getName());
								iniCountM ++;
							} else {
								iniList.addElement(players[iniCountP].getInitiative() + " " + players[iniCountP].getName());
								iniCountP ++;
							}
						}
						
					}
					String tmpStr = iniList.firstElement();
					tmpStr = tmpStr + " <===";
					String[] tmpName = tmpStr.split(" ");
					iniList.set(0, tmpStr);
					boolean foundChar = false;
					for (int i = 0; i < enemyList.getSize(); i++) {
						if (monsters[i].getName().equalsIgnoreCase(tmpName[1].trim())) {
							cTxtIni.setText(monsters[i].getInitiative() + "");
							cTxtStr.setText(monsters[i].getStrength() + "");
							cTxtCont.setText(monsters[i].getConstitution() + "");
							cTxtDex.setText(monsters[i].getDexterity() + "");
							cTxtWis.setText(monsters[i].getWisdom() + "");
							cTxtIntel.setText(monsters[i].getIntelligence() + "");
							cTxtChar.setText(monsters[i].getCharisma() + "");
							cTxtAc.setText(monsters[i].getAc() + "");
							cTxtRef.setText(monsters[i].getReflex() + "");
							cTxtFort.setText(monsters[i].getFortitude() + "");
							cTxtWill.setText(monsters[i].getWill() + "");
							cTxtAbility.setText(monsters[i].getAbilities().toString());
							cTxtSpeed.setText(monsters[i].getSpeed() + "");
							cSpinHp.setValue(monsters[i].getHp());
							nameLblc.setText(monsters[i].getName());
							typeLblc.setText(monsters[i].getType());
							sideLblc.setText("Enemy");
							cCondList.clear();
							String[] tmpCond = monsters[i].getConditions();
							for (int x = 0; x < tmpCond.length; x++) {
								cCondList.addElement(tmpCond[x]);
							}
							foundChar = true;
						}
					}
					if (foundChar == false) {
						for (int i = 0; i < partyList.getSize(); i++) {
							if (players[i].getName().equalsIgnoreCase(tmpName[1].trim())) {
								cTxtIni.setText(players[i].getInitiative() + "");
								cTxtStr.setText(players[i].getStrength() + "");
								cTxtCont.setText(players[i].getConstitution() + "");
								cTxtDex.setText(players[i].getDexterity() + "");
								cTxtWis.setText(players[i].getWisdom() + "");
								cTxtIntel.setText(players[i].getIntelligence() + "");
								cTxtChar.setText(players[i].getCharisma() + "");
								cTxtAc.setText(players[i].getAc() + "");
								cTxtRef.setText(players[i].getReflex() + "");
								cTxtFort.setText(players[i].getFortitude() + "");
								cTxtWill.setText(players[i].getWill() + "");
								cTxtAbility.setText(players[i].getAbilities().toString());
								cTxtSpeed.setText(players[i].getSpeed() + "");
								cSpinHp.setValue(players[i].getHp());
								nameLblc.setText(players[i].getName());
								typeLblc.setText(players[i].getType());
								sideLblc.setText("Party");
								cCondList.clear();
								String[] tmpCond = players[i].getConditions();
								for (int x = 0; x < tmpCond.length; x++) {
									cCondList.addElement(tmpCond[x]);
								}
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(null,"please set initiatives");
				}
				
			}
		});
		btnStart.setBounds(1205, 198, 97, 25);
		battlePane.add(btnStart);
		
		JLabel lblInitiativeOrder = new JLabel("Initiative Order");
		lblInitiativeOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblInitiativeOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInitiativeOrder.setBounds(1316, 13, 159, 14);
		battlePane.add(lblInitiativeOrder);
		cCondTable = new JList<String>(cCondList);
		cCondTable.setBounds(682, 312, 350, 125);
		battlePane.add(cCondTable);
		
		cTxtIni = new JTextField();
		cTxtIni.setColumns(10);
		cTxtIni.setBounds(689, 102, 50, 22);
		battlePane.add(cTxtIni);
		
		JLabel label_1 = new JLabel("Active Conditions");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(682, 295, 350, 16);
		battlePane.add(label_1);
		
		cSpinHp = new JSpinner();
		cSpinHp.setBounds(988, 102, 44, 22);
		battlePane.add(cSpinHp);
		
		JLabel label_2 = new JLabel("HP");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(988, 80, 44, 16);
		battlePane.add(label_2);
		
		JLabel label_3 = new JLabel("Initiative");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(689, 80, 50, 16);
		battlePane.add(label_3);
		
		JLabel lblCurrentPlayer = new JLabel("Current Player");
		lblCurrentPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPlayer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentPlayer.setBounds(682, 13, 350, 16);
		battlePane.add(lblCurrentPlayer);
		
		nameLblc = new JLabel("Name");
		nameLblc.setHorizontalAlignment(SwingConstants.CENTER);
		nameLblc.setFont(new Font("Tahoma", Font.BOLD, 13));
		nameLblc.setBounds(682, 32, 116, 16);
		battlePane.add(nameLblc);
		
		typeLblc = new JLabel("Type");
		typeLblc.setHorizontalAlignment(SwingConstants.CENTER);
		typeLblc.setFont(new Font("Tahoma", Font.BOLD, 13));
		typeLblc.setBounds(808, 32, 122, 16);
		battlePane.add(typeLblc);
		
		sideLblc = new JLabel("Side");
		sideLblc.setHorizontalAlignment(SwingConstants.CENTER);
		sideLblc.setFont(new Font("Tahoma", Font.BOLD, 13));
		sideLblc.setBounds(942, 32, 90, 16);
		battlePane.add(sideLblc);
		
		sTxtStr = new JTextField();
		sTxtStr.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				updateChar();
			}
		});
		sTxtStr.setColumns(10);
		sTxtStr.setBounds(232, 159, 50, 22);
		battlePane.add(sTxtStr);
		
		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setHorizontalAlignment(SwingConstants.CENTER);
		lblStrength.setBounds(232, 137, 50, 16);
		battlePane.add(lblStrength);
		
		sTxtCont = new JTextField();
		sTxtCont.setColumns(10);
		sTxtCont.setBounds(232, 209, 50, 22);
		battlePane.add(sTxtCont);
		
		JLabel lblConstitution = new JLabel("Constitution");
		lblConstitution.setHorizontalAlignment(SwingConstants.CENTER);
		lblConstitution.setBounds(225, 187, 67, 16);
		battlePane.add(lblConstitution);
		
		sTxtDex = new JTextField();
		sTxtDex.setColumns(10);
		sTxtDex.setBounds(312, 159, 50, 22);
		battlePane.add(sTxtDex);
		
		JLabel lblDexterity = new JLabel("Dexterity");
		lblDexterity.setHorizontalAlignment(SwingConstants.CENTER);
		lblDexterity.setBounds(312, 137, 50, 16);
		battlePane.add(lblDexterity);
		
		sTxtWis = new JTextField();
		sTxtWis.setColumns(10);
		sTxtWis.setBounds(312, 209, 50, 22);
		battlePane.add(sTxtWis);
		
		JLabel lblWisdom = new JLabel("Wisdom");
		lblWisdom.setHorizontalAlignment(SwingConstants.CENTER);
		lblWisdom.setBounds(312, 187, 50, 16);
		battlePane.add(lblWisdom);
		
		sTxtChar = new JTextField();
		sTxtChar.setColumns(10);
		sTxtChar.setBounds(232, 265, 50, 22);
		battlePane.add(sTxtChar);
		
		JLabel lblCharisma = new JLabel("Charisma");
		lblCharisma.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharisma.setBounds(225, 243, 66, 16);
		battlePane.add(lblCharisma);
		
		sTxtIntel = new JTextField();
		sTxtIntel.setColumns(10);
		sTxtIntel.setBounds(312, 265, 50, 22);
		battlePane.add(sTxtIntel);
		
		lblIntelligence = new JLabel("Intelligence");
		lblIntelligence.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntelligence.setBounds(303, 243, 69, 16);
		battlePane.add(lblIntelligence);
		
		sTxtAc = new JTextField();
		sTxtAc.setColumns(10);
		sTxtAc.setBounds(445, 159, 50, 22);
		battlePane.add(sTxtAc);
		
		sTxtFort = new JTextField();
		sTxtFort.setColumns(10);
		sTxtFort.setBounds(445, 209, 50, 22);
		battlePane.add(sTxtFort);
		
		sTxtWill = new JTextField();
		sTxtWill.setColumns(10);
		sTxtWill.setBounds(525, 209, 50, 22);
		battlePane.add(sTxtWill);
		
		sTxtRef = new JTextField();
		sTxtRef.setColumns(10);
		sTxtRef.setBounds(525, 159, 50, 22);
		battlePane.add(sTxtRef);
		
		lblFortitude = new JLabel("Reflex");
		lblFortitude.setHorizontalAlignment(SwingConstants.CENTER);
		lblFortitude.setBounds(525, 137, 50, 16);
		battlePane.add(lblFortitude);
		
		lblAc = new JLabel("AC");
		lblAc.setHorizontalAlignment(SwingConstants.CENTER);
		lblAc.setBounds(445, 137, 50, 16);
		battlePane.add(lblAc);
		
		lblFortitude_1 = new JLabel("Fortitude");
		lblFortitude_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFortitude_1.setBounds(438, 187, 67, 16);
		battlePane.add(lblFortitude_1);
		
		lblWill = new JLabel("Will");
		lblWill.setHorizontalAlignment(SwingConstants.CENTER);
		lblWill.setBounds(525, 187, 50, 16);
		battlePane.add(lblWill);
		
		cTxtWill = new JTextField();
		cTxtWill.setColumns(10);
		cTxtWill.setBounds(982, 209, 50, 22);
		battlePane.add(cTxtWill);
		
		cTxtFort = new JTextField();
		cTxtFort.setColumns(10);
		cTxtFort.setBounds(902, 209, 50, 22);
		battlePane.add(cTxtFort);
		
		label_4 = new JLabel("Fortitude");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(895, 187, 67, 16);
		battlePane.add(label_4);
		
		label_5 = new JLabel("Will");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(982, 187, 50, 16);
		battlePane.add(label_5);
		
		cTxtRef = new JTextField();
		cTxtRef.setColumns(10);
		cTxtRef.setBounds(982, 159, 50, 22);
		battlePane.add(cTxtRef);
		
		label_6 = new JLabel("Reflex");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(982, 137, 50, 16);
		battlePane.add(label_6);
		
		label_7 = new JLabel("AC");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(902, 137, 50, 16);
		battlePane.add(label_7);
		
		cTxtAc = new JTextField();
		cTxtAc.setColumns(10);
		cTxtAc.setBounds(902, 159, 50, 22);
		battlePane.add(cTxtAc);
		
		cTxtIntel = new JTextField();
		cTxtIntel.setColumns(10);
		cTxtIntel.setBounds(769, 265, 50, 22);
		battlePane.add(cTxtIntel);
		
		cTxtChar = new JTextField();
		cTxtChar.setColumns(10);
		cTxtChar.setBounds(689, 265, 50, 22);
		battlePane.add(cTxtChar);
		
		JLabel label_8 = new JLabel("Charisma");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(682, 243, 66, 16);
		battlePane.add(label_8);
		
		JLabel label_9 = new JLabel("Intelligence");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(760, 243, 69, 16);
		battlePane.add(label_9);
		
		cTxtWis = new JTextField();
		cTxtWis.setColumns(10);
		cTxtWis.setBounds(769, 209, 50, 22);
		battlePane.add(cTxtWis);
		
		JLabel label_10 = new JLabel("Wisdom");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(769, 187, 50, 16);
		battlePane.add(label_10);
		
		cTxtDex = new JTextField();
		cTxtDex.setColumns(10);
		cTxtDex.setBounds(769, 159, 50, 22);
		battlePane.add(cTxtDex);
		
		JLabel label_11 = new JLabel("Dexterity");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(769, 137, 50, 16);
		battlePane.add(label_11);
		
		JLabel label_12 = new JLabel("Strength");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(689, 137, 50, 16);
		battlePane.add(label_12);
		
		cTxtStr = new JTextField();
		cTxtStr.setColumns(10);
		cTxtStr.setBounds(689, 159, 50, 22);
		battlePane.add(cTxtStr);
		
		JLabel label_13 = new JLabel("Constitution");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(682, 187, 67, 16);
		battlePane.add(label_13);
		
		cTxtCont = new JTextField();
		cTxtCont.setColumns(10);
		cTxtCont.setBounds(689, 209, 50, 22);
		battlePane.add(cTxtCont);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_4.setBounds(682, 462, 350, 130);
		battlePane.add(scrollPane_4);
		
		cTxtAbility = new JTextArea();
		cTxtAbility.setLineWrap(true);
		cTxtAbility.setWrapStyleWord(true);
		scrollPane_4.setViewportView(cTxtAbility);
		
		JLabel lblAbilities = new JLabel("Abilities");
		lblAbilities.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilities.setBounds(682, 447, 350, 16);
		battlePane.add(lblAbilities);
		
		JLabel label_14 = new JLabel("Abilities");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(225, 447, 350, 16);
		battlePane.add(label_14);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_5.setBounds(227, 462, 348, 128);
		battlePane.add(scrollPane_5);
		
		sTxtAbility = new JTextArea();
		sTxtAbility.setLineWrap(true);
		sTxtAbility.setWrapStyleWord(true);
		scrollPane_5.setViewportView(sTxtAbility);
		
		sTxtSpeed = new JTextField();
		sTxtSpeed.setColumns(10);
		sTxtSpeed.setBounds(312, 102, 50, 22);
		battlePane.add(sTxtSpeed);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpeed.setBounds(312, 80, 50, 16);
		battlePane.add(lblSpeed);
		
		cTxtSpeed = new JTextField();
		cTxtSpeed.setColumns(10);
		cTxtSpeed.setBounds(769, 102, 50, 22);
		battlePane.add(cTxtSpeed);
		
		JLabel label_15 = new JLabel("Speed");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(769, 80, 50, 16);
		battlePane.add(label_15);
		
	}
			
	public void updateChar() {		
		if (sideLbl.getText().equalsIgnoreCase("party")) {
			for (int i = 0; i < partyList.getSize(); i++){
				if (players[i].getName() == nameLbl.getText()) {
					players[i].setHp((int) sSpinHp.getValue());
					players[i].setInitiative(Integer.parseInt(sTxtIni.getText()));
					players[i].setStrength(Integer.parseInt(sTxtStr.getText()));
					players[i].setConstitution(Integer.parseInt(sTxtCont.getText()));
					players[i].setDexterity(Integer.parseInt(sTxtDex.getText()));
					players[i].setWisdom(Integer.parseInt(sTxtWis.getText()));
					players[i].setIntelligence(Integer.parseInt(sTxtIntel.getText()));
					players[i].setCharisma(Integer.parseInt(sTxtChar.getText()));
					players[i].setAc(Integer.parseInt(sTxtAc.getText()));
					players[i].setFortitude(Integer.parseInt(sTxtFort.getText()));
					players[i].setWill(Integer.parseInt(sTxtWill.getText()));
					players[i].setReflex(Integer.parseInt(sTxtRef.getText()));
					players[i].setSpeed(Integer.parseInt(sTxtSpeed.getText()));
				}
			}
		} else {
			for (int i = 0; i < enemyList.getSize(); i++){
				if (monsters[i].getName() == nameLbl.getText()) {
					monsters[i].setHp((int) sSpinHp.getValue());
					monsters[i].setInitiative(Integer.parseInt(sTxtIni.getText()));
					monsters[i].setStrength(Integer.parseInt(sTxtStr.getText()));
					monsters[i].setConstitution(Integer.parseInt(sTxtCont.getText()));
					monsters[i].setDexterity(Integer.parseInt(sTxtDex.getText()));
					monsters[i].setWisdom(Integer.parseInt(sTxtWis.getText()));
					monsters[i].setIntelligence(Integer.parseInt(sTxtIntel.getText()));
					monsters[i].setCharisma(Integer.parseInt(sTxtChar.getText()));
					monsters[i].setAc(Integer.parseInt(sTxtAc.getText()));
					monsters[i].setFortitude(Integer.parseInt(sTxtFort.getText()));
					monsters[i].setWill(Integer.parseInt(sTxtWill.getText()));
					monsters[i].setReflex(Integer.parseInt(sTxtRef.getText()));	
					monsters[i].setSpeed(Integer.parseInt(sTxtSpeed.getText()));				
				}
			}
		}
	}
	
	public ResultSet getInfo(String state) throws ClassNotFoundException {
		ResultSet rs = null;
		try {
		      Class.forName("org.sqlite.JDBC" );
		  } catch (Exception e) {
		      System.err.println("ERROR: failed to load sqlite JDBC driver.");
		      e.printStackTrace();
		      return rs;
		  }
		try
	    {
		      
		  Connection connection = null;
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:D:\\workspace\\SQLite DBs\\DnD\\DnD.db");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec. 
	     
	      rs = statement.executeQuery(state);
	           
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
		return rs;
	}
}
