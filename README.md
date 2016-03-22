# Android-AkshatCounterTask2
		 =======================================================
         		      			Android Application Development
                  		    			    CIS 4930
		  =======================================================



		       		  Application Name-Akshat Counter Task
  	           		     -----------------------------------------------


		        			      Project Description
               
 		  In this android app we have to create an application that that counts the amount of 		  seconds that the activity is on screen. It will pause the counter if the user navigates 		  away. When the user comes back, it will continue from where it left off.
	            
 

                		 MainActivity.java

                      	display the current count
			run task when active
			pause task when inactive
			update the count when requested


                         				//////////////////////////////
		 
			 CounterThread.java
			maintain a counter
			when paused, do nothing
			when running, update the counter
			 every second and notify the 
			Main Activity of the new count
        	    


                         				 /////////////////////////////

			CounterApplication.java
	
			Instantiate and start a CounterThread.
			Contains a globally defined variable
			seconds which stores the counter value.

						 /////////////////////////////


                 		activity_main.xml

			This .xml file is used to design the user interface of the 
			application. The layout for the application is relative and 
			I have used  buttons and text views for the interface.


		


      			 ////////////////////////////////////////////////////////////////////////////////////
       			////////////////////////////////////////////////////////////////////////////////////
