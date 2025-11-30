package sort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import geometry.Doughnut;
import geometry.Point;

public class FrmSort extends JFrame{	
	private JPanel contentPane;
	private DefaultListModel<Doughnut> listSort = new DefaultListModel<Doughnut>();
		public static void main (String[] args) 
		{
			EventQueue.invokeLater(new Runnable() 
			{
				public void run() 
				{
					try 
					{
						FrmSort frame = new FrmSort();
						frame.setVisible(true);
						
					}
					catch(Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
		}
		
		public FrmSort() 
		{
			setTitle("Mihajlo Markovic IT75/2023");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 500, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5,5,5,5));
			contentPane.setLayout(new BorderLayout(0,0));
			setContentPane(contentPane);
			contentPane.setBackground(new Color(240, 250, 200));
			
			
			JPanel panelCenter = new JPanel();
			contentPane.add(panelCenter, BorderLayout.CENTER);
			panelCenter.setBackground(Color.WHITE);
			
			
			JList list = new JList();
			panelCenter.add(list);
			list.setModel(listSort);
			
			JScrollBar scrollBar = new JScrollBar();
			scrollBar.setBackground(Color.BLACK);
			panelCenter.add(scrollBar);
			
			JPanel panelSouth = new JPanel();
			panelSouth.setBackground(new Color(240, 250, 200));
			contentPane.add(panelSouth, BorderLayout.SOUTH);
			
			JButton btnAdd = new JButton("ADD");
			btnAdd.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) 
				{
					DlgSort dialog = new DlgSort();
					dialog.setVisible(true);
					if (dialog.isConfirmation()) {
					    Doughnut doughnut = new Doughnut(
					        Integer.parseInt(dialog.getTxtRadius().getText()),
					        Integer.parseInt(dialog.getTxtInnerRadius().getText()),
					        new Point(
					            Integer.parseInt(dialog.getTxtXCoordinate().getText()),
					            Integer.parseInt(dialog.getTxtYCoordinate().getText())
					        )
					    );

					    listSort.addElement(doughnut);
					}

				}
			});
			btnAdd.setBackground(Color.GREEN);
			panelSouth.add(btnAdd);
			
			JButton btnSort = new JButton ("SORT");
			btnSort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					 List<Doughnut> doughnuts = new ArrayList<>();
		                for (int i = 0; i < listSort.size(); i++) {
		                    doughnuts.add(listSort.getElementAt(i));
		                }

		               
		                Collections.sort(doughnuts, new Comparator<Doughnut>() {
		                    @Override
		                    public int compare(Doughnut d1, Doughnut d2) {
		                        return Double.compare(d2.area(), d1.area());
		                    }
		                });

		              
		                listSort.clear();
		                for (Doughnut donut : doughnuts) {
		                    listSort.addElement(donut);
		                }	
				}
			});
			btnSort.setBackground(Color.RED);
			panelSouth.add(btnSort);
			
			JPanel panelNorth = new JPanel();
			panelNorth.setBackground(new Color(240,250,200));
			contentPane.add(panelNorth, BorderLayout.NORTH);
			
			JLabel labelNorth = new JLabel("Stack with sort: ");
			labelNorth.setForeground(new Color(0,0,0));
			labelNorth.setFont(new Font("Segoe UI", Font.BOLD, 22));
			panelNorth.add(labelNorth);
				
			
		}
}
