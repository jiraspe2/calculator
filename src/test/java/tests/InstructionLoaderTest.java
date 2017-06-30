package tests;

import instructions.Instruction;
import instructions.InstructionLoader;

import org.junit.Test;
/*because of a bug in Java compiler
 *there must be * instead of just things I need
 */
import static org.junit.Assert.*;

public class InstructionLoaderTest {
	
	@Test
	public final void whenOnlyApplyIsInTheFile(){
		InstructionLoader instructionLoader =
				new InstructionLoader("src/test/resources/test1");
		assertEquals(1,instructionLoader.getApply());
		assertNull(instructionLoader.getNextInstruction());
	}
	
	@Test
	public final void whenOneInstructionInTheFile(){
		InstructionLoader instructionLoader =
				new InstructionLoader("src/test/resources/test2");
		
		assertEquals(5,instructionLoader.getApply());
		
		Instruction instruction = instructionLoader.getNextInstruction();
		assertEquals(9,instruction.getOperand());
		assertEquals(Instruction.Type.MULTIPLY, instruction.getType());
		
		assertEquals(null,instructionLoader.getNextInstruction());
	}
	
	@Test
	public final void whenMultipleInstructionsInTheFile(){
		InstructionLoader instructionLoader =
				new InstructionLoader("src/test/resources/test3");
		
		assertEquals(4,instructionLoader.getApply());
		
		Instruction instruction1 = instructionLoader.getNextInstruction();
		assertEquals(Instruction.Type.ADD,instruction1.getType());
		assertEquals(2,instruction1.getOperand());
		
		Instruction instruction2 = instructionLoader.getNextInstruction();
		assertEquals(Instruction.Type.MULTIPLY,instruction2.getType());
		assertEquals(3,instruction2.getOperand());
		
		assertEquals(null,instructionLoader.getNextInstruction());
	}
	
}
