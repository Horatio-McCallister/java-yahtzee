import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import java.util.Random;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Main {

	protected Shell shlYahtzee;
	
	public yahtzee logic;
	
	boolean closeWindow = false;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlYahtzee.open();
		shlYahtzee.layout();
		while (!shlYahtzee.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
			if(closeWindow == true)
			{
				shlYahtzee.dispose();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		logic = new yahtzee();
		
		shlYahtzee = new Shell();
		shlYahtzee.setSize(838, 596);
		shlYahtzee.setText("Yahtzee");
		
		Label lblDice1 = new Label(shlYahtzee, SWT.NONE);
		lblDice1.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-1.png"));
		lblDice1.setBounds(34, 70, 104, 104);
		
		Label lblDice2 = new Label(shlYahtzee, SWT.NONE);
		lblDice2.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-2.png"));
		lblDice2.setBounds(183, 70, 104, 104);
		
		Label lblDice3 = new Label(shlYahtzee, SWT.NONE);
		lblDice3.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-3.png"));
		lblDice3.setBounds(348, 70, 104, 104);
		
		Label lblDice4 = new Label(shlYahtzee, SWT.NONE);
		lblDice4.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-4.png"));
		lblDice4.setBounds(513, 70, 104, 104);
		
		Label lblDice5 = new Label(shlYahtzee, SWT.NONE);
		lblDice5.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-5.png"));
		lblDice5.setBounds(675, 70, 104, 104);
		
		Label lblRollsRemain = new Label(shlYahtzee, SWT.NONE);
		lblRollsRemain.setFont(SWTResourceManager.getFont("Segoe UI", 32, SWT.NORMAL));
		lblRollsRemain.setBounds(226, 0, 343, 59);
		lblRollsRemain.setText("Rolls Remaining: 3");
		
		Group grpUpperSection = new Group(shlYahtzee, SWT.NONE);
		grpUpperSection.setText("Upper Section");
		grpUpperSection.setBounds(10, 303, 397, 224);
		
		Group grpLowerSection = new Group(shlYahtzee, SWT.NONE);
		grpLowerSection.setText("Lower Section");
		grpLowerSection.setBounds(413, 303, 399, 224);
		
		Label lblTotalUS = new Label(grpUpperSection, SWT.NONE);
		lblTotalUS.setText("Total: 0");
		lblTotalUS.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblTotalUS.setBounds(279, 186, 108, 28);
		
		Label lblTotalLS = new Label(grpLowerSection, SWT.NONE);
		lblTotalLS.setText("Total: 0");
		lblTotalLS.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblTotalLS.setBounds(281, 186, 108, 28);
		
		Button btnDice1Lock = new Button(shlYahtzee, SWT.CHECK);
		btnDice1Lock.setBounds(78, 200, 13, 16);
		if(logic.lockDisabled)
		{
			btnDice1Lock.setEnabled(!logic.lockDisabled);
		}
		
		Button btnDice2Lock = new Button(shlYahtzee, SWT.CHECK);
		btnDice2Lock.setBounds(229, 200, 13, 16);
		if(logic.lockDisabled)
		{
			btnDice2Lock.setEnabled(!logic.lockDisabled);
		}
		
		Button btnDice3Lock = new Button(shlYahtzee, SWT.CHECK);
		btnDice3Lock.setBounds(394, 200, 13, 16);
		if(logic.lockDisabled)
		{
			btnDice3Lock.setEnabled(!logic.lockDisabled);
		}
		
		Button btnDice4Lock = new Button(shlYahtzee, SWT.CHECK);
		btnDice4Lock.setBounds(556, 200, 13, 16);
		if(logic.lockDisabled)
		{
			btnDice4Lock.setEnabled(!logic.lockDisabled);
		}
		
		Button btnDice5Lock = new Button(shlYahtzee, SWT.CHECK);
		btnDice5Lock.setBounds(719, 200, 13, 16);
		if(logic.lockDisabled)
		{
			btnDice5Lock.setEnabled(!logic.lockDisabled);
		}
		
		Label lblOnes = new Label(grpUpperSection, SWT.NONE);
		lblOnes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreOnes(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblOnes);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateUSTotal(lblTotalUS);
			}
		});
		lblOnes.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblOnes.setBounds(10, 37, 108, 28);
		lblOnes.setText("Ones: -");
		
		Label lblTwos = new Label(grpUpperSection, SWT.NONE);
		lblTwos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreTwos(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblTwos);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateUSTotal(lblTotalUS);
			}
		});
		lblTwos.setText("Twos: -");
		lblTwos.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblTwos.setBounds(10, 71, 108, 28);
		
		Label lblThrees = new Label(grpUpperSection, SWT.NONE);
		lblThrees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreThrees(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblThrees);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateUSTotal(lblTotalUS);
			}
		});
		lblThrees.setText("Threes: -");
		lblThrees.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblThrees.setBounds(10, 105, 108, 28);
		
		Label lblFours = new Label(grpUpperSection, SWT.NONE);
		lblFours.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreFours(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblFours);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateUSTotal(lblTotalUS);
			}
		});
		lblFours.setText("Fours: -");
		lblFours.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblFours.setBounds(186, 37, 108, 28);
		
		Label lblFives = new Label(grpUpperSection, SWT.NONE);
		lblFives.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreFives(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblFives);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateUSTotal(lblTotalUS);
			}
		});
		lblFives.setText("Fives: -");
		lblFives.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblFives.setBounds(186, 71, 108, 28);
		
		Label lblSixes = new Label(grpUpperSection, SWT.NONE);
		lblSixes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreSixes(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblSixes);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateUSTotal(lblTotalUS);
			}
		});
		lblSixes.setText("Sixes: -");
		lblSixes.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblSixes.setBounds(186, 105, 108, 28);
		
		Label lblBonus = new Label(grpUpperSection, SWT.NONE);
		lblBonus.setText("Bonus: -");
		lblBonus.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblBonus.setBounds(10, 186, 108, 28);
		
		Label lblIfTotalIs = new Label(grpUpperSection, SWT.NONE);
		lblIfTotalIs.setBounds(10, 173, 151, 15);
		lblIfTotalIs.setText("If total is over 63, +35 points.");
		
		Label lblThreeOfA = new Label(grpLowerSection, SWT.NONE);
		lblThreeOfA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreThreeKind(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblThreeOfA);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateLSTotal(lblTotalLS);
			}
		});
		lblThreeOfA.setText("3 of a Kind: -");
		lblThreeOfA.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblThreeOfA.setBounds(10, 27, 151, 28);
		
		Label lblFourOfA = new Label(grpLowerSection, SWT.NONE);
		lblFourOfA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreFourKind(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblFourOfA);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateLSTotal(lblTotalLS);
			}
		});
		lblFourOfA.setText("4 of a Kind: -");
		lblFourOfA.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblFourOfA.setBounds(10, 61, 151, 28);
		
		Label lblFullHouse = new Label(grpLowerSection, SWT.NONE);
		lblFullHouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreFullHouse(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblFullHouse);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateLSTotal(lblTotalLS);
			}
		});
		lblFullHouse.setText("Full House: -");
		lblFullHouse.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblFullHouse.setBounds(10, 95, 151, 28);
		
		Label lblChance = new Label(grpLowerSection, SWT.NONE);
		lblChance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreChance(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblChance);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateLSTotal(lblTotalLS);
			}
		});
		lblChance.setText("Chance: -");
		lblChance.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblChance.setBounds(10, 129, 151, 28);
		
		Label lblSmStraight = new Label(grpLowerSection, SWT.NONE);
		lblSmStraight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreSmStraight(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblSmStraight);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateLSTotal(lblTotalLS);
			}
		});
		lblSmStraight.setText("Sm. Straight: -");
		lblSmStraight.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblSmStraight.setBounds(194, 27, 162, 28);
		
		Label lblLgStraight = new Label(grpLowerSection, SWT.NONE);
		lblLgStraight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreLgStraight(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblLgStraight);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateLSTotal(lblTotalLS);
			}
		});
		lblLgStraight.setText("Lg. Straight: -");
		lblLgStraight.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblLgStraight.setBounds(194, 61, 162, 28);
		
		Label lblYahtzee = new Label(grpLowerSection, SWT.NONE);
		lblYahtzee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				logic.scoreYahtzee(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblYahtzee);
				lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				logic.disableLocks(btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock, btnDice5Lock);
				logic.updateLSTotal(lblTotalLS);
			}
		});
		lblYahtzee.setText("Yahtzee: -");
		lblYahtzee.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblYahtzee.setBounds(194, 95, 162, 28);
		
		Label lblYahtzeeBonus = new Label(grpLowerSection, SWT.NONE);
		lblYahtzeeBonus.setText("Yahtzee Bonus: -");
		lblYahtzeeBonus.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblYahtzeeBonus.setBounds(10, 186, 195, 28);
		
		Button btnRollTheDice = new Button(shlYahtzee, SWT.NONE);
		btnRollTheDice.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Roll dice if able
				if(logic.rollsRemain > 0)
				{
					//Change dice if not locked
					if(!btnDice1Lock.getSelection())
					{
						lblDice1.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-" + logic.rollDice() + ".png"));
					}
					if(!btnDice2Lock.getSelection())
					{
						lblDice2.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-" + logic.rollDice() + ".png"));
					}
					if(!btnDice3Lock.getSelection())
					{
						lblDice3.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-" + logic.rollDice() + ".png"));
					}
					if(!btnDice4Lock.getSelection())
					{
						lblDice4.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-" + logic.rollDice() + ".png"));
					}
					if(!btnDice5Lock.getSelection())
					{
						lblDice5.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-" + logic.rollDice() + ".png"));
					}
					
					logic.decrementRolls();
					lblRollsRemain.setText("Rolls Remaining: " + logic.rollsRemain);
				}
				
				//Check button locks
				btnDice1Lock.setEnabled(!logic.lockDisabled);
				btnDice2Lock.setEnabled(!logic.lockDisabled);
				btnDice3Lock.setEnabled(!logic.lockDisabled);
				btnDice4Lock.setEnabled(!logic.lockDisabled);
				btnDice5Lock.setEnabled(!logic.lockDisabled);
				
				int count = 0;
				int[][] scoreTracking = logic.scoreTracking;
				
				for(int i = 0; i < scoreTracking.length; i++)
				{
					if(scoreTracking[i][1] == 1)
						count++;
				}
			
				if(count == 13)
				{
					lblRollsRemain.setText("Final Score: " + logic.finalScore);
					btnRollTheDice.setText("Restart Game");
				}
			}
		});
		btnRollTheDice.setBounds(348, 246, 104, 25);
		btnRollTheDice.setText("Roll The Dice!");
		
		if(logic.reset)
		{
			resetGame(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblRollsRemain, btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock,
					btnDice5Lock, lblTotalUS, lblTotalLS, lblOnes, lblTwos, lblThrees,
					lblFours, lblFives, lblSixes, lblBonus, lblThreeOfA, lblFourOfA,
					lblFullHouse, lblChance, lblSmStraight, lblLgStraight, lblLgStraight,
					lblYahtzee, lblYahtzeeBonus, btnRollTheDice);
		}
		
		Menu menu = new Menu(shlYahtzee, SWT.BAR);
		shlYahtzee.setMenuBar(menu);
		
		MenuItem mntmMenu = new MenuItem(menu, SWT.CASCADE);
		mntmMenu.setText("File");
		
		Menu menu_1 = new Menu(mntmMenu);
		mntmMenu.setMenu(menu_1);
		
		MenuItem mntmRestart = new MenuItem(menu_1, SWT.NONE);
		mntmRestart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				resetGame(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5, lblRollsRemain, btnDice1Lock, btnDice2Lock, btnDice3Lock, btnDice4Lock,
						btnDice5Lock, lblTotalUS, lblTotalLS, lblOnes, lblTwos, lblThrees,
						lblFours, lblFives, lblSixes, lblBonus, lblThreeOfA, lblFourOfA,
						lblFullHouse, lblChance, lblSmStraight, lblLgStraight, lblLgStraight,
						lblYahtzee, lblYahtzeeBonus, btnRollTheDice);
			}
		});
		mntmRestart.setText("Restart Game");
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				closeWindow = true;
			}
		});
		mntmExit.setText("Exit");
	}
	
	
	void resetGame(Label lblDice1, Label lblDice2, Label lblDice3, Label lblDice4, Label lblDice5,
			Label lblRollsRemain, Button btnDice1Lock, Button btnDice2Lock, Button btnDice3Lock, Button btnDice4Lock,
			Button btnDice5Lock, Label lblTotalUS, Label lblTotalLS, Label lblOnes, Label lblTwos, Label lblThrees,
			Label lblFours, Label lblFives, Label lblSixes, Label lblBonus, Label lblThreeOfA, Label lblFourOfA,
			Label lblFullHouse, Label lblChance, Label lblSmStraight, Label lblLgStraight, Label lblLgStraight1,
			Label lblYahtzee, Label lblYahtzeeBonus, Button btnRollTheDice)
	{
		logic.restartGame(lblDice1, lblDice2, lblDice3, lblDice4, lblDice5);
		lblRollsRemain.setText("Rolls Remaining: 3");
		
		//Reset locks
		btnDice1Lock.setEnabled(!logic.lockDisabled);
		btnDice2Lock.setEnabled(!logic.lockDisabled);
		btnDice3Lock.setEnabled(!logic.lockDisabled);
		btnDice4Lock.setEnabled(!logic.lockDisabled);
		btnDice5Lock.setEnabled(!logic.lockDisabled);
		
		btnRollTheDice.setEnabled(true);
		btnRollTheDice.setText("Roll The Dice!");
		
		//Reset Labels
		lblTotalUS.setText("Total: 0");
		lblTotalLS.setText("Total: 0");
		lblOnes.setText("Ones: -");
		lblTwos.setText("Twos: -");
		lblThrees.setText("Threes: -");
		lblFours.setText("Fours: -");
		lblFives.setText("Fives: -");
		lblSixes.setText("Sixes: -");
		lblBonus.setText("Bonus: -");
		lblThreeOfA.setText("3 of a Kind: -");
		lblFourOfA.setText("4 of a Kind: -");
		lblFullHouse.setText("Full House: -");
		lblChance.setText("Chance: -");
		lblSmStraight.setText("Sm. Straight: -");
		lblLgStraight1.setText("Lg. Straight: -");
		lblYahtzee.setText("Yahtzee: -");
		lblYahtzeeBonus.setText("Yahtzee Bonus: -");
	}
}
