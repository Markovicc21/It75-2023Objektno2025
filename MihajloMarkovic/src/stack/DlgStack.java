package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgStack extends JDialog {
	private JPanel contentPane;
	private JPanel panelCenter;
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	private JPanel panelSouth;
	private JButton btnOK;
	private JButton btnCancel;
	private boolean confirmation;

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
		
		
		JLabel lblRadius = new JLabel("Radius: ");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.insets = new Insets(5,5,5,5);
		gbc_lblRadius.gridx = 0;
		gbc_lblRadius.gridy = 2;
		panelCenter.add(lblRadius, gbc_lblRadius);
		
		
		txtRadius = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(5, 5, 5, 0);
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 1;
		gbc_txtRadius.gridy = 2;
		panelCenter.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);
		
		
		JLabel lblInnerRadius = new JLabel("Inner Radius:");
		GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
		gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
		gbc_lblInnerRadius.insets = new Insets(5, 5, 5, 5);
		gbc_lblInnerRadius.gridx = 0;
		gbc_lblInnerRadius.gridy = 3;
		panelCenter.add(lblInnerRadius, gbc_lblInnerRadius);
		
		
		txtInnerRadius = new JTextField();
		GridBagConstraints gbc_txtInnerRadius = new GridBagConstraints();
		gbc_txtInnerRadius.insets = new Insets(5, 5, 5, 0);
		gbc_txtInnerRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInnerRadius.gridx = 1;
		gbc_txtInnerRadius.gridy = 3;
		panelCenter.add(txtInnerRadius, gbc_txtInnerRadius);
		txtInnerRadius.setColumns(10);
		
		
		panelSouth = new JPanel();
		panelSouth.setBackground(new Color(240, 250, 200));
		panelSouth.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
		
		btnOK =  new JButton("OK");
		btnOK.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) 
		    {
		        if (txtXCoordinate.getText().isEmpty() || txtYCoordinate.getText().isEmpty() 
		                || txtRadius.getText().isEmpty() || txtInnerRadius.getText().isEmpty()) 
		        {
		            JOptionPane.showMessageDialog(null, "You can't leave the fields empty!", 
		                    "Error message", JOptionPane.WARNING_MESSAGE);
		        } 
		        else 
		        {
		            try 
		            {
		                int radius = Integer.parseInt(txtRadius.getText());
		                int innerRadius = Integer.parseInt(txtInnerRadius.getText());
		                
		                if (radius <= innerRadius) 
		                {
		                    JOptionPane.showMessageDialog(null, "Radius must be bigger than inner radius!", 
		                            "Warning message", JOptionPane.WARNING_MESSAGE);
		                } 
		                else if (radius <= 0 || innerRadius <= 0) 
		                {
		                    JOptionPane.showMessageDialog(null, "You must enter positive numbers!",
		                            "Warning message", JOptionPane.WARNING_MESSAGE);
		                } 
		                else 
		                {
		                    
		                    confirmation = true;
		                    setVisible(false);
		                }
		            } 
		            catch (NumberFormatException ex) 
		            {
		                JOptionPane.showMessageDialog(null, "You must enter numbers!", 
		                        "WARNING", JOptionPane.WARNING_MESSAGE);
		            }
		        }
		    }
		});

		btnOK.setPreferredSize(new Dimension(80, 30));
		btnOK.setBackground(Color.GREEN);
		panelSouth.add(btnOK);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				confirmation = false;
				dispose();
			}
		});
		
		
		btnCancel.setPreferredSize(new Dimension(80, 30));
		btnCancel.setBackground(Color.RED);
		panelSouth.add(btnCancel);
	}
	
	public JPanel getPanelCenter() 
	{
		return panelCenter;
	}
	
	public void setPanelCenter(JPanel panelCenter) 
	{
		this.panelCenter = panelCenter;
	}
	
	public JPanel getPanelSouth() 
	{
		return panelSouth;
	}
	
	public void setPanelSouth(JPanel panelSouth) 
	{
		this.panelSouth = panelSouth;
	}
	
	public JTextField getTxtXCoordinate() 
	{
		return txtXCoordinate;
	}
	
	public void setTxtXCoordinate(JTextField txtXCoordinate) 
	{
		this.txtXCoordinate = txtXCoordinate;
	}
	
	public JTextField getTxtYCoordinate() 
	{
		return txtYCoordinate;
	}
	
	public void setTxtYCoordinate(JTextField txtYCoordinate) 
	{
		this.txtYCoordinate = txtYCoordinate;
	}
	
	public JTextField getTxtRadius() 
	{
		return txtRadius;
	}
	
	
	public void setTxtRadius(JTextField txtRadius) 
	{
		this.txtRadius = txtRadius;
	}
	
	public  JTextField getTxtInnerRadius() 
	{
		return txtInnerRadius;
	}
	
	public void setTxtInnerRadius(JTextField txtInnerRadius) 
	{
		this.txtInnerRadius = txtInnerRadius;
	}
	
	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public boolean isConfirmation() {
		return confirmation;
	}
	
	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}
}
	


