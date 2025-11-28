package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Doughnut;
import geometry.Point;

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
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DlgStack dialog = new DlgStack();
				dialog.setVisible(true);
				
				if(dialog.isConfirmation()) 
				{
					Doughnut doughnut = new Doughnut(
					        Integer.parseInt(dialog.getTxtRadius().getText()),
					        Integer.parseInt(dialog.getTxtInnerRadius().getText()),
					        new Point(
					            Integer.parseInt(dialog.getTxtXCoordinate().getText()),
					            Integer.parseInt(dialog.getTxtYCoordinate().getText())
					        )
					);
					
					listStack.add(0,  doughnut);

				}
			}
			
		});
		panelSouth.add(addButton);
		addButton.setBackground(Color.GREEN);
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) 
		    {
		        if (listStack.isEmpty()) 
		        {
		            JOptionPane.showMessageDialog(null, "THE STACK IS EMPTY!", "ERROR", JOptionPane.ERROR_MESSAGE);
		        } 
		        else 
		        {
		            DlgStack dialog = new DlgStack();

		           
		            dialog.getTxtXCoordinate().setText(String.valueOf(listStack.getElementAt(0).getCenter().getX()));
		            dialog.getTxtYCoordinate().setText(String.valueOf(listStack.getElementAt(0).getCenter().getY()));
		            dialog.getTxtRadius().setText(String.valueOf(listStack.getElementAt(0).getRadius()));
		            dialog.getTxtInnerRadius().setText(String.valueOf(listStack.getElementAt(0).getInnerRadius()));

		           
		            dialog.getTxtXCoordinate().setEditable(false);
		            dialog.getTxtYCoordinate().setEditable(false);
		            dialog.getTxtRadius().setEditable(false);
		            dialog.getTxtInnerRadius().setEditable(false);

		            dialog.setVisible(true);

		           
		            if (dialog.isConfirmation()) 
		            {
		                listStack.removeElementAt(0);
		            }
		        }
		    }
		});

		panelSouth.add(deleteButton);
		deleteButton.setBackground(Color.RED);
		

	}
}
