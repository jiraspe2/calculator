package instructions;

public class Instruction {
	
	public enum Type{
		ADD, SUBTRACT, DIVIDE, MULTIPLY
	}
	
	Type type;
	int operand;
	
	public Instruction(int operand, Instruction.Type type){
		this.type = type;
		this.operand = operand;
	}
	
	public int getOperand(){
		return operand;
	}
	
	public Instruction.Type getType(){
		return type;
	}
	
	/**
	 * Converts the type of operation from String to Instruction.type
	 * @param type One of the values "add", "divide", "subtract" or "multiply"
	 * @return the same type as given by parameter
	 */
	public static Type getTypeFromString(String type){
		if(type.equals("add")) return Instruction.Type.ADD;
		if(type.equals("multiply")) return Instruction.Type.MULTIPLY;
		if(type.equals("subtract")) return Instruction.Type.SUBTRACT;
		return Instruction.Type.DIVIDE;
	}
}
