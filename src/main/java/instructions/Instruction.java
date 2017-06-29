package instructions;

public class Instruction {
	
	public enum Type{
		ADD, SUBTRACT, DIVIDE, MULTIPLY
	}
	
	public Instruction(int operand, Instruction.Type type){
		
	}
	
	public int getOperand(){
		return -1;
	}
	
	public Instruction.Type getType(){
		return Type.ADD;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
