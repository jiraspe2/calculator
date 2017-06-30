package calculator;

import java.io.File;

import instructions.Instruction;
import instructions.InstructionLoader;

public class Calculator {
	
	int apply;
	int result;
	
	/**
	 * Initializes new instance of calculator.
	 * @param apply The base number given from file
	 */
	public Calculator(int apply){
		this.apply = apply;
		result = apply;
	}
	
	/**
	 * @return	current result after instructions executed.
	 */
	public int getResult(){
		return result;
	}
	
	/**
	 * Executes the instruction and changes the current result
	 * according to it.
	 * @param instruction Instruction to be executed.
	 * In case the instruction is null, NullPointerException
	 * is thrown.
	 */
	public void executeInstruction(Instruction instruction){
		if(instruction==null){
			throw new NullPointerException();
		}
		if(instruction.getType().equals(Instruction.Type.ADD)){
			result = result + instruction.getOperand();
		}
		if(instruction.getType() == Instruction.Type.MULTIPLY){
			result = result * instruction.getOperand();
		}
		if(instruction.getType() == Instruction.Type.SUBTRACT){
			result = result - instruction.getOperand();
		}
		if(instruction.getType() == Instruction.Type.DIVIDE){
			result = result / instruction.getOperand();
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 0 || args.length > 1){
			System.out.println("Please enter only name of the file with instructions.");
		}
		File file = new File(args[0]);
		if(file.exists() && !file.isDirectory()) { 
			InstructionLoader instructionLoader = new InstructionLoader(args[0]);
			Calculator calculator = new Calculator(instructionLoader.getApply());
			Instruction instruction = instructionLoader.getNextInstruction();
			while(instruction != null){
				calculator.executeInstruction(instruction);
				instruction = instructionLoader.getNextInstruction();
			}
			System.out.println(calculator.getResult());
		}
		else{
			System.out.println("Invalid file name.");
		}
	}

}
