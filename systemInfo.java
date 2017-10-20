package JackeLibrary;


import java.io.File;


public class systemInfo{

    private static Runtime runtime = Runtime.getRuntime();
    
    //: System.out.prints all the available info
    public static void info() {
    		System.out.print("OS-name : " + systemInfo.OSname());
		System.out.print("\n");
		System.out.print("OS-version : " + systemInfo.OSversion());
		System.out.print("\n");
		System.out.print("OS-arch : " + systemInfo.OsArch());
		System.out.print("\n");
		System.out.print("Max-mem : " + systemInfo.maxMem());
		System.out.print("\n");
		System.out.print("Alocated-mem : " + systemInfo.totalMem());
		System.out.print("\n");
		System.out.print("Used-mem : " + systemInfo.usedMem());
		System.out.print("\n");
		System.out.print("total free mem : " + systemInfo.totalFreeMem());
		System.out.print("\n");
		System.out.print("avaleble-cores : " +systemInfo.availableCores());
		System.out.print("\n");
		
		System.out.print("\n");
    }
    
    
    // -- System general info Functions -- //
    public static String OSname() {
        return System.getProperty("os.name");
    }

    public static String OSversion() {
        return System.getProperty("os.version");
    }

    public static String OsArch() {
        return System.getProperty("os.arch");
    }

   
    // -- Ram Functions -- //
    public static long totalMem() {
        return Runtime.getRuntime().totalMemory() / 1024;
    }
    
    public static long freeMem() {
        return Runtime.getRuntime().freeMemory() / 1024;
    }
    
    public static long maxMem() {
        return Runtime.getRuntime().maxMemory() / 1024;
    }
    
    public static long totalFreeMem() {
        return freeMem() + (maxMem() - totalMem()) / 1024;
    }
    
    public static long usedMem() {
        return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 ;
    }
    
    
    // -- Disk Functions -- //
    public static int amountOfDrives() {
   	 File[] roots = File.listRoots();	 
   	 return roots.length;
   }
    
    public static String diskname(int Disknumber) {
    	  File[] roots = File.listRoots();
    	  return roots[Disknumber].getAbsolutePath();
    }
    
    public static long totallDiskSpace(int Disknumber) {
    	  File[] roots = File.listRoots();
    	  return roots[Disknumber].getTotalSpace() / 1000000000;
    }
    
    public static long avalableDiskSpace(int Disknumber) {
    	  File[] roots = File.listRoots();
    	  return roots[Disknumber].getFreeSpace() / 1000000000;
    }
    
    public static long usableDiskSpcae(int Disknumber) {
    	  File[] roots = File.listRoots();
    	  return roots[Disknumber].getUsableSpace() / 1000000000;
    }

    public static int diskProcentage(int Disknumber) {
	
    	double calculate =  (1 - ((double) avalableDiskSpace(Disknumber)/(double) totallDiskSpace(Disknumber) )) * 100;
    	return (int)calculate;
    	
    }
    
    public static String diskPath(int Disknumber) {
    	  File[] roots = File.listRoots();
    	  return roots[Disknumber].getPath();
    }
  
    
    // -- CPU Functions -- //
    public static int availableCores() {
        return runtime.availableProcessors();
    }
    
}