package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

@Component
public class UI {
	public  JFrame frame;
	public  JPanel pMain;

	// 主窗口包含工具栏、数据区、状态栏
	public  JPanel pDirTree;
	public  JPanel toolBar;
	public  JPanel locationBar;
	public  JPanel pBody;
	public  JLabel statusBar;

	//左侧目录树列表
	public List awtList;
	// 工具栏元素
	public  JButton btBack;
	public  JButton btForward;
	public  JButton btUp;
	public  JButton btSearch;
	public  JButton btDeploy;

	public JTextField location;
	public JButton btChangeLocation ;

	// 给table添加滚动动条
	public  JScrollPane scrollPane;
	public  JTable table;

	// 创建UI元素
	public void init() {
		frame = new JFrame("增量打包工具");
		pMain = new JPanel();
		
		pDirTree = new JPanel();
		toolBar = new JPanel();
		locationBar = new JPanel();
		pBody = new JPanel();
		statusBar = new JLabel("状态栏");

		awtList = new List(20);
		btBack =  new JButton("←");
		btForward =  new JButton("→");
		btUp =  new JButton("↑");
		btSearch =  new JButton("⊙");
		btDeploy =  new JButton(new ImageIcon("./resource/search.jpg"));
		
		location = new JTextField("                                                                                                                       ");
		btChangeLocation = new JButton("设置地址");
		scrollPane = new JScrollPane();
		table = new JTable(50, 4);
	}

	// 设置UI元素的属性
	public void compose() {
		frame.setSize(954, 750);
		frame.setLocation(200, 50);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		// 目录树
		awtList.add("C");
		awtList.add("D");
		awtList.add("E");
		awtList.add("F");
		pDirTree.add(awtList);
		frame.add("West", pDirTree);
		
		// 工具栏
		toolBar.add(btBack);
		toolBar.add(btForward);
		toolBar.add(btUp);
		toolBar.add(btSearch);
		toolBar.add(btDeploy);
		
		locationBar.add(location);
		toolBar.add(locationBar);
		frame.add("North", toolBar);

		

		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		table.setShowGrid(true);
		table.setAutoscrolls(true);
		table.setDragEnabled(true);
		table.setCellSelectionEnabled(true);
		table.setSelectionBackground(new Color(233, 223, 233));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);

		frame.add("Center", scrollPane);

		statusBar.setAlignmentX(JLabel.RIGHT);
		frame.add("South", statusBar);

		frame.setVisible(true);
	}
	public static void main(String[] args) {
		UI ui = new UI();
		ui.init();
		ui.compose();
		FileZone fz =new FileZone();
		fz.setPath("/tmp");
		ui.table.setModel(fz.getFileList());
	}
}
