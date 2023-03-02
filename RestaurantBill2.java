package com.Divya;

import java.util.Scanner;

public class RestaurantBill2 {
	
	static boolean dinein;
	static boolean Takeaway;
	static boolean ordering = true;
	String[] Veg = new String[]{"idly","wada","dosa"};
	String[] Nonveg=new String[] {"chicken Biriyani" ,"Mutton Biriyani","Fish Curry"};
	int[] Vegrate = new int[]{30,35,40};
	int[] Nonvegrate=new int[] {100,200,150};
	static int[] qt = new int[3]; // qt for veg food
	static int[]qt1=new int[3];  // qt1 for non veg food
    double sum=0;
    double GST;
	Scanner sc=new Scanner(System.in);
	final String currency="Rs";
	int Takeawaycharge;
	static int numberofitems;
	static boolean Flag;
	
	//set dine in and takeaway variable
	public void getServiceOffering()
	{
		int option;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please select the service offering from below list");
		
		System.out.println("[1] dine-in \n[2] take away");
		System.out.println("Please enter the option");
		option=sc.nextInt();
		switch(option)
		{
		case 1 :
			System.out.println("You have selected dine-in");
			dinein=true;
			Flag=true;
			break;
		case 2:
			System.out.println("You have selected take-away");
			Takeaway=true;
			Flag=true;
			break;
		default:
			System.out.println("Invalid option, press 1 or2 ");
			
		    Flag=false;
		    getServiceOffering();
		    		    
		break;
		}
	}
	
	
	public void DisplayVegmenu()
	{
		for(int i=0;i<Veg.length;i++)
            System.out.println((i+1)+"."+Veg[i]+"--"+"Per Item" +Vegrate[i] + currency);
	}
	public void DisplayNonVegmenu()
	{
		for(int i=0;i<Nonveg.length;i++)
            System.out.println((i+1)+"."+Nonveg[i]+"--"+"Per Item"+Nonvegrate[i]+ currency);
	}
	
	//select Veg Menu or Non Veg Menu and order the food
	public void SelectFoodCategory()
	{
		int category;
		
		System.out.println("***Please select the Food category from the below list :***");
		System.out.println("[1] Vegetarian \n[2] non-veg");
		System.out.println("Please enter the option");
		category=sc.nextInt();
		switch(category)
		{
		case 1 :
			System.out.println("You have selected Vegetarian");
			System.out.println("Below are the dishes available in Veg");
			DisplayVegmenu();
		    OrderVegFood();
			break;
		case 2 :
			System.out.println("You have selected Non-Vegetarian");
			System.out.println("Below are the dishes available in Non Veg");
			DisplayNonVegmenu();
		    OrderNonVegFood();
			break;
		default:
			System.out.println("Invalid option");
		break;
			
		}
		}
		
	
	
	public void OrderVegFood() {
		int menu;
		String var , var1;
		do {
			System.out.println("Enter the option");
			menu=sc.nextInt();
			//numberofitems=numberofitems+1;  
		     if(menu>0&&menu<4)
		    {
		    	 numberofitems=numberofitems+1;  
				System.out.println("enter the no of quantites of "+Veg[menu-1] +" you would like to order");
				int q=sc.nextInt();         
				//int q=input;
			    qt[menu-1]+=q;
			       
		        System.out.println("Would you like to order more Y /N ");
		        var=sc.next();
		        
		        if (var.equalsIgnoreCase("Y"))
		        {
		        	ordering=true;
		        	DisplayVegmenu();
        	
		        }
		        else if (var.equalsIgnoreCase("N"))
		        {
		        	System.out.println("Would you like to order from category Y/N");
		             var1=sc.next();
		             if(var1.equalsIgnoreCase("Y"))
		             {
		                ordering=true;
			        	DisplayNonVegmenu();
			        	OrderNonVegFood();
		             }
		       
		             else if(var.equalsIgnoreCase("N")) 
		               
		        	  ordering=false;
		    }
		      		 
	}else { System.out.println("invalid option") ; ordering=true;}
		
   }while(ordering);
	//	return;
		//calculateBill();
		//System.exit(1);
	}
	
	
	public void OrderNonVegFood() {
		int menu;
		String var;
			do {
				System.out.println("Enter the option");
				menu=sc.nextInt();
		
		     if(menu>0&&menu<4)
		    {
		    	 numberofitems=numberofitems+1;  
			System.out.println("enter the no of quantites of "+Nonveg[menu-1] +"you would like to order");
			int input=sc.nextInt();         
			int q=input;
		         qt1[menu-1]+=q;
		         
		         System.out.println("Would you like to order more Y /N ");
		        var=sc.next();
		        if (var.equalsIgnoreCase("Y"))
		        {
		        	ordering=true;
		        	DisplayNonVegmenu();
        	
		        }
		        else if (var.equalsIgnoreCase("N"))
		        {
		        	System.out.println("Would you like to order from another category Y/N");
		             String var1 = sc.next();
		             if(var1.equalsIgnoreCase("Y"))
		             {
		               ordering=true;
			        	DisplayVegmenu();
			        	OrderVegFood();
			        	
		             }else if(var1.equalsIgnoreCase("N"))
		                   
		        	  ordering=false;
		             
		    }
		     
		  		    		 
	}  else 
	 {
	 System.out.println("invalid option, press 1 ,2 or 3");
	 ordering=true;
	
	 }
		
	} while(ordering);
		//	return;
			//calculateBill();
		
	}

	
	public void calculateBill() {
		// TODO Auto-generated method stub
		//System.out.println("Entering Calculate Bill");
		System.out.println("*********Your Orders are:*********\n");
		
	    for(int i=0;i<=2;i++)
	    {
              	 
	    	      sum+=((qt[i]*Vegrate[i])+(qt1[i]*Nonvegrate[i]));
	           
	    }  	
	    for(int i=0;i<3;i++)
	    {
	    	if(qt[i] != 0)
	    	System.out.println(Veg[i] + " " + qt[i] + "==" + qt[i]*Vegrate[i]+"Rs");
	    }
           // System.out.println(Veg[i]+"* ordered is  "+qt[i]+"=="+qt[i]*Vegrate[i]+"rs \n" +  Nonveg[i]+"* ordered is  "+qt1[i]+"=="+qt1[i]*Nonvegrate[i]+"rs\n");
           for (int j=0;j<3;j++)
           { 
        	   if (qt1[j] != 0)
        	   System.out.println(Nonveg[j] +" " + qt1[j] + "==" + qt1[j]*Nonvegrate[j]+"Rs" );
           }
           
	    System.out.println("Total Bill Before Tax and charge  is " + sum +currency);
           
        GST=sum*0.06;
	    System.out.println("GST is " +GST +currency);
	    sum=sum+GST;
	    System.out.println("Total Bill after GST is " +sum +currency);
	    if (dinein==true)
	    {
	      sum=sum+30;
	      System.out.println("dine charge 30 rs added " + sum +currency);
	    }
	    else if (Takeaway==true)
	    {
	    	Takeawaycharge=numberofitems*10;  
	    	 sum=sum+Takeawaycharge;
		      System.out.println("Parcel charge " + Takeawaycharge +" added.  " + sum + currency);
	    }
	    
	      if (sum>1000 && sum<1500)
	      {
	    	sum= (sum-sum*0.1);
	      System.out.println("Discount for order greater than 1000 is " +sum + currency);
	      } 
	      else  if(sum>1500)
	      {
	      sum=(sum-sum*0.15);
	      System.out.println("Discount for order greater than 1500 is " +sum + currency);
	      }
	       System.out.println("The Total bill is " + sum + "Rs");
		  // System.out.println("Exiting Calculate Bill");
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestaurantBill2 rb=new RestaurantBill2();
		System.out.println("*********Welcome to the Numpy Ninja Restraunt**********");
		rb.getServiceOffering();
		if(Flag==true)
		{
		rb.SelectFoodCategory();
		rb.calculateBill();
		}
	
	
		

	}

}
