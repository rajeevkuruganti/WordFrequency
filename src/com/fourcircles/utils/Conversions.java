package com.fourcircles.utils;

public class Conversions {
/*
 * 
 */
             
     public static double fahrenToCenti(double fahren){
	 return (5*((fahren-32)/9));	 
     }
     public static double centiToFahren(double centi){
	 return (((9*centi)/5)+32);
     }
     public static double kgToPounds(double kg){
	 return (kg*2.2);	 
     }
     
     public static double poundsToKg(double pds){
	 return(pds/2.2);
     }
     public static double milesToKm(double miles){
	 return (miles*1.6);
     }
     public static double kmToMiles(double km){
	 return(km/1.6);
     }
     
    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	//Conversions c = new Conversions();
	for (int i=0;i<=100;i++){
	    System.out.println("c.centiToFahren(0)="+Conversions.centiToFahren(i));
	}
	
	System.out.println("c.kmToMiles(3.2)="+Conversions.kmToMiles(3.2));
	System.out.println("pdsToKg="+Conversions.poundsToKg(169.4));

    }

}
