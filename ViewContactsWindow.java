import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewContactsWindow extends JFrame{		
	private JButton btnListByName;	
	private JButton btnListBySalary;	
	private JButton btnListByBirthday;	
	private JButton btnCancel;	
	
	public ViewContactsWindow(){
		setSize(900,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		
		JLabel lblContactsList = new JLabel("CONTACTS LIST",SwingConstants.CENTER);
		lblContactsList.setFont(new Font("Tahoma",Font.BOLD,40));		
		lblContactsList.setOpaque(true);
		lblContactsList.setBackground(new Color(150,210,255));
		lblContactsList.setPreferredSize(new Dimension(0,100));
		add(lblContactsList,BorderLayout.NORTH);
		
		JPanel midPanel = new JPanel(new GridLayout(3,1,0,50));
		midPanel.setBorder(BorderFactory.createEmptyBorder(60,220,40,220));
				
		btnListByName = new JButton("List by Name");
		btnListByName.setFont(new Font("SansSerif",Font.BOLD,30));
		btnListByName.setBorder(BorderFactory.createRaisedBevelBorder());
		btnListByName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new ListByNameWindow();
			}
		});
		midPanel.add(btnListByName);
		
		
		btnListBySalary = new JButton("List by Salary");
		btnListBySalary.setFont(new Font("SansSerif",Font.BOLD,30));
		btnListBySalary.setBorder(BorderFactory.createRaisedBevelBorder());
		btnListBySalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new ListBySalaryWindow();
			}
		});		
		midPanel.add(btnListBySalary);
				
		btnListByBirthday = new JButton("List by Birthday");
		btnListByBirthday.setFont(new Font("SansSerif",Font.BOLD,30));		
		btnListByBirthday.setBorder(BorderFactory.createRaisedBevelBorder());
		btnListByBirthday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new ListByBirthdayWindow();
			}
		});
		midPanel.add(btnListByBirthday);
		
		add(midPanel,BorderLayout.CENTER);		
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,40));		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma",Font.BOLD,30));
		btnCancel.setBorder(BorderFactory.createRaisedBevelBorder());
		btnCancel.setPreferredSize(new Dimension(200,50));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				IFriendContactManager.getHomePageWindow().setVisible(true);
			}
		});
		southPanel.add(btnCancel);		
		add(southPanel,BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				IFriendContactManager.getHomePageWindow().setVisible(true);
			}
		});
	}
}

