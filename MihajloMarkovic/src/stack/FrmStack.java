package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Doughnut;

public class FrmStack extends JFrame
{
	private JPanel contentPane;
	private DefaultListModel<Doughnut> listStack = new DefaultListModel<Doughnut>();
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	
	}
	
	public FrmStack() 
	{
		setTitle("Mihajlo Markovic IT75/2023");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setBackground(new Color(240,250,200));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(Color.GRAY);
		
		
		JList list = new JList();
		panelCenter.add(list);
		list.setModel(listStack);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBackground(new Color(240,250,200));
		
		JButton addButton = new JButton("ADD");
		panelSouth.add(addButton);
		addButton.setBackground(Color.GREEN);
		
		JButton deleteButton = new JButton("DELETE");
		panelSouth.add(deleteButton);
		deleteButton.setBackground(Color.RED);
		

	}
}
