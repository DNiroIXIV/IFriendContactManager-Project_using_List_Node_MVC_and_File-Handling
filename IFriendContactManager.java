//OR24112092_Dinushi Nirodha_OOP Coursework_03
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IFriendContactManager extends JFrame{
	private JButton btnAddNewContact;
	private JButton btnUpdateContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnViewContact;
	private JButton btnExit;
	
	public IFriendContactManager(){
		setSize(1000,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,10,new Color(245,245,245)));
		
		JPanel appTitlePanel = new JPanel(new GridLayout(2,1));
		appTitlePanel.setBorder(BorderFactory.createMatteBorder(15,20,15,20,new Color(255,255,255)));
		appTitlePanel.setBackground(new Color(255,255,255));
		
		JLabel iFriendLabel = new JLabel("iFRIEND",SwingConstants.CENTER);
		iFriendLabel.setFont(new Font("SansSerif",Font.BOLD,40));
		appTitlePanel.add(iFriendLabel);
		
		JLabel contactManagerLabel = new JLabel("Contact Manager",SwingConstants.CENTER);
		contactManagerLabel.setFont(new Font("SansSerif",Font.BOLD,40));
		appTitlePanel.add(contactManagerLabel);
		
		leftPanel.add(appTitlePanel,BorderLayout.NORTH);
		leftPanel.add(new ImagePanel("image.jpg"),BorderLayout.CENTER);
		add(leftPanel,BorderLayout.WEST);
		
		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.setBackground(new Color(150,210,255));
		rightPanel.setBorder(BorderFactory.createMatteBorder(20,40,40,40,new Color(150,210,255)));
		
		JPanel homePagePanel = new JPanel();
		homePagePanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(132,73,195)));
		homePagePanel.setBackground(new Color(150,210,255));
		
		JLabel lblHomePage =  new JLabel("Home Page",SwingConstants.CENTER);
		lblHomePage.setFont(new Font("Tahoma",Font.BOLD,40));
		lblHomePage.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(150,210,255)));
		homePagePanel.add(lblHomePage);
		rightPanel.add(homePagePanel,BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel(new GridLayout(5,1,0,40));
		buttonPanel.setBorder(BorderFactory.createMatteBorder(30,100,30,100,new Color(150,210,255)));
		buttonPanel.setBackground(new Color(150,210,255));
		
		btnAddNewContact = new JButton("Add New Contact");
		btnAddNewContact.setFont(new Font("Arial",Font.BOLD,20));
		btnAddNewContact.setBorder(BorderFactory.createLineBorder(new Color(169,169,169),1));
		btnAddNewContact.setBackground(Color.WHITE);
		btnAddNewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new AddContactWindow();
			}
		});		
		buttonPanel.add(btnAddNewContact);
		
		btnUpdateContact = new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("Arial",Font.BOLD,20));
		btnUpdateContact.setBorder(BorderFactory.createLineBorder(new Color(169,169,169),1));
		btnUpdateContact.setBackground(Color.WHITE);
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new UpdateContactWindow();
			}
		});
		buttonPanel.add(btnUpdateContact);
		
		btnSearchContact = new JButton("Search Contact");
		btnSearchContact.setFont(new Font("Arial",Font.BOLD,20));
		btnSearchContact.setBorder(BorderFactory.createLineBorder(new Color(169,169,169),1));
		btnSearchContact.setBackground(Color.WHITE);
		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new SearchContactWindow();
			}
		});
		buttonPanel.add(btnSearchContact);
		
		btnDeleteContact = new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("Arial",Font.BOLD,20));
		btnDeleteContact.setBorder(BorderFactory.createLineBorder(new Color(169,169,169),1));
		btnDeleteContact.setBackground(Color.WHITE);
		btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new DeleteContactWindow();
			}
		});
		buttonPanel.add(btnDeleteContact);
		
		btnViewContact = new JButton("View Contact");
		btnViewContact.setFont(new Font("Arial",Font.BOLD,20));
		btnViewContact.setBorder(BorderFactory.createLineBorder(new Color(169,169,169),1));
		btnViewContact.setBackground(Color.WHITE);
		btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				viewContactWindow.setVisible(true);
			}
		});
		buttonPanel.add(btnViewContact);
		
		rightPanel.add(buttonPanel,BorderLayout.CENTER);
		
		JPanel exitBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		exitBtnPanel.setBackground(new Color(150,210,255));
		
		btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Arial",Font.BOLD,18));
		btnExit.setPreferredSize(new Dimension(120,40));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBorder(BorderFactory.createLineBorder(new Color(169,169,169),1));
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				viewContactWindow.dispose();				
				dispose();				
			}
		});
		exitBtnPanel.add(btnExit);
		
		rightPanel.add(exitBtnPanel,BorderLayout.SOUTH);
		
		add(rightPanel,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	private static IFriendContactManager homePageWindow = null;
	private static ViewContactsWindow viewContactWindow  = null;
	
	public static void main(String[] args){
		homePageWindow = new IFriendContactManager();
		viewContactWindow = new ViewContactsWindow();
	}
	
	public static IFriendContactManager getHomePageWindow(){
		return homePageWindow;
	}
	
	public static ViewContactsWindow getViewContactsWindow(){
		return viewContactWindow;
	}
}

class ImagePanel extends JPanel{
	private String image;
	
	public ImagePanel(String image){
		this.image=image;
	}
	
	public void paintComponent(Graphics g){
		ImageIcon imageIcon = new ImageIcon(image);
		
		g.drawImage(imageIcon.getImage(),0,5,365,474,null);
	}
}
