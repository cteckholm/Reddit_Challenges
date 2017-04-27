/**
 * Program Challenge #304
 *      Bank Account Information
 *
 * @author cteckholm
 * @version 4/27/2017
 */

import java.util.*;
public class Challenge {

    private static ArrayList<Numbers> memory = new ArrayList<>();

    private static String accnt; //Account number
    private static String name; // Account description
    private static double debit; // Account debit
    private static double balance; // Account balance
    private static double credit; // Account credit


    /**
     * Adds all the account information to a HashMap
     *      Uses the Scanner function to ask the user to input data
     * @param args
     */
    public static void main(String[] args){


        boolean rep = true;

        /**
         * Asks the "accountant" to input the information
         */
        while(rep){
            Scanner s = new Scanner(System.in);
            System.out.print("Account number: "); //Assigning account number
            accnt = s.next();
            System.out.print("\nDescription: "); //Assigning description
            name = s.next();
            System.out.print("\nDebit amount: $"); //Assigning debit amount
            debit = s.nextDouble();
            System.out.print("\nCredit amount: "); //Assigning credit amount
            credit = s.nextDouble();
            balance = debit - credit;



            memory.add(new Numbers(accnt, name, debit, credit, balance));


            System.out.print("More? (y/n): "); //Asking if the user has more
            String m = s.next();

            if(m.equals("y") || m.equals("Y")){
                rep = true;
            }
            else if(m.equals("n") || m.equals("N")){
                rep = false;
            }
            else{
                System.out.println("Invalid Selection. Try Again");
            }

            }
        System.out.println("\nAccount \t| Name \t| Debit\t| Credit\t| Balance");
        for(int i = 0; i < memory.size(); i++){
            System.out.println(memory.get(i));
        }
        }
    }
class Numbers {

    private String account; //Account number
    private String description; //Description
    private Double debit; //Debit amount
    private Double credit; //Credit amount
    private Double balance; //Account balance

    /**
     * Constructor for the Numbers class
     *
     * @param account account number
     * @param description description
     * @param debit the amount charged as a debit
     * @param credit the amount charged as credit
     * @param balance the account balance
     */
    public Numbers(String account, String description,
                   Double debit, Double credit, Double balance){


        this.account = account;
        this.description = description;
        this.debit = debit;
        this.credit = credit;
        this.balance = balance;
    }

    /**
     * Puts all the elements into a string
     * @return String
     */
    public String toString(){

        return (account + "\t\t|"
                + description + "\t|"
                + debit + "\t|"
                + credit + "\t|" + balance + "|");}


}







