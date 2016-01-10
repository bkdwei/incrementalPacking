package com;

import java.io.File;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

@Component
public class FileZone {
	private String path;
	private DefaultTableModel fileList ;
	private Vector fileTitle;

	public FileZone() {
		fileList = new DefaultTableModel();
		fileTitle = new Vector<>();
		fileTitle.addElement("名称");
		fileTitle.addElement("大小");
		fileTitle.addElement("类型");
		fileTitle.addElement("修改日期");
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public DefaultTableModel getFileList() {
		File fPath;

		Vector rows = new Vector();
		if (path != null && !path.equals("")) {
			fPath = new File(path);

			if (fPath.exists() && fPath.isDirectory()) {
				String fList[] = fPath.list();
				if (fList.length > 0) {

					for (int i = 0; i < fList.length; i++) {
						Vector fileRows = new Vector();
						File tmpFile = new File(fList[i]);
						fileRows.addElement(fList[i]);
						fileRows.addElement(tmpFile.length());
						fileRows.addElement(fList[i].substring(fList[i].length()-3));
						fileRows.addElement(tmpFile.lastModified()+"");
						rows.addElement(fileRows);
					}
				}
			}
		}
		if (!rows.isEmpty()) {
			
			this.fileList.setDataVector(rows, fileTitle);
		}
		return fileList;
	}

	public void setFileList(DefaultTableModel fileList) {
		this.fileList = fileList;
	}

}
