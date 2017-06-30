package tests;

import instructions.Instruction;

import org.junit.Test;

import calculator.Calculator;
/*because of a bug in Java compiler
 *there must be * instead of just things I need
 */
import static org.junit.Assert.*;

public class CalculatorTest {
	@Test
	public final void whenInitilaized(){
		Calculator calculator = new Calculator(11);
		assertEquals(11,calculator.getResult());
	}
	
	@Test
	public final void whenAddExecuted(){
		Calculator calculator = new Calculator(11);
		calculator.executeInstruction(new Instruction(
				2,Instruction.Type.ADD));
		assertEquals(13,calculator.getResult());
	}
	
	@Test
	public final void whenSubtractExecuted(){
		Calculator calculator = new Calculator(11);
		calculator.executeInstruction(new Instruction(
				2,Instruction.Type.SUBTRACT));
		assertEquals(9,calculator.getResult());
	}
	
	@Test
	public final void whenMultiplyExecuted(){
		Calculator calculator = new Calculator(11);
		calculator.executeInstruction(new Instruction(
				2,Instruction.Type.MULTIPLY));
		assertEquals(22,calculator.getResult());
	}
	
	@Test
	public final void whenExecuted(){
		Calculator calculator = new Calculator(11);
		calculator.executeInstruction(new Instruction(
				2,Instruction.Type.DIVIDE));
		assertEquals(5,calculator.getResult());
	}
	
	@Test(expected = NullPointerException.class)
	public final void whenNullInstructionIsGiven(){
		Calculator calculator = new Calculator(11);
		calculator.executeInstruction(null);
	}
}
