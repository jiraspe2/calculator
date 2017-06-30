package instructions;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class InstructionLoader {

	/**
	 * List of instructions as given from file. If file contains
	 * just apply, then this list is empty.
	 */
	ArrayList<Instruction> instructions;
	/**
	 * The basic value for the calculator.
	 */
	int apply;
	/**
	 * Index of the instruction, that should be served as next
	 */
	int currentInstructionIndex;
	
	/**
	 * 
	 * @param filename File with instructions.
	 */
	public InstructionLoader(String filename){
		instructions = new ArrayList<Instruction>();
		currentInstructionIndex = 0;
		
		filename = Paths.get("").toAbsolutePath().toString() + "/" + filename;
		File file = new File(filename);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String instruction = line.split(" ")[0];
			int operand = Integer.parseInt(line.split(" ")[1]);
			if(instruction.equals("apply")){
				apply = operand;
				break;
			}
			instructions.add(new Instruction(operand,
					Instruction.getTypeFromString(instruction)));
		}
		scanner.close();
	}
	
	public int getApply(){
		return apply;
	}
	
	public Instruction getNextInstruction(){
		if(currentInstructionIndex >= instructions.size()){
			return null;
		}
		return instructions.get(currentInstructionIndex++);
	}
}
