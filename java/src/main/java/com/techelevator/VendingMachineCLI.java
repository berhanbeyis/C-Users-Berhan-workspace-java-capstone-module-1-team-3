package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.nio.channels.SelectableChannel;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT };

	private static final String FEED_MONEY = "Feed Money";
	private static final String SELECT_PRODUCT = "Select product";
	private static final String FINISH_TRANSACTION = "Finish transaction";
	private static final String[] SECOND_MENU_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};

	private static final String ONE_DOLLAR = "$1";
	private static final String TWO_DOLLARS = "$2";
	private static final String FIVE_DOLLARS = "$5";
	private static final String TEN_DOLLARS = "$10";
	private static final String STOP = "Back to previous menu";
	private static final String[] FEED_OPTIONS = {ONE_DOLLAR, TWO_DOLLARS, FIVE_DOLLARS, TEN_DOLLARS, STOP};





	private Menu menu;

	boolean boolOne = true;
	boolean boolTwo = true;
	boolean boolThree = true;
	VendingMachine vending= new VendingMachine();
	BankAccoutn myAccount = new BankAccoutn();
	Scanner scan = new Scanner(System.in);

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		while (boolOne) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			vending.startMachine();


			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vending.displayItems();


			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				//print balance in machine
//				System.out.println(vending.getVendingBalance());

				while(boolTwo) {
					System.out.println("Current money provided: " + vending.getMachineBalance());

					String choiceTwo = (String) menu.getChoiceFromOptions(SECOND_MENU_OPTIONS);


					if(choiceTwo.equals(FEED_MONEY)) {
						//feed money here
						while(boolThree) {
							System.out.println("Current money provided: " + vending.getMachineBalance());
							String choiceThree = (String) menu.getChoiceFromOptions(FEED_OPTIONS);

							if(choiceThree.equals(ONE_DOLLAR)) {
								vending.addToMachineBalance(1);
								myAccount.withdraw(1);


							} else if (choiceThree.equals(TWO_DOLLARS)) {
								//add two dollars
								//withdraw from bank
								vending.addToMachineBalance(2);
								myAccount.withdraw(2);

							} else if(choiceThree.equals(FIVE_DOLLARS)) {
								//add five dollars
								//withdraw from bank
								vending.addToMachineBalance(5);
								myAccount.withdraw(5);

							} else if(choiceThree.equals(TEN_DOLLARS)) {
								//add ten dollars
								//withdraw from bank
								vending.addToMachineBalance(10);
								myAccount.withdraw(10);

							} else if(choiceThree.equals(STOP)) {
								boolThree = false;
							}

						}

					} else if (choiceTwo.equals(SELECT_PRODUCT)) {
						//select the product

						vending.displayItems();
						System.out.println("Enter Product Code>>> ");
						String vendingCode = scan.nextLine();

						if(vending.isSoldOut(vendingCode)) {
							boolTwo = false;
						} else {
							vending.chooseItem(vendingCode);
						}
						vending.getMachineBalance();




					} else if (choiceTwo.equals(FINISH_TRANSACTION)) {
						//finish transaction, give change
						vending.giveChange();
						myAccount.deposit(vending.getMachineBalance());
						boolThree = false;
						boolTwo = false;

					}


				}


			}else if (choice.equals(MAIN_MENU_EXIT)){
				System.exit(1);

			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	VendingMachine vending= new VendingMachine();
	vending.startMachine();
		vending.displayItems();


	}


}
