package edu.asu.ser215.pathfinder.core;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

	@Test
	public void testConstructDice() {
		// Test invalid number of sides
		try {
			Dice d = Dice.constructDice(1, 1);
			Assert.fail("Tried to create dice with sides < 2");
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().contains("number of sides")) {
				Assert.fail("Failed with wrong exception. expected 'number of sides' to be inside the message.");
			}
		}

		// Test invalid offset (negative)
		try {
			Dice d = Dice.constructDice(6, -1);
			Assert.fail("Tried to create dice with offset < 0");
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().contains("offset")) {
				Assert.fail("Failed with wrong exception. expected 'offset' to be inside the message.");
			}
		}
	}

	@Test
	public void testGenerateName() {
		Assert.assertEquals(Dice.REPRESENTATION + "3", Dice.generateName(3));
	}

	@Test
	public void testRoll() {
		// Two dice to test
		Dice d1 = Dice.constructDice(6, 1);
		Dice d2 = Dice.constructDice(2, 1);
		// Run the test 50 times to be sure
		for (int i = 0; i < 50; i++) {
			int value = d1.roll();
			if ((value > 6) || (value < 1)) {
				Assert.fail("Dice roll out of range. Expected 1-6, got "
						+ value);
			}
			value = d2.roll();
			if ((value > 2) || (value < 1)) {
				Assert.fail("Dice roll out of range. Expected 1-2, got "
						+ value);
			}
		}
	}

	@Test
	public void testParseDice() {
		Assert.assertEquals("Parsed dice should equal " + Dice.REPRESENTATION
				+ "6", Dice.REPRESENTATION + "6", Dice.parseDice("d6")
				.getName());
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("Parsed dice should equal " + Dice.REPRESENTATION
				+ "6", Dice.REPRESENTATION + "6", Dice.constructDice(6, 1)
				.getName());
	}

	@Test
	public void testListDice() {
		Dice.constructDice(3, 1);
		Dice.constructDice(5, 2);
		Dice.constructDice(10, 3);

		String list = Dice.listDice();

		if (list.isEmpty()) {
			Assert.fail("Dice list can not be empty");
		}

		if (!list.contains("3") || !list.contains("5") || !list.contains("10")) {
			Assert.fail("Dice list does not contain all the created dice.");
		}
	}

}
