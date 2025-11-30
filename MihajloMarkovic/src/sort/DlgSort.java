package sort;

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

public class DlgSort  extends JDialog{ 
	private final JPanel contentPanel =  new JPanel();
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	private boolean confirmation;
	
	public static void main(String[] args) 
	{
		try {
			DlgSort dialog = new DlgSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
		public DlgSort() {
			setModal(true);
			setBounds(100, 100, 500, 300);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
			gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			contentPanel.setLayout(gbl_contentPanel);
			contentPanel.setBackground(new Color(240, 250, 200));
			{
				JLabel lblXCoordinate = new JLabel("Enter the X coordinate:");
				GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
				gbc_lblXCoordinate.anchor = GridBagConstraints.WEST;
				gbc_lblXCoordinate.insets = new Insets(0, 0, 25, 5);
				gbc_lblXCoordinate.gridx = 0;
				gbc_lblXCoordinate.gridy = 1;
				contentPanel.add(lblXCoordinate, gbc_lblXCoordinate);
			}
			
			{
				txtXCoordinate = new JTextField();
				GridBagConstraints gbc_txtXCoordinate = new GridBagConstraints();
				gbc_txtXCoordinate.insets = new Insets(0, 0, 25, 0);
				gbc_txtXCoordinate.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtXCoordinate.gridx = 1;
				gbc_txtXCoordinate.gridy = 1;
				contentPanel.add(txtXCoordinate, gbc_txtXCoordinate);
				txtXCoordinate.setColumns(10);
			}
			
			{
				JLabel lblYCoordinate = new JLabel("Enter the Y coordinate:");
				GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
				gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
				gbc_lblYCoordinate.insets = new Insets(0, 0, 25, 5);
				gbc_lblYCoordinate.gridx = 0;
				gbc_lblYCoordinate.gridy = 2;
				contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
			}
			
			{
				txtYCoordinate = new JTextField();
				GridBagConstraints gbc_txtYCoordinate = new GridBagConstraints();
				gbc_txtYCoordinate.insets = new Insets(0, 0, 25, 0);
				gbc_txtYCoordinate.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtYCoordinate.gridx = 1;
				gbc_txtYCoordinate.gridy = 2;
				contentPanel.add(txtYCoordinate, gbc_txtYCoordinate);
				txtYCoordinate.setColumns(10);
			}
			
			{
				JLabel lblRadius = new JLabel("Enter the Radius:");
				GridBagConstraints gbc_lblRadius = new GridBagConstraints();
				gbc_lblRadius.anchor = GridBagConstraints.EAST;
				gbc_lblRadius.insets = new Insets(0, 0, 25, 5);
				gbc_lblRadius.gridx = 0;
				gbc_lblRadius.gridy = 3;
				contentPanel.add(lblRadius, gbc_lblRadius);
			}
			
			{
				txtRadius = new JTextField();
				GridBagConstraints gbc_txtRadius = new GridBagConstraints();
				gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
				gbc_txtRadius.anchor = GridBagConstraints.NORTH;
				gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRadius.gridx = 1;
				gbc_txtRadius.gridy = 3;
				contentPanel.add(txtRadius, gbc_txtRadius);
				txtRadius.setColumns(10);
			}
			
			{
				JLabel lblInnerRadius = new JLabel("Inner Radius");
				GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
				gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
				gbc_lblInnerRadius.insets = new Insets(0, 0, 0, 5);
				gbc_lblInnerRadius.gridx = 0;
				gbc_lblInnerRadius.gridy = 5;
				contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
			}
			
			{
				txtInnerRadius = new JTextField();
				GridBagConstraints gbc_textInnerRadius = new GridBagConstraints();
				gbc_textInnerRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_textInnerRadius.gridx = 1;
				gbc_textInnerRadius.gridy = 5;
				contentPanel.add(txtInnerRadius, gbc_textInnerRadius);
				txtInnerRadius.setColumns(10);
			}
			
			{
			JPanel panelSouth = new JPanel();
			panelSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
			getContentPane().add(panelSouth, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (txtXCoordinate.getText().isEmpty() || txtYCoordinate.getText().isEmpty()
								|| txtRadius.getText().isEmpty() || txtInnerRadius.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "You can't leave the fields empty!", "Error message",
									JOptionPane.WARNING_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(txtRadius.getText()) <= Integer
										.parseInt(txtInnerRadius.getText())) {
									JOptionPane.showMessageDialog(null, "Radius must be bigger than inner radius!",
											"Warning message", JOptionPane.WARNING_MESSAGE);
								}else if (Integer.parseInt(txtRadius.getText()) <= 0
										|| Integer.parseInt(txtInnerRadius.getText()) <= 0) {

									JOptionPane.showMessageDialog(null, "You must enter positive numbers!", "Warning message",
											JOptionPane.WARNING_MESSAGE);
								} 
								
								
								
								else {
									setVisible(false);
									confirmation = true;
								}
							} catch (Exception NumberFormatException) {
								JOptionPane.showMessageDialog(null, "You must enter numbers!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}
						}
					}

				});
				okButton.setBackground(new Color(240, 250, 200));
				panelSouth.add(okButton);
			}
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						confirmation = false;
						dispose();

					}

				});

				cancelButton.setBackground(new Color(220, 0, 0));
				panelSouth.add(cancelButton);
				}
			}
		}
		
		public JTextField getTxtXCoordinate() {
			return txtXCoordinate;
		}

		public void setTxtXCoordinate(JTextField txtXCoordinate) {
			this.txtXCoordinate = txtXCoordinate;
		}

		public JTextField getTxtYCoordinate() {
			return txtYCoordinate;
		}

		public void setTxtYCoordinate(JTextField txtYCoordinate) {
			this.txtYCoordinate = txtYCoordinate;
		}

		public JTextField getTxtRadius() {
			return txtRadius;
		}

		public void setTxtRadius(JTextField txtRadius) {
			this.txtRadius = txtRadius;
		}

		public JTextField getTxtInnerRadius() {
			return txtInnerRadius;
		}

		public void setTextInnerRadius(JTextField textInnerRadius) {
			this.txtInnerRadius = textInnerRadius;
		}

		public boolean isConfirmation() {
			return confirmation;
		}

		public void setConfirmation(boolean confiramtion) {
			this.confirmation = confiramtion;
		}

		public JPanel getContentPanel() {
			return contentPanel;
		}
	}
	



