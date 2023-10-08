Schiller Douyon

import java.util.Scanner;
public class menuoption
{
// find the sum of digits
public static boolean sum(int n)
{
      int sum = 1;
      
      for(int  i = 2; i * i <= n ; ++i){
            if(n % i == 0){
                 if( i * i!= n){
                      sum =  sum  + n / i + i;
                 }
                 else
                 {
                      sum = sum + i;
                 }
            }
      }
      
      
		if(sum == n){
			  if(n!=1){
			  	  return true;
			  }
			  else
			  {
			  	 return false;
			  }
		}
		else
		{
			 return false;
			 
		}
}

public static void sumHelper(int n){
      for(int i = 1  ; i <= n ; ++i){
           if(sum(i)){
                System.out.println(i);
           }
      }
      
      System.out.println("\n");
      
}

public static void sum(){
      
      Scanner sc = new Scanner(System.in);
      while(true)
      {
          System.out.println("Enter numbers for finding perfect sum \n");
          
          int num = sc.nextInt();
          
           sumHelper(num);
           System.out.println("Press 1 to continue finding sum or press any other key to return to main menu ");
           
                 char res = sc.next().charAt(0);
                 if(res == '1') continue;
                 else
                 return;
      }
}
      // reverse a Number
      public static void reverse(){
      Scanner Scanner = new Scanner(System.in);
       System.out.println("your number is: " + "num");
       
 }

public static int reverse(int num) {   
    int rNum = 0;
    while (num != 0) {
        rNum = rNum + num % 10;
        num = num / 10;
    }
    return(1);
  }
    /* finding primes */ 
    
public static boolean prime(int n){
      for(int  i = 2 ; i * i <= n ; ++i){
            if(n % i == 0){
                 return false;
            }
      }
      
      return true;
      
    }    
    
  public static void primehelper(int n ){
       for(int i =  1;  i  <= n ; ++i){
            if(prime(i)){
                 System.out.println(i + " ");
            }
       }
       System.out.println("\n");
        
  }   
    
    public static void prime(){
           Scanner sc = new Scanner(System.in);
           
           while(true){
                System.out.println("Enter the range limit for finding prime numbers \n");
                int n = sc.nextInt();
                
                primehelper(n);
                
                System.out.println("Press 1 to continue finding primes or press any other key to return to main menu ");
                 char res = sc.next().charAt(0);
                 if(res == '1') continue;
                 else
                 return;
                
                
           }
    }
    
    /* factorial function */
    public static int facthelper(int n){
         int ans = 1;
         for(int i = 1  ; i<= n ; ++i){
              ans = ans * i;
         }
         
         return ans;
         
    }
    
    public static void factorial(){
         Scanner sc = new Scanner(System.in);
                
                while(true)
                {
                    
                System.out.println("Enter the number n \n");
                int n = sc.nextInt();
                int soln = facthelper(n);
                
                System.out.println("Factorial  of " + n + " is : " + soln + "\n");
                
                System.out.println("Press 1  to find new factorial or press any other key to return to main menu");
                char res = sc.next().charAt(0);
                if(res == '1'){
                    continue;
                }
                else
                {
                     return;
                }
             
               
                }                
       
    }
    
    public static void main(String[] args) 
    {
        
         Scanner sc = new Scanner(System.in);
         
        while(true)
        {
              System.out.println(" 1.Calculate factorial \n");
              System.out.println(" 2.Check prime numbers \n");
              System.out.println(" 3.Find the sum of digits \n");
              System.out.println(" 4.Reverse a number \n");
              System.out.println(" 5.Exit \n");
              System.out.println(" Enter your choice  \n");
              
              int n = sc.nextInt();
              
              if(n == 1)
              {
                   factorial();
              }
              if(n == 2)
              {
                   prime();
                   
              }
              if(n == 3)
              {
                  sum();
                  
              }
              if(n == 4)
              {
                  reverse();
              }
              if (n==5)
              {
                    System.exit(0);
              } 
        }
    }
}

