package instructions;

public class InstructionLoader {

	
	public InstructionLoader(String filename){
		
	}
	
	public int getApply(){
		return -1;
	}
	
	public Instruction getNextInstruction(){
		return new Instruction(-1, Instruction.Type.ADD);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
