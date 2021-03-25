package labJava;
//FOR: CSE 110
//ASSIGNMENT: Assignment 2
//AUTHOR: Jessica Farias
//DESCRIPTION:a program used to compute materials and costs for a specified road construction project

import java.util.Scanner;

public class Assignment2
{
	public static void main(String[] args) 
	{
		//creating scanner object for taking user input
		Scanner sc = new Scanner(System.in);
		
		//declare variables
		double roadLengthMi;
		int numberOfLanes;
		int asphaltDepthIn;
		int daysToCompleteProject;
		int trucks;
		double asphaltVolume, totalAsphaltWeightLbs;
		int intersections;
		int conduitPipes;
		int stoplights;
		int crewMember;
		double totalAsphaltCost, totalStoplightsCost, totalPipesCost, totalLaborCost;
		double totalCost;
		
		//declaring and initializing variables 
		double truckLoadsOfAsphalt = 5.0;
		double laneWidth = 12;
		double totalAsphaltCubicFt = 150;
		double asphaltCostPerTon = 200;
		double stoplightCost = 25000;
		double conduitPipeCost = 500;
		double payPerHour = 25;
		double workHour = 8;
		
		System.out.print(String.format("%" + (-30) + "s", "Length of road project(miles)") + ": "); //requesting length of road in miles from user
		roadLengthMi = sc.nextDouble();
		System.out.print(String.format("%" + (-30) + "s", "Number of lanes") + ": "); //requesting number of lanes from user
		numberOfLanes = sc.nextInt();
		System.out.print(String.format("%" + (-30) + "s", "Depth of asphalt (inches)") + ": "); //requesting depth of asphalt in inches from user
		asphaltDepthIn = sc.nextInt();
		System.out.print(String.format("%" + (-30) + "s", "Days to complete project") + ": "); //requesting days from user to complete project
		daysToCompleteProject = sc.nextInt();
		
		asphaltVolume = (roadLengthMi * 5280) * (laneWidth * numberOfLanes) * (asphaltDepthIn / 12.0);//calculating volume of asphalt
		totalAsphaltWeightLbs = (asphaltVolume * totalAsphaltCubicFt) / 2000.0; //calculating weight of asphalt
		trucks = (int) Math.ceil(totalAsphaltWeightLbs / truckLoadsOfAsphalt); //calculating number of truckloads of asphalt needed
		intersections = (int) Math.floor(roadLengthMi); //calculating number of total intersections
		stoplights = (2 * intersections) + (3 * intersections); //calculating number of stoplights needed
		conduitPipes = (int) Math.ceil((roadLengthMi * 5280) / 24.0); //calculating number of conduit pipes
		crewMember = (int) Math.ceil((50.0 * roadLengthMi * numberOfLanes) / daysToCompleteProject);//calculating number of crew members needed
		
		totalAsphaltCost = (trucks * truckLoadsOfAsphalt) * asphaltCostPerTon; //calculating cost of truckloads of asphalt
		totalStoplightsCost = stoplights * stoplightCost; //calculating cost of stoplights
		totalPipesCost = conduitPipes * conduitPipeCost;// calculating cost of conduit pipes
		totalLaborCost = crewMember * (payPerHour * workHour) * daysToCompleteProject; //calculating cost of labor
		
		//calculating cost of project
		totalCost = totalAsphaltCost + totalStoplightsCost + totalPipesCost +  totalLaborCost;
		
		//displaying amount of materials needed
		System.out.println("\n=== Amount of materials needed ===");
		System.out.println(String.format("%" + (-22) + "s", "Truckloads of Asphalt") + ": " + trucks);
		System.out.println(String.format("%" + (-22) + "s", "Stoplights") + ": " + stoplights);
		System.out.println(String.format("%" + (-22) + "s", "Conduit pipes") + ": " + conduitPipes);
		System.out.println(String.format("%" + (-22) + "s", "Crew members needed") + ": " + crewMember);

		//display cost of materials
		System.out.println("=== Cost of Materials ============");
		System.out.printf("%s: $%.2f\n", String.format("%" + (-22) + "s", "Cost of Asphalt"), totalAsphaltCost);
		System.out.printf("%s: $%.2f\n", String.format("%" + (-22) + "s", "Cost of Stoplights"), totalStoplightsCost);
		System.out.printf("%s: $%.2f\n", String.format("%" + (-22) + "s", "Cost of Conduit pipes"), totalPipesCost);
		System.out.printf("%s: $%.2f\n", String.format("%" + (-22) + "s", "Cost of Labor"), totalLaborCost);
		
		System.out.println("=== Total Cost of Project ========");
		System.out.printf("%s: $%.2f\n", String.format("%" + (-22) + "s", "Total cost of project"), totalCost);
	}
}
