import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;

public class ListByBirthdayWindow extends JFrame{
	private JButton btnBackToHomePage;	
	
	private DefaultTableModel defaultTableModel;
	private JTable contactsTable;
	
	public ListByBirthdayWindow(){
		setSize(1100,750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		JLabel lblListByName = new JLabel("LIST CONTACTS BY BIRTHDAY",SwingConstants.CENTER);
		lblListByName.setFont(new Font("Tahoma",Font.BOLD,40));
		lblListByName.setOpaque(true);
		lblListByName.setBackground(new Color(150,210,255));
		lblListByName.setPreferredSize(new Dimension(0,80));
		add(lblListByName,BorderLayout.NORTH);
		
		String[] columnNames = {"Contact ID","Name","Contact Number","Company","Salary","Birthday"};
		defaultTableModel = new DefaultTableModel(columnNames,0);
		
		contactsTable = new JTable(defaultTableModel);
		contactsTable.setFont(new Font("SansSerif",Font.BOLD,18));
		contactsTable.setRowHeight(30);
		contactsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		for (int i = 0; i < contactsTable.getColumnCount(); i++){
			TableColumn tableColumn = contactsTable.getColumnModel().getColumn(i);
			switch(i){
				case 0 : tableColumn.setPreferredWidth(120);break;				
				case 1 : 
				case 2 : 
				case 3 : 
				case 4 : 
				case 5 : tableColumn.setPreferredWidth(180);
			}
		}
		
		
		for (int i = 0; i < contactsTable.getColumnCount(); i++){
			TableColumn tableColumn = contactsTable.getColumnModel().getColumn(i);
			DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
			
			switch(i){
				case 0 :
				case 2 :
				case 5 : {
					cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				}
				break;
				case 1 :
				case 3 : {
					cellRenderer.setHorizontalAlignment(SwingConstants.LEFT);
				}
				break;
				case 4 : {
					cellRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
				}
			}
			tableColumn.setCellRenderer(cellRenderer);
		}
		
		
		JTableHeader tableHeader = contactsTable.getTableHeader();
		tableHeader.setReorderingAllowed(false);
		tableHeader.setBackground(new Color(111,111,108));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(new Font("SansSerif",Font.BOLD,20));
		tableHeader.setPreferredSize(new Dimension(tableHeader.getPreferredSize().width,40));
		
		JScrollPane scrollPane = new JScrollPane(contactsTable);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(40,40,40,40),scrollPane.getBorder()));
		
		add(scrollPane,BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,30));
		
		btnBackToHomePage = new JButton("Back To HomePage");
		btnBackToHomePage.setFont(new Font("Tahoma",Font.BOLD,30));
		btnBackToHomePage.setPreferredSize(new Dimension(400,50));
		btnBackToHomePage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				IFriendContactManager.getHomePageWindow().setVisible(true);
			}
		});
		southPanel.add(btnBackToHomePage);
		
		add(southPanel,BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosed(WindowEvent evt){
				IFriendContactManager.getHomePageWindow().setVisible(true);
			}
		});
		
		Contact[] contactDbListedByBirthaday = listContactsByBirthday();
		
		for (int i = 0; i < contactDbListedByBirthaday.length; i++){
			Contact contact = contactDbListedByBirthaday[i];
			Object[] rowData = contact.getContactDetails();
			defaultTableModel.addRow(rowData);
		}
		
		setVisible(true);
	}
	
	private Contact[] listContactsByBirthday(){
		Contact[] tempContactsArray = ListByNameWindow.listContactsByName();
		
		for (int i = tempContactsArray.length-1; i > 0; i--){
			for (int j = 0; j < i; j++){
				int valueOfCompareTo = tempContactsArray[j].birthdayCompareTo(tempContactsArray[j+1]);
				if(valueOfCompareTo > 0){
					swapContacts(tempContactsArray, j);
				}				
			}			
		}		
		return tempContactsArray;
	}
	
	private void swapContacts(Contact[] tempContactsArray, int index){
		Contact contact = tempContactsArray[index];
		tempContactsArray[index] = tempContactsArray[index+1];
		tempContactsArray[index+1] = contact;
	}
}