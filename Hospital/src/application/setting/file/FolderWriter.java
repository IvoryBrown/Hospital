package application.setting.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FolderWriter {
	private String PER_R_N = "\r\n";
	private File homeDirectory;
	private File dBDirectory;
	private String aplicationFloder = "\\AppData\\Local\\Hospital\\";
	private String dataBaseFloder = "\\AppData\\Local\\Hospital\\DB\\";

	public FolderWriter() {
		homeDirectory = new File(System.getProperty("user.home") + aplicationFloder);

		if (!homeDirectory.exists()) {
			System.out.println("creating directory: " + homeDirectory.getName());
			boolean result = false;

			try {
				homeDirectory.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}
		dbFolderWriter();
	}

	private void dbFolderWriter() {
		dBDirectory = new File(System.getProperty("user.home") + dataBaseFloder);

		if (!dBDirectory.exists()) {
			System.out.println("creating directory: " + dBDirectory.getName());
			boolean result = false;

			try {
				dBDirectory.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}

		try {

			if (DBFileWriter.outputDB().size() == 0) {

				BufferedWriter output = new BufferedWriter(
						new FileWriter(System.getProperty("user.home") + dataBaseFloder + "output.txt"));

				String allSetting = "11" + PER_R_N + "112" + PER_R_N + "113";
				output.write(allSetting);
				output.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
