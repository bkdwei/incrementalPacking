package com;

import org.springframework.beans.factory.annotation.Autowired;

public class IncrementalPacking {

	@Autowired
	private UI ui;
	@Autowired
	private FileZone fileZone;

	public static void main(String[] args) {
		IncrementalPacking ip = new IncrementalPacking();
		ip.ui.init();
		ip.ui.compose();
		ip.fileZone.setPath("/tmp");
		ip.ui.table.setModel(ip.fileZone.getFileList());

	}

}
