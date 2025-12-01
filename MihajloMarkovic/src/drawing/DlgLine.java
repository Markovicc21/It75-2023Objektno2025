package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class DlgLine extends JDialog{
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX1;
	private JTextField txtX2;
	private JTextField txtY1;
	private JTextField txtY2;
	private boolean confirmation = false;
	
	
	public static void main(String[] args) 
	{
		try 
		{
			DlgLine dialog =  new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public DlgLine() 
	{
		setModal(true);
		setBounds(100,100,450,300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5,5,5,5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {0,0,0,0,0};
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		
		
		JLabel lblX1Coordinate = new JLabel("X1 coordinate:");
		GridBagConstraints gbc_lblX1Coordinate = new GridBagConstraints();
		gbc_lblX1Coordinate.insets = new Insets(0, 0, 5, 5);
		gbc_lblX1Coordinate.gridx = 1;
		gbc_lblX1Coordinate.gridy = 1;
		contentPanel.add(lblX1Coordinate, gbc_lblX1Coordinate);
		
		
		txtX1 = new JTextField();
		GridBagConstraints gbc_txtX1 = new GridBagConstraints();
		gbc_txtX1.insets = new Insets(0, 0, 5, 0);
		gbc_txtX1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX1.gridx = 3;
		gbc_txtX1.gridy = 1;
		contentPanel.add(txtX1, gbc_txtX1);
		txtX1.setColumns(10);
		
		
		JLabel lblY1Coordinate = new JLabel("Y1 coordinate:");
		GridBagConstraints gbc_lblY1Coordinate = new GridBagConstraints();
		gbc_lblY1Coordinate.insets = new Insets(0, 0, 5, 5);
		gbc_lblY1Coordinate.gridx = 1;
		gbc_lblY1Coordinate.gridy = 3;
		contentPanel.add(lblY1Coordinate, gbc_lblY1Coordinate);
		
		
		txtY1 = new JTextField();
		GridBagConstraints gbc_txtY1 = new GridBagConstraints();
		gbc_txtY1.insets = new Insets(0, 0, 5, 0);
		gbc_txtY1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY1.gridx = 3;
		gbc_txtY1.gridy = 3;
		contentPanel.add(txtY1, gbc_txtY1);
		txtY1.setColumns(10);
		
		
		JLabel lblX2Coordinate = new JLabel("X2 coordinate:");
		GridBagConstraints gbc_lblX2Coordinate = new GridBagConstraints();
		gbc_lblX2Coordinate.insets = new Insets(0, 0, 5, 5);
		gbc_lblX2Coordinate.gridx = 1;
		gbc_lblX2Coordinate.gridy = 5;
		contentPanel.add(lblX2Coordinate, gbc_lblX2Coordinate);
		
		
		txtX2 = new JTextField();
		GridBagConstraints gbc_txtX2 = new GridBagConstraints();
		gbc_txtX2.insets = new Insets(0, 0, 5, 0);
		gbc_txtX2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX2.gridx = 3;
		gbc_txtX2.gridy = 5;
		contentPanel.add(txtX2, gbc_txtX2);
		txtX2.setColumns(10);
		
		
		JLabel lblY2Coordinate = new JLabel("Y2 coordinate:");
		GridBagConstraints gbc_lblY2Coordinate = new GridBagConstraints();
		gbc_lblY2Coordinate.insets = new Insets(0, 0, 5, 5);
		gbc_lblY2Coordinate.gridx = 1;
		gbc_lblY2Coordinate.gridy = 7;
		contentPanel.add(lblY2Coordinate, gbc_lblY2Coordinate);
		
		
		txtY2 = new JTextField();
		GridBagConstraints gbc_txtY2 = new GridBagConstraints();
		gbc_txtY2.insets = new Insets(0, 0, 5, 0);
		gbc_txtY2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY2.gridx = 3;
		gbc_txtY2.gridy = 7;
		contentPanel.add(txtY2, gbc_txtY2);
		txtY2.setColumns(10);
		
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(240, 250, 200));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton ("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (txtX1.getText().isEmpty() || txtY1.getText().isEmpty() || txtX2.getText().isEmpty() || txtY2.getText().isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Please enter values!", "WARNING", JOptionPane.WARNING_MESSAGE);
				} else {
				    confirmation = true;
				    setVisible(false);
				}

			}
		});
		okButton.setBackground(Color.GREEN);
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				confirmation = false;
			}
		});
		
		cancelButton.setBackground(Color.RED);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
	}
	

	public JTextField getTxtX1() {
	    return txtX1;
	}

	public void setTxtX1(JTextField txtX1) {
	    this.txtX1 = txtX1;
	}

	public JTextField getTxtY1() {
	    return txtY1;
	}

	public void setTxtY1(JTextField txtY1) {
	    this.txtY1 = txtY1;
	}

	public JTextField getTxtX2() {
	    return txtX2;
	}

	public void setTxtX2(JTextField txtX2) {
	    this.txtX2 = txtX2;
	}

	public JTextField getTxtY2() {
	    return txtY2;
	}

	public void setTxtY2(JTextField txtY2) {
	    this.txtY2 = txtY2;
	}


	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}
	
	
	
}
