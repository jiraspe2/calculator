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
	
	public static Type getTypeFromString(String type){
		if(type.equals("add")) return Instruction.Type.ADD;
		if(type.equals("multiply")) return Instruction.Type.MULTIPLY;
		if(type.equals("subtract")) return Instruction.Type.SUBTRACT;
		return Instruction.Type.DIVIDE;
	}
}
