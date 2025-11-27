package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgStack extends JDialog {
	private JPanel contentPane;
	private JPanel panelCenter;
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;

	public static void main (String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					DlgStack dialog = new DlgStack();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});	
	}
	
	public DlgStack() 
	{
		setTitle("Mihajlo Markovic IT75/2023");
		setModal(true);
		setSize(400,300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		contentPane.setBackground(new Color(240,250,200));
		contentPane.setLayout(new BorderLayout(0,0));
		
		setContentPane(contentPane);
		
		panelCenter = new JPanel();
		panelCenter.setBackground(Color.WHITE);
		panelCenter.setBorder(new EmptyBorder(20,20,20,20));
		contentPane.add(panelCenter,BorderLayout.CENTER);
		
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[] {0,0,0};
		gbl_panelCenter.rowHeights = new int[] {0,0,0,0,0};
		gbl_panelCenter.columnWeights = new double [] {0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[] {0.0 , 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JLabel lblXCoordinate = new JLabel("X Coordinate: ");
		GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
		gbc_lblXCoordinate.anchor = GridBagConstraints.EAST;
		gbc_lblXCoordinate.insets = new Insets(5, 5, 5, 5);
		gbc_lblXCoordinate.gridx = 0;
		gbc_lblXCoordinate.gridy = 0;
		panelCenter.add(lblXCoordinate, gbc_lblXCoordinate );
		
		
		txtXCoordinate = new JTextField();
		GridBagConstraints gbc_txtXCoordinate = new GridBagConstraints();
		gbc_txtXCoordinate.insets = new Insets(5,5,5,0);
		gbc_txtXCoordinate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXCoordinate.gridx = 1;
		gbc_txtXCoordinate.gridy = 0;
		panelCenter.add(txtXCoordinate, gbc_txtXCoordinate);
		txtXCoordinate.setColumns(10);
		
		
		JLabel lblYCoordinate = new JLabel("Y Coordinate: ");
		GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
		gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
		gbc_lblYCoordinate.insets = new Insets(5,5,5,5);
		gbc_lblYCoordinate.gridx = 0;
		gbc_lblYCoordinate.gridy = 1;
		panelCenter.add(lblYCoordinate, gbc_lblYCoordinate);
	
		
		txtYCoordinate = new JTextField();
		GridBagConstraints gbc_txtYCoordinate = new GridBagConstraints();
		gbc_txtYCoordinate.insets = new Insets(5,5,5,0);
		gbc_txtYCoordinate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYCoordinate.gridx = 1;
		gbc_txtYCoordinate.gridy = 1;
		panelCenter.add(txtYCoordinate, gbc_txtYCoordinate);
		txtYCoordinate.setColumns(10);
		
		
	
		
		
		
	}
}
