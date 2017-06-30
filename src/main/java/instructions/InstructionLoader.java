package instructions;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class InstructionLoader {

	ArrayList<Instruction> instructions;
	int apply;
	int currentInstructionIndex;
	
	String cesta;
	
	public String getCesta(){
		return cesta;
	}
	
	public InstructionLoader(String filename){
		
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		filename = s + "/" + filename;
		
		File file = new File(filename);
		BufferedReader reader = null;
		
		instructions = new ArrayList<Instruction>();
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		        String [] line = text.split(" ");
		        if(line[0].equals("apply")){
		        	apply = Integer.parseInt(line[1]);
		        	currentInstructionIndex = 0;
		        	return;
		        }
		        instructions.add(new Instruction(
		        		Integer.parseInt(line[1]),
		        		Instruction.getTypeFromString(line[0])));
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
		currentInstructionIndex = 0;

		/*
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] arr = line.split(" "); 			
			if(arr[0].equals("APPLY")){
				this.apply = Integer.parseInt(arr[1]);
				break;
			}
			String type = "ADD";
			int operand = 1;
			instructions.add(new Instruction(
					operand,Instruction.getTypeFromString(type)));
		}
		scanner.close();
		currentInstructionIndex = 0;*/
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
