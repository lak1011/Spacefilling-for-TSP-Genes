package edu.sru.thangiah.zeus.vrp;

import java.io.File;

import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.vrp.vrpcostfunctions.*;

public class VRPRoot {
  /**
   * Constructor. Runs the VRP and calculates the total CPU time
   */
  public VRPRoot() {

    //Settings for the ProblemInfo class
    //Problem info consists of a set of static values that are used by a number
    //of different classes. The following has to be set in order for the program
    //to function correctly.
    ProblemInfo.nodesLLLevelCostF = new VRPNodesLLCostFunctions();
    ProblemInfo.truckLevelCostF = new VRPTruckCostFunctions();
    ProblemInfo.truckLLLevelCostF = new VRPTruckLLCostFunctions();
    ProblemInfo.depotLevelCostF = new VRPDepotCostFunctions();
    ProblemInfo.depotLLLevelCostF = new VRPDepotLLCostFunctions();
    //Paths for temporary, input and output files
    //ProblemInfo.currDir gives the working directory of the program
    ProblemInfo.tempFileLocation = ProblemInfo.workingDirectory+"\\temp";
    ProblemInfo.inputPath = ProblemInfo.workingDirectory+"\\data\\tsp\\problems\\";

    ProblemInfo.outputPath = ProblemInfo.workingDirectory+"\\data\\tsp\\results\\";

    /* String path = "";
           String newpath = "SBVRP/new";
           String oldpath = "SBVRP/old";
           Settings.debugLevel = Settings.WARNING; //only show error messages

           ProblemInfo.inputPath  = path + "data/" + newpath + "/";
           ProblemInfo.outputPath = path + "results/" + newpath + "/";

           ProblemInfo.inputPath  = path + "data/" + oldpath + "/";
           ProblemInfo.outputPath = path + "results/" + oldpath + "/";
     */


    /* All problems are labeled as p01, p02,...,p10, p11.
       This code generates the file names automatically and passes it to
      algorithm to be solved.
     */
    /* for(int i=1; i<=2; i++){
        String s = "p";
        //all files that have single digits are named p01, p02 ..
        if(i<10){
          s += "0" + i;
        }
        //for files that have double digits such as p10,p11
        else{
          s += "" + i;
        }

        System.out.println("Executing old " + s);
        new VRP(path + "data/" + oldpath + "/" + s);
      }
     */
    //new vrp.MDVRP("mdvrp_p01.txt");
    //new VRP("mdvrp_p01.txt"); //Reading from a text file
    // The section below creates a VRP for all items in the given input folder

    // Creates a list of all of the input files in the input folder
    File inPath = new File(ProblemInfo.inputPath);
    File[] allInFiles = inPath.listFiles();
    // Creates a new VRP for each file in the list
    int i; // Initialize integer i
    int numFiles = allInFiles.length; // Get the number of files
    for (i = 0; i < numFiles; i++)
    {
    	if (allInFiles[i].getName().matches("^.*\\.xlsx$"))
    		new VRP(allInFiles[i].getName());
    }
    
    //new edu.sru.thangiah.zeus.vrp.VRP("mdvrp_p01.txt");
  }
}
