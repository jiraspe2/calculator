package calculator;

import instructions.Instruction;

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
		}else{
			if(instruction.getType() == Instruction.Type.MULTIPLY){
				result = result * instruction.getOperand();
			}else{
				if(instruction.getType() == Instruction.Type.SUBTRACT){
					result = result - instruction.getOperand();
				}else{
					if(instruction.getType() == Instruction.Type.DIVIDE){
						result = result / instruction.getOperand();
					}
				}
			}
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
