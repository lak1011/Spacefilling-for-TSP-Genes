package edu.sru.thangiah.zeus.tsp;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.tsp.tspcostfunctions.*;

public class TSPRoot {
  /**
   * Constructor. Runs the TSP and calculates the total CPU time
   */
  public TSPRoot() {

    ProblemInfo.nodesLLLevelCostF = new TSPNodesLLCostFunctions();
    ProblemInfo.truckLevelCostF = new TSPTruckCostFunctions();
    ProblemInfo.truckLLLevelCostF = new TSPTruckLLCostFunctions();
    ProblemInfo.depotLevelCostF = new TSPDepotCostFunctions();
    ProblemInfo.depotLLLevelCostF = new TSPDepotLLCostFunctions();
    ProblemInfo.tempFileLocation = ProblemInfo.workingDirectory+"/temp";
    ProblemInfo.inputPath = ProblemInfo.workingDirectory+"/data/tsp/problems/";

    ProblemInfo.outputPath = ProblemInfo.workingDirectory+"/data/tsp/results/";

    
	//Open the requested file
    String filename = "";
    String master = "master.xlsx";
	XSSFWorkbook workbook = new XSSFWorkbook();    
	FileInputStream fis;
	XSSFSheet sheet;
	XSSFRow curRow;
	int rowCounter = 0; 


	try { 
		fis = new FileInputStream(ProblemInfo.inputPath+master);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		curRow = sheet.getRow(rowCounter); 
		String cell = (String)curRow.getCell(0).getStringCellValue();
		
		while (cell != "EOF") {
			rowCounter++;
			curRow = sheet.getRow(rowCounter); // the 2nd row is the problem data
			filename = (String)curRow.getCell(0).getStringCellValue();
		    new TSP(filename+".xlsx");
		}
	}
	catch (Exception e) {
		System.out.println("readDataFromExcelFile 'master.xlsx' file is not present");
	}
  }
}
